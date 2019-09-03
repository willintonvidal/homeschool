package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;
import com.springboot.storedprocedure.model.Materia;

@Repository
public class Materiadao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Materia> get_all_materia() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-materia").getResultList();
	}
	
	public Integer insertar_materia(Long mat_id,String mat_nombre,Long gra_id,Long prof_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar-materia")
				.setParameter("id_mat", mat_id)
				.setParameter("nombre_mat", mat_nombre)
				.setParameter("id_gra", gra_id)
				.setParameter("id_prof", prof_id)
		        .getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_materia(Long mat_id,String mat_nombre,Long gra_id,Long prof_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar-materia")
				.setParameter("id_mat", mat_id)
				.setParameter("nombre_mat", mat_nombre)
				.setParameter("id_gra", gra_id)
				.setParameter("id_prof", prof_id)
		        .getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_materia(Long mat_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar-materia")
				.setParameter("id_mat", mat_id)
				.getOutputParameterValue("ejecuto");
	}
}