package com.edu;

import java.util.Scanner;

public class Boletin3 {

	/*1. Escribe una función que reciba una cadena de texto y una variable bandera
(par/impar) e imprima solo los caracteres que se encuentran situados en las
posiciones pares o impares (según indique la variable bandera).
Desarrolla el código con un bucle for y después modifica el código para que utilice
una estructura while y do-while*/
	
	
	public static String parOimpar (String cadena, boolean par) {
		StringBuilder salida = new StringBuilder();
		
		for (int i=0; i<cadena.length();i++) {
			
			if (i==0&&par) {
				salida.append(cadena.charAt(i));
			}else if (i%2==0&&par) {
				salida.append(cadena.charAt(i));
			}else if (i%2!=0&&!par){
				salida.append(cadena.charAt(i));
			}
		}
		
		
		return salida.toString();
		
	}
	
	/*2. Un número es divisible por 3 si la suma de todas sus cifras reducidas a una cifra es
igual a 0, 3, 6 ó 9.
Por ejemplo, 156 ⇒ 1+5+6=12 ⇒ 1+2 = 3 es divisible,
pero 157 ⇒ 1+5+7 =13 ⇒ 1+3 =4 no lo es.
Elabora un programa que compruebe la divisibilidad por 3 según este algoritmo. El
programa debe comprobar que el número facilitado es válido.
*/
	
	public static boolean esDivisible3 (String numero) {
			boolean esDivisible = false;
			int suma = 0;
			int contador=0;
			StringBuilder total = new StringBuilder();
			if (Integer.valueOf(numero)>0||Integer.valueOf(numero)<0) {
				
				do {
					for (int i=0; i<numero.length();i++) {
						suma += Integer.valueOf(String.valueOf(numero.charAt(i)));
					}
		
					total.append(suma);
				}while (total.length()>1);
				
				
			esDivisible=total.toString().equals("0")||total.toString().equals("3")||total.toString().equals("6")||
					total.toString().equals("9")?true:false;
		}
			
			
		return esDivisible;
	}
	
	/* 3. Diseña un programa que cuente el número de veces que aparece una palabra en
una cadena de texto.
*/
	
	public static int contarPalabras (String cadena, String palabra) {
		String almacen = "";
		int comienza=0;
		int contador = 0;
		int veces=0;
		for (int i=0; i<cadena.length();i++) {
			while (cadena.charAt(i)!=' ' && i!=cadena.length()-1) {
				i++;
				contador++;
			}
			almacen = i!=cadena.length()-1?cadena.substring(comienza, contador+comienza):cadena.substring(comienza, contador+comienza+1);
			/*almacen.append(cadena.substring(comienza, contador+comienza));*/
			comienza=i+1;
			contador=0;
			if (palabra.equals(almacen)) {
				veces++;
			}
			
		}
		
		return veces-1;
	}
	
	/*4. Crea tres funciones cuyo comportamiento sea como el de los métodos de String
startsWirth, contains y endsWith, pero sin utilizar ninguno de ellos.*/
	
	public static boolean comienzaCon (String palabra, String prefijo) {
		int offset = prefijo.length();
		
		return ( palabra.substring(0, offset).equals(prefijo));
		
	}
	
	public static boolean terminaCon (String palabra, String sufijo) {
		int offset = palabra.length()-sufijo.length();
		
		return ( palabra.substring(offset, palabra.length()).equals(sufijo));
		
	}
	
	public static boolean contiene (String cadena, String palabra) {
		boolean contiene= false;
		int posicion = 0;
		
		while (!contiene&&posicion<cadena.length()&&palabra.length()+posicion<=cadena.length()) {
			
			if (cadena.toUpperCase().substring(posicion, palabra.toUpperCase().length()+posicion).equals(palabra.toUpperCase())) {
				contiene=true;
			}else {
				posicion++;
			}
			
			
		}
		return contiene;
		
		
		
	}
	
	/*5. Diseña una función llamada esPalindromo que reciba una cadena de caracteres y
determine si constituye un palíndromo o no. Una palabra es un palíndromo si puede
leerse del mismo modo de izquierda a derecha que de derecha a izquierda. Obvia
los espacios en blanco y caracteres separadores, así como tildes, etc.
Ejemplos de palíndromos: ‘Ligar es ser ágil’, ‘Somos o no somos’.*/
	
