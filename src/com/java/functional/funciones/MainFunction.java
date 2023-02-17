package com.java.functional.funciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;
import com.java.functional.beans.Usuario;

public class MainFunction {
	
	static final Logger logger = LoggerFactory.getLogger(MainFunction.class);
	
	public static void main(String[] args) {
		
		/*
		 * Interfaz funcional Function que recibe un par�metro (Object T) y devuelve un par�metro (Object R)
		 * Los argumentos pueden ser de diferentes tipos
		 * Interface Function<T, R>
		 * Tiene un m�todo abstracto que recibe un objeto apply(T t)
		 */
		Function<Integer, String> convertidor = x -> Integer.toString(x);
		logger.debug("{}", convertidor.apply(543274).length());
		
		//Ejemplo de Function con un bean
		Usuario usuario = new Usuario(1, "Jos�", LocalDate.of(1987, 3, 12), 2750.3, 0);
		String nombre = (String ) obtenerDatosUsuario(usuario, Usuario::getNombre);
		int edad = (int) obtenerDatosUsuario(usuario, Usuario::getFechaNacimiento);
		float sueldo = (float) obtenerDatosUsuario(usuario, Usuario::getSueldo);
		
		logger.debug("El nombre del usuario es: {}", nombre);
		logger.debug("La edad del usuario es: {}", edad);
		logger.debug("El sueldo del usuario es: {}", sueldo);
		
		//Ejemplo de Function con una lista
		List<Usuario> listaUsuarios = Base.listaUsuarios();
		
		List<Object> listaNombres = obtenerUsuarios(listaUsuarios, Usuario::getNombre);
		logger.debug("--------------------------------------------------------------");
		logger.debug("La lista de nombres de usuario es:");
		listaNombres.stream().forEach(nom -> logger.debug("   - Nombre: {}", nom));

	}
	
	public static Object obtenerDatosUsuario(Usuario usuario, Function<Usuario, Object> function) {
		return function.apply(usuario);
	}
	
	public static List<Object> obtenerUsuarios(List<Usuario> listaUsuarios, Function<Usuario, Object> function){
		List<Object> listaNombres = new ArrayList<>();
		listaUsuarios.stream().forEach(usu -> listaNombres.add(function.apply(usu)));
		return listaNombres;
	}
	
}
