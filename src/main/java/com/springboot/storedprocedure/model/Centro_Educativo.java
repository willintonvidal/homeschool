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
@Table(name= "CENTRO_EDUCATIVO")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one", procedureName= "gestionar_centro_educativo.mostrar_centro_educativo",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorInstitucion", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two", procedureName= "gestionar_centro_educativo.insertar_centro_educativo", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nit_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "ciudad_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "telefono_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "direccion_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third", procedureName= "gestionar_centro_educativo.actualizar_centro_educativo", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nit_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "ciudad_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "telefono_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "direccion_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four", procedureName= "gestionar_centro_educativo.eliminar_centro_educativo", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nit_centro_educativo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Centro_Educativo {

	@Id
	private String CEN_EDU_NIT;
	private String CEN_EDU_NOMBRE;
	private String CEN_EDU_CIUDAD;
	private String CEN_EDU_TELEFONO;
	private String CEN_EDU_DIRECCION;
	
	
	public String getCEN_EDU_NIT() {
		return CEN_EDU_NIT;
	}


	public void setCEN_EDU_NIT(String cEN_EDU_NIT) {
		CEN_EDU_NIT = cEN_EDU_NIT;
	}


	public String getCEN_EDU_NOMBRE() {
		return CEN_EDU_NOMBRE;
	}


	public void setCEN_EDU_NOMBRE(String cEN_EDU_NOMBRE) {
		CEN_EDU_NOMBRE = cEN_EDU_NOMBRE;
	}


	public String getCEN_EDU_CIUDAD() {
		return CEN_EDU_CIUDAD;
	}


	public void setCEN_EDU_CIUDAD(String cEN_EDU_CIUDAD) {
		CEN_EDU_CIUDAD = cEN_EDU_CIUDAD;
	}


	public String getCEN_EDU_TELEFONO() {
		return CEN_EDU_TELEFONO;
	}


	public void setCEN_EDU_TELEFONO(String cEN_EDU_TELEFONO) {
		CEN_EDU_TELEFONO = cEN_EDU_TELEFONO;
	}


	public String getCEN_EDU_DIRECCION() {
		return CEN_EDU_DIRECCION;
	}


	public void setCEN_EDU_DIRECCION(String cEN_EDU_DIRECCION) {
		CEN_EDU_DIRECCION = cEN_EDU_DIRECCION;
	}


	

	
	@Override
	public String toString() {
		return "Centro_Educativo [CEN_EDU_NIT=" + CEN_EDU_NIT + ", CEN_EDU_NOMBRE=" + CEN_EDU_NOMBRE
				+ ", CEN_EDU_CIUDAD=" + CEN_EDU_CIUDAD + ", CEN_EDU_TELEFONO=" + CEN_EDU_TELEFONO
				+ ", CEN_EDU_DIRECCION=" + CEN_EDU_DIRECCION + "]";
	}
}