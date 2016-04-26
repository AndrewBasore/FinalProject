package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Stylable {

	protected String scanCSS(String filename){
		try{
			Scanner scan = new Scanner(new File(filename));
			scan.useDelimiter("[$]");
			String result = scan.next();
			scan.close();
			return result;
		}
		catch(FileNotFoundException e){
			System.out.println("File Does Not Exist");
		}
		return null;
		
	}
	
	protected abstract void style();
}
