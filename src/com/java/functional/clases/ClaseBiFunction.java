package com.java.functional.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.java.functional.beans.Usuario;

public class ClaseBiFunction {
	
	public String calcular(BiFunction<Integer, Integer, String> biFun, int x, int y) {
		return biFun.apply(x, y);
	}
	
	public List<String> calcularSueldos(BiFunction<Usuario, Double, String> biFun, List<Usuario> listaUsuarios, Double incremento){
		List<String> listaSalariosUsuarios = new ArrayList<>();
		listaUsuarios.stream().forEach(user -> listaSalariosUsuarios.add(biFun.apply(user, incremento)));
		return listaSalariosUsuarios;
	}
	
	public List<Usuario> calcularSueldoUusario(BiFunction<Usuario, Double, Usuario> biFun, List<Usuario> listaUsuarios, Double incremento){
		List<Usuario> listaSalariosUsuarios = new ArrayList<>();
		listaUsuarios.stream().forEach(user -> listaSalariosUsuarios.add(biFun.apply(user, incremento)));
		return listaSalariosUsuarios;
	}

}
