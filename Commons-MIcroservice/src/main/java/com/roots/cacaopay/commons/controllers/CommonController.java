package com.roots.cacaopay.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.roots.cacaopay.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id){
		Optional<E> entity = service.findById(id);
		if(!entity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody E entity){
		E entityNew = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityNew);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
