package com.springboot.storedprocedure.repository;


import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class ActividadEvaluativaRepositorio {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_actividad_evaluativa() {
		return em.createNamedStoredProcedureQuery("procedure-one-mostrar-actividad-evaluativa").getResultList();
	}
	
	public Integer insertar_actividad_evaluativa(Long actividad_eva_id,Long tema_id,Long materia_id,String actividad_eva_nombre,Date actividad_fecha_inicio,Date actividad_eva_fin,String actividad_eva_,String actividad_eva_foto) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two-editar--actividad-evaluativa")
				.setParameter("actividad_eva_id", actividad_eva_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("actividad_eva_nombre", actividad_eva_nombre)
				.setParameter("actividad_fecha_inicio", actividad_fecha_inicio)
				.setParameter("actividad_eva_fin", actividad_eva_fin)
				.setParameter("actividad_eva_", actividad_eva_)
				.setParameter("actividad_eva_foto", actividad_eva_foto)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_actividad_evaluativa(Long actividad_eva_id,Long tema_id,Long materia_id,String actividad_eva_nombre,Date actividad_fecha_inicio,Date actividad_eva_fin,String actividad_eva_,String actividad_eva_foto) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third-actualizar-actividad-evaluativa")
				.setParameter("actividad_eva_id", actividad_eva_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("actividad_eva_nombre", actividad_eva_nombre)
				.setParameter("actividad_fecha_inicio", actividad_fecha_inicio)
				.setParameter("actividad_eva_fin", actividad_eva_fin)
				.setParameter("actividad_eva_", actividad_eva_)
				.setParameter("actividad_eva_foto", actividad_eva_foto)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_actividad_evaluativa(Long actividad_eva_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four-eliminar-actividad-evaluativa")
				.setParameter("actividad_eva_id", actividad_eva_id)
				.getOutputParameterValue("ejecuto");
	}
}