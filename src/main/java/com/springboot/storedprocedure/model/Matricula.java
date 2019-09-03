package com.springboot.storedprocedure.model;

import java.awt.Cursor;
import java.text.DateFormat;
import java.util.Date;
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
@Table(name= "MATRICULA")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar-matricula", procedureName= "GestionarMatricula.mostrarMatricula",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorMatricula", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar-matricula", procedureName= "GestionarMatricula.insertarMatricula", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_matri", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_est", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "fecha_inicio_matri", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "fecha_fin_matri", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estado_matri", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "not_final_matri", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar-matricula", procedureName= "GestionarMatricula.actualizarMatricula", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_matri", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_est", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "fecha_inicio_matri", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "fecha_fin_matri", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estado_matri", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "not_final_matri", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar-matricula", procedureName= "GestionarMatricula.eliminarMatricula", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_matri", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Matricula {

	@Id
	private Long matri_id;
	private Long est_id;
	private Long mat_id;
	private Date matri_fecha_inicio;
	private Date matri_fecha_fin;
	private String matri_estado;
	private Long matri_not_final; 

	public Long getMatri_id() {
		return matri_id;
	}
	public void setMatri_id(Long matri_id) {
		this.matri_id = matri_id;
	}
	public Long getEst_id() {
		return est_id;
	}
	public void setEst_id(Long est_id) {
		this.est_id = est_id;
	}
	public Long getMat_id() {
		return mat_id;
	}
	public void setMat_id(Long mat_id) {
		this.mat_id = mat_id;
	}
	public Date getMatri_fecha_inicio() {
		return matri_fecha_inicio;
	}
	public void setMatri_fecha_inicio(Date matri_fecha_inicio) {
		this.matri_fecha_inicio = matri_fecha_inicio;
	}
	public Date getMatri_fecha_fin() {
		return matri_fecha_fin;
	}
	public void setMatri_fecha_fin(Date matri_fecha_fin) {
		this.matri_fecha_fin = matri_fecha_fin;
	}
	public String getMatri_estado() {
		return matri_estado;
	}
	public void setMatri_estado(String matri_estado) {
		this.matri_estado = matri_estado;
	}
	public Long getMatri_not_final() {
		return matri_not_final;
	}
	public void setMatri_not_final(Long matri_not_final) {
		this.matri_not_final = matri_not_final;
	}

	@Override
	public String toString() {
		return "Matricula [matri_id=" + matri_id + ", est_id=" + est_id + ", mat_id=" + mat_id + ", matri_fecha_inicio="
				+ matri_fecha_inicio + ", matri_fecha_fin=" + matri_fecha_fin + ", matri_estado=" + matri_estado
				+ ", matri_not_final=" + matri_not_final + "]";
	}
	
	
}