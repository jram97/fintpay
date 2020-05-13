package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.DefinicionCuenta;
import com.roots.cacaopay.transaccion.repository.DefinicionCuentaRepository;

@Service
public class DefinicionCuentaServiceImple extends CommonServiceImple<DefinicionCuenta, DefinicionCuentaRepository> implements DefinicionCuentaService{

}
