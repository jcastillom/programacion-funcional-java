package com.java.functional.funciones;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainBinaryOperator {
	
	static final Logger logger = LoggerFactory.getLogger(MainBinaryOperator.class);

	public static void main(String[] args) {
		/*
		 * Interface funcional BynaryOperator, recibe dos objetos T y devuelve un objeto del mismo tipo T
		 * Funciona igual que la interface BiFunction<T, T, T> pero los tipos de dato de entrada y retorno deben ser el mismo
		 * Esta interface extiende de la interface BiFunction<T, T, T>
		 * Su método abstracto heredado es apply(T y, T t) que devuelve un valor
		 */
		IntBinaryOperator operadorBinario = (x, y) -> x * y;
		logger.debug("Resultado de operador binario: {}", operadorBinario.applyAsInt(10, 20));
		
		BinaryOperator<Integer> opBinarioMin = BinaryOperator.minBy((Integer x, Integer y) -> x.compareTo(y));
		BinaryOperator<Integer> opBinarioMax = BinaryOperator.maxBy((Integer x, Integer y) -> x.compareTo(y));
		
		logger.debug("El numero mínimo es: {}", opBinarioMin.apply(10, 20));
		logger.debug("El numero máximo es: {}", opBinarioMax.apply(10, 20));
	}

}
