package ar.edu.ucc.arqSoft.taskManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "STATE")
public class State extends GenericObject {

	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "NAME")
	private String name;

	/*public State(String stateName) {
		super();
		this.name = stateName;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
