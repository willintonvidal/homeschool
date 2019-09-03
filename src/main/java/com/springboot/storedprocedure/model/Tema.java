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
@Table(name= "TEMAS")
@NamedStoredProcedureQueries(value= {
		@NamedStoredProcedureQuery(name= "procedure-mostrar-tema", procedureName= "GestionarTema.mostrarTema",parameters= {
				@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "cursorTema", type= void.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-insertar-tema", procedureName= "GestionarTema.insertarTema", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_tem", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "descripcion_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "foto_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "material_archivo_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "material_video_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-actualizar-tema", procedureName= "GestionarTema.actualizarTema", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_tem", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_mat", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "nombre_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "descripcion_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "foto_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "material_archivo_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "material_video_tem", type= String.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		}),
		@NamedStoredProcedureQuery(name= "procedure-eliminar-tema", procedureName= "GestionarTema.eliminarTema", parameters= {
				@StoredProcedureParameter(mode= ParameterMode.IN, name= "id_tem", type= Long.class),
				@StoredProcedureParameter(mode= ParameterMode.OUT, name= "ejecuto", type= Integer.class)
		})  
})
public class Tema {

	@Id
	private Long TEM_ID;
	private Long MAT_ID;
	private String TEM_NOMBRE;
	private String TEM_DESCRIPCION;
	private String TEM_FOTO;
	private String TEM_MATERIAL_ARCHIVO;
	private String TEM_MATERIAL_VIDEO;
	
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
	public String getTEM_NOMBRE() {
		return TEM_NOMBRE;
	}
	public void setTEM_NOMBRE(String tEM_NOMBRE) {
		TEM_NOMBRE = tEM_NOMBRE;
	}
	public String getTEM_DESCRIPCION() {
		return TEM_DESCRIPCION;
	}
	public void setTEM_DESCRIPCION(String tEM_DESCRIPCION) {
		TEM_DESCRIPCION = tEM_DESCRIPCION;
	}
	public String getTEM_FOTO() {
		return TEM_FOTO;
	}
	public void setTEM_FOTO(String tEM_FOTO) {
		TEM_FOTO = tEM_FOTO;
	}
	public String getTEM_MATERIAL_ARCHIVO() {
		return TEM_MATERIAL_ARCHIVO;
	}
	public void setTEM_MATERIAL_ARCHIVO(String tEM_MATERIAL_ARCHIVO) {
		TEM_MATERIAL_ARCHIVO = tEM_MATERIAL_ARCHIVO;
	}
	public String getTEM_MATERIAL_VIDEO() {
		return TEM_MATERIAL_VIDEO;
	}
	public void setTEM_MATERIAL_VIDEO(String tEM_MATERIAL_VIDEO) {
		TEM_MATERIAL_VIDEO = tEM_MATERIAL_VIDEO;
	}
	
	@Override
	public String toString() {
		return "Tema [TEM_ID=" + TEM_ID + ", MAT_ID=" + MAT_ID + ", TEM_NOMBRE=" + TEM_NOMBRE + ", TEM_DESCRIPCION="
				+ TEM_DESCRIPCION + ", TEM_FOTO=" + TEM_FOTO + ", TEM_MATERIAL_ARCHIVO=" + TEM_MATERIAL_ARCHIVO
				+ ", TEM_MATERIAL_VIDEO=" + TEM_MATERIAL_VIDEO + "]";
	}

	
}