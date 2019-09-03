package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class temaEstudianteRequest {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String rel_tema_est_id;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String estudiante_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String tema_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String materia_id;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String rel_tema_nota;

	public String getRel_tema_est_id() {
		return rel_tema_est_id;
	}

	public void setRel_tema_est_id(String rel_tema_est_id) {
		this.rel_tema_est_id = rel_tema_est_id;
	}

	public String getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(String estudiante_id) {
		this.estudiante_id = estudiante_id;
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

	public String getRel_tema_nota() {
		return rel_tema_nota;
	}

	public void setRel_tema_nota(String rel_tema_nota) {
		this.rel_tema_nota = rel_tema_nota;
	}

	@Override
	public String toString() {
		return "centroEducativoRequest [rel_tema_est_id=" + rel_tema_est_id + ", estudiante_id=" + estudiante_id
				+ ", tema_id=" + tema_id + ", materia_id=" + materia_id + ", rel_tema_nota=" + rel_tema_nota + "]";
	}
    
    
	
	
    
    
    
	
	
    

    
	

}
