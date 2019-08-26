package com.springboot.storedprocedure.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storedprocedure.model.Centro_Educativo;
import com.springboot.storedprocedure.repository.CentroEducativodao;
import com.springboot.storedprocedure.request.centroEducativo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/centroeducativo")
public class CentroEducativocontroller {
	@Autowired
	CentroEducativodao centroEdao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all centros educativos");
		return centroEdao.get_all_centro_educativo();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	
	

	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearInstitucion(@Valid @RequestBody centroEducativo centro) {
		
		
		
		Integer resul = centroEdao.insertar_centro_educativo(centro.getNit(),centro.getNombre(),centro.getCiudad(),centro.getTelefono(),centro.getDireccion());
		if(resul ==1) return "Se insertaron correctamente los datos";
		else return "Los datos no fueron insertados";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
    public String actualizarInstitucion(@Valid @RequestBody centroEducativo centro) {
		
		
		Integer resul = centroEdao.actualizar_centro_educativo(centro.getNit(),centro.getNombre(),centro.getCiudad(),centro.getTelefono(),centro.getDireccion());
		if(resul ==1) return "Los datos fueron actualizados correctamente";
		else return "No se pudo actualizar los datos";
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarInstitucion(@PathVariable String id) {
		Integer resul = centroEdao.eliminar_centro_educativo(id);
		if(resul==1) return "La institucion fue eliminar el centro educativo";
		else return "No se pudo eliminar el centro educativo";
	}

	
}