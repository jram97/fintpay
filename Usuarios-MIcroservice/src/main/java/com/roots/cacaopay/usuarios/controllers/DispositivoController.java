package com.roots.cacaopay.usuarios.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.usuarios.entity.Dispositivo;
import com.roots.cacaopay.usuarios.service.DispositivosService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController extends CommonController<Dispositivo, DispositivosService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Dispositivo dispositivo, @PathVariable Long id){

		Optional<Dispositivo> dispositivoExists = this.service.findById(id);
		
		if(!dispositivoExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Dispositivo dispositivoUpdate = dispositivoExists.get();
		
		dispositivoUpdate.setEstado(dispositivo.getEstado());
		dispositivoUpdate.setSecuencia(dispositivo.getSecuencia());
		dispositivoUpdate.setIdentificador(dispositivo.getIdentificador());
		dispositivoUpdate.setNombre(dispositivo.getNombre());
		dispositivoUpdate.setModelo(dispositivo.getModelo());
		dispositivoUpdate.setMarca(dispositivo.getMarca());
		dispositivoUpdate.setCodigoenlace(dispositivo.getCodigoenlace());
		dispositivoUpdate.setSecuencia(dispositivo.getSecuencia());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dispositivoUpdate));
	}
}
