package com.roots.cacaopay.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.transaccion.entity.DefinicionCuenta;

@Repository
public interface DefinicionCuentaRepository extends JpaRepository<DefinicionCuenta, Long> {

}
