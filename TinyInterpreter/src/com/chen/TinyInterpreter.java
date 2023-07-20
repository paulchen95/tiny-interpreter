package com.chen;
import java.io.File;
import java.io.FileNotFoundException;


public class TinyInterpreter {

	public static void main(String[] args) throws FileNotFoundException {
		
		String file = FileReader.readFile(new File("resources/sample"));
		System.out.println(file);
		
		Parser parse = new Parser();
		System.out.println(parse.parse(file).toString());
	}
}

