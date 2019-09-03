package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class actividadEstudianteRequest {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String rel_act_est_id;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String estudiante_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String actividad_eva_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String tema_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String materia_id;
    
    @NotBlank
    private String rel_actividad_nota;

	public String getRel_act_est_id() {
		return rel_act_est_id;
	}

	public void setRel_act_est_id(String rel_act_est_id) {
		this.rel_act_est_id = rel_act_est_id;
	}

	public String getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

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

	public String getRel_actividad_nota() {
		return rel_actividad_nota;
	}

	public void setRel_actividad_nota(String rel_actividad_nota) {
		this.rel_actividad_nota = rel_actividad_nota;
	}
    
    
    
    
    
	
	
    

    
	

}
