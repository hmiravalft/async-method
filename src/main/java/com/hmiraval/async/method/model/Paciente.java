package com.hmiraval.async.method.model;

public class Paciente {
	
	private String nombre;
	private String enfermedad;
	
	public Paciente(String nombre, String enfermedad) {
		
		this.nombre = nombre;
		this.enfermedad = enfermedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	

}
