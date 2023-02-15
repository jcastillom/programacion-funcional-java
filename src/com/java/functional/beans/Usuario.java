package com.java.functional.beans;

import java.time.LocalDate;

public class Usuario implements Comparable<Usuario> {
	
	private int id;
	private String nombre;
	private LocalDate fechaNacimiento;
	private double sueldo;
	private double sueldoAumento;
	
	/*
	 * Para hacer instancias simples
	 */
	public Usuario() {
		
	}
	
	public Usuario(int id, String nombre, LocalDate fechaNacimiento, double sueldo, double sueldoAumento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldo = sueldo;
		this.sueldoAumento = sueldoAumento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", \tnombre=" + nombre + ", \tfechaNacimiento=" + fechaNacimiento + ", \tsueldo="+ sueldo + ", \tsueldoAumento=" + sueldoAumento + "]";
	}
	
	@Override
	public int compareTo(Usuario usuario) {
		return this.nombre.compareTo(usuario.getNombre());
	}
	
}
