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
import com.springboot.storedprocedure.repository.TemaEstudianteRepositorio;
import com.springboot.storedprocedure.request.temaEstudianteRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/tema_estudiante")
public class TemaEstudianteController {
	@Autowired
	TemaEstudianteRepositorio temaEstudianteRepo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all Tema estudiante");
		return temaEstudianteRepo.get_all_tema_estudiante();
	}
	

	
	@PostMapping("/insertar")
    public String crearTemaEstudiante(@Valid @RequestBody temaEstudianteRequest temaes) {
		
		Long uno = new Long(temaes.getRel_tema_est_id());
		Long dos = new Long(temaes.getEstudiante_id());
		Long tres = new Long(temaes.getTema_id());
		Long cuatro = new Long(temaes.getMateria_id());
		//Long cinco = new Long(temaes.getRel_tema_nota());
		Double cinco = new Double(temaes.getRel_tema_nota().replace(",","."));
		
		Integer resul = temaEstudianteRepo.insertar_tema_estudiante(uno,dos,tres,cuatro,cinco);
		if(resul ==1) return "Se insertaron correctamente los datos";
		else return "Los datos no fueron insertados";
        
    }

	
	
	
	
	@PutMapping("/actualizar")
	public String actualizatTemaEstudiante(@Valid @RequestBody temaEstudianteRequest temaes) {
		
		Long uno = new Long(temaes.getRel_tema_est_id());
		Long dos = new Long(temaes.getEstudiante_id());
		Long tres = new Long(temaes.getTema_id());
		Long cuatro = new Long(temaes.getMateria_id());
		Double cinco = new Double(temaes.getRel_tema_nota().replace(",","."));
		
		Integer resul = temaEstudianteRepo.actualizar_tema_estudiante(uno,dos,tres,cuatro,cinco);
		if(resul ==1) return "Se actualizaron correctamente los datos de tema estudiante";
		else return "No se actualizaron los datos de tema estudiante";
        
    }
	
	
	@DeleteMapping("/eliminar/{id}")
    public String eliminarTemaInstitucion(@PathVariable Long id) {
		Integer resul = temaEstudianteRepo.eliminar_tema_estudiante(id);
		if(resul==1) return "los datos de la tabla TemaEstudiantefueron eliminados";
		else return "No se pudo eliminar los datos de la tabla tema Estudiante";
	}
	

	
}