package com.springboot.storedprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@Entity 
@Table(name= "ESTUDIANTE")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one-mostrar-estudiantes", procedureName= "gestionar_estudiante.get_all_estudiantes",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorEstudiante", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two-insertar", procedureName= "gestionar_estudiante.insertar_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_numero_ident", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "grado_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third-editar", procedureName= "gestionar_estudiante.actualizar_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_numero_ident", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "grado_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four-eliminar", procedureName= "gestionar_estudiante.eliminar_estudiante", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "estudiante_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Estudiante {
	
	@Id
	private Long EST_ID;
	private Long ACU_NUMERO_IDENTIFICACION;
	private Long GRA_ID;
	
	
	
	public Long getEST_ID() {
		return EST_ID;
	}
	public void setEST_ID(Long eST_ID) {
		EST_ID = eST_ID;
	}
	public Long getACU_NUMERO_IDENTIFICACION() {
		return ACU_NUMERO_IDENTIFICACION;
	}
	public void setACU_NUMERO_IDENTIFICACION(Long aCU_NUMERO_IDENTIFICACION) {
		ACU_NUMERO_IDENTIFICACION = aCU_NUMERO_IDENTIFICACION;
	}
	public Long getGRA_ID() {
		return GRA_ID;
	}
	public void setGRA_ID(Long gRA_ID) {
		GRA_ID = gRA_ID;
	}
	
		
	
	@Override
	public String toString() {
		return "Estudiante [EST_ID=" + EST_ID + ", ACU_NUMERO_IDENTIFICACION=" + ACU_NUMERO_IDENTIFICACION + ", GRA_ID="
				+ GRA_ID + "]";
	}	
	
	
	
}
