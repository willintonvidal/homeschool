package com.springboot.storedprocedure.model;

import java.awt.Cursor;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


//debemos mapear la entidad, de aqui se dan nombre a los procedimientos y a sus 
//respectivos datos de entrada y de salida para luego pasar al repositorio y ser llamados de ahi
@Entity 
@Table(name= "GRADO")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar-grado", procedureName= "GestionarGrado.mostrarGrado",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorGrado", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar-grado", procedureName= "GestionarGrado.insertarGrado", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_gra", type=Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_gra", type= String.class),
			    @StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar-grado", procedureName= "GestionarGrado.actualizarGrado", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_gra", type=Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_gra", type= String.class),
			    @StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar-grado", procedureName= "GestionarGrado.eliminarGrado", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_gra", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Grado {

	@Id
    private Long GRA_ID;
	
	private String GRA_NOMBRE;
	
	
	public Long getGRA_ID() {
		return GRA_ID;
	}
	public void setGRA_ID(Long gRA_ID) {
		GRA_ID=gRA_ID;
	}
	public String getGRA_NOMBRE() {
		return GRA_NOMBRE;
	}
	public void setGRA_NOMBRE(String gRA_NOMBRE) {
		GRA_NOMBRE = gRA_NOMBRE;
	}

	
	@Override
	public String toString() {
		return "Grado [GRA_ID=" + GRA_ID + ", GRA_NOMBRE=" + GRA_NOMBRE + "]";
	}

	
}