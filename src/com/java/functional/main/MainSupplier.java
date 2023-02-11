package com.java.functional.main;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSupplier {

	static final Logger logger = LoggerFactory.getLogger(MainSupplier.class);

	public static void main(String[] args) {
		/*
		 * Interface funcional Supplier no se le pasa ningún parámetro y devuelve un valor genérico T
		 * El tipo de retorno puede ser de cualquier tipo
		 * Interface Supplier<T>
		 * Tiene un método abstracto get() que devuelve un valor.
		 */
		Supplier<String> sup = () -> "Chappie";
		logger.debug("Valor de supplier: {}", sup.get());
		
		
	}

}
