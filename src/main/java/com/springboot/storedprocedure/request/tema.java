package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class tema {
	
	@NotBlank
    @Size(min=1, max = 30)
    private String tem_id;
	
	@NotBlank
    @Size(min = 1, max = 30)
    private String mat_id;
    
    @NotBlank
    @Size(min = 1, max = 30)
    private String tem_nombre;
    
    @NotBlank
    @Size(min=1, max = 500)
    private String tem_descripcion;
    
    @NotBlank
    @Size(min = 1, max = 50)
    private String tem_foto;
    
    @NotBlank
    @Size(min = 1, max = 100)
    private String tem_material_archivo;
    
    @NotBlank
    @Size(min = 1, max = 100)
    private String tem_material_video;


	public String getTem_id() {
		return tem_id;
	}

	public void setTem_id(String tem_id) {
		this.tem_id = tem_id;
	}

	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getTem_nombre() {
		return tem_nombre;
	}

	public void setTem_nombre(String tem_nombre) {
		this.tem_nombre = tem_nombre;
	}

	public String getTem_descripcion() {
		return tem_descripcion;
	}

	public void setTem_descripcion(String tem_descripcion) {
		this.tem_descripcion = tem_descripcion;
	}

	public String getTem_foto() {
		return tem_foto;
	}

	public void setTem_foto(String tem_foto) {
		this.tem_foto = tem_foto;
	}

	public String getTem_material_archivo() {
		return tem_material_archivo;
	}

	public void setTem_material_archivo(String tem_material_archivo) {
		this.tem_material_archivo = tem_material_archivo;
	}

	public String getTem_material_video() {
		return tem_material_video;
	}

	public void setTem_material_video(String tem_material_video) {
		this.tem_material_video = tem_material_video;
	}

    /*{ "tem_id":"9016", "mat_id":"1405","tem_nombre":"lomas", "tem_descripcion":"restas de numeros", "tem_foto":"677", "tem_material_archivo":" efwef", "tem_material_video": "sfsfsf" }*/

    
	

}
