package com.roots.cacaopay.transaccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roots.cacaopay.transaccion.entity.Cuenta;
import com.roots.cacaopay.transaccion.entity.RelacionCuenta;
import com.roots.cacaopay.usuarios.commons.entity.Usuario;

@Repository
public interface RelacionCuentaRepository extends JpaRepository<RelacionCuenta, Long> {

	@Query(value = "SELECT * FROM public.relacioncuenta INNER JOIN public.usuario ON public.relacioncuenta.usuario_id = :codigo", nativeQuery = true)
	public Usuario buscarUsuarioPorId(@Param(value = "codigo") Long codigo);
	
	public RelacionCuenta findByCuenta(Cuenta cuenta);

	@Query(value = "SELECT * FROM public.relacioncuenta INNER JOIN public.usuario ON public.relacioncuenta.usuario_id = :id", nativeQuery = true)
	public RelacionCuenta buscarPorUsuarioId(@Param(value = "id") Long id);
	
	
}
