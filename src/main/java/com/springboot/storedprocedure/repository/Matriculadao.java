package com.springboot.storedprocedure.repository;


import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;
import com.springboot.storedprocedure.model.Matricula;

@Repository
public class Matriculadao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Matricula> get_all_matriculas() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-matricula").getResultList();
	}
	
	public Integer insertar_matricula(Long matri_id,Long est_id,Long mat_id, Date matri_feha_inicio, Date matri_fecha_fin, String matri_estado, Double matri_not_final) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar-matricula")
				.setParameter("id_matri", matri_id)
				.setParameter("id_est", est_id)
				.setParameter("id_mat", mat_id)
				.setParameter("fecha_inicio_matri", matri_feha_inicio)
				.setParameter("fecha_fin_matri", matri_fecha_fin)
				.setParameter("estado_matri", matri_estado)
				.setParameter("not_final_matri", matri_not_final)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_matricula(Long matri_id,Long est_id,Long mat_id, Date matri_feha_inicio, Date matri_fecha_fin, String matri_estado, Double matri_not_final) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar-matricula")
				.setParameter("id_matri", matri_id)
				.setParameter("id_est", est_id)
				.setParameter("id_mat", mat_id)
				.setParameter("fecha_inicio_matri", matri_feha_inicio)
				.setParameter("fecha_fin_matri", matri_fecha_fin)
				.setParameter("estado_matri", matri_estado)
				.setParameter("not_final_matri", matri_not_final)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_matricula(Long matri_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar-matricula")
				.setParameter("id_matri", matri_id)
				.getOutputParameterValue("ejecuto");
	}
}