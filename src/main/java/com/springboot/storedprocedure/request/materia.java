package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class materia {
	
	@NotBlank
    @Size(min=1, max = 30)
    private String mat_id;
	
	@NotBlank
    @Size(min = 1, max = 30)
    private String mat_nombre;
    
    @NotBlank
    @Size(min = 1, max = 20)
    private String gra_id;
    
    @NotBlank
    @Size(min = 1, max = 50)
    private String prof_id;

	
	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getMat_nombre() {
		return mat_nombre;
	}

	public void setMat_nombre(String mat_nombre) {
		this.mat_nombre = mat_nombre;
	}

	public String getGra_id() {
		return gra_id;
	}

	public void setGra_id(String gra_id) {
		this.gra_id = gra_id;
	}


	public String getProf_id() {
		return prof_id;
	}

	public void setProf_id(String prof_id) {
		this.prof_id = prof_id;
	}
	/*{ "mat_id":"1406", "mat_nombre":"Frances", "gra_id":"2", "prof_id":"1061777"}*/

}
