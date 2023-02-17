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
	
	protected static final Logger logger = LoggerFactory.getLogger(Base.class);
	
	protected static final String SEPARADOR = "----------------------------------------------------------------------"; 
	
	public static List<Usuario> listaUsuarios(){
		return Arrays.asList(
				new Usuario(29, "Chappie", LocalDate.of(1990, 12, 25), 3000, 0), 
				new Usuario(31, "Karen", LocalDate.of(1980, 05, 27), 2000, 0),
				new Usuario(13, "Marcial", LocalDate.of(1970, 06, 15), 8000, 0),
				new Usuario(33, "Emilio", LocalDate.of(1986, 4, 4), 3000, 0),
				new Usuario(43, "Lupita", LocalDate.of(1997, 2, 14), 6000, 0),
				new Usuario(67, "Ivon", LocalDate.of(1990, 11, 20), 7000, 0),
				new Usuario(27, "Monse", LocalDate.of(1990, 12, 9), 4000, 0),
				new Usuario(71, "Ricardo", LocalDate.of(1990, 1, 29), 14000, 0),
				new Usuario(89, "Beatriz", LocalDate.of(1990, 5, 7), 5000, 0),
				new Usuario(67, "Paola", LocalDate.of(1990, 9, 6), 9000, 0),
				new Usuario(11, "Jos�", LocalDate.of(1986, 3, 12), 1000, 0)
			);
	}
	
	public static Map<String, String> obtenerMapa(){
		String[][] arreglo = {{"MX", "M�xico"}, {"JP", "JAPON"}, {"EN", "Estados Unidos"}, {"BR", "BRASIL"}, {"FR", "FRANCIA"}};
		Map<String, String> map = new HashMap<>();
		
		Arrays.asList(arreglo).forEach(x -> map.put(x[0], x[1]));
		
		return map;
	}
	
	public static List<Integer> obtenerEnteros(){
		return Arrays.asList(3, 5, 7, 2, 4, 9, 8, 1, 6, 10);
	}

}
