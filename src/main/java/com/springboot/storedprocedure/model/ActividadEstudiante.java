package com.springboot.storedprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@Entity 
@Table(name= "ACTIVIDAD_ESTUDIANTE")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one-mostrar-actividad-estudiante", procedureName= "gestionar_actividad_estudiante.get_all_actividad_estudiant",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorActividadEstudiante", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two-insertar-actividad-estudiante", procedureName= "gestionar_actividad_estudiante.insertar_actividad_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_act_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_actividad_nota", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third-editar-actividad-estudiante", procedureName= "gestionar_actividad_estudiante.actualizar_actividad_estudiant", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_act_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "actividad_eva_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_actividad_nota", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four-eliminar-actividad-estudiante", procedureName= "gestionar_actividad_estudiante.eliminar_actividad_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_act_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class ActividadEstudiante {
	
	@Id
	private Long REL_ACT_ID;
	private Long EST_ID;
	private Long ACT_EVA_ID;
	private Long TEM_ID;
	private Long MAT_ID;
	private Long REL_ACT_NOTA;
	public Long getREL_ACT_ID() {
		return REL_ACT_ID;
	}
	public void setREL_ACT_ID(Long rEL_ACT_ID) {
		REL_ACT_ID = rEL_ACT_ID;
	}
	public Long getEST_ID() {
		return EST_ID;
	}
	public void setEST_ID(Long eST_ID) {
		EST_ID = eST_ID;
	}
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
	public Long getREL_ACT_NOTA() {
		return REL_ACT_NOTA;
	}
	public void setREL_ACT_NOTA(Long rEL_ACT_NOTA) {
		REL_ACT_NOTA = rEL_ACT_NOTA;
	}
	
	
	@Override
	public String toString() {
		return "ActividadEstudiante [REL_ACT_ID=" + REL_ACT_ID + ", EST_ID=" + EST_ID + ", ACT_EVA_ID=" + ACT_EVA_ID
				+ ", TEM_ID=" + TEM_ID + ", MAT_ID=" + MAT_ID + ", REL_ACT_NOTA=" + REL_ACT_NOTA + "]";
	}
	
		
	
		
	
}
