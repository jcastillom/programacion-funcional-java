package com.java.functional.beans;

public class Persona implements Comparable<Persona> {
	
	private Integer id;
	private String nombre;
	
	public Persona() {
		
	}
	
	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
	
	@Override
	public int compareTo(Persona p) {
		return this.nombre.compareTo(p.nombre);	// ordenamiento ascendente
//		return p.nombre.compareTo(this.nombre); // ordenamiento descendente
	}
	
	public static int compararPorId(Persona p1, Persona p2) {
		return p1.getId().compareTo(p2.getId());
	}
	
	public int compararPorId2(Persona p1) {
		return this.getId().compareTo(p1.getId());
	}
	
}
