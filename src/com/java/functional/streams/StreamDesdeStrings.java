package com.java.functional.streams;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.java.functional.base.Base;

public class StreamDesdeStrings extends Base {

	public static void main(String[] args) {

		logger.debug(SEPARADOR);
		String str = "HTML, CSS, JAVASCRIPT, JAVA, C++, C#, RUBY";
		Pattern.compile(", ")
		.splitAsStream(str)
		.forEach(logger::debug);

		logger.debug(SEPARADOR);
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		IntStream streamChars = entrada.chars();
		
		streamChars.filter(x -> !Character.isDigit((char) x) && !Character.isWhitespace((char) x))
			.forEach(x -> logger.debug("{}", (char) x));
		sc.close();
		
	}

}
