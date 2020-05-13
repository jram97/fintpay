package com.roots.cacaopay.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.transaccion.entity.ReglaDefinicion;

@Repository
public interface ReglaDefinicionRepository extends JpaRepository<ReglaDefinicion, Long> {

}
