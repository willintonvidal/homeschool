package com.springboot.storedprocedure.controller;



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

import com.springboot.storedprocedure.model.Profesor;
import com.springboot.storedprocedure.repository.Profesordao;
import com.springboot.storedprocedure.request.centroEducativo;
import com.springboot.storedprocedure.request.profesor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/profesor")
public class Profesorcontroller {
	@Autowired
	Profesordao profedao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Profesor> getAll() {
		logger.debug("Get all  los profesores");
		return profedao.get_all_profesor();
	}
	
	@GetMapping(value= "/gradosasignados/{id}")
	public Iterable<Profesor> gradosAsignados(@PathVariable Long id) {
		logger.debug("Get all  cursos asignados");
		return profedao.CursosAsignados(id);
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearProfesor(@Valid @RequestBody profesor prof) {
		Long id= new Long (prof.getId_prof());
		Integer resul =profedao.insertar_profesor(id, prof.getTitulo_prof(),prof.getExperiencia_laboral_prof());
		if(resul ==1) return "Se insertaron correctamente los datos de la tabla profesor";
		else return "Los datos de la tabla profesor no fueron insertados ";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
    public String actualizarProfesor(@Valid @RequestBody profesor prof) {
		Long id= new Long (prof.getId_prof());
		Integer resul =profedao.actualizar_profesor(id, prof.getTitulo_prof(),prof.getExperiencia_laboral_prof());
		if(resul ==1) return "Se actualizaron correctamente los datos de la tabla profesor";
		else return "Los datos de la tabla profesor no fueron actualizados ";
        
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Long id) {
		Integer resul = profedao.eliminar_profesor(id);
		if(resul==1) return "El profesor se elimino correctamente";
		else return "No se pudo eliminar el profesor";
	}

	
}