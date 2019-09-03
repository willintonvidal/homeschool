package com.springboot.storedprocedure.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class acudienteRequest {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String acudiente_tipo_ident;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String acu_numero_ident;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String acu_nombre_completo;
    
    @NotBlank
    @Size(min = 1, max = 40)
    @Email
    private String ecudiente_email;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String acudiente_telefono;
    

	public String getAcudiente_tipo_ident() {
		return acudiente_tipo_ident;
	}

	public void setAcudiente_tipo_ident(String acudiente_tipo_ident) {
		this.acudiente_tipo_ident = acudiente_tipo_ident;
	}

	public String getAcu_numero_ident() {
		return acu_numero_ident;
	}

	public void setAcu_numero_ident(String acu_numero_ident) {
		this.acu_numero_ident = acu_numero_ident;
	}

	public String getAcu_nombre_completo() {
		return acu_nombre_completo;
	}

	public void setAcu_nombre_completo(String acu_nombre_completo) {
		this.acu_nombre_completo = acu_nombre_completo;
	}

	public String getEcudiente_email() {
		return ecudiente_email;
	}

	public void setEcudiente_email(String ecudiente_email) {
		this.ecudiente_email = ecudiente_email;
	}

	public String getAcudiente_telefono() {
		return acudiente_telefono;
	}

	public void setAcudiente_telefono(String acudiente_telefono) {
		this.acudiente_telefono = acudiente_telefono;
	}
    
    
    
	
    

    
	

}
