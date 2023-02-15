package com.edu;

public class Boletin2 {
	
	/*1. Realizar un método llamado numeroSolucionesEcuacionSegundoGrado que reciba
los coeficientes de una ecuación de segundo grado y devuelva el número de
soluciones que tiene. Si los argumentos no son válidos (el primer coeficiente tiene
que ser distinto de cero) debe devolver un -1.
*/

	public static String numeroSolucionesEcuacionSegundoGrado(double a, double b, double c) {
		double x1= 0;
		double x2=0;
		
		if (a!=0) {
			x1= ((-b)+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
			x2= ((-b)-Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
			
		}else {
			x1=-1;
			x2=-2;
		}
		
		
		return ("X1="+x1+" X2="+x2);
		
	}
	
	/*2. Realiza un programa que pida un número por teclado y que después muestre ese
número al revés.
*/
	
	public static String numeroDelReves(String numero) {
		
		String mensaje="";
		
		try {
		if (Integer.parseInt(numero)>9) {
			for (int i = numero.length()-1;i>=0;i--)
			
			mensaje+=numero.charAt(i);
		}
			
		}catch(Exception noEsNumero) {
			mensaje="Introduce un numero mayor 9";
		}
		
		return mensaje;
	}
	
	/*3. Diseña una función que, dada una cadena de entrada, comprueba si es una
contraseña fuerte o no. Se considera que una contraseña es fuerte si contiene 8 o
más caracteres, y entre ellos al menos hay una mayúscula, una minúscula, un signo
de puntuación y al menos un dígito.
*/
	
	public static boolean checkPassword(String password) {
		boolean strenght=false;
		
		strenght=password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,15}")?true:false;
		
		return strenght;
	}
	
	/*4. Elabora un programa que codifique una cadena, de tal modo que en el resultado se
inviertan cada 2 caracteres. Los caracteres intercambiados no pueden volver a
intercambiarse. Ejemplo:
Entrada -> Hola mundo
Salida -> oHalm nuod
*/
	
	public static String codificarCadena(String cadena) {
		String nuevaCadena="";
			for (int posicion = 0; posicion < cadena.length()-1; posicion++) {
			
				if (cadena.length()%2==0&&posicion % 2 == 0) {
					
					nuevaCadena += cadena.charAt(posicion+1);
					nuevaCadena += cadena.charAt(posicion);
				
			
			}
				
			
		}
		
		
		return nuevaCadena;
	}
	
	
	
	/*5. Realizar un método llamado esMultiplo que recibirá dos números y devuelva True si
el primer número es múltiplo del segundo.
*/
	
	public static boolean esMultiplo(int numero1, int numero2) {
		boolean esMultiplo=false;
		
		esMultiplo=numero1%numero2==0?true:false;
		
		return esMultiplo;
	}
	
	/*6. Realizar un método llamado horaMayor que recibirá seis valores enteres, los tres
primeros representarán la hora, minuto y segundos de la primera hora y los otros
tres de la segunda hora. Se deberá devolver un 1 si la primera hora es mayor que la
segunda, un 2 si la segunda hora es mayor que la primera, un 0 si son iguales y un
-1000 si los datos no son correctos.*/
	
	
	public static int horaMayor(int hora1, int minutos1, int segundos1, int hora2, int minutos2, int segundos2) {
		int horaMayor;
		if(hora1>=0&&hora1<24&&hora2>=0&&hora2<24&&minutos1>=0&&minutos1<60&&
				minutos2>=0&&minutos2<60&&segundos1>=0&&segundos1<60&&segundos2>=0&&segundos2<60) {
			
			if (hora1==hora2&&minutos1==minutos2&&segundos1==segundos2){
				horaMayor=0;
				
			}else if (hora1>hora2) {
				horaMayor=1;
			}else if (hora1==hora2) {
				horaMayor=minutos1>minutos2?1:2;
				if (minutos1==minutos2 && segundos1!=segundos2) {
					horaMayor=segundos1>segundos2?1:2;
				}
			}else {
				horaMayor=2;
			}
			
		}else {
			horaMayor=-1000;
		}
		

		
		return horaMayor;
	}
	
	/*7. Realizar un método llamado segundosEntre que recibirá seis valores enteros, los
tres primeros representarán la hora, minuto y segundos de la primera hora y los
otros tres de la segunda hora. Se deberá devolver el número de segundos que hay
entre la primera hora y la segunda (el valor debe ser siempre en positivo). Si los
datos no son correctos se deberá devolver -1000*/
	
	public static int segundosEntre(int hora1, int minutos1, int segundos1, int hora2, int minutos2, int segundos2) {
		int totalSegundos1;
		int totalSegundos2;
		int total=-1000;
		if(hora1>=0&&hora1<24&&hora2>=0&&hora2<24&&minutos1>=0&&minutos1<60&&
				minutos2>=0&&minutos2<60&&segundos1>=0&&segundos1<60&&segundos2>=0&&segundos2<60) {
			totalSegundos1=((hora1*60)*60)+(minutos1*60)+segundos1;
			totalSegundos2=((hora2*60)*60)+(minutos2*60)+segundos2;
			
			total=Math.abs(totalSegundos1-totalSegundos2);
			
			
		}
		
		return total;
	}
	
	/*8. Realiza un método llamado toBinary que reciba un número decimal como
argumento y devuelva un String con el número binario correspondiente.
*/
	
	
	public static String toBinary(int decimal) {
		String binario="";
		
		while (decimal/2!=0&&decimal/2!=1) {
			binario=Integer.toString(decimal%2)+binario;
			decimal=decimal/2;
		}
		if (decimal/2==1||decimal/2==0) {
			binario=Integer.toString(decimal%2)+binario;
			binario=Integer.toString(decimal/2)+binario;
		}
		return binario;
		
	}
	/*9. Realiza un método llamado toDecimal que reciba un String con un valor binario
como argumento y devuelva un número con el número decimal correspondiente.
*/
	
    public static int toDecimal(String binario) {
        int decimal = 0;
        int exponent = 0;
        for(int i = binario.length() -1; i >= 0; i--) {
            decimal += Integer.valueOf(binario.substring(i, i+1)) * Math.pow(2, exponent);
            exponent++;
        }
        return decimal;
    }

	/*10. Realiza un método llamado gcd (greaterCommonDivisor) que recibirá dos números y
devuelva el máximo común divisor según el algoritmo de Euclides*/
    
    public static int gcd (int numero1, int numero2) {
    	int gcd=0;
    	int numMayor=numero1>numero2?numero1:numero2;
    	while (!(numero1%numMayor==numero2%numMayor)) {
    		numMayor--;
    		gcd=numMayor;
    	}
    	
    	return gcd;
    }
    
    /*11. Realizar un método llamado minimoComunMultiplo que reciba dos números y
calcule el mínimo común múltiplo de dos números. Con el máximo común divisor de
una pareja de números podemos obtener fácilmente el mínimo común múltiplo de
dicha pareja. El mínimo común múltiplo de dos números es igual al producto de los
números dividido entre su máximo común divisor. Por ejemplo, el máximo común
divisor de 24 y 36 es 12, por tanto el mínimo común múltiplo de 24 y 36 es
(24×36)/12=72*/
    
    public static int minimoComunMultiplo (int numero1, int numero2) {
    	int mcm;
    	
    	mcm = (numero1*numero2)/gcd(numero1, numero2);
    	
    	return mcm;
    }
	
    /* Realiza una funcion que cifre un caracter segun el cifrado cesar y un desplazamiento dado.
     * 
     * crea otra funcion que utilice la anterior para codificar una palabra o texto*/
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ejercicio 1
		//System.out.println(numeroSolucionesEcuacionSegundoGrado(1, -5, 6));
		//Ejercicio 2
		//System.out.println(numeroDelReves("45645645"));
		//Ejercicio 3
		//System.out.println(checkPassword("T65tuv54%"));
		//Ejercicio 4
		System.out.println(codificarCadena("Hola mundo"));
		//Ejercicio 5
		//System.out.println(esMultiplo(20, 10));
		//Ejercicio 6
		//System.out.println(horaMayor(20, 22, 23, 19, 22, 23));
		//Ejercicio 7
		//System.out.println(segundosEntre(22, 10, 10, 22, 22, 22));
		//Ejercicio 8
		//System.out.println(toBinary(883));
		//Ejercicio 9
		//System.out.println(toDecimal("01111101"));
		//Ejercicio 10
		//System.out.println(gcd(20, 10));
		//Ejercicio 11
		//System.out.println(minimoComunMultiplo(2, 6));
		
	}

}
