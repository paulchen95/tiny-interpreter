package com.chen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static String readFile(File f) throws FileNotFoundException {
		
		try(Scanner sc = new Scanner(f)){
			String string = "";
			
			while(sc.hasNext()) {
				string += (String)sc.next();
			}
			
			return string;
		}
	}
}
