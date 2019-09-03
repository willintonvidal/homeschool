package com.springboot.storedprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@Entity 
@Table(name= "ACUDIENTE")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-one-mostrar-acudiente", procedureName= "gestionar_acudiente.get_all_acudientes",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorAcudiente", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-two-insertar-acudiente", procedureName= "gestionar_acudiente.insertar_acudiente", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acudiente_tipo_ident", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_numero_ident", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_nombre_completo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "ecudiente_email", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acudiente_telefono", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-third-editar-acudiente", procedureName= "gestionar_acudiente.actualizar_acudiente", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acudiente_tipo_ident", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_numero_ident", type = Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_nombre_completo", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "ecudiente_email", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acudiente_telefono", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-four-eliminar-acudiente", procedureName= "gestionar_acudiente.eliminar_acudiente", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "acu_numero_ident", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Acudiente {
	
	@Id
	private String ACU_TIPO_IDENTIFICACION;
	private Long ACU_NUMERO_IDENTIFICACION;
	private String ACU_NOMBRE_COMPLETO;
	private String ACU_EMAIL;
	private String ACU_TELEFONO;
	public String getACU_TIPO_IDENTIFICACION() {
		return ACU_TIPO_IDENTIFICACION;
	}
	public void setACU_TIPO_IDENTIFICACION(String aCU_TIPO_IDENTIFICACION) {
		ACU_TIPO_IDENTIFICACION = aCU_TIPO_IDENTIFICACION;
	}
	public Long getACU_NUMERO_IDENTIFICACION() {
		return ACU_NUMERO_IDENTIFICACION;
	}
	public void setACU_NUMERO_IDENTIFICACION(Long aCU_NUMERO_IDENTIFICACION) {
		ACU_NUMERO_IDENTIFICACION = aCU_NUMERO_IDENTIFICACION;
	}
	public String getACU_NOMBRE_COMPLETO() {
		return ACU_NOMBRE_COMPLETO;
	}
	public void setACU_NOMBRE_COMPLETO(String aCU_NOMBRE_COMPLETO) {
		ACU_NOMBRE_COMPLETO = aCU_NOMBRE_COMPLETO;
	}
	public String getACU_EMAIL() {
		return ACU_EMAIL;
	}
	public void setACU_EMAIL(String aCU_EMAIL) {
		ACU_EMAIL = aCU_EMAIL;
	}
	public String getACU_TELEFONO() {
		return ACU_TELEFONO;
	}
	public void setACU_TELEFONO(String aCU_TELEFONO) {
		ACU_TELEFONO = aCU_TELEFONO;
	}
	
	
	@Override
	public String toString() {
		return "Acudiente [ACU_TIPO_IDENTIFICACION=" + ACU_TIPO_IDENTIFICACION + ", ACU_NUMERO_IDENTIFICACION="
				+ ACU_NUMERO_IDENTIFICACION + ", ACU_NOMBRE_COMPLETO=" + ACU_NOMBRE_COMPLETO + ", ACU_EMAIL="
				+ ACU_EMAIL + ", ACU_TELEFONO=" + ACU_TELEFONO + "]";
	}
	
	
	
		
	
	
}
