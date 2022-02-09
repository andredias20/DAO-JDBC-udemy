package model.entities;

import java.util.Date;

public class Client {
	private String name;
	private Date BirthDate;
	
	public Client(String name, Date birthDate) {
		super();
		this.name = name;
		BirthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	
}
