package com.java.functional.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;

public class MainUnaryOperator {
	
	static final Logger logger = LoggerFactory.getLogger(MainUnaryOperator.class);
	
	public static void main(String[] args) {
		/*
		 * Interface funcional UnaryOperator, recibe un objeto T y devulve un objeto del mismo tipo T
		 * Funciona igual que la interface Function<T, T> pero el tipo de dato de entrada y retorno debe ser el mismo
		 * Esta interface extiende de la interface Function<T, T>
		 * Interface UnaryOperator<T> extends Function<T, T>
		 * Tiene un método abstracto heredado es apply() que devuelve un valor
		 */
		logger.debug("----- Valores originales: ");
		Base.obtenerEnteros().forEach(num -> logger.debug("     > {}", num));
		
		List<Integer> listaMultiplicados = ejecutarOperadorUnario(Base.obtenerEnteros(), num -> num * num);
		logger.debug("----- Los valores multiplocados son: ");
		listaMultiplicados.forEach(num -> logger.debug("     > {}", num));
		
	}
	/*
	 * SonarLint indica que se utilice IntUnaryOperator sin identifiación genérica en lugar de UnaryOperator<Integer>
	 * SonarLint indica que se utilice el método abstracto applyAsInt() de IntUnaryOperator en lugar de apply() de UnaryOperator<Integer>
	 */
	public static List<Integer> ejecutarOperadorUnario(List<Integer> listaEnteros, IntUnaryOperator operadorUnario){
		List<Integer> listaEnterosMultiplicados = new ArrayList<>();
		
		listaEnteros.forEach(num -> listaEnterosMultiplicados.add(operadorUnario.applyAsInt(num)));
		
		return listaEnterosMultiplicados;
	}

}
