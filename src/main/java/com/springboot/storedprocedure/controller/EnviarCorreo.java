package com.springboot.storedprocedure.controller;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storedprocedure.repository.Usuariodao;
import com.springboot.storedprocedure.request.enviarEmailRequest;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/api/email")
public class EnviarCorreo {
	
	
	@Autowired
    private JavaMailSender mailSender;

	@Autowired
	Usuariodao Usudao;
	
	@PostMapping(value= "/")
	public String verificarcorreo2(@Valid @RequestBody enviarEmailRequest em) {

		SimpleMailMessage email = new SimpleMailMessage();
		
		String password = Usudao.restablecerCorreo(em.getEmail());
		if(password.equals("NO_DATA_FOUND"))
			return "0";
		
		email.setTo(em.getEmail());
        email.setSubject("Restauración de contrasña");
        email.setText("Su contraseña es: "+password+"  Por favor no olvide su contraseña" );
        
        mailSender.send(email);
		return "Se envio la contraseña a tu correo "+em.getEmail()+" ---Su contraseña es : "+password;
		
		
	}
	

	
	
}