package com.roots.cacaopay.tipocanalfisico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.tipocanalfisico.entity.TipoCanalFisico;

@Repository
public interface TipoCanalFisicoRepository extends JpaRepository<TipoCanalFisico, Long> {

}
