package com.java.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.functional.base.Base;
import com.java.functional.beans.Estudiante;

public class StreamsDesdeColeccionesArreglos extends Base {

	public static void main(String[] args) {
		
		logger.debug(SEPARADOR);
		IntStream numStream = Arrays.stream(new int[] {1, 2, 3});
		numStream.forEach(x ->logger.debug("{}", x));

		logger.debug(SEPARADOR);
		Stream<String> nombres = Arrays.stream(new String [] {"Jose", "Chappie", "Karen"});
		nombres.forEach(x -> logger.debug("{}", x));
		
		logger.debug(SEPARADOR);
		Set<String> lengSet = new HashSet<>();
		lengSet.add("JAVA");
		lengSet.add("PHYTON");
		lengSet.add("c++");
		Stream<String> lengSet2 = lengSet.stream();
		lengSet2.forEach(logger::debug);
		
		logger.debug(SEPARADOR);
		logger.debug("ParallelStream de estudiantes");
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante("n01", 17, 1.70, 9.5));
		estudiantes.add(new Estudiante("n02", 18, 1.85, 9.7));
		estudiantes.add(new Estudiante("n03", 15, 1.63, 9.3));
		estudiantes.add(new Estudiante("n04", 17, 1.68, 9.1));
		
		Stream<Estudiante> estudiantesStream = estudiantes.parallelStream();
		estudiantesStream.forEach(est -> logger.debug("Nombre: {}", est.getIdentificacion()));
		
	}

}
