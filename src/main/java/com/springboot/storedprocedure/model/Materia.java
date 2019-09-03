package com.springboot.storedprocedure.model;

import java.awt.Cursor;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

//debemos mapear la entidad, de aqui se dan nombre a los procedimientos y a sus 
//respectivos datos de entrada y de salida para luego pasar al repositorio y ser llamados de ahi
@Entity 
@Table(name= "MATERIA")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar-materia", procedureName= "GestionarMateria.mostrarMateria",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorMateria", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar-materia", procedureName= "GestionarMateria.insertarMateria", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_mat", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_gra", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_prof", type= Long.class),
			    @StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar-materia", procedureName= "GestionarMateria.actualizarMateria", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_mat", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_gra", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_prof", type= Long.class),
			    @StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar-materia", procedureName= "GestionarMateria.eliminarMateria", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Materia {

	@Id
	private Long mat_id;
	private String mat_nombre;
	private Long gra_id;
	private Long prof_id;
	
	public Long getMat_id() {
		return mat_id;
	}
	public void setMat_id(Long mat_id) {
		this.mat_id = mat_id;
	}
	public String getMat_nombre() {
		return mat_nombre;
	}
	public void setMat_nombre(String mat_nombre) {
		this.mat_nombre = mat_nombre;
	}
	public Long getGra_id() {
		return gra_id;
	}
	public void setGra_id(Long gra_id) {
		this.gra_id = gra_id;
	}
	public Long getProf_id() {
		return prof_id;
	}
	public void setProf_id(Long prof_id) {
		this.prof_id = prof_id;
	}
	
	@Override
	public String toString() {
		return "Materia [mat_id=" + mat_id + ", mat_nombre=" + mat_nombre + ", gra_id=" + gra_id + ", prof_id="
				+ prof_id + "]";
	}
}