package com.roots.cacaopay.transaccion.service;

import java.util.Optional;

import com.roots.cacaopay.commons.services.CommonService;
import com.roots.cacaopay.transaccion.entity.Cuenta;

public interface CuentaService extends CommonService<Cuenta> {

	public Optional<Cuenta> findByNumero(String numero);
}
