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

import com.springboot.storedprocedure.model.Centro_Educativo;
import com.springboot.storedprocedure.repository.EstudianteRepositorio;
import com.springboot.storedprocedure.request.estudianteRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/estudiante")
public class EstudianteController {
	@Autowired
	EstudianteRepositorio estudianteRepo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all Estudiantes");
		return estudianteRepo.get_all_estudiante();
	}
	

	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearEstudiante(@Valid @RequestBody estudianteRequest estudent) {
		
		Long uno = new Long(estudent.getEstudiante_id());
		Long dos = new Long(estudent.getAcu_numero_ident());
		Long tres = new Long(estudent.getGrado_id());
		
		Integer resul = estudianteRepo.insertar_estudiante(uno,dos,tres);
		if(resul ==1) return "Se insertaron correctamente los datos";
		else return "Los datos no fueron insertados";
        
    }

	//
	@PutMapping("/actualizar")
    public String actualizarInstitucion(@Valid @RequestBody estudianteRequest estudent) {
		
		Long uno = new Long(estudent.getEstudiante_id());
		Long dos = new Long(estudent.getAcu_numero_ident());
		Long tres = new Long(estudent.getGrado_id());
		
		Integer resul = estudianteRepo.actualizar_estudiante(uno,dos,tres);
		if(resul ==1) return "Los datos del estudiante fueron actualizaron correctamente";
		else return "No se actualizaron los datos de estudiante";
    }

	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarInstitucion(@PathVariable Long id) {
		Integer resul = estudianteRepo.eliminar_estudiante(id);
		if(resul==1) return "El estudiante se elimino correctamente";
		else return "No se pudo eliminar el estudiante";
	}

	
}