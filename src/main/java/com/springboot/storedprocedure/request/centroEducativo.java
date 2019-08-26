package com.springboot.storedprocedure.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class centroEducativo {
	
	@NotBlank
    @Size(min=1, max = 60)
    private String nit;
	
	@NotBlank
    @Size(min = 1, max = 40)
    private String nombre;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String ciudad;
    
    @NotBlank
    @Size(min=1, max = 60)
    private String telefono;
    
    @NotBlank
    @Size(min = 1, max = 40)
    private String direccion;

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    
    
	
	
    

    
	

}
