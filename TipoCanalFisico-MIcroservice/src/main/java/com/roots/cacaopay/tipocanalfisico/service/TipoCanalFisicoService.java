package com.roots.cacaopay.tipocanalfisico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roots.cacaopay.tipocanalfisico.entity.TipoCanalFisico;
import com.roots.cacaopay.tipocanalfisico.repository.TipoCanalFisicoRepository;

@Service
public class TipoCanalFisicoService {

	@Autowired
	private TipoCanalFisicoRepository tCanalFisicoRepository;
	
	public List<TipoCanalFisico> getAll(){
		return tCanalFisicoRepository.findAll();
	}
	
}
