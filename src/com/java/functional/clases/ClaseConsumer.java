package com.java.functional.clases;

import java.util.List;
import java.util.function.Consumer;

import com.java.functional.beans.Usuario;

public class ClaseConsumer {
	
	public void aumentoTodos(List<Usuario> listaUsuarios, Consumer<Usuario> cons) {
		listaUsuarios.forEach(cons::accept);
	}

}
