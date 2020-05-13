package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.ControlCuenta;
import com.roots.cacaopay.transaccion.repository.ControlCuentaRepository;

@Service
public class ControlCuentaServiceImple extends CommonServiceImple<ControlCuenta, ControlCuentaRepository> implements ControlCuentaService {

}
