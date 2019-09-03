package com.springboot.storedprocedure.model;



import java.util.Date;

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
@Table(name= "ACTIVIDAD_EVALUATIVA")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one-mostrar-actividad-evaluativa", procedureName= "gestionar_actividad_evaluativa.get_all_actividad_evaluativa",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorActividadEvaluativa", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two-editar--actividad-evaluativa", procedureName= "gestionar_actividad_evaluativa.insertar_actividad_evaluativa", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_nombre", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_fecha_inicio", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_fin", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_foto", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third-actualizar-actividad-evaluativa", procedureName= "gestionar_actividad_evaluativa.actualizar_actividad_evaluati", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_nombre", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_fecha_inicio", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_fin", type= Date.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_foto", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four-eliminar-actividad-evaluativa", procedureName= "gestionar_actividad_evaluativa.eliminar_actividad_evaluativa", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Actividad_Evaluativa {

	@Id
	private Long ACT_EVA_ID;
	private Long TEM_ID;
	private Long MAT_ID;
	private String ACT_EVA_NOMBRE;
	private Date ACT_EVA_FECHA_INICIO;
	private Date ACT_EVA_FECHA_FIN;
	private String ACT_EVA_OBSERVACION;
	private String ACT_EVA_FOTO;
	public Long getACT_EVA_ID() {
		return ACT_EVA_ID;
	}
	public void setACT_EVA_ID(Long aCT_EVA_ID) {
		ACT_EVA_ID = aCT_EVA_ID;
	}
	public Long getTEM_ID() {
		return TEM_ID;
	}
	public void setTEM_ID(Long tEM_ID) {
		TEM_ID = tEM_ID;
	}
	public Long getMAT_ID() {
		return MAT_ID;
	}
	public void setMAT_ID(Long mAT_ID) {
		MAT_ID = mAT_ID;
	}
	public String getACT_EVA_NOMBRE() {
		return ACT_EVA_NOMBRE;
	}
	public void setACT_EVA_NOMBRE(String aCT_EVA_NOMBRE) {
		ACT_EVA_NOMBRE = aCT_EVA_NOMBRE;
	}
	public Date getACT_EVA_FECHA_INICIO() {
		return ACT_EVA_FECHA_INICIO;
	}
	public void setACT_EVA_FECHA_INICIO(Date aCT_EVA_FECHA_INICIO) {
		ACT_EVA_FECHA_INICIO = aCT_EVA_FECHA_INICIO;
	}
	public Date getACT_EVA_FECHA_FIN() {
		return ACT_EVA_FECHA_FIN;
	}
	public void setACT_EVA_FECHA_FIN(Date aCT_EVA_FECHA_FIN) {
		ACT_EVA_FECHA_FIN = aCT_EVA_FECHA_FIN;
	}
	public String getACT_EVA_OBSERVACION() {
		return ACT_EVA_OBSERVACION;
	}
	public void setACT_EVA_OBSERVACION(String aCT_EVA_OBSERVACION) {
		ACT_EVA_OBSERVACION = aCT_EVA_OBSERVACION;
	}
	public String getACT_EVA_FOTO() {
		return ACT_EVA_FOTO;
	}
	public void setACT_EVA_FOTO(String aCT_EVA_FOTO) {
		ACT_EVA_FOTO = aCT_EVA_FOTO;
	}
	@Override
	public String toString() {
		return "Actividad_Evaluativa [ACT_EVA_ID=" + ACT_EVA_ID + ", TEM_ID=" + TEM_ID + ", MAT_ID=" + MAT_ID
				+ ", ACT_EVA_NOMBRE=" + ACT_EVA_NOMBRE + ", ACT_EVA_FECHA_INICIO=" + ACT_EVA_FECHA_INICIO
				+ ", ACT_EVA_FECHA_FIN=" + ACT_EVA_FECHA_FIN + ", ACT_EVA_OBSERVACION=" + ACT_EVA_OBSERVACION
				+ ", ACT_EVA_FOTO=" + ACT_EVA_FOTO + "]";
	}
	
	
	
	

}