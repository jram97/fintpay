package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.TransaccionCuenta;
import com.roots.cacaopay.transaccion.repository.TransaccionCuentaRepository;

@Service
public class TransaccionCuentaServiceImple extends CommonServiceImple<TransaccionCuenta, TransaccionCuentaRepository> implements TransaccionCuentaService{

}
