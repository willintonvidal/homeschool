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
import com.springboot.storedprocedure.repository.AcudienteRepositorio;
import com.springboot.storedprocedure.request.acudienteRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/acudiente")
public class AcudienteController {
	@Autowired
	AcudienteRepositorio acudienteRepo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(value= "/getall")
	public Iterable<Centro_Educativo> getAll() {
		logger.debug("Get all acudientes");
		return acudienteRepo.get_all_acudiente();
	}
	
	@PostMapping("/insertar")
    public String crearAcudiente(@Valid @RequestBody acudienteRequest acudiente) {
		
		Long id = new Long(acudiente.getAcu_numero_ident());
		
		
		Integer resul = acudienteRepo.insertar_acudiente(acudiente.getAcudiente_tipo_ident(),id, acudiente.getAcu_nombre_completo(),acudiente.getEcudiente_email(),acudiente.getAcudiente_telefono());
		if(resul ==1) return "No se puedo eliminar el acudiente";
		else return "Los datos no fueron insertados";
        
    }

	//Este metodo actualiza todos los datos de la tabla estudiante
	@PutMapping("/actualizar")
    public String actualizarAcudiente(@Valid @RequestBody acudienteRequest acudiente) {
		
		Long id = new Long(acudiente.getAcu_numero_ident());
		
		
		Integer resul = acudienteRepo.actualizar_acudiente(acudiente.getAcudiente_tipo_ident(),id, acudiente.getAcu_nombre_completo(),acudiente.getEcudiente_email(),acudiente.getAcudiente_telefono());
		if(resul ==1) return "Se actualizaron correctamente los datos";
		else return "Los datos no fueron actualizados";    }

	
	
	@DeleteMapping("/eliminar/{id}")
    public String eliminarInstitucion(@PathVariable Long id) {
		Integer resul = acudienteRepo.eliminar_acudiente(id);
		if(resul==1) return "Se elimino correctamente el acudiente";
		else return "No se pudo eliminar el acudiente";
	}

	
}