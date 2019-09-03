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
import com.springboot.storedprocedure.model.Grado;
import com.springboot.storedprocedure.repository.CentroEducativodao;
import com.springboot.storedprocedure.repository.Gradodao;
import com.springboot.storedprocedure.request.centroEducativo;
import com.springboot.storedprocedure.request.grado;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/grado")
public class Gradocontroller {
	@Autowired
	Gradodao gradao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla grado
	
	@GetMapping(value= "/getall")
	public Iterable<Grado> getAll() {
		logger.debug("Get all los grados");
		return gradao.get_all_grados();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	

	//Este metodo inserta todos los datos en la tabla grado
	@PostMapping("/insertar")
    public String crearGrado(@Valid @RequestBody grado gra) {
         Long n1= new Long (gra.getId());
         Integer resul = gradao.insertar_grados(n1, gra.getNombre());
		if(resul ==1) return "Se insertaron correctamente los datos  a la tabla grado";
		else return "Los datos no fueron insertados en la tabla grado ";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
    public String actualizarGrado(@Valid @RequestBody grado gra) {
		 
	    Long n1= new Long (gra.getId());
     	Integer resul = gradao.actualizar_grados(n1, gra.getNombre());
		if(resul ==1) return "Se actualizaron correctamente los datos  a la tabla grado";
		else return "Los datos no fueron actualizados en la tabla grado ";
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarGrado(@PathVariable Long id) {
		
		Integer resul = gradao.eliminar_grados(id);
		if(resul==1) return "El grado se elimino correctamente";
		else return "No se pudo eliminarel grado";
	}

	
}