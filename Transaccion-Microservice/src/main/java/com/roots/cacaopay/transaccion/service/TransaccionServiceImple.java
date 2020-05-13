package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.Transaccion;
import com.roots.cacaopay.transaccion.repository.TransaccionRepository;

@Service
public class TransaccionServiceImple extends CommonServiceImple<Transaccion, TransaccionRepository> implements TransaccionService{

}
