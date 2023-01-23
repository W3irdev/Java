package com.edu;

import java.util.Scanner;

public class Boletin1 {

	public static boolean multiplo(int numero1, int numero2) {

		return (numero1 % numero2 == 0);

	}

	public static String asignatura(String dia) {
		String asignatura;
		if (dia.equalsIgnoreCase("Lunes")) {
			asignatura = "BBDD";
		} else if (dia.equalsIgnoreCase("Martes")) {
			asignatura = "Programación";
		} else if (dia.equalsIgnoreCase("Miércoles")) {
			asignatura = "Programación";
		} else if (dia.equalsIgnoreCase("Jueves")) {
			asignatura = "FOL";
		} else if (dia.equalsIgnoreCase("Viernes")) {
			asignatura = "Programación";
		} else {
			asignatura = "No hay clase";
		}
		return (asignatura);
	}

	public static String tipoCaracter(char caracter) {
		String tipo;
		int codigo;
		codigo = (int) caracter;
		tipo = "";
		if (codigo >= 48 && codigo <= 57) {
			tipo = "Es un numero de 0 a 9";
		} else if (codigo >= 65 && codigo <= 90) {
			tipo = "Es una letra mayuscula";
		} else if (codigo >= 97 && codigo <= 122) {
			tipo = "Es una letra minuscula";
		} else if (codigo >= 44 || codigo == 58 || codigo == 59) {
			tipo = "Es un punto";
		} else if (codigo == 32) {
			tipo = "Es un espacio blanco";
		} else if (codigo == 40 || codigo == 41 || codigo == 123 || codigo == 125) {
			tipo = " Paréntesis () o llaves";
		} else {
			tipo = "Es otro caracter";
		}

		return tipo;

	}

	/*
	 * 4. Calcular las calificaciones de un alumno con un método que reciba la nota
	 * de la parte práctica, la nota de los problemas y la parte teórica. La nota
	 * final se calcula según el siguiente criterio: la parte práctica vale el 10%;
	 * la parte de problemas vale el 50% y la parte teórica el 40%. Las notas deben
	 * estar entre 0 y 10, si no lo están, deberá devolver un mensaje de error.
	 * Realiza el método que calcule la media de tres notas y te devuelva la nota
	 * del boletín (insuficiente, suficiente, bien, notable o sobresaliente).
	 */
	public static String calcularNota(double practica, double problemas, double teorico) {
		String calificacion;

		double practicaCalculo = practica * 0.1;
		double problemasCalculo = problemas * 0.5;
		double teoricoCalculo = teorico * 0.4;
		double total = practicaCalculo + problemasCalculo + teoricoCalculo;

		if (total < 5) {
			calificacion = "Insuficiente";
		} else if (total >= 5 && total < 6) {
			calificacion = "Suficiente";
		} else if (total >= 6 && total < 8) {
			calificacion = "Notable";
		} else {
			calificacion = "Sobresaliente";
		}

		return calificacion;
	}

	/*
	 * 5. Realiza un método que reciba una hora por parámetro y que muestre luego
	 * buenos días, buenas tardes o buenas noches según corresponda. Se utilizarán
	 * los tramos de 6 a 12, de 13 a 20 y de 21 a 5, respectivamente, sólo teniendo
	 * en cuenta el valor de las horas.
	 */

	public static String saludoDia(String horaMinutos) {
		String saludo;

		int horas = Integer.valueOf(horaMinutos.substring(0, 2));

		if (horas >= 6 && horas < 13) {
			saludo = "Buenos dias";
		} else if (horas >= 13 && horas < 20) {
			saludo = "Buenas tardes";
		} else {
			saludo = "Buenas noches";
		}

		return saludo;
	}

	/*
	 * 6. Programar un sistema de calefacción-refrigeración que compruebe en función
	 * del día y el mes, la estación en la que estamos y dependiendo de la estación
	 * programe la temperatura: Invierno→19º, Primavera→20º, Verano→24º, Otoño→19º.
	 * El método deberá recibir como parámetro el mes y el día actual y devolver los
	 * grados a los que deberemos programar el sistema
	 */

	public static int termostato(int dia, int mes) {
		int grados = 0;

		if (dia > 19 && dia <= 31 && mes == 3) {
			grados = 20;
		} else if (dia > 19 && dia <= 30 && mes == 6) {
			grados = 24;
		} else if (dia > 19 && dia <= 31 && mes == 9) {
			grados = 19;
		} else if (mes > 3 && mes <= 6) {
			grados = 20;
		} else if (mes > 6 && mes <= 9) {
			grados = 24;
		} else if (mes > 9 && mes <= 12) {
			grados = 19;
		} else {
			grados = 19;
		}

		return grados;
	}

	/*
	 * 7. Codifica las siguientes secuencias numéricas haciendo uso de estructuras:
	 * i) for, ii) while, iii) do-while en cada una de ellas: a. Crea un método que
	 * muestre los números del 1 al 100 b. Repite el ejercicio anterior, pero en
	 * formato descendente, es decir, del 100 al 1. c. Crea un programa que calcule
	 * y escriba los números múltiplos de 5 de 0 a 100. d. Escribe los números del
	 * 320 al 160, contando de 20 en 20 hacia atrás.
	 */