	public static boolean esPalindromo (String cadena) {
		StringBuilder noSpace = new StringBuilder();
		StringBuilder noSpaceReverse = new StringBuilder();
		
		if (cadena != null&&cadena!="") {
			for (int i=0; i<cadena.length(); i++) {
				noSpace.append(cadena.toLowerCase().substring(i, i+1).equals(" ")||cadena.toLowerCase().substring(i, i+1).equals(".")?"":cadena.toLowerCase().charAt(i));
				noSpaceReverse.insert(0, cadena.toLowerCase().substring(i, i+1).equals(" ")||cadena.toLowerCase().substring(i, i+1).equals(".")?"":cadena.toLowerCase().charAt(i));
			}
		}
		
		return noSpace.toString().equals(noSpaceReverse.toString())?true:false;
	}
	
	/*6. Haciendo uso de la función anterior crea una función esCapicúa que acepte
números tanto enteros como decimales.
*/
	
	public static boolean esCapicua(String numero) {
		boolean esCapicua=false;
		
		try {
		if (numero!=null&&Double.valueOf(numero)>0||Double.valueOf(numero)<0) {
			esCapicua=esPalindromo(numero);
			
		}else {
			
			esCapicua=false;
		}
		
		}catch (Exception e) {
			System.out.println("Introduce un numero.");
		}
		return esCapicua;
	}
	
	
	/*7. Realizar una función que busque una palabra escondida dentro de un texto. Por
ejemplo, si la cadena es “shybaoxlna” y la palabra que queremos buscar es “hola”,
entonces si se encontrará y deberá devolver True, en caso contrario deberá devolver
False. Las letras de la palabra escondida deben aparecer en el orden correcto en la
cadena que la oculta:
shybaoxlna ⇒ hola: True
soybahxlna ⇒ hola: False*/
	
	public static boolean buscarPalabra (String cadena, String palabra) {
		int posicion=0;
		for (int i=0; i<cadena.length();i++) {
			if (posicion!=palabra.length()&&cadena.substring(i, i+1).equals(String.valueOf(palabra.charAt(posicion)))) {
				posicion++;
			}
		}
		
		
		return posicion==palabra.length()?true:false;
	}
	
	/*
	 * 8. Diseñar una función que reciba como parámetro tres cadenas, la primera será una
frase y deberá buscar si existe la palabra que recibe como segundo parámetro y
reemplazarla por la tercera.

	 */
	
	/*public static String reemplazar(String cadena, String palabra, String reemplazo) {
		int posicion=0;
		boolean reemplazado = false;
		StringBuilder nuevaCadena = new StringBuilder();
		if (buscarPalabra(cadena, palabra)) {
			for (int i=0; i<cadena.length();i++) {
			
				
			if (posicion!=palabra.length()&&cadena.substring(i, i+1).equals(String.valueOf(palabra.charAt(posicion)))) {
				posicion++;}
			else if (posicion==palabra.length()) {
				nuevaCadena.append(reemplazo);
				i--;
				posicion=0;
				reemplazado=true;
				
			}else{
				posicion=0;
				nuevaCadena.append(cadena.charAt(i));
			}

			}
			
			
		}
		
		return nuevaCadena.toString();
		
	}*/
	
	public static String reemplazar(String cadena, String palabra, String reemplazo) {
		int posicion = 0;
		StringBuilder resultado = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		for (int i=0; i<cadena.length();i++) {
			if (cadena.substring(i,i+1).equals(palabra.substring(posicion, posicion+1))) {
				
				if (posicion==palabra.length()-1) {
					tmp.append("");
					resultado.append(reemplazo);
					posicion = 0;
				}else {
					tmp.append(cadena.substring(i, i+1));
					posicion++;
				}
			}else {
				resultado.append(tmp+cadena.substring(i, i+1));
				posicion=0;
				tmp.setLength(0);
			}
		}
		
		
		
		return resultado.toString();
	}
	
	
	/*9. Escribir una función que devuelva el número de palabras, frases y párrafos que
existen en una cadena de texto que recibe como parámetro. Ten en cuenta que entre
dos palabras puede haber más de un blanco, las frases se separan por puntos y los
párrafos por saltos de línea.*/
	
	public static String devolverPalabrasFrasesParrafos(String texto) {
		int palabras=0;
		int frases=0;
		int parrafos=0;
		StringBuilder palabrasGuardadas = new StringBuilder();
		
		if (texto.length()>0) {
			parrafos++;
			
		for (int i=0; i<texto.length();i++) {
			
			if (i==0&&!texto.substring(0, 1).equals(" ")){
				palabras++;

			}else if (!texto.substring(i, i+1).isBlank()&&texto.substring(i-1, i).isBlank()){
				palabras++;
				
				
			}else if (texto.substring(i, i+1).equals(".")&&!texto.substring(i-1, i).isBlank()) { 
				
				frases++;
			}else if (texto.substring(i, i+1).equals("\n")) {
				
				parrafos++;
			}
			
		}
		
		}
		
		return ("Hay "+palabras+" palabras, "+frases+ " frases y "+parrafos+" parrafos.");
	}

