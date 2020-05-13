package com.roots.cacaopay.transaccion.controller;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.catalogos.entity.TipoTransaccion;
import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.clients.Rest;
import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.entity.RelacionCuenta;
import com.roots.cacaopay.transaccion.entity.TransaccionCuenta;
import com.roots.cacaopay.transaccion.service.CuentaService;
import com.roots.cacaopay.transaccion.service.RelacionCuentaService;
import com.roots.cacaopay.transaccion.service.TransaccionCuentaService;
import com.roots.cacaopay.usuarios.commons.entity.Usuario;

@RestController
@RequestMapping("/transaccion-cuenta")
public class TransaccionCuentaController extends CommonController<TransaccionCuenta, TransaccionCuentaService> {

	@Autowired
	private Rest clienteRest;
	@Autowired
	private RelacionCuentaService relacionCuenta;
	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/envio/{de}/{para}/{tipoe}/{tipor}")
	public ResponseEntity<?> envio(
			@Valid @RequestBody TransaccionCuenta transaccionCuenta,
			@PathVariable Long de,
			@PathVariable Long para,
			@PathVariable Long tipoe,
			@PathVariable Long tipor){

		Usuario userDe = clienteRest.findById(de);
		Usuario userPara = clienteRest.findById(para);
		TipoTransaccion tipoTransaccione = clienteRest.findByIdTipo(tipoe);
		TipoTransaccion tipoTransaccionr = clienteRest.findByIdTipo(tipor);
		
		/*if(userDe == null && userPara == null) {
			return ResponseEntity.notFound().build();
		}*/
			TransaccionCuenta tc = transaccionCuenta;
			tc.setMonto(new BigDecimal(transaccionCuenta.getMonto())
					.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			tc.setUsuariode(userDe);
			tc.setUsuario_para(userPara);
			tc.setTipotransaccionenvio(tipoTransaccione);
			tc.setTipotransaccionrecibo(tipoTransaccionr);			

			RelacionCuenta rc1 = relacionCuenta.buscarPorUsuarioId(userDe.getId());
			Optional<Cuenta> cuenta = cuentaService.findById(rc1.getCuenta().getId());
			cuenta.get().setSaldo(tc.getMonto());

			RelacionCuenta rc2 = relacionCuenta.buscarPorUsuarioId(userPara.getId());
			Optional<Cuenta> cuentae = cuentaService.findById(rc2.getCuenta().getId());
			
			cuentae.get().setSaldo(tc.getMonto());
			
			clienteRest.restarCuenta(cuenta, cuenta.get().getId());
			clienteRest.sumarCuenta(cuentae, cuentae.get().getId());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(tc));
			
	}
}
