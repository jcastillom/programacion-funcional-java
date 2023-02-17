package com.java.functional.funciones;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;
import com.java.functional.beans.Usuario;


public class MainPredicate {

	static final Logger logger = LoggerFactory.getLogger(MainPredicate.class);

	public static void main(String[] args) {
		/*
		 * Interfaz funcional Predicate que recibe un parámetro (Object T) y devuelve un booleano
		 * El argumento puede ser de difente tipo
		 * Interfaz Predicate<T>
		 * Tiene un m�todo bstracto que recibe un objeto test(T)
		 */
		// Tambien se puede utilizar como: Predicate<Integer>
		IntPredicate pred = valor -> valor > 0;
		logger.debug("Evaluacion boolean con Predicate: {}", pred.test(123));
		
		//Ejemplo de Predicate con una lista
		List<Usuario> listUsers = obtenerSueldosMayores(Base.listaUsuarios(), user -> user.getSueldo() > 500);
		logger.debug("-------------------------------------");
		listUsers.forEach(u -> logger.debug("Sueldo mayor - {}", u));
		
		//Ejemplo de Predicate con una lista, filter y map
		List<String> listaNombresUsuarios = Base.listaUsuarios().stream()
				.filter(usuario -> usuario.getSueldo() > 5000)
				.map(usuario -> usuario.getNombre() + " - " + usuario.getSueldo())
				.collect(Collectors.toList());
		
		logger.debug("-------------------------------------");
		logger.debug("Usuarios con salario mayor a 5000: ");
		listaNombresUsuarios.forEach(u -> logger.debug("     > {}", u));
		
		//Obtener los usuarios mayores de edad con Predicate, filter, map y Period
		List<String> listaUsuariosMayores = Base.listaUsuarios().stream()
				.filter(usuario -> obtenerEdad(usuario.getFechaNacimiento()) > 34)
				.map(usuario -> usuario.getNombre() + " tiene " + obtenerEdad(usuario.getFechaNacimiento()) + " a�os")
				.collect(Collectors.toList());
		logger.debug("-------------------------------------");
		listaUsuariosMayores.forEach(logger::debug);
		
	}
	
	public static List<Usuario> obtenerSueldosMayores(List<Usuario> listaUsuarios, Predicate<Usuario> pred) {
		List<Usuario> listaMayores = new ArrayList<>();
		
		for(Usuario usu : listaUsuarios) {
			if(pred.test(usu)) {
				listaMayores.add(usu);
			}
		}
		
		return listaMayores;
	}
	
	public static int obtenerEdad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}

}
