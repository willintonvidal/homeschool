package com.springboot.storedprocedure.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.storedprocedure.model.Usuario;

@Repository
public class Usuariodao {
	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public Iterable<Usuario> get_all_usuarios() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Usuario> get_usuarios_no_validados() {
		return em.createNamedStoredProcedureQuery("procedure-mostrar-usuarios-no-validados").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Usuario> inicio_sesion(Long usuario_id,String usuario_contrasenia) {
		return em.createNamedStoredProcedureQuery("procedure-inicio-sesion")
				.setParameter("usuario_id", usuario_id)
				.setParameter("usuario_contrasenia", usuario_contrasenia)
				.getResultList();
	}
	
	public Integer insertar_usuario(Long usu_id,String cen_edu_nit,String usu_tipo_documento,String usu_nombres, String usu_apellidos, String usu_tipo_usuario,String usu_contrasenia,String usu_estado,String usu_email, String usu_telefono, String usu_foto) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-insertar")
				.setParameter("id_usu", usu_id)
				.setParameter("edu_nit_cen", cen_edu_nit)
				.setParameter("tipo_documento_usu", usu_tipo_documento)
				.setParameter("nombres_usu", usu_nombres)
				.setParameter("apellidos_usu", usu_apellidos)
				.setParameter("tipo_usuario_usu", usu_tipo_usuario)
				.setParameter("contrasenia_usu", usu_contrasenia)
				.setParameter("estado_usu", usu_estado)
				.setParameter("email_usu", usu_email)
				.setParameter("telefono_usu", usu_telefono)
				.setParameter("foto_usu", usu_foto)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer verificarUsuario(Long usu_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-verificar-usuario")
				.setParameter("id_usu", usu_id)
				.getOutputParameterValue("ejecuto");
	}
	
	public Integer ValidarEstadoUsuario(Long usuario_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-validar-estado-usuario")
				.setParameter("usuario_id", usuario_id)
				.getOutputParameterValue("ejecuto");
	}
	
	public String restablecerCorreo(String email) {
		return (String) em.createNamedStoredProcedureQuery("procedure-restablecer-password")
				.setParameter("email", email)
				.getOutputParameterValue("pass");
	}
	
	public Integer actualizar_usuario(Long usu_id,String cen_edu_nit,String usu_tipo_documento,String usu_nombres, String usu_apellidos, String usu_tipo_usuario,String usu_contrasenia,String usu_estado,String usu_email, String usu_telefono, String usu_foto) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-actualizar")
				.setParameter("id_usu", usu_id)
				.setParameter("edu_nit_cen", cen_edu_nit)
				.setParameter("tipo_documento_usu", usu_tipo_documento)
				.setParameter("nombres_usu", usu_nombres)
				.setParameter("apellidos_usu", usu_apellidos)
				.setParameter("tipo_usuario_usu", usu_tipo_usuario)
				.setParameter("contrasenia_usu", usu_contrasenia)
				.setParameter("estado_usu", usu_estado)
				.setParameter("email_usu", usu_email)
				.setParameter("telefono_usu", usu_telefono)
				.setParameter("foto_usu", usu_foto)
				.getOutputParameterValue("ejecuto");
	}
	

	
	public Integer eliminar_usuario(Long usu_id) {
		return (Integer) em.createNamedStoredProcedureQuery("procedure-eliminar")
				.setParameter("id_usu", usu_id)
				.getOutputParameterValue("ejecuto");
	}
}