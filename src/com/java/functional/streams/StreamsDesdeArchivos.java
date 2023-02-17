package com.java.functional.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.java.functional.base.Base;

public class StreamsDesdeArchivos extends Base {

	public static void main(String[] args) {
		
		String strCarpeeta = System.getProperty("user.dir");
		File carpeta = new File(strCarpeeta);
		Stream.of(carpeta.listFiles()).forEach(x -> logger.debug("{}", x.getAbsolutePath()));
		
		logger.debug(SEPARADOR);
		Path path1 = Paths.get("resources\\files\\Lorem ipsum.txt");
		
		try (Stream<String> lineas = Files.lines(path1)) {
			
			lineas.forEach(
					linea -> {
						logger.debug("Linea... ");
						logger.debug(linea);
					}
				);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.debug(SEPARADOR);
		Path dir = Paths.get(".");
		logger.debug("El arbol de archivos del proyecto para {} es:", dir.toAbsolutePath());
		
		try (Stream<Path> paths = Files.walk(dir)){
			
			paths.filter(p -> p.startsWith(".\\resources")).forEach(p -> logger.debug("{}", p));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
