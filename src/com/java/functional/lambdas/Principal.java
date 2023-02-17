package com.java.functional.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;

public class Principal extends Base {
	
	static Logger log = LoggerFactory.getLogger(Principal.class);

	public static void main(String[] args) {
		ejecutarLambdaSimple();
		ejecutarLambdaConParametros();
		
		calcular((int a, int b) -> a * b);					// indicar el tipo de dato directo en los par�metros
		
		calcular((LambdaCalculadoraInt)(a, b) -> a / b);	// Hacer Casteo del objeto al que pertenece la expresipon infiere el tipo de dato
		
		LambdaCalculadoraInt calInt = (a, b) -> a + b;		// Crear la expresi�n Lamda con la interface requerida e infiere el tipo de dato
		calcular(calInt);
		
		LambdaCalculadoraLong calLong = ( a, b) -> a - b;
		calcular(calLong);
	}
	
	public static void test() {
		log.debug("Hola Mundo");
	}
	
	public static void ejecutarLambdaSimple() {
		LambdaSimple ls = () -> log.debug("Lambda Simple");
		ls.ejecutarLamdaSimple();
	}
	
	public static void ejecutarLambdaConParametros() {
		LambdaParametros lp = (a, b) -> log.debug("Lambda con parametros: {} - {}", a, b);
		lp.ejecutarLambdaConParametros("Hola", "mundo lambdas");
	}
	
	public static void calcular(LambdaCalculadoraInt calInt) {
		int a = 9;
		int b = 7;
		log.debug("Resultado de calculadora Int {}", calInt.ejecutarCalculadoraIntParams(a, b));
	}
	
	public static void calcular(LambdaCalculadoraLong calLong) {
		long a = 5;
		long b = 18;
		log.debug("Resultado de calculadora Long {}", calLong.ejecutarCalculadoraLongParams(a, b));
	}

}
