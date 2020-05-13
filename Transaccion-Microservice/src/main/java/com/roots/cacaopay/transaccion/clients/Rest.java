package com.roots.cacaopay.transaccion.clients;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.roots.cacaopay.catalogos.entity.TipoTransaccion;
import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.entity.DefinicionCuenta;
import com.roots.cacaopay.usuarios.commons.entity.Usuario;

@Service
public class Rest {

	@Autowired
	private RestTemplate clientTemplate;
	
	public Usuario findById(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		Usuario usuario = clientTemplate.getForObject("http://localhost:8090/ws/usuarios/usuarios/{id}", Usuario.class, pathVariable);
		return usuario;
	}

	public TipoTransaccion findByIdTipo(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		TipoTransaccion tipo = clientTemplate.getForObject("http://localhost:8090/ws/catalogos/tipo-transaccion/{id}", TipoTransaccion.class, pathVariable);
		return tipo;
	}
	
	public DefinicionCuenta findByIdDefinicionCuenta(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		DefinicionCuenta dcuenta = clientTemplate.getForObject("http://localhost:8090/ws/transaccion/definicion-cuenta/{id}", DefinicionCuenta.class, pathVariable);
		return dcuenta;	
	}

	public Cuenta findByIdCuenta(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		Cuenta cuenta = clientTemplate.getForObject("http://localhost:8090/ws/transaccion/cuenta/{id}", Cuenta.class, pathVariable);
		return cuenta;	
	}

	public void sumarCuenta(Optional<Cuenta> cuentae, Long id) {
		HttpEntity<Cuenta> body = new HttpEntity<Cuenta>(cuentae.get());
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());

		ResponseEntity<Cuenta> response = clientTemplate.exchange("http://localhost:8090/ws/transaccion/cuenta/sumar-monto/{id}", HttpMethod.PUT, body, Cuenta.class, pathVariable);
		System.out.println("SUMANDO::::::::: " + response);
		//return response.getBody();
	}

	public void restarCuenta(Optional<Cuenta> cuenta, Long id) {
		HttpEntity<Cuenta> body = new HttpEntity<Cuenta>(cuenta.get());
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());

		ResponseEntity<Cuenta> response = clientTemplate.exchange("http://localhost:8090/ws/transaccion/cuenta/restar-monto/{id}", HttpMethod.PUT, body, Cuenta.class, pathVariable);
		System.out.println("RESTANDO::::::::: " + response);
		
		//return response.getBody();
	}
}
