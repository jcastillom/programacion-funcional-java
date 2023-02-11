package com.java.functional.main;

import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.functional.base.Base;

public class MainBiConsumer {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(MainBiConsumer.class);
		
		/**
		 * Interface funcional BConsumer que recibe dos parámetros de entrada (Object T, Object U)
		 * Losargumentos pueden ser de cualquier tipo
		 * Interface Consumer<T, U>
		 * Su método abstracto recibe dos objeto accept(T t, U u)
		 */
		
		BiConsumer<Double, Double> biConsumer = (x, y) -> logger.debug("Resultado de x * y = {}", x*y);
		biConsumer.accept(1.5, 10.0);
		
		logger.debug("");
		logger.debug("----- Iterando map de forma tradicional -----");
		Iterator<Map.Entry<String, String>> iter = Base.obtenerMapa().entrySet().iterator();
		if(iter.hasNext()) {
			while(iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				logger.debug("\t> Clave: {} - Valor: {}", entry.getKey(), entry.getValue());
			}
		}
		
		logger.debug("");
		logger.debug("----- Iterando map con BiConsumer y lambdas -----");
		Base.obtenerMapa().forEach( (key, value) -> logger.debug("\t> Clave: {} - Valor: {}", key, value) );		

	}

}
