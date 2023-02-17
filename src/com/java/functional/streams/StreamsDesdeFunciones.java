package com.java.functional.streams;

import java.util.Random;
import java.util.stream.Stream;

import com.java.functional.base.Base;

public class StreamsDesdeFunciones extends Base {
	
	public static void main(String... args) {
		
		logger.debug(SEPARADOR);
		Stream<Long> primerosDiez = Stream.iterate(1L, x -> x +1)
				.limit(10);
		primerosDiez.forEach(x -> logger.debug("{}", x));
		
		logger.debug(SEPARADOR);
		Stream.iterate(1L, n -> n+1)
		.filter(x -> x % 2 == 0)
		.limit(10)
		.forEach(x -> logger.debug("{}", x));
		
		logger.debug(SEPARADOR);
		Stream.iterate(1L, x -> x + 1)
		.filter(x -> x % 2 == 0)
		.skip(100)
		.limit(5)
		.forEach(x -> logger.debug("- {}", x));
		
		logger.debug(SEPARADOR);
		Stream.generate(Math::random)
		.limit(5)
		.forEach(x -> logger.debug("Números aleatorios funcion generate() {}", x));
		
		logger.debug(SEPARADOR);
		new Random().ints()
		.limit(5)
		.forEach(x -> logger.debug("Numeros aleatorios funcion Random() {}", x));
			
		logger.debug(SEPARADOR);
		
	}

}
