package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class matricula {
	
	@NotBlank
    @Size(min=1, max = 10)
    private String matri_id;
	
	@NotBlank
    @Size(min = 1, max = 15)
    private String est_id;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String mat_id;
    
    @NotBlank
    @Size(min=1, max = 30)
    private String matri_fecha_inicio;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String matri_fecha_fin;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String matri_estado;

    @NotBlank
    @Size(min = 1, max = 5)
    private String matri_not_final;

    
    
	public String getMatri_id() {
		return matri_id;
	}

	public void setMatri_id(String matri_id) {
		this.matri_id = matri_id;
	}

	public String getEst_id() {
		return est_id;
	}

	public void setEst_id(String est_id) {
		this.est_id = est_id;
	}

	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getMatri_fecha_inicio() {
		return matri_fecha_inicio;
	}

	public void setMatri_fecha_inicio(String matri_fecha_inicio) {
		this.matri_fecha_inicio = matri_fecha_inicio;
	}

	public String getMatri_fecha_fin() {
		return matri_fecha_fin;
	}

	public void setMatri_fecha_fin(String matri_fecha_fin) {
		this.matri_fecha_fin = matri_fecha_fin;
	}

	public String getMatri_estado() {
		return matri_estado;
	}

	public void setMatri_estado(String matri_estado) {
		this.matri_estado = matri_estado;
	}

	public String getMatri_not_final() {
		return matri_not_final;
	}

	public void setMatri_not_final(String matri_not_final) {
		this.matri_not_final = matri_not_final;
	}


    
	
	
    

    
	

}
