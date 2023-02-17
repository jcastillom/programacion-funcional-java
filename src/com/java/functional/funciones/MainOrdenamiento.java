package com.java.functional.funciones;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.beans.OrdenaUsuarioPorId;
import com.java.functional.beans.OrdenarPersona;
import com.java.functional.beans.Persona;
import com.java.functional.beans.Usuario;

public class MainOrdenamiento {
	
	static final Logger logger = LoggerFactory.getLogger(MainOrdenamiento.class);
	private static final String SEPARADOR = "----------------------------------------------------------";
	
	public static void main(String[] args) {
		
		List<String> listaNombres = Arrays.asList("Jos�", "Chappie", "Joel", "Luis", "Esau", "Jose", "Mayra", "Alvaro");
		
		List<Persona> listaPersonas = Arrays.asList(new Persona(2, "Jos�"), new Persona(1, "Emilio"), new Persona(5, "Chappie"), new Persona(4, "Karen"), new Persona(3, "Roseno"));
		
		//Ordenar listas 
		logger.debug("Lista original de nombres: ");
		logger.debug("\t{}", listaNombres);
		
		
		logger.debug("Lista ordenada de nombres: ");
		Collections.sort(listaNombres);
		logger.debug("\t{}", listaNombres);
		
		logger.debug("Lista ordenada de nombres viceversa: ");
		Collections.sort(listaNombres, Collections.reverseOrder());
		logger.debug("\t{}", listaNombres);
		
		// Ordenamiento de personas con implemenacion Comparable en el objeto Persona
		logger.debug(SEPARADOR);
		logger.debug("Personas sin ordenamiento COMPARABLE: ");
		logger.debug("\t{}", listaPersonas);
		logger.debug("Personas con ordenamiento COPARABLE: ");
		Collections.sort(listaPersonas);
		logger.debug("\t{}", listaPersonas);
		
		/*
		 * Comparator
		 * 	(-x) Devuelve entero negativo si el primer argumento es menor al segundo argumento
		 * 	(0)	 Deveulve cero si el primero argumento es igual al segundo argumento
		 *	(x)  Deveulve entero positivo si el primer argumento es mayor al segundo argumento
		 */
		logger.debug(SEPARADOR);
		logger.debug("Personas con ordenamiento COMPARATOR: ");
		Collections.sort(listaPersonas, new OrdenarPersona());
		logger.debug("\t{}", listaPersonas);
		
		// Ordenamiento por ID de usuario con Comparator
		List<Usuario> listaUsuarios = Arrays.asList(
				new Usuario(29, "Chappie", LocalDate.of(1990, 12, 25), 3000, 0), 
				new Usuario(31, "Karen", LocalDate.of(1980, 05, 27), 2000, 0),
				new Usuario(13, "Marcial", LocalDate.of(1970, 06, 15), 8000, 0),
				new Usuario(33, "Emilio", LocalDate.of(1986, 4, 4), 3000, 0),
				new Usuario(43, "Lupita", LocalDate.of(1997, 2, 14), 6000, 0),
				new Usuario(67, "Ivon", LocalDate.of(1981, 11, 20), 7000, 0),
				new Usuario(27, "Monse", LocalDate.of(2010, 12, 9), 4000, 0),
				new Usuario(71, "Ricardo", LocalDate.of(1994, 1, 29), 14000, 0),
				new Usuario(89, "Beatriz", LocalDate.of(1999, 5, 7), 5000, 0),
				new Usuario(67, "Paola", LocalDate.of(1987, 9, 6), 9000, 0),
				new Usuario(11, "Jos�", LocalDate.of(1986, 3, 12), 1000, 0)
			);
		
		logger.debug(SEPARADOR);
		logger.debug("Usuarios SIN ordenamiento COMPARABLE: ");
		logger.debug("\t{}", listaUsuarios);
		logger.debug("Usuarios CON ordenamiento COMPARABLE: ");
		Collections.sort(listaUsuarios);
		logger.debug("\t{}", listaUsuarios);
		
		logger.debug("Usuarios CON ordenamiento COMPARATOR: ");
		Collections.sort(listaUsuarios, new OrdenaUsuarioPorId());
		logger.debug("\t{}", listaUsuarios);
		
		// Ordenar por algun par�metro espec�fico sin hacer una clase extra, solo con una clase an�nima
		logger.debug(SEPARADOR);
		logger.debug("Usuarios CON ordenamiento COMPARATOR y clase an�nima: ");
		Collections.sort(listaUsuarios, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario user1, Usuario user2) {
				return user1.getId() - user2.getId();
			}
		});
		logger.debug("\t{}", listaUsuarios);
		
		// Ordenamiento COMPARATOR con expresi�n lambda
		logger.debug(SEPARADOR);
		logger.debug("Usuarios CON ordenamiento por ID COMPARATOR y expresi�n lambda: ");
		Collections.sort(listaUsuarios, (user1, user2) -> user1.getId() - user2.getId());
		logger.debug("\t{}", listaUsuarios);
		
		// Ordenamiento COMPARATOR con expresi�n lambda ordenado por Fecha de nacimiento.
		logger.debug(SEPARADOR);
		logger.debug("Usuarios CON ordenamiento por Fecha de Nacimiento, COMPARATOR y expresi�n lambda: ");
//		Collections.sort(listaUsuarios, (user1, user2) -> user2.getFechaNacimiento().compareTo(user1.getFechaNacimiento())); // Ordenamiento usando compareTo
		Collections.sort(listaUsuarios, Comparator.comparing(Usuario::getFechaNacimiento)); // Ordenamiento usando Comparator.comparing por fecha de nacimiento
		logger.debug("\t{}", listaUsuarios);
		Collections.sort(listaUsuarios, Comparator.comparing(Usuario::getFechaNacimiento).reversed()); // Ordenamiento usando Comparator.comparing por fecha de nacimiento viseversa
		logger.debug("\t{}", listaUsuarios);
		Collections.sort(listaUsuarios, Comparator.comparing(Usuario::getSueldo)); // Ordenamiento usando Comparator.comparing por sueldo
		logger.debug("\t{}", listaUsuarios);		
		Collections.sort(listaUsuarios, Comparator.comparing(Usuario::getSueldo).reversed()); // Ordenamiento usando Comparator.comparing por sueldo viceversa
		logger.debug("\t{}", listaUsuarios);
		
	}

}
