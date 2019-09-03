package com.springboot.storedprocedure.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class enviarEmailRequest {
	
	@NotBlank
	@Email
    @Size(min=1, max = 60)
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "enviarEmailRequest [email=" + email + "]";
	}
	
		
    
    
    
	
	
    

    
	

}
