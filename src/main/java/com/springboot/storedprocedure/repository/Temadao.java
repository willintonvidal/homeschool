package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.storedprocedure.model.Centro_Educativo;
import com.springboot.storedprocedure.model.Tema;

@Repository
public class Temadao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Tema> get_all_temas() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-tema").getResultList();
	}
	
	public Integer insertar_tema (Long tem_id,Long mat_id,String tem_nombre,String tem_descripcion,String tem_foto, String tem_material_archivo, String tem_material_video) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar-tema")
				.setParameter("id_tem", tem_id)
				.setParameter("id_mat", mat_id)
				.setParameter("nombre_tem", tem_nombre)
				.setParameter("descripcion_tem", tem_descripcion)
				.setParameter("foto_tem", tem_foto)
				.setParameter("material_archivo_tem", tem_material_archivo)
				.setParameter("material_video_tem", tem_material_video)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer actualizar_tema (Long tem_id,Long mat_id,String tem_nombre,String tem_descripcion,String tem_foto, String tem_material_archivo, String tem_material_video) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar-tema")
				.setParameter("id_tem", tem_id)
				.setParameter("id_mat", mat_id)
				.setParameter("nombre_tem", tem_nombre)
				.setParameter("descripcion_tem", tem_descripcion)
				.setParameter("foto_tem", tem_foto)
				.setParameter("material_archivo_tem", tem_material_archivo)
				.setParameter("material_video_tem", tem_material_video)
				.getOutputParameterValue("ejecuto");
	}
	
	
	public Integer eliminar_tema(Long tem_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar-tema")
				.setParameter("id_tem", tem_id)
				.getOutputParameterValue("ejecuto");
	}
}