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
import com.springboot.storedprocedure.model.Materia;
import com.springboot.storedprocedure.repository.CentroEducativodao;
import com.springboot.storedprocedure.repository.Materiadao;
import com.springboot.storedprocedure.request.centroEducativo;
import com.springboot.storedprocedure.request.materia;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/materia")
public class Materiacontroller {
	@Autowired
	Materiadao matedao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Materia> getAll() {
		logger.debug("Get all materias");
		return matedao.get_all_materia();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	
	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearMateria(@Valid @RequestBody materia mat) {
		
		
		Long id= new Long(mat.getMat_id());
		Long idGrado= new Long(mat.getGra_id());
		Long idProfesor= new Long(mat.getProf_id());
		
		
		Integer resul = matedao.insertar_materia(id,mat.getMat_nombre(), idGrado,idProfesor);
		if(resul ==1) return "Se insertaron correctamente los datos de la tabla materia";
		else return "Los datos de  la tabla materia no fueron insertados";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
    public String actualizarMateria(@Valid @RequestBody materia mat) {
		
		Long id= new Long(mat.getMat_id());
		Long idGrado= new Long(mat.getGra_id());
		Long idProfesor= new Long(mat.getProf_id());
		
		Integer resul = matedao.actualizar_materia(id,mat.getMat_nombre(), idGrado,idProfesor);
		if(resul ==1) return "Los datos de la tabla materia fueron actualizados correctamente";
		else return "No se pudo actualizar los datos de la tabla materia";
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id) {
		Integer resul = matedao.eliminar_materia(id);
		if(resul==1) return "La materia fue eliminada exitosamnete";
		else return "No se pudo eliminar la tabla materia";
	}

	
}