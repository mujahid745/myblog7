package com.myblognew7.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
