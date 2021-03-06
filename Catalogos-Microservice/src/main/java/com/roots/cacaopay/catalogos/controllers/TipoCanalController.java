package com.roots.cacaopay.catalogos.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.catalogos.entity.TipoCanalFisico;
import com.roots.cacaopay.catalogos.services.TipoCanalFisicoService;
import com.roots.cacaopay.commons.controllers.CommonController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RefreshScope
@RestController
@RequestMapping("tipo-canal")
@Api(value = "Tipo Canal Fisico Controller", description = "Controlador para la tabla catalogo Tipo Canal Fisico")
public class TipoCanalController extends CommonController<TipoCanalFisico, TipoCanalFisicoService> {

	@Autowired
	private Environment env;

	@Value("${configuracion.texto}")
	private String texto;

	@ApiOperation(value = "Actualizar Tipo Canal Fisico")
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(
			@ApiParam(value = "Request Objecto Tipo Canal Fisico", required = true) @RequestBody TipoCanalFisico tipoCanalFisico,
			@ApiParam(value = "Request ID a editar", required = true) @PathVariable Long id) {
		Optional<TipoCanalFisico> tipoCanal = this.service.findById(id);
		if (!tipoCanal.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		TipoCanalFisico nuevoRegistro = tipoCanal.get();

		nuevoRegistro.setCodigo(tipoCanalFisico.getCodigo());
		nuevoRegistro.setNombre(tipoCanalFisico.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(nuevoRegistro));
	}

	@GetMapping("/get-config")
	public ResponseEntity<?> getConfig(@Value("${server.port}") String port) {
		Map<String, String> json = new HashMap<>();
		json.put("config", texto);
		json.put("port", port);
		json.put("author.nombre", env.getProperty("configuracion.author.nombre"));
		json.put("author.email", env.getProperty("configuracion.author.email"));
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}

}
