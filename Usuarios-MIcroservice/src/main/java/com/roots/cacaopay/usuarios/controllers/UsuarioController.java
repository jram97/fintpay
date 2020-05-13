package com.roots.cacaopay.usuarios.controllers;

import java.util.List;
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
import com.roots.cacaopay.usuarios.entity.Usuario;
import com.roots.cacaopay.usuarios.service.UsuariosServices;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends CommonController<Usuario, UsuariosServices> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> userExists = this.service.findById(id);
		if(!userExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		Usuario updateUser = userExists.get();
		updateUser.setDireccion(usuario.getDireccion());
		updateUser.setAlias(usuario.getAlias());
		updateUser.setNotificacion(usuario.getNotificacion());
		updateUser.setEstado(usuario.getEstado());
		updateUser.setClave(usuario.getClave());
		updateUser.setDireccion(usuario.getDireccion());
		updateUser.setVerificacion(usuario.getVerificacion());
		updateUser.setTipoautenticacion(usuario.getTipoautenticacion());
		updateUser.setAutenticacionclave(usuario.getAutenticacionclave());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(updateUser));
	}
	
	@PutMapping("/{id}/nuevo-dispositivo")
	public ResponseEntity<?> agregarDispositivo(@RequestBody List<Dispositivo> dispositivoList, @PathVariable Long id){
		Optional<Usuario> userExists = this.service.findById(id);
		if(!userExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		Usuario updateUser = userExists.get();
		dispositivoList.forEach(d -> updateUser.addDispositivoList(d));
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(updateUser));
	}
	
	@PutMapping("/{id}/eliminar-dispositivo")
	public ResponseEntity<?> eliminarDispositivo(@RequestBody Dispositivo dispositivo, @PathVariable Long id){
		Optional<Usuario> userExists = this.service.findById(id);
		if(!userExists.isPresent()) {
			return ResponseEntity.notFound().build();
		}		
		Usuario updateUser = userExists.get();
		updateUser.deleteDispositivoList(dispositivo);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(updateUser));
	}
	
}
