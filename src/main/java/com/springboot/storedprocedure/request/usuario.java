package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class usuario {
	
	@NotBlank
	@Size(min=1, max = 15)
	private String usu_id;
	
	@NotBlank
    @Size(min = 1, max = 30)
    private String cen_edu_nit;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String usu_tipo_documento;
    
    @NotBlank
    @Size(min=1, max = 30)
    private String usu_nombres;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String usu_apellidos;
    
   
	@NotBlank
    @Size(min = 1, max = 30)
    private String usu_tipo_usuario;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String usu_contrasenia;
    
    @NotBlank
    @Size(min=1, max = 30)
    private String usu_estado;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String usu_email;
    
    @NotBlank
    @Size(min = 1, max = 20)
    private String usu_telefono;
    
    @NotBlank
    @Size(min = 1, max = 60)
    private String usu_foto;
   
	
    
	
   	public void setUsu_id(String usu_id) {
   		this.usu_id = usu_id;
   	}

   	public String getUsu_id() {
		return usu_id;
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

}
/*
{ "usu_id":"15677", "cen_edu_nit":"1065", "usu_tipo_documento":"cedula", "usu_nombres":"Alexandra", "usu_apellidos":"Pino","usu_tipo_usuario":"estudiante", "usu_contrasenia":"paola", "usu_estado":"estudy", "usu_email":"nuevo", "usu_telefono":"3455", "usu_foto":"hgi"}

 */