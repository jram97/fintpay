package com.roots.cacaopay.transaccion.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.repository.CuentaRepository;

@Service
public class CuentaServiceImple extends CommonServiceImple<Cuenta, CuentaRepository> implements CuentaService {

	@Override
	public Optional<Cuenta> findByNumero(String numero) {
		return repository.findByNumero(numero);
	}

}
