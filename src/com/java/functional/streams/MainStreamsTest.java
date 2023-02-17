package com.java.functional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainStreamsTest {
	
	static final Logger logger = LoggerFactory.getLogger(MainStreamsTest.class);
	
	public static void main(String... args) {
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		
		Stream<Integer> sumaNumeros = listaNumeros.stream();
		int suma = sumaNumeros
				.filter(num -> num % 2 == 1)
				.map(num -> num * num)
//				.reduce(0, (x, y) -> x + y);
				.reduce(0, Integer::sum);
		
		logger.debug("Valor de suma: {}", suma);
		
	}

}
