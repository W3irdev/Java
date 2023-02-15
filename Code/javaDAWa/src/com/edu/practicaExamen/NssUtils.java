package com.edu.practicaExamen;

public class NssUtils {

	public static String generarDigitoControl (String nss) {
		String dc = "-1";
		if (!(nss==null||nss.isEmpty()||nss.length()<9||nss.length()>11)) {
			dc=String.valueOf(Integer.parseInt(nss)%97).length()<2?"0"+Integer.parseInt(nss)%97:String.valueOf(Integer.parseInt(nss)%97);
			
			
		}else {
			System.out.println("El numero NSS, no es valido");
		}
		
		
		return dc;
	}
	
	public static boolean esEmitidoAndalucia (String nss) {
		boolean andalucia = false;
		if (!(nss==null||nss.isEmpty()||nss.length()<10||nss.length()>12)) {
			if (nss.substring(nss.length()-2, nss.length()).equals(generarDigitoControl(nss.substring(0, nss.length()-2)))) {
			
			switch (nss.substring(0, 2)) {
			case "04","11","14","18","21","23","29","41" -> andalucia=true;
			default -> andalucia = false;
			}
			}else {
				System.out.println("El numero de control dado, no es valido para ese NSS");
			}
			
		}else {
			System.out.println("El numero NSS, no es valido");
		}
		return andalucia;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(generarDigitoControl("1101301164"));
		System.out.println(esEmitidoAndalucia("110130116424"));

	}

}
