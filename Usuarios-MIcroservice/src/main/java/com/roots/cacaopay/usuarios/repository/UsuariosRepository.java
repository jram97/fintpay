package com.roots.cacaopay.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.usuarios.entity.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
