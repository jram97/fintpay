package com.roots.cacaopay.usuarios.service;

import org.springframework.stereotype.Service;

import com.roots.cacaopay.commons.services.CommonServiceImple;
import com.roots.cacaopay.usuarios.entity.Usuario;
import com.roots.cacaopay.usuarios.repository.UsuariosRepository;

@Service
public class UsuariosServiceImple extends CommonServiceImple<Usuario, UsuariosRepository> implements UsuariosServices {
	
}
