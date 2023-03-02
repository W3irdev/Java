package com.edu.examen2;

public class ADNUtil {

	final static String NUCLEOTIDOS = "ATGC";
	
	public static int contarPalabra(String secuencia, String buscar) {
		int palabras=0;
		boolean esValido=true;
		for (int i=0; i<secuencia.length();i++) {
			
			
			if (!((secuencia==null||secuencia.equals("")||buscar==null||buscar.equals(""))||NUCLEOTIDOS.indexOf(secuencia.charAt(i))==-1)) {
			
			if (!(i+buscar.length()>secuencia.length())&&esValido) {
				
				if (secuencia.substring(i, i+buscar.length()).equalsIgnoreCase(buscar)){
					palabras++;
					
				}
			
			}
			}else {
				System.out.println("La cadena es incorrecta");
				esValido=false;
			}
			
		}
		
		
		return palabras;
	}
	
	public static String descomprimeADN(String comprimido) {

		StringBuilder adnCompleto = new StringBuilder(); 
		boolean esValido=true;
	
		if (!(comprimido==null||comprimido.equals(""))) {
		
			for (int i=0; i<comprimido.length()-1&&esValido;i++) {
				if (!(Character.isDigit(comprimido.charAt(i)))) {
					
					for (int j=0;j<Integer.valueOf(comprimido.substring(i+1, i+2));j++){
						adnCompleto.append(comprimido.substring(i, i+1));
					}
				}
				
		}
		}else {
			System.out.println("La cadena es incorrecta");
		}
		return adnCompleto.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(contarPalabra("CTCGTTCTCGTTGATCTTTT", "CGTT"));
		System.out.println(descomprimeADN("A2G2T1C3"));
		
	}
}
