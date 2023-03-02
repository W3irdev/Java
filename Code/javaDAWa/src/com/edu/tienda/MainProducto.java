package com.edu.tienda;

import com.edu.tienda.model.Producto;

public class MainProducto {

	public static void main(String[] args) {
		Producto producto1 = new Producto("Articulo artesanal de prueba", 120);
		
		System.out.println(producto1);
		System.out.println(producto1.precioConIVA());
	}

}
