package com.zak.hibernet.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
class Pet {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String owner;
	@Column(length = 30)
	private String type;
	public Pet()
	{}
	public Pet( String name, String owner, String type) {
		super();
	
		this.name = name;
		this.owner = owner;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", owner=" + owner + ", type=" + type + "]";
	}
	
}

