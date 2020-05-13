package com.roots.cacaopay.tipocanalfisico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.tipocanalfisico.entity.TipoCanalFisico;
import com.roots.cacaopay.tipocanalfisico.service.TipoCanalFisicoService;

@RestController
public class TipoCanalFisicoController {

	@Autowired
	private TipoCanalFisicoService canalFisicoRepository;
	
	@GetMapping("/")
	public List<TipoCanalFisico> getAll(){
		return canalFisicoRepository.getAll();
	}
	
}
