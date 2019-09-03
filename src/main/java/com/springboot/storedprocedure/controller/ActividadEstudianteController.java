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
import com.springboot.storedprocedure.repository.ActividadEstudianteRepositorio;
import com.springboot.storedprocedure.request.actividadEstudianteRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/actividad_estudiante")
public class ActividadEstudianteController {
	@Autowired
	ActividadEstudianteRepositorio  actiEstudiante;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all Actividades estudiante");
		return actiEstudiante.get_all_actividad_estudiante();
	}
	

	
	@PostMapping("/insertar")
    public String crearActividadEvaluativa(@Valid @RequestBody actividadEstudianteRequest actiEva) {
		
		Long uno = new Long(actiEva.getRel_act_est_id());
		Long dos = new Long(actiEva.getEstudiante_id());
		Long tres = new Long(actiEva.getActividad_eva_id());
		Long cuatro = new Long(actiEva.getTema_id());
		Long cinco = new Long(actiEva.getMateria_id());

		
		Double seis = new Double(actiEva.getRel_actividad_nota().replace(",","."));
		
		Integer resul = actiEstudiante.insertar_actividad_estudiante(uno,dos,tres,cuatro,cinco,seis);
		if(resul ==1) return "Se insertaron correctamente los datos";
		else return "Los datos no fueron insertados";
        
    }

	
	@PutMapping("/actualizar")
    public String actualizarActividadEvaluativa(@Valid @RequestBody actividadEstudianteRequest actiEva) {
		
		Long uno = new Long(actiEva.getRel_act_est_id());
		Long dos = new Long(actiEva.getEstudiante_id());
		Long tres = new Long(actiEva.getActividad_eva_id());
		Long cuatro = new Long(actiEva.getTema_id());
		Long cinco = new Long(actiEva.getMateria_id());
		Double seis = new Double(actiEva.getRel_actividad_nota().replace(",","."));
		
		Integer resul = actiEstudiante.actualizar_actividad_estudiante(uno,dos,tres,cuatro,cinco,seis);
		if(resul ==1) return "Se actualizaron correctamente los datos";
		else return "Los datos no fueron actualizados";
		
	}

	
	//
	@DeleteMapping("/eliminar/{id}")
    public String eliminarActividadEvaluativa(@PathVariable Long id) {
		Integer resul = actiEstudiante.eliminar_actividad_estudiante(id);
		if(resul==1) return "Se elimino correctamente la actividad evaluativa";
		else return "No se elimino correctamente la actividad evaluativa";
	}

	
}