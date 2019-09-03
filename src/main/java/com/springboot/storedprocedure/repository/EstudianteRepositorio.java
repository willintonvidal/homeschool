package com.springboot.storedprocedure.repository;



import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class EstudianteRepositorio {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_estudiante() {
		return em.createNamedStoredProcedureQuery("procedure-one-mostrar-estudiantes").getResultList();
	}
	

	public Integer insertar_estudiante(Long estudiante_id,Long acu_numero_ident,Long grado_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two-insertar")
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("acu_numero_ident", acu_numero_ident)
				.setParameter("grado_id", grado_id)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_estudiante(Long estudiante_id,Long acu_numero_ident,Long grado_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third-editar")
				.setParameter("estudiante_id", estudiante_id)
				.setParameter("acu_numero_ident", acu_numero_ident)
				.setParameter("grado_id", grado_id)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_estudiante(Long estudiante_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four-eliminar")
				.setParameter("estudiante_id",estudiante_id)
				.getOutputParameterValue("ejecuto");
	}
}