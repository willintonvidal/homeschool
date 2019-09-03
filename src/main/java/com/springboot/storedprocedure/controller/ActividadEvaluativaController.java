package com.springboot.storedprocedure.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.springboot.storedprocedure.repository.ActividadEvaluativaRepositorio;

import com.springboot.storedprocedure.request.actividadEvaluativaRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/actividad_evaluativa")
public class ActividadEvaluativaController {
	@Autowired
	ActividadEvaluativaRepositorio actiEvaluativa;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all actividad evaluativa");
		return actiEvaluativa.get_all_actividad_evaluativa();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	
	

	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearActividadEvaluativa(@Valid @RequestBody actividadEvaluativaRequest actiEva) throws ParseException {
		
		Long uno = new Long(actiEva.getActividad_eva_id());
		Long dos = new Long(actiEva.getTema_id());
		Long tres = new Long(actiEva.getMateria_id());
		
		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(actiEva.getActividad_fecha_inicio());
		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(actiEva.getActividad_eva_fin());
		
		
		
		Integer resul = actiEvaluativa.insertar_actividad_evaluativa(uno,dos,tres,actiEva.getActividad_eva_nombre(),date1,date2,actiEva.getActividad_eva_(),actiEva.getActividad_eva_foto());
		if(resul ==1) return "Se insertaron correctamente los datos";
		else return "Los datos no fueron insertados";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
    public String actualizarActividadEvaluativa(@Valid @RequestBody actividadEvaluativaRequest actiEva) throws ParseException {
		
		
		Long uno = new Long(actiEva.getActividad_eva_id());
		Long dos = new Long(actiEva.getTema_id());
		Long tres = new Long(actiEva.getMateria_id());
		
		Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(actiEva.getActividad_fecha_inicio());
		Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(actiEva.getActividad_eva_fin());
		
		
		
		Integer resul = actiEvaluativa.actualizar_actividad_evaluativa(uno,dos,tres,actiEva.getActividad_eva_nombre(),date1,date2,actiEva.getActividad_eva_(),actiEva.getActividad_eva_foto());
		if(resul ==1) return "Se actualizaron correctamente los datos";
		else return "No se actualizaron los datos de actividad evaluativa";
		
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarActividadEvaluativa(@PathVariable Long id) {
		Integer resul = actiEvaluativa.eliminar_actividad_evaluativa(id);
		if(resul==1) return "La actividad evaluativa fue eliminada correctamente";
		else return "No se pudo eliminar la actividad evaluativa";
	}

	
}