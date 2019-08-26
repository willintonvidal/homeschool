package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class CentroEducativodao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_centro_educativo() {
		return em.createNamedStoredProcedureQuery("procedure-one").getResultList();
	}
	
	public Integer insertar_centro_educativo(String CEN_EDU_NIT,String CEN_EDU_NOMBRE,String CEN_EDU_CIUDAD,String CEN_EDU_TELEFONO,String CEN_EDU_DIRECCION) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two")
				.setParameter("nit_centro_educativo", CEN_EDU_NIT)
				.setParameter("nombre_centro_educativo", CEN_EDU_NOMBRE)
				.setParameter("ciudad_centro_educativo", CEN_EDU_CIUDAD)
				.setParameter("telefono_centro_educativo", CEN_EDU_TELEFONO)
				.setParameter("direccion_centro_educativo", CEN_EDU_DIRECCION)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_centro_educativo(String CEN_EDU_NIT,String CEN_EDU_NOMBRE,String CEN_EDU_CIUDAD,String CEN_EDU_TELEFONO,String CEN_EDU_DIRECCION) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third")
				.setParameter("nit_centro_educativo", CEN_EDU_NIT)
				.setParameter("nombre_centro_educativo", CEN_EDU_NOMBRE)
				.setParameter("ciudad_centro_educativo", CEN_EDU_CIUDAD)
				.setParameter("telefono_centro_educativo", CEN_EDU_TELEFONO)
				.setParameter("direccion_centro_educativo", CEN_EDU_DIRECCION)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_centro_educativo(String CEN_EDU_NIT) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four")
				.setParameter("nit_centro_educativo", CEN_EDU_NIT)
				.getOutputParameterValue("ejecuto");
	}
}