	public static void secuenciaAscendente() {
		int secuencia = 1;
		final int LIMITE_SUPERIOR = 101;
		while (secuencia < LIMITE_SUPERIOR) {

			System.out.println(secuencia++);

		}
		
		/*for (int i=1; i<LIMITE_SUPERIOR;i++) {
			System.out.println(i);
		}*/
		
		secuencia = 1;
		do {
			System.out.println(secuencia++);
		} while (secuencia < LIMITE_SUPERIOR);

	}

	public static void secuenciaDescendente() {
		final int LIMITE_INFERIOR = 1;
		int secuencia = 100;
		for (int i = LIMITE_INFERIOR; i > 0; i--) {

			System.out.println(i);
		}
		
		/*do {
			System.out.println(secuencia--);
		} while (secuencia > LIMITE_INFERIOR);

		while (secuencia > LIMITE_INFERIOR) {
			System.out.println(secuencia--);
		} */

		
	}

	public static void multiplosCinco() {
		int total = 0;
		int secuencia = 0;
		while (total < 100) {
			System.out.println(total = secuencia * 5);
			secuencia++;
		}

	}
	
	public static void secuenciaVeinte() {

		for (int i = 320; i >= 160; i -= 20) {
			System.out.println(i);
		}

	}
	
	/* 8. Método que pida 15 números y realice su suma. */

	public static int realizarSuma() {
		Scanner sc = new Scanner(System.in);
		int contador = 1;
		int total = 0;
		do {
			System.out.println("Introduzca numero " + contador + "/15: ");
			total += sc.nextInt();

			contador++;
		} while (contador <= 15);

		return total;

	}


	
	/*9. Método que pida 5 números e imprima si alguno es múltiplo de 3*/
	
	public static String multiplosTres() {
		int contador = 1;
		String mensaje = "";
		int numero = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca numero "+contador+"/5: ");
			numero = Integer.parseInt(sc.nextLine());
			
			if (numero%3==0) {
				
				mensaje+=numero+" Es multiplo de 3, ";
			}
			
			contador++;
		}while (contador <=5);
		
