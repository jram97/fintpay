package com.roots.cacaopay.transaccion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.clients.Rest;
import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.entity.RelacionCuenta;
import com.roots.cacaopay.transaccion.service.RelacionCuentaService;
import com.roots.cacaopay.usuarios.commons.entity.Usuario;

@RestController
@RequestMapping("/relacion-cuenta")
public class RelacionCuentaController extends CommonController<RelacionCuenta, RelacionCuentaService> {

	@Autowired
	private Rest clientRest;
	
	@PostMapping("/relacion/{cuenta}/{cliente}")
	public ResponseEntity<?> agregarDefinicionCuenta(@PathVariable Long cuenta, @PathVariable Long cliente){
		Cuenta cuentaExist = clientRest.findByIdCuenta(cuenta);
		Usuario usuarioExist = clientRest.findById(cliente);
		
		if(cuentaExist == null || usuarioExist == null) {
			return ResponseEntity.notFound().build();
		}

		RelacionCuenta rCuenta = new RelacionCuenta();
		rCuenta.setCuenta(cuentaExist);
		rCuenta.setUsuario(usuarioExist);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(rCuenta));
	}
	
}