	/*10. El cifrado César es un tipo de cifrado por sustitución en el que una letra del alfabeto
es sustituida por otra que se encuentra situada en el abecedario
(abcdefghijklmnñopqrstuvwxyz) un número dado de posiciones desde la primera,
como puede observarse en la siguiente imagen:
Así, por ejemplo, la palabra CASADO, con un cifrado de tres posiciones pasaría a
ser FDVDGR.
a. Realiza una función que cifre un carácter según el cifrado César y un
desplazamiento dado.
b. Elabora una función que, haciendo uso de la anterior, reciba una palabra y un
número fijo de posiciones y la codifique según este algoritmo.
c. Diseña otra función que reciba dos palabras y compruebe si son equivalentes
según este tipo de cifrado e indique el nivel de sustitución utilizado, es decir,
si cifrando una de ellas podemos obtener la otra.
Ej: Si recibe CASADO y FDVDGR debe indicar que son equivalentes
y utilizan un nivel de codificación 3
Si recibe CASADO y AAAABD debe indicar que no son equivalentes.
El programa no debe distinguir entre mayúsculas y minúsculas*/
	
	public static String cifradoCesar (String texto, int nivel) {
		String abecedario = "abcdefghijklmnñopqrstuvwxyz";
		StringBuilder cifrado = new StringBuilder();
		int posicionABC;
		
		if (texto.length()>0) {
			for (int i=0; i<texto.length();i++) {
				posicionABC = abecedario.substring(0).indexOf(texto.toLowerCase().substring(i, i+1));
				cifrado.append(abecedario.charAt((posicionABC+nivel)%abecedario.length()));
			}
		}
		
		return cifrado.toString();
	}
	
	public static String cifradoCesarEspecifico (String texto, int nivel) {
		StringBuilder cadenaCifrada = new StringBuilder ();
		int nivelEspecifico = 0;
		Scanner sc = new Scanner (System.in);
		
		
		for (int i = 0 ; i<texto.length(); i++) {
			
			System.out.println("Introduzca nivel de cifrado para el caracter "+ (i+1)+"/"+texto.length());
			nivelEspecifico=Integer.valueOf(sc.nextLine());
			cadenaCifrada.append(cifradoCesar(texto.substring(i, i+1), nivelEspecifico));
			
			
		}
		
		
		
		return cadenaCifrada.toString();
	}
	
	public static String nivelCifrado (String palabra1, String palabra2) {
		int nivelCifrado=-1;
		boolean descifrado=false;
		String mensaje ="";
		for (int i=0; i<27;i++) {
		
		if (!descifrado&&palabra1.toLowerCase().equals(cifradoCesar(palabra2.toLowerCase(), i))) {
			nivelCifrado=27-i;
			descifrado=true;
		}
		}
		
		mensaje = descifrado?"Son equivalentes y posee un nivel de cifrado de "+nivelCifrado:"No son equivalentes";
		
		return mensaje;
	}
	
	public static void main(String[] args) {
		// Ejericio 1
		//System.out.println(parOimpar("Ejemplo", false));
		// Ejercicio 2
		//System.out.println(esDivisible3("21"));
		// Ejercicio 3
		//System.out.println(contarPalabras("cuantas veces se repite cuantas", "cuantas"));
		// Ejercicio 4
		//System.out.println(comienzaCon("Esternocleidomastoideo", "Est"));
		//.out.println(terminaCon("esternocleidomastoideo", "deo"));
		//System.out.println(contiene("Erase una vez", "una"));
		// Ejercicio 5
		//System.out.println(esPalindromo("Somos o no somos"));
		// Ejercicio 6
		//System.out.println(esCapicua("11111"));
		// Ejercicio 7
		//System.out.println(buscarPalabra("shybaoxlna", "hola"));
		// Ejercicio 8
		//System.out.println(reemplazar("En esta frase hay que reemplazar coche por moto", "coche", "moto"));
		// Ejercicio 9
		//System.out.println("En este texto hay varias palabras. Alguna que otra frase.\nY dos parrafos");
		System.out.println(devolverPalabrasFrasesParrafos("En este texto hay varias palabras. Alguna que otra frase. \n Y dos parrafos."));
		// Ejercicio 10
		///System.out.println(nivelCifrado("CASADO", "fdvdgr"));
		//System.out.println(cifradoCesarEspecifico("Lacasa", 0));
		//System.out.println(cifradoCesar("CASADO", 3));
		
	}

}
