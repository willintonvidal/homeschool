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

import com.springboot.storedprocedure.model.Tema;
import com.springboot.storedprocedure.repository.Temadao;
import com.springboot.storedprocedure.request.tema;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/tema")
public class Temacontroller {
	@Autowired
	Temadao temadao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla tema
	
	@GetMapping(value= "/getall")
	public Iterable<Tema> getAll() {
		logger.debug("Get all los temas");
		return temadao.get_all_temas();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	
	//Este metodo inserta todos los datos en la tabla tema
	@PostMapping("/insertar")
    public String crearTema(@Valid @RequestBody tema tem) {
		
		Long id_tema=new Long(tem.getTem_id());
		Long id_materia= new Long (tem.getMat_id());
		Integer resul = temadao.insertar_tema(id_tema, id_materia,tem.getTem_nombre(),tem.getTem_descripcion(), tem.getTem_foto(),tem.getTem_material_archivo(), tem.getTem_material_video());
		if(resul ==1) return "Se insertaron correctamente los datos de la tabla tema";
		else return "Los datos no fueron insertados en la tabla tema";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla tema
	@PutMapping("/actualizar")
    public String actualizarInstitucion(@Valid @RequestBody tema tem) {
		
		Long id_tema=new Long(tem.getTem_id());
		Long id_materia= new Long (tem.getMat_id());
		Integer resul = temadao.actualizar_tema(id_tema, id_materia,tem.getTem_nombre(),tem.getTem_descripcion(), tem.getTem_foto(),tem.getTem_material_archivo(), tem.getTem_material_video());
		if(resul ==1) return "Se actualizaron correctamente los datos de la tabla tema";
		else return "Los datos no fueron actualizados en la tabla tema";
    }
	
	
	//Este metodo elimina los datos por id del tema
	@DeleteMapping("/eliminar/{id}")
    public String eliminarInstitucion(@PathVariable Long id) {
		Integer resul = temadao.eliminar_tema(id);
		if(resul==1) return "El tema se elimino correctamente";
		else return "El tema no se pudo eliminar";
	}

	
}