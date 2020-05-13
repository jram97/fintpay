package com.roots.cacaopay.usuarios.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.usuarios.entity.Dispositivo;
import com.roots.cacaopay.usuarios.repository.DispositivosRepository;

@Service
public class DispositivosServiceImple extends CommonServiceImple<Dispositivo, DispositivosRepository> implements DispositivosService {

}
