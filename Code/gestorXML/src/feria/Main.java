package feria;

import java.io.IOException;
import java.util.Scanner;

import feria.model.Feria;

public class Main {

	public static void main(String[] args) {
		Feria casetas = new Feria("files/casetasferia.xml");
		Scanner sc = new Scanner(System.in);
		String menu = "1. Mostrar todas las casetas existentes en una calle.\r\n"
                + "2. Mostrar todas las casetas de tipo familiar.\r\n"
                + "3. Mostrar todas las casetas de tipo Distrito\r\n"
                + "4. Mostrar todas las casetas que no sean ni familiares ni distritos.\r\n"
                + "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar\r\n"
                + "que existen.\r\n"
                + "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito\r\n"
                + "que existen.\r\n"
                + "7. Eliminar caseta.\r\n"
                + "8. Salir.";
		
		String numero=""; 
		String opcion ="";
		String calle="";
		try {
			casetas.exportarJson();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(!opcion.equals("8")) {
			System.out.println(menu + "\nIntroduzca Opcion: ");
			opcion=sc.nextLine();
			if(opcion.equals("1")) {
				System.out.println("Introduzca nombre de calle: ");
				calle=sc.nextLine();
				System.out.println(casetas.mostrarCasetasCalle(calle));
			}else if(opcion.equals("2")) {
				System.out.println(casetas.mostrarCasetasTipo("FAMILIAR"));
			}else if(opcion.equals("3")) {
				System.out.println(casetas.mostrarCasetasTipo("DISTRITO"));
			}else if(opcion.equals("4")) {
				System.out.println(casetas.mostrarCasetasTipo("OTROS"));
			}else if(opcion.equals("5")) {
				System.out.println(casetas.contarCasetas("FAMILIAR"));
			}else if(opcion.equals("6")) {
				System.out.println(casetas.contarCasetas("DISTRITO"));
			}else if(opcion.equals("7")) {
				System.out.println("Introduzca nombre de calle: ");
				calle=sc.nextLine();
				System.out.println("Introduzca numero caseta: ");
				numero=sc.nextLine();
				try {
					casetas.eliminarCaseta(calle, numero);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		

	}

}
