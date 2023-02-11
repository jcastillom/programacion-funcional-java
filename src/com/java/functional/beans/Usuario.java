package com.java.functional.beans;

import java.time.LocalDate;

public class Usuario {
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private double sueldo;
	private double sueldoAumento;
	
	/*
	 * Para hacer instancias simples
	 */
	public Usuario() {
		
	}
	
	public Usuario(String nombre, LocalDate fechaNacimiento, double sueldo, double sueldoAumento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldo = sueldo;
		this.sueldoAumento = sueldoAumento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", sueldo=" + sueldo
				+ ", sueldoAumento=" + sueldoAumento + "]";
	}
	
}
