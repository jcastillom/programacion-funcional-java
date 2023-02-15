package com.java.functional.beans;

import java.util.Comparator;

public class OrdenaUsuarioPorId implements Comparator<Usuario> {
	
	@Override
	public int compare(Usuario u1, Usuario u2) {
		return u1.getId() - u2.getId();
	}

}
