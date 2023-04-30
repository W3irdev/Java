package ficheros;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		File directorioRaiz = new File("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Ficheros");
		File fichero1 = new File("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Ficheros\\Fichero1.txt");
		System.out.println(directorioRaiz.isDirectory());
		System.out.println(fichero1.isDirectory());
		File directorioRaizCrear = new File("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Ficheros\\tempPrueba");
		
		System.out.println(directorioRaizCrear.mkdir());
		System.out.println(directorioRaizCrear.mkdir());
		
		Fichero fichero2;
		try {
			fichero2 = new Fichero("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Ficheros");
			System.out.println(fichero2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
