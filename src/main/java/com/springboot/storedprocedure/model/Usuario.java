package com.springboot.storedprocedure.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

//debemos mapear la entidad, de aqui se dan nombre a los procedimientos y a sus 
//respectivos datos de entrada y de salida para luego pasar al repositorio y ser llamados de ahi
@Entity 
@Table(name= "USUARIO")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar", procedureName= "GestionarUsuario.mostrarUsuario",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorUsuario", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-mostrar-usuarios-no-validados", procedureName= "GestionarUsuario.usuariosNoValidados",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorUsuarioNoValid", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-inicio-sesion", procedureName= "GestionarUsuario.inicioSesion",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "usuario_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "usuario_contrasenia", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorInicioSesion", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-verificar-usuario", procedureName= "GestionarUsuario.existePorId",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_usu", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-validar-estado-usuario", procedureName= "GestionarUsuario.validarUsuarios",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "usuario_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-restablecer-password", procedureName= "GestionarUsuario.buscarPorEmail",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "email", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "pass", type= String.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar", procedureName= "GestionarUsuario.insertarUsuario", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_usu", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "edu_nit_cen", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tipo_documento_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombres_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "apellidos_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tipo_usuario_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "contrasenia_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estado_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "email_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "telefono_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "foto_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar", procedureName= "GestionarUsuario.actualizarUsuario", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_usu", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "edu_nit_cen", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tipo_documento_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombres_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "apellidos_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tipo_usuario_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "contrasenia_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estado_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "email_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "telefono_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "foto_usu", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar", procedureName= "GestionarUsuario.eliminarUsuario", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_usu", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Usuario {

	@Id
	private Long usu_id;
	private String usu_tipo_documento;
	private String usu_nombres;
	private String usu_apellidos;
	private String usu_tipo_usuario;
	private String usu_contrasenia;
	private String usu_estado;
	private String usu_email;
	private String usu_telefono;
	private String usu_foto;
	
	public Long getUsu_id() {
		return usu_id;
	}
	public void setUsu_id(Long usu_id) {
		this.usu_id = usu_id;
	}
	public String getCen_edu_nit() {
		return cen_edu_nit;
	}
	public void setCen_edu_nit(String cen_edu_nit) {
		this.cen_edu_nit = cen_edu_nit;
	}
	public String getUsu_tipo_documento() {
		return usu_tipo_documento;
	}
	public void setUsu_tipo_documento(String usu_tipo_documento) {
		this.usu_tipo_documento = usu_tipo_documento;
	}
	public String getUsu_nombres() {
		return usu_nombres;
	}
	public void setUsu_nombres(String usu_nombres) {
		this.usu_nombres = usu_nombres;
	}
	public String getUsu_apellidos() {
		return usu_apellidos;
	}
	public void setUsu_apellidos(String usu_apellidos) {
		this.usu_apellidos = usu_apellidos;
	}
	public String getUsu_tipo_usuario() {
		return usu_tipo_usuario;
	}
	public void setUsu_tipo_usuario(String usu_tipo_usuario) {
		this.usu_tipo_usuario = usu_tipo_usuario;
	}
	public String getUsu_contrasenia() {
		return usu_contrasenia;
	}
	public void setUsu_contrasenia(String usu_contrasenia) {
		this.usu_contrasenia = usu_contrasenia;
	}
	public String getUsu_estado() {
		return usu_estado;
	}
	public void setUsu_estado(String usu_estado) {
		this.usu_estado = usu_estado;
	}
	public String getUsu_email() {
		return usu_email;
	}
	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}
	public String getUsu_telefono() {
		return usu_telefono;
	}
	public void setUsu_telefono(String usu_telefono) {
		this.usu_telefono = usu_telefono;
	}
	public String getUsu_foto() {
		return usu_foto;
	}
	public void setUsu_foto(String usu_foto) {
		this.usu_foto = usu_foto;
	}
	private String cen_edu_nit;
	@Override
	public String toString() {
		return "Usuario [usu_id=" + usu_id + ", cen_edu_nit=" + cen_edu_nit + ", usu_tipo_documento="
				+ usu_tipo_documento + ", usu_nombres=" + usu_nombres + ", usu_apellidos=" + usu_apellidos
				+ ", usu_tipo_usuario=" + usu_tipo_usuario + ", usu_contrasenia=" + usu_contrasenia + ", usu_estado="
				+ usu_estado + ", usu_email=" + usu_email + ", usu_telefono=" + usu_telefono + ", usu_foto=" + usu_foto
				+ "]";
	}
	
	
	
}