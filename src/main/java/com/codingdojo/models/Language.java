package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name= "language" )
public class Language {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@NotNull
	@Size(min = 2, max = 20, message="El nombre debe tener entre 2 y 20 caracteres.")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 20, message="El creador debe tener entre 2 y 20 caracteres.")
	private String creator;
	
	@NotNull
	@Min(value=0, message="La version no puede estar vacia.")
	private String currentVersion;

	public Language() {
		this.name = "N/A";
		this.creator = "N/A";
		this.currentVersion = "N/A";
	}
	
	public Language(String name, String creator, String currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	
}
