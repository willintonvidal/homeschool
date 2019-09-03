package com.springboot.storedprocedure.model;


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
@Table(name= "PROFESOR")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar-profesor", procedureName= "GestionarProfesor.mostrarProfesor",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorProfesor", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-mostrar-cursos-asignados", procedureName= "GestionarProfesor.mostrarCursosAsignados",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "profesor_id", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorCurAsignados", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar-profesor", procedureName= "GestionarProfesor.insertarProfesor", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_prof", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "titulo_prof", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "experiencia_laboral_prof", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
			
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar-profesor", procedureName= "GestionarProfesor.actualizarProfesor", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_prof", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "titulo_prof", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "experiencia_laboral_prof", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar-profesor", procedureName= "GestionarProfesor.eliminarProfesor", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_prof", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Profesor {

	@Id
	private Long prof_id;
	private String prof_titulo;
	private String prof_experiencia_laboral;
	
	public Long getProf_id() {
		return prof_id;
	}
	public void setProf_id(Long prof_id) {
		this.prof_id = prof_id;
	}
	public String getProf_titulo() {
		return prof_titulo;
	}
	public void setProf_titulo(String prof_titulo) {
		this.prof_titulo = prof_titulo;
	}
	@Override
	public String toString() {
		return "Profesor [prof_id=" + prof_id + ", prof_titulo=" + prof_titulo + ", prof_experiencia_laboral="
				+ prof_experiencia_laboral + "]";
	}
	
	
	
}