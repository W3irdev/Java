package com.pooavanzado.figuras;

import com.pooavanzado.figuras.model.Circulo;
import com.pooavanzado.figuras.model.Figura;
import com.pooavanzado.figuras.model.Triangulo;

public class MainFiguras {

	public static void main(String[] args) {
		
		
		Figura circulo = new Circulo(3);
		Figura triangulo = new Triangulo(3,4,5);
		
		System.out.println(triangulo.calcularPerimetro());
		System.out.println(circulo.calcularArea());
		System.out.println(circulo.calcularPerimetro());
	}

}
