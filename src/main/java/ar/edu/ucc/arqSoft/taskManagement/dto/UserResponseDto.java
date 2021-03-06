package ar.edu.ucc.arqSoft.taskManagement.dto;

import java.util.Set;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;
import ar.edu.ucc.arqSoft.taskManagement.model.Project;
import ar.edu.ucc.arqSoft.taskManagement.model.Task;

public class UserResponseDto implements DtoEntity{

	private String name;
	
	private String lastName;
	
	private String dni;
	
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
