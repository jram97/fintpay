package com.roots.cacaopay.transaccion.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.entity.RelacionCuenta;
import com.roots.cacaopay.transaccion.repository.RelacionCuentaRepository;
import com.roots.cacaopay.usuarios.commons.entity.Usuario;

@Service
public class RelacionCuentaServiceImple extends CommonServiceImple<RelacionCuenta, RelacionCuentaRepository> implements RelacionCuentaService {
	
	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		return repository.buscarUsuarioPorId(id);
	}

	@Override
	public RelacionCuenta findByCuenta(Cuenta cuenta) {
		return repository.findByCuenta(cuenta);
	}

	@Override
	public RelacionCuenta buscarPorUsuarioId(Long id) {
		return repository.buscarPorUsuarioId(id);
	}
	
}
