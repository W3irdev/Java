package com.examen;

public class ADNUtil {
	
	public static final String NUCLEOTIDOS = "ATGC";
	
	/**
	 * @param secuencia
	 * 
	 * Argumento para la cadena ADN a obtener numero de palabras
	 * @return
	 */
	public static int obtenerNumeroPalabras(String secuencia) {
		/**
		 * Recorremos con bucle la cadena, en un StringBuilder vamos formando las palabras, si coincide con TAA o ATT entonces cuenta una palabra
		 */
		
		boolean esValido=true;
		int palabras = 0;
		StringBuilder conjunto = new StringBuilder();
		
		for (int i=0; i<secuencia.length()&&esValido;i++) {
			if (NUCLEOTIDOS.indexOf(secuencia.charAt(i))==-1) {
				esValido=false; //En caso de que la entrada no sea nucleotido, salimos del bucle y terminamos programa
				palabras=-1;
			}else {
				if (secuencia.charAt(i)=='A'||secuencia.charAt(i)=='T') {
					conjunto.append(secuencia.charAt(i));
					if (conjunto.toString().equals("ATT")||conjunto.toString().equals("TAA")) {
						palabras++;
					}
					
					
				}else {
					conjunto.setLength(0);
				}
				
			}
			
		}
		
		return palabras;
	}
	
	
	/**
	 * @param comprimido
	 * Cadena con el ADN en formato comprimido A3G2T1C3
	 * @return
	 */
	public static String descomprimeADN(String comprimido) {
		
		/**
		 * Esta funcion permite descomprimir cadenas de ADN
		 */
		
		StringBuilder descomprimido = new StringBuilder(); //Vamos almacenando la cadena descomprimida
		boolean esValido=true;
		
	
			for (int i=0; i<comprimido.length()-1&&esValido;i++) {
				if (!(Character.isDigit(comprimido.charAt(i)))) {
					
					for (int j=0;j<Integer.valueOf(comprimido.substring(i+1, i+2));j++){
						descomprimido.append(comprimido.substring(i, i+1));
					}
				}
				
			
			
		}
		
		
		return descomprimido.toString();
	}
	
	public static String comprimeADN(String cadena) {
	
		int contador=0;
		String temp="";
		StringBuilder comprimido=new StringBuilder();
		
		
		for (int i=0; i<cadena.length();i++) {
			
			if (!(NUCLEOTIDOS.indexOf(cadena.charAt(i))==-1)) {
				temp=String.valueOf(cadena.charAt(i));
				while (String.valueOf(cadena.charAt(i)).equals(temp)) {
					contador++;
				}
				if (contador>0) {
					comprimido.append(cadena.substring(i-1, i)+contador);
					contador=0;
				}
				
			}
			
		}
		
		
		return comprimido.toString();
	}

	public static void main(String[] args) {
		//System.out.println(obtenerNumeroPalabras("ATTATCTCGTAAAGGATCTCGAAT"));
		//System.out.println(descomprimeADN("A3G2T1C3"));
		System.out.println(comprimeADN("AAAGGTCCC"));
	}

}
