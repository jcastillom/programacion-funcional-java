package com.java.functional.funciones;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;
import com.java.functional.beans.Usuario;
import com.java.functional.clases.ClaseConsumer;

public class MainConsumer {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(MainConsumer.class);
		
		/**
		 * Interface funcional Consumer que recibe un par�metro (Object T)
		 * El argumento puede ser de cualquier tipo
		 * Interface Consumer<T>
		 * Su m�todo abstracto recibe un objeto accept(T t)
		 */
		Consumer<String> nombreUpper = nombre -> logger.debug("Nombre en may�sculas: {}", nombre.toUpperCase());
		nombreUpper.accept("Jos�");
		
		//Ejemplo de aumento de sueldo con Consumer
		ClaseConsumer claseConsumer = new ClaseConsumer();
		Consumer<Usuario> cons1 = usu -> logger.debug("Usuario: {} - Sueldo: {} - - Aumento: {}", usu.getNombre(), usu.getSueldo(), usu.getSueldoAumento());
		claseConsumer.aumentoTodos(Base.listaUsuarios(), cons1);
		
		Consumer<Usuario> cons2 = usu -> usu.setSueldoAumento(usu.getSueldo() * 1.1);
		
		logger.debug("------------------------------------------------------------------------");
		Consumer<Usuario> cons3 = cons2.andThen(cons1);
		claseConsumer.aumentoTodos(Base.listaUsuarios(), cons3);

	}

}
