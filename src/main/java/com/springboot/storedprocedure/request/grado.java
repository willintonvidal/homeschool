package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class grado {
	
	@NotBlank
    @Size(min=1, max = 20)
    private String id;
	
	@NotBlank
    @Size(min = 1, max = 30)
    private String nombre;
	
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
    
    
	
	
    

    
	

}
