package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.storedprocedure.model.Profesor;

@Repository
public class Profesordao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Profesor> get_all_profesor() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-profesor").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Profesor> CursosAsignados(Long profesor_id) {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-cursos-asignados")
				.setParameter("profesor_id", profesor_id)
				.getResultList();
	}
	
	
	public Integer insertar_profesor(Long prof_id,String prof_titulo,String prof_experiencia_laboral) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar-profesor")
				.setParameter("id_prof", prof_id)
				.setParameter("titulo_prof", prof_titulo)
				.setParameter("experiencia_laboral_prof", prof_experiencia_laboral)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_profesor(Long prof_id,String prof_titulo,String prof_experiencia_laboral) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar-profesor")
				.setParameter("id_prof", prof_id)
				.setParameter("titulo_prof", prof_titulo)
				.setParameter("experiencia_laboral_prof", prof_experiencia_laboral)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_profesor(Long prof_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar-profesor")
				.setParameter("id_prof", prof_id)
				.getOutputParameterValue("ejecuto");
	}
}