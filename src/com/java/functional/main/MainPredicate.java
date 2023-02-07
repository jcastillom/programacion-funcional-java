package com.java.functional.main;

import java.util.function.IntPredicate;

public class MainPredicate {

	public static void main(String[] args) {
		
		/*
		 * Interfaz funcional Predicate que recibe un parámetro (Object T) y devuelve un booleano
		 * El argumento puede ser de difente tipo
		 * Interfaz Predicate<T>
		 * Tiene un método bstracto que recibe un objeto test(T)
		 */
		// Tambien se puede utilizar como: Predicate<Integer>
		IntPredicate pred = valor -> valor > 0;
		pred.test(123);

	}

}
