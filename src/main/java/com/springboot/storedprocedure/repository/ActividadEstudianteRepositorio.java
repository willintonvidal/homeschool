package com.springboot.storedprocedure.repository;



import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class ActividadEstudianteRepositorio {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_actividad_estudiante() {
		return em.createNamedStoredProcedureQuery("procedure-one-mostrar-actividad-estudiante").getResultList();
	}
	

	public Integer insertar_actividad_estudiante(Long rel_act_est_id,Long estudiante_id,Long actividad_eva_id,Long tema_id,Long materia_id,Double rel_actividad_nota) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two-insertar-actividad-estudiante")
				.setParameter("rel_act_est_id", rel_act_est_id)
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("actividad_eva_id", actividad_eva_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("rel_actividad_nota", rel_actividad_nota)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_actividad_estudiante(Long rel_act_est_id,Long estudiante_id,Long actividad_eva_id,Long tema_id,Long materia_id,Double rel_actividad_nota) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third-editar-actividad-estudiante")
				.setParameter("rel_act_est_id", rel_act_est_id)
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("actividad_eva_id", actividad_eva_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("rel_actividad_nota", rel_actividad_nota)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_actividad_estudiante(Long rel_act_est_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four-eliminar-actividad-estudiante")
				.setParameter("rel_act_est_id",rel_act_est_id)
				.getOutputParameterValue("ejecuto");
	}
}