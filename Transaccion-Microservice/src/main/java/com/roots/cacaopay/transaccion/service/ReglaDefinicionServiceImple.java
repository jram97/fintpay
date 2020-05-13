package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.ReglaDefinicion;
import com.roots.cacaopay.transaccion.repository.ReglaDefinicionRepository;

@Service
public class ReglaDefinicionServiceImple extends CommonServiceImple<ReglaDefinicion, ReglaDefinicionRepository> implements ReglaDefinicionService {

}
