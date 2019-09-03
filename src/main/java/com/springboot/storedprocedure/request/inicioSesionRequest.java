package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class inicioSesionRequest {
	
	@NotBlank
    @Size(min=1, max = 30)
    private String usuario_id;
	
	@NotBlank
    @Size(min = 1, max = 30)
    private String usuario_contrasenia;

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUsuario_contrasenia() {
		return usuario_contrasenia;
	}

	public void setUsuario_contrasenia(String usuario_contrasenia) {
		this.usuario_contrasenia = usuario_contrasenia;
	}
    
    
    
	

}
