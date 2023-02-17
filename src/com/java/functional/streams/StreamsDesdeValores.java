package com.java.functional.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.beans.Estudiante;

public class StreamsDesdeValores {
	
	static final Logger logger = LoggerFactory.getLogger(StreamsDesdeValores.class);
	static final String SEPARADOR = "----------------------------------------------------------------------"; 

	public static void main(String[] args) {
		
		Stream<String> stream1 = Stream.of("Curso de programación funcional");
		stream1.forEach(logger::debug);
		
		logger.debug(SEPARADOR);
		Stream<String> stream2 = Stream.of("Curso1", "Curso2", "Curso3", "Curso4");
		stream2.forEach(logger::debug);
		
		
		logger.debug(SEPARADOR);
		String[] arreglo = {"java", "c#" , "pyton", ".net", "ruby"};
		Stream<String> stream3 = Stream.of(arreglo);
		stream3.forEach(logger::debug);
		
		logger.debug(SEPARADOR);
		Stream<Estudiante> streamEstudiantes = Stream.<Estudiante>builder()
				.add(new Estudiante("n01", 17, 1.70, 9.5))
				.add(new Estudiante("n02", 18, 1.85, 9.7))
				.build();
		streamEstudiantes.forEach(estudiante -> logger.debug("{}", estudiante));
		
		logger.debug(SEPARADOR);
		IntStream unoAVeinte = IntStream.range(1, 6); // no incluye el 6
		unoAVeinte.forEach(x -> logger.debug("{}", x));
		logger.debug(SEPARADOR);
		IntStream unoAVeinteX = IntStream.rangeClosed(1, 5); // incluye el 5
		unoAVeinteX.forEach(x -> logger.debug("{}", x));

	}

}
