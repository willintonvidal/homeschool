package com.springboot.storedprocedure.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import com.springboot.storedprocedure.model.Matricula;
import com.springboot.storedprocedure.repository.CentroEducativodao;
import com.springboot.storedprocedure.repository.Matriculadao;
import com.springboot.storedprocedure.request.centroEducativo;
import com.springboot.storedprocedure.request.matricula;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/matricula")
public class Matriculacontroller {
	@Autowired
	Matriculadao matridao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Matricula> getAll() {
		logger.debug("Get all matriculaas");
		return matridao.get_all_matriculas();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	//Este metodo inserta todos los datos en la tabla matricula
	@PostMapping("/insertar")
    public String crearMatricula(@Valid @RequestBody matricula matr) throws ParseException {
		
		Long matri_id= new Long (matr.getMatri_id());
		Long est_id= new Long (matr.getEst_id());
		Long mat_id= new Long (matr.getMat_id());
		Date matri_f_inicio= new SimpleDateFormat("dd-MM-yyyy").parse(matr.getMatri_fecha_inicio());
		Date matri_f_fin= new SimpleDateFormat("dd-MM-yyyy").parse(matr.getMatri_fecha_fin());
		Double matri_not_final= new Double (matr.getMatri_not_final());
		
		Integer resul =matridao.insertar_matricula( matri_id, est_id, mat_id, matri_f_inicio, matri_f_fin, matr.getMatri_estado(), matri_not_final);
		if(resul ==1) return "Se insertaron correctamente los datos de la tabla matricula";
		else return "Los datos no fueron insertados";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla matricula
	@PutMapping("/actualizar")
    public String actualizarMatricula(@Valid @RequestBody  matricula matr) throws ParseException {
	
		Long matri_id= new Long (matr.getMatri_id());
		Long est_id= new Long (matr.getEst_id());
		Long mat_id= new Long (matr.getMat_id());
		Date matri_f_inicio= new SimpleDateFormat("dd-MM-yyyy").parse(matr.getMatri_fecha_inicio());
		Date matri_f_fin= new SimpleDateFormat("dd-MM-yyyy").parse(matr.getMatri_fecha_fin());
		Double matri_not_final= new Double (matr.getMatri_not_final());
		
		Integer resul =matridao.actualizar_matricula( matri_id, est_id, mat_id, matri_f_inicio, matri_f_fin, matr.getMatri_estado(), matri_not_final);
		if(resul ==1) return "Los datos fueron actualizados correctamente para la tabla matricula";
		else return "No se pudo actualizar los datos de la tabla matricula";
    }
	
	
	//Este metodo elimina los datos por id de la tabla matricula
	@DeleteMapping("/eliminar/{id}")
    public String eliminarMatricula(@PathVariable Long id) {
		Integer resul = matridao.eliminar_matricula(id);
		if(resul==1) return "se elimino correctamente la matricula";
		else return "No se pudo eliminar la matricula";
	}

	
}