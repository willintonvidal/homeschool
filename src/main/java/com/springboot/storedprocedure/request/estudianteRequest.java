package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class estudianteRequest {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String estudiante_id;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String acu_numero_ident;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String grado_id;
    
    

	public String getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public String getAcu_numero_ident() {
		return acu_numero_ident;
	}

	public void setAcu_numero_ident(String acu_numero_ident) {
		this.acu_numero_ident = acu_numero_ident;
	}

	public String getGrado_id() {
		return grado_id;
	}

	public void setGrado_id(String grado_id) {
		this.grado_id = grado_id;
	}
    
    
    
    
	
	
    

    
	

}
