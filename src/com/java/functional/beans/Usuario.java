package com.java.functional.beans;

public class Usuario {
	
	private String nombre;
	private int edad;
	private double sueldo;
	private double sueldoAumento;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, int edad, double sueldo, double suedoAumento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.sueldoAumento = suedoAumento;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getSueldoAumento() {
		return sueldoAumento;
	}

	public void setSueldoAumento(double sueldoAumento) {
		this.sueldoAumento = sueldoAumento;
	}
	
}
