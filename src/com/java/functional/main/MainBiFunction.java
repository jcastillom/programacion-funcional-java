package com.java.functional.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;
import com.java.functional.beans.Usuario;
import com.java.functional.clases.ClaseBiFunction;

public class MainBiFunction {
	
	static final Logger logger = LoggerFactory.getLogger(MainBiFunction.class);
	
	public static void main(String[] args) {
		
		/*
		 * Interface funcional BiFunction que recibe dos parámetros (Object T, Object U) y devuelve uno (Object R)
		 * Los argumentos pueden ser de diferentes tipos
		 * Interface BiFunction(T t, U u, R r)
		 * Tiene un método abstracto que recibe dos objetos apply(T t, U u)
		 */
		BiFunction<String, String, String> bi = (x, y) -> x + y;
		logger.debug("Se concatenan valores con BiFunction: {}", bi.apply("Bi-", "Function").length());


		
		//Ejemplo de BiFunctioncon un método de otra clase
		ClaseBiFunction calc = new ClaseBiFunction();
		String resultado = calc.calcular((x, y) -> ": " + x * y, 10, 60);
		logger.debug("El resultado es{}", resultado);
		
		
		
		//Ejemplo de BiFunction con Listas
		List<Usuario> listaUsuarios = Base.listaUsuarios();
		
		//Devuelve una lista de cadenas con el aumento de sueldo
		List<String> listaIncrementos = calc.calcularSueldos((usuario, incremento) -> "" + usuario.getSueldo() * Double.valueOf("1." + incremento.intValue()), listaUsuarios, 30.0);
		listaIncrementos.stream().forEach(incremento -> logger.debug("El sueldo con incremento es de: {}", incremento));
		
		//Devuelve una lista de usuarios con el aumento de sueldo
		List<Usuario> user = calc.calcularSueldoUusario((usuario, incremento) -> new Usuario(usuario.getId(), usuario.getNombre(), usuario.getFechaNacimiento(), usuario.getSueldo(), usuario.getSueldo() * Double.valueOf("1." + incremento.intValue())), listaUsuarios, 30.0);
		user.stream().forEach(u -> logger.debug("El usuario \u001b[36m {} \u001B[0m de \u001b[36m {} \u001B[0m años de edad con un sueldo de \u001b[36m {} \u001B[0m tuvo un aumento que equivale a: \u001b[36m {} \u001B[0m", 
				u.getNombre(), u.getFechaNacimiento(), u.getSueldo(), u.getSueldoAumento()));
		
	}
	
	public static List<Usuario> calcularSueldoUusario(BiFunction<Usuario, Double, Usuario> biFun, List<Usuario> listaUsuarios, Double incremento){
		List<Usuario> listaSalariosUsuarios = new ArrayList<>();
		listaUsuarios.stream().forEach(user -> listaSalariosUsuarios.add(biFun.apply(user, incremento)));
		return listaSalariosUsuarios;
	}

}
