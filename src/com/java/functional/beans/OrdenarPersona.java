package com.java.functional.beans;

import java.util.Comparator;

public class OrdenarPersona implements Comparator<Persona> {
	
	@Override
	public int compare(Persona per1, Persona per2) {
		return per1.getId() - per2.getId();
	}
	
	public int ordenarPorId(Persona per1, Persona per2) {
		return per1.getId().compareTo(per2.getId());
	}
	
	public int ordenarPorNombre(Persona per1, Persona per2) {
		return per1.getNombre().compareTo(per2.getNombre());
	}

}
