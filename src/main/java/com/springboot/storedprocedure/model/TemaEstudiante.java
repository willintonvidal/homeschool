package com.springboot.storedprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@Entity 
@Table(name= "TEMA_ESTUDIANTE")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one-mostrar-tema-estudiante", procedureName= "gestionar_tema_estudiante.get_all_temas_estudiante",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorTemaEstudiante", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two-insertar-tema-estudiante", procedureName= "gestionar_tema_estudiante.insertar_tema_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_tema_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_tema_nota", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third-editar-tema-estudiante", procedureName= "gestionar_tema_estudiante.actualizar_tema_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_tema_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "tema_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "materia_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_tema_nota", type= Double.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four-eliminar-tema-estudiante", procedureName= "gestionar_tema_estudiante.eliminar_tema_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "rel_tema_est_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class TemaEstudiante {
	
	@Id
	private Long REL_TEMA_ID;
	private Long EST_ID;
	private Long TEM_ID;
	private Long MAT_ID;
	private Long REL_TEM_NOTA;
	
	
	public Long getREL_TEMA_ID() {
		return REL_TEMA_ID;
	}
	public void setREL_TEMA_ID(Long rEL_TEMA_ID) {
		REL_TEMA_ID = rEL_TEMA_ID;
	}
	public Long getEST_ID() {
		return EST_ID;
	}
	public void setEST_ID(Long eST_ID) {
		EST_ID = eST_ID;
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
	public Long getREL_TEM_NOTA() {
		return REL_TEM_NOTA;
	}
	public void setREL_TEM_NOTA(Long rEL_TEM_NOTA) {
		REL_TEM_NOTA = rEL_TEM_NOTA;
	}
	@Override
	public String toString() {
		return "TemaEstudiante [REL_TEMA_ID=" + REL_TEMA_ID + ", EST_ID=" + EST_ID + ", TEM_ID=" + TEM_ID + ", MAT_ID="
				+ MAT_ID + ", REL_TEM_NOTA=" + REL_TEM_NOTA + "]";
	}
	
	
	
	
		
	
	
}
