package com.roots.cacaopay.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.transaccion.entity.TransaccionCuenta;

@Repository
public interface TransaccionCuentaRepository extends JpaRepository<TransaccionCuenta, Long> {

}
