package com.java.functional.base;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.beans.Usuario;


public class Base {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static List<Usuario> listaUsuarios(){
		return Arrays.asList(
				new Usuario("Chappie", LocalDate.of(1990, 12, 25), 3000, 0), 
				new Usuario("Karen", LocalDate.of(1980, 05, 27), 2000, 0),
				new Usuario("Marcial", LocalDate.of(1970, 06, 15), 8000, 0),
				new Usuario("Emilio", LocalDate.of(1986, 4, 4), 3000, 0),
				new Usuario("Lupita", LocalDate.of(1997, 2, 14), 6000, 0),
				new Usuario("Ivon", LocalDate.of(1990, 11, 20), 7000, 0),
				new Usuario("Monse", LocalDate.of(1990, 12, 9), 4000, 0),
				new Usuario("Ricardo", LocalDate.of(1990, 1, 29), 14000, 0),
				new Usuario("Beatriz", LocalDate.of(1990, 5, 7), 5000, 0),
				new Usuario("Paola", LocalDate.of(1990, 9, 6), 9000, 0),
				new Usuario("José", LocalDate.of(1986, 3, 12), 1000, 0)
			);
	}
	
	public static Map<String, String> obtenerMapa(){
		String[][] arreglo = {{"MX", "México"}, {"JP", "JAPON"}, {"EN", "Estados Unidos"}, {"BR", "BRASIL"}, {"FR", "FRANCIA"}};
		Map<String, String> map = new HashMap<>();
		
		Arrays.asList(arreglo).forEach(x -> map.put(x[0], x[1]));
		
		return map;
	
	}

}
