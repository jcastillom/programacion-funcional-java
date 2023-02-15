package com.java.functional.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.beans.OrdenarPersona;
import com.java.functional.beans.Persona;

public class MainMetodosReferenciados {
	
	static final Logger logger = LoggerFactory.getLogger(MainMetodosReferenciados.class);
	private static final String SEPARADOR = "----------------------------------------------------------\n";

	public static void main(String[] args) {
		
		List<Persona> listaPersonas = Arrays.asList(new Persona(2, "Jos�"), new Persona(1, "Emilio"), new Persona(5, "Chappie"), new Persona(4, "Karen"), new Persona(3, "Roseno"));

		logger.debug("Lista original de personas: ");
		logger.debug("\t{}", listaPersonas);
		logger.debug("Lista de personas ordenadas por ID método est�tico referenciado");
		Collections.sort(listaPersonas, Persona::compararPorId);
		logger.debug("\t{}", listaPersonas);
		
		logger.debug(SEPARADOR);
		logger.debug("Lista de personas ordenadas por NOMBRE por m�todo de instancia");
		OrdenarPersona persona = new OrdenarPersona();
		Collections.sort(listaPersonas, persona::ordenarPorNombre);
		listaPersonas.forEach(p -> logger.debug("{}", p));
		
		// Ordenamiento por método referenciado de instancia de un objeto arbitrario particular
		logger.debug(SEPARADOR);
		logger.debug("Ordenamiento por método referenciado de instancia de un objeto arbitrario particular con lambda");
		Collections.sort(listaPersonas, (per1, per2) -> per1.compararPorId2(per2)); // esta es la forma larga de hacerlo
		logger.debug("\t{}", listaPersonas);
		logger.debug("Ordenamiento por método referenciado de instancia de un objeto arbitrario particular con método referenciado");
		Collections.sort(listaPersonas, Persona::compararPorId2); // esta es la forma corta de hacerlo con m�todos referenciados
		logger.debug("\t{}", listaPersonas);
		
		// Método referenciado a un contructor
		List<String> listaNumStr = Arrays.asList("8", "3", "7", "1", "9", "4", "2", "1");
		logger.debug(SEPARADOR);
		logger.debug("Método referenciado con un contructor con lambdas");
		List<Integer> listaEnteros = obtenerEnteros(listaNumStr, numStr -> new Integer(numStr)); // forma larga de hacerlo con lambdas
		Collections.sort(listaEnteros);
		logger.debug("\t{}", listaEnteros);
		logger.debug("Método referenciado con un contructor, forma corta");
		obtenerEnteros(listaNumStr, Integer::new).forEach(MainMetodosReferenciados::multiplicarPorDiez); // forma larga de hacerlo con lambdas

	}
	
	public static List<Integer> obtenerEnteros(List<String> listaNumStr, Function<String, Integer> func){
		List<Integer> listaEnteros = new ArrayList<>();
		
		listaNumStr.forEach(numStr -> listaEnteros.add(func.apply(numStr)));
		
		return listaEnteros;
	}
	
	public static void multiplicarPorDiez(int num) {
		logger.debug("El nuevo valor de: {} ahora es: {}", num, num * 10);
	}

}
