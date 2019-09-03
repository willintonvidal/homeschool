package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class actividadEvaluativaRequest {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String actividad_eva_id;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String tema_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String materia_id;
    
    @NotBlank
    @Size(min=1, max = 60)
    private String actividad_eva_nombre;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String actividad_fecha_inicio;

    @NotBlank
    @Size(min = 1, max = 40)
    private String actividad_eva_fin;

    @NotBlank
    @Size(min = 1, max = 40)
    private String actividad_eva_;

    @NotBlank
    @Size(min = 1, max = 40)
    private String actividad_eva_foto;

	public String getActividad_eva_id() {
		return actividad_eva_id;
	}

	public void setActividad_eva_id(String actividad_eva_id) {
		this.actividad_eva_id = actividad_eva_id;
	}

	public String getTema_id() {
		return tema_id;
	}

	public void setTema_id(String tema_id) {
		this.tema_id = tema_id;
	}

	public String getMateria_id() {
		return materia_id;
	}

	public void setMateria_id(String materia_id) {
		this.materia_id = materia_id;
	}

	public String getActividad_eva_nombre() {
		return actividad_eva_nombre;
	}

	public void setActividad_eva_nombre(String actividad_eva_nombre) {
		this.actividad_eva_nombre = actividad_eva_nombre;
	}

	public String getActividad_fecha_inicio() {
		return actividad_fecha_inicio;
	}

	public void setActividad_fecha_inicio(String actividad_fecha_inicio) {
		this.actividad_fecha_inicio = actividad_fecha_inicio;
	}

	public String getActividad_eva_fin() {
		return actividad_eva_fin;
	}

	public void setActividad_eva_fin(String actividad_eva_fin) {
		this.actividad_eva_fin = actividad_eva_fin;
	}

	public String getActividad_eva_() {
		return actividad_eva_;
	}

	public void setActividad_eva_(String actividad_eva_) {
		this.actividad_eva_ = actividad_eva_;
	}

	public String getActividad_eva_foto() {
		return actividad_eva_foto;
	}

	public void setActividad_eva_foto(String actividad_eva_foto) {
		this.actividad_eva_foto = actividad_eva_foto;
	}


    
    
}
