package com.roots.cacaopay.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.catalogos.entity.TipoCanalFisico;

@Repository
public interface TipoCanalFisicoRepository extends JpaRepository<TipoCanalFisico, Long>{

}
