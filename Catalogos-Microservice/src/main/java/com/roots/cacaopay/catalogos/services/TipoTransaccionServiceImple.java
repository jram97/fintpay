package com.roots.cacaopay.catalogos.services;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.catalogos.entity.TipoTransaccion;
import com.roots.cacaopay.catalogos.repository.TipoTransaccionRepository;
import com.roots.cacaopay.commons.services.CommonServiceImple;

@Service
public class TipoTransaccionServiceImple
extends CommonServiceImple<TipoTransaccion, TipoTransaccionRepository>
implements TipoTransaccionService {

}
