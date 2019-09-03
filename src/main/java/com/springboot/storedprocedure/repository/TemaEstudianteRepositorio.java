package com.springboot.storedprocedure.repository;



import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class TemaEstudianteRepositorio {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_tema_estudiante() {
		return em.createNamedStoredProcedureQuery("procedure-one-mostrar-tema-estudiante").getResultList();
	}
	

	public Integer insertar_tema_estudiante(Long rel_tema_est_id,Long estudiante_id,Long tema_id,Long materia_id,Double rel_tema_nota) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two-insertar-tema-estudiante")
				.setParameter("rel_tema_est_id", rel_tema_est_id)
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("rel_tema_nota", rel_tema_nota)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_tema_estudiante(Long rel_tema_est_id,Long estudiante_id,Long tema_id,Long materia_id,Double rel_tema_nota) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third-editar-tema-estudiante")
				.setParameter("rel_tema_est_id", rel_tema_est_id)
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("tema_id", tema_id)
				.setParameter("materia_id", materia_id)
				.setParameter("rel_tema_nota", rel_tema_nota)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_tema_estudiante(Long rel_tema_est_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four-eliminar-tema-estudiante")
				.setParameter("rel_tema_est_id",rel_tema_est_id)
				.getOutputParameterValue("ejecuto");
	}
}