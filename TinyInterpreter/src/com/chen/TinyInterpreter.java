package com.chen;
import java.io.File;
import java.io.FileNotFoundException;


public class TinyInterpreter {

	public static void main(String[] args) throws FileNotFoundException {
		
		String file = FileReader.readFile(new File("resources/sample"));

	}
}

