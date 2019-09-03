package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Grado;

import oracle.sql.NUMBER;

@Repository
public class Gradodao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Grado> get_all_grados() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-grado").getResultList();
	}
	
	public Integer insertar_grados(Long gra_id,String gra_nombre) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar-grado")
				.setParameter("id_gra", gra_id)
				.setParameter("nombre_gra", gra_nombre)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_grados(Long gra_id,String gra_nombre) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar-grado")
				.setParameter("id_gra", gra_id)
				.setParameter("nombre_gra", gra_nombre)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_grados(Long gra_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar-grado")
				.setParameter("id_gra", gra_id)
				.getOutputParameterValue("ejecuto");
	}
}