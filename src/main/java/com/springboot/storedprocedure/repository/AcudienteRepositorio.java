package com.springboot.storedprocedure.repository;



import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;

@Repository
public class AcudienteRepositorio {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Centro_Educativo> get_all_acudiente() {
		return em.createNamedStoredProcedureQuery("procedure-one-mostrar-acudiente").getResultList();
	}
	

	public Integer insertar_acudiente(String acudiente_tipo_ident,Long acu_numero_ident,String acu_nombre_completo,String ecudiente_email,String acudiente_telefono) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-two-insertar-acudiente")
				.setParameter("acudiente_tipo_ident", acudiente_tipo_ident)
				.setParameter("acu_numero_ident", acu_numero_ident)
				.setParameter("acu_nombre_completo", acu_nombre_completo)
				.setParameter("ecudiente_email", ecudiente_email)
				.setParameter("acudiente_telefono", acudiente_telefono)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_acudiente(String acudiente_tipo_ident,Long acu_numero_ident,String acu_nombre_completo,String ecudiente_email,String acudiente_telefono) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-third-editar-acudiente")
				.setParameter("acudiente_tipo_ident", acudiente_tipo_ident)
				.setParameter("acu_numero_ident", acu_numero_ident)
				.setParameter("acu_nombre_completo", acu_nombre_completo)
				.setParameter("ecudiente_email", ecudiente_email)
				.setParameter("acudiente_telefono", acudiente_telefono)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer eliminar_acudiente(Long acu_numero_ident) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-four-eliminar-acudiente")
				.setParameter("acu_numero_ident",acu_numero_ident)
				.getOutputParameterValue("ejecuto");
	}
}