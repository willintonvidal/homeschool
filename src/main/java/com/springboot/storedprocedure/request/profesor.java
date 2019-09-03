package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class profesor {
	
	@NotBlank
    @Size(min=1, max = 15)
    private String id_prof;
	
	@NotBlank
    @Size(min = 1, max = 50)
    private String titulo_prof;
	
	@NotBlank
    @Size(min = 1, max = 100)
    private String experiencia_laboral_prof;

	public String getId_prof() {
		return id_prof;
	}

	public void setId_prof(String id_prof) {
		this.id_prof = id_prof;
	}

	public String getTitulo_prof() {
		return titulo_prof;
	}

	public void setTitulo_prof(String titulo_prof) {
		this.titulo_prof = titulo_prof;
	}

	public String getExperiencia_laboral_prof() {
		return experiencia_laboral_prof;
	}

	public void setExperiencia_laboral_prof(String experiencia_laboral_prof) {
		this.experiencia_laboral_prof = experiencia_laboral_prof;
	}
	
    /*{ "id_prof":"1061780", "titulo_prof":"Ingeniero de minas", "experiencia_laboral_prof":"3 años"}*/

    
	
	
    

    
	

}