		return mensaje.substring(0, (mensaje.length())-2);
	}

	/*10. Realiza un programa que sume los 100 números siguientes a un número entero y
positivo introducido por teclado. Se debe comprobar que el dato introducido es
correcto (que es un número positivo).*/
	
	public static int sumaCien() {
		int total=0;
		Scanner sc = new Scanner(System.in);
		int numero=0;
		do {
			System.out.println("Introduce un numero: ");
			numero = Integer.parseInt(sc.nextLine());
			
			
		}while(numero<0);
		
		for (int i = numero+100;i>=numero;i--) {
			
			total+=i;
			
		}
		
		
		return total;
	}
	
	/*11. Realiza un programa que pida números y muestre su cuadrado, repitiendo el
proceso hasta que se introduzca un número negativo.*/
	
	public static void powerIT() {
		Scanner sc = new Scanner(System.in);
		int numero=0;
		System.out.println("Introduce numero, mete negativo para terminar");
		numero = Integer.parseInt(sc.nextLine());
		
		while (numero>0) {
			System.out.println(numero*numero);
			System.out.println("Introduce numero, mete negativo para terminar");
			numero = Integer.parseInt(sc.nextLine());
		}
		
		
		
	}
	
	/*12. Realiza un programa que pida números hasta que se teclee uno negativo y muestre
cuántos números se han introducido*/
	
	public static String contarNumeros() {
		Scanner sc = new Scanner(System.in);
		int numero=0;
		System.out.println("Introduce numero, mete negativo para terminar");
		numero = Integer.parseInt(sc.nextLine());
		int cantidad = 0;
		while (numero>0) {
			cantidad++;
			System.out.println("Introduce numero, mete negativo para terminar");
			numero = Integer.parseInt(sc.nextLine());
		}
		return ("Se ha introducido "+ cantidad + " numeros.");
	}
	
	/*13. Programa que reciba 10 números y nos indique el valor máximo y mínimo*/
	
	public static String contarMaximoMinimo() {
		Scanner sc = new Scanner(System.in);
		int numero=0;
		int contador = 1;
		int maximo = 0;
		int minimo = 0;
		while (contador<10) {
			System.out.println("Introduce numero "+ contador + "/10");
			numero = Integer.parseInt(sc.nextLine());
			
			maximo = numero>maximo?numero:maximo;
			minimo = contador==1?numero:minimo;
			minimo = numero<minimo?numero:minimo;
			contador++;
		}
		
		return ("El numero mayor introducido es "+ maximo + " y el minimo es "+minimo);
	}
	
	/*14. Realiza un programa que vaya pidiendo números hasta que se introduzca un
número negativo y nos diga cuántos números se han introducido, la media de los
impares y el mayor de los pares. El número negativo sólo se utiliza para indicar el
final de la introducción de datos pero no se incluye en el cómputo.*/
	
	public static String calculosVarios() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero, introduce un negativo para cancelar");
		int numero = Integer.parseInt(sc.nextLine());
		int media = 0;
		int contador = 0;
		int sumaimpares = 0;
		int mayorpares = 0;
		int contadorimpares = 0;
		while(numero>=0) {
			contador++;
			contadorimpares = numero%2!=0?++contadorimpares:contadorimpares;
			sumaimpares = numero%2!=0?sumaimpares+numero:sumaimpares;
			media = sumaimpares/contadorimpares;
			mayorpares = numero>mayorpares?numero:mayorpares;
			System.out.println("Introduce numero, introduce un negativo para cancelar");
			numero = Integer.parseInt(sc.nextLine());
			
		}
		return ("La media de los impares es "+media+" se han introducido "+ contador+ " numeros y el mayor de los pares es "+mayorpares);
	}
	
	/*15. Crea un programa que permita sumar N números. El usuario decide cuándo termina
de introducir números al indicar la palabra ‘fin’*/
	
	public static int sumarNnumeros() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero o fin, para finalizar");
		String numero = sc.nextLine();
		int suma = 0;
		while (!numero.equals("fin")) {
			suma = Integer.parseInt(numero)>0||Integer.parseInt(numero)<0?suma+Integer.parseInt(numero):suma;
			System.out.println("Introduzca un numero o fin, para finalizar");
			numero = sc.nextLine();
		}
		return suma;
	}
	
	/*16. Pedir 10 valores numéricos que representan el salario mensual de 10 empleados.
Mostrar su suma y cuantos hay mayores de 1000€
*/
	public static String salario() {
		Scanner sc = new Scanner(System.in);
		int salario = 0;
		int suma = 0;
		int mileurista = 0;
		for(int i=1;i<11;i++) {
			
			System.out.println("Introduce salario de empleado "+ i + "/10");
			salario = Integer.parseInt(sc.nextLine());
			suma += salario;
			mileurista = salario>1000?++mileurista:mileurista;
			
		}
		return ("La suma de todos los salarios es "+suma+"€ y de ellos "+mileurista+" cobran mas de 1000€");
	}
	
	/*17. Escribe un programa que muestre los N primeros términos de la serie de Fibonacci.
El primer término de la serie de Fibonacci es 1, el segundo es 1 y el resto se calcula
sumando los dos anteriores, por lo que tendríamos que los términos son 1, 1, 2, 3, 5,
8, 13, 21, 34, 55, 89, 144*/
	
	public static String fibonacci (int cantidad) {
		int acumulador1 = 1;
		int acumulador2 = 1;
		int acumulador3 =0;
		String salida = "";
		for (int i=0; i<cantidad;i++) {

			acumulador3 = acumulador1+acumulador2;
			acumulador1 = acumulador2;
			acumulador2 = acumulador3;
			salida += acumulador3+", ";
			
		}
		
		return ("1, 1, "+ salida.substring(0, salida.length()-2));
	}
	
	/*18. Realizar un método llamado calcularAreaCirculo que devuelva el área de un círculo
y otro llamado calcularLongitudCirculo que devuelva su longitud*/
	
	public static double calcularAreaCirculo(int radio) {
		double area = Math.pow(radio, radio)*Math.PI;
		
		return area;
	}
	
	public static double calcularLongitudCirculo(int radio) {
		double longitud = (radio*2)*Math.PI;
		
		return longitud;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ejercicio 3
		// char caracter = 'Q';
		// System.out.println(tipoCaracter(caracter));

		// Ejercicio 4
		// System.out.println(calcularNota(10, 10, 10));

		// Ejercicio 5
		// System.out.println(saludoDia("13:00"));

		// Ejercicio 6
		// System.out.println(termostato(21, 5));

		// Ejercicio 7

		// a.
		// secuenciaAscendente();

		// b.
		// secuenciaDescendente();

		// c.
		// multiplosCinco();

		// d.
		// secuenciaVeinte();

		// Ejercicio 8

		//System.out.println(realizarSuma());

		// Ejercicio 9
		//System.out.println(multiplosTres());
		
		// Ejercicio 10
		//System.out.println(sumaCien());
		
		//Ejercicio 11
		//powerIT();
		
		//Ejercicio 12
		//System.out.println(contarNumeros());
		
		//Ejercicio 13
		//System.out.println(contarMaximoMinimo());
		
		//Ejercicio 14
		//System.out.println(calculosVarios());
		
		//Ejercicio 15
		//System.out.println(sumarNnumeros());	
		
		//Ejercicio 16
		//System.out.println(salario());
		
		//Ejercicio 17
		//System.out.println(fibonacci(10));
		
		//Ejercicio 18
		//System.out.println(calcularAreaCirculo(25));
		//System.out.println(calcularLongitudCirculo(25));
		
	}

}
