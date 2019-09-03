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
import com.springboot.storedprocedure.model.Usuario;
import com.springboot.storedprocedure.repository.CentroEducativodao;
import com.springboot.storedprocedure.repository.Usuariodao;
import com.springboot.storedprocedure.request.inicioSesionRequest;
import com.springboot.storedprocedure.request.usuario;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/usuario")
public class Usuariocontroller {
	@Autowired
	Usuariodao Usudao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to fetch all employees from the db.
	 * @return
	 */
	
	//Este metodo obtiene todos los datos de la tabla centro_educativo
	
	@GetMapping(value= "/getall")
	public Iterable<Usuario> getAll() {
		logger.debug("Get all los usuarios del sistema");
		return Usudao.get_all_usuarios();
	}
	
	@GetMapping(value= "/getnovalid")
	public Iterable<Usuario> get_usuarios_no_validados() {
		logger.debug("Get all los usuarios no validados");
		return Usudao.get_usuarios_no_validados();
	}
	
	@GetMapping(value= "/")
	public String informacion() {
		return "index";
	}
	
	
	@PostMapping("/iniciosesion")
	public Iterable<Usuario> iniciosesion( @Valid @RequestBody inicioSesionRequest ini) {
		Long id= new Long (ini.getUsuario_id() );
		return  Usudao.inicio_sesion(id, ini.getUsuario_contrasenia());
        
    }
	
	@GetMapping("/verificarusuario/{id}")
	public boolean verificarusuario(@PathVariable Long id) {
		if(Usudao.verificarUsuario(id) ==1)
		return true;  
		
		return false;
        
    }
	
	@GetMapping("/validarusuario/{id}")
	public boolean validarEstadoUsuario(@PathVariable Long id) {
		if(Usudao.ValidarEstadoUsuario(id) ==1)
		return true;  
		
		return false;
        
    }
	
	

	
	//Este metodo inserta todos los datos en la tabla centro educativo
	@PostMapping("/insertar")
    public String crearUsuario(@Valid @RequestBody usuario user) {
		Long id= new Long (user.getUsu_id() );
		Integer resul = Usudao.insertar_usuario(id, user.getCen_edu_nit(), user.getUsu_tipo_documento(),user.getUsu_nombres(),user.getUsu_apellidos(), user.getUsu_tipo_usuario(), user.getUsu_contrasenia(), user.getUsu_estado(), user.getUsu_email(), user.getUsu_telefono(), user.getUsu_foto());
		if(resul ==1) return "Se insertaron correctamente los datos de la tabla usuario";
		else return "Los datos  de la tabla usuario no fueron insertados";
        
    }
	
	
	//Este metodo actualiza todos los datos de la tabla centro educativo
	@PutMapping("/actualizar")
	 public String actualizarUsuario(@Valid @RequestBody usuario user) {
		Long id= new Long (user.getUsu_id() );
		Integer resul = Usudao.actualizar_usuario(id, user.getCen_edu_nit(), user.getUsu_tipo_documento(),user.getUsu_nombres(),user.getUsu_apellidos(), user.getUsu_tipo_usuario(), user.getUsu_contrasenia(), user.getUsu_estado(), user.getUsu_email(), user.getUsu_telefono(), user.getUsu_foto());
		if(resul ==1) return "Se actualizaron correctamente los datos de la tabla usuario";
		else return "Los datos  de la tabla usuario no fueron actualizados";
        
    }
	
	
	//Este metodo elimina los datos por id del centro educativo
	@DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
		Integer resul = Usudao.eliminar_usuario(id);
		if(resul==1) return "se elimino correctamete el usuario";
		else return "No se pudo eliminar el usuario";
	}

	
}