package main;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.ConnectTienda;

public class Main {

	public static void main(String[] args) {
		
		try {
			ConnectTienda ct = new ConnectTienda();
	        Scanner sc= new Scanner(System.in);
	        int opcion=0;
        	String nombre = "";
        	String apellido = "";
        	String email = "";
        	String emailNuevo = "";
        	String fechaNacimiento = "";
        	String genero = "";
        	int idCliente =-1;
        	int idPedido =-1;
        	String codigoProducto="";
        	String nombreProducto="";
        	int cantidad=0;
        	double precio=0.0;
	        while(opcion<7) {
	            do {
	                System.out.println("Elige opción: \n 1- Mostrar informacion sobre clientes \n 2- Mostrar pedidos \n 3- Añadir cliente \n 4- Actualizar un cliente existente \n 5- Eliminar cliente \n 6- Añadir pedido \n 7- Incluir lineas de pedido a un pedido existente \n 8- Salir del menu");
	                opcion=Integer.valueOf(sc.nextLine());
	            }while (opcion<1 || opcion>8);
	            switch(opcion) {
	            case 1:
	            	System.out.println(ct.mostrarClientes());
	            	
	                break;
	            case 2:
	            	System.out.println(ct.mostrarPedidosPorPrecio());
	                break;
	            case 3:
	            	System.out.println("Introduzca nombre: ");
	            	nombre = sc.nextLine();
	            	System.out.println("Introduzca apellido: ");
	            	apellido = sc.nextLine();
	            	System.out.println("Introduzca email");
	            	email = sc.nextLine();
	            	System.out.println("Introduzca fecha nacimiento en formato (yyyy-MM-dd)");
	            	fechaNacimiento = sc.nextLine();
	            	System.out.println("Introduzca genero (M o F)");
	            	genero = sc.nextLine();
	            	
	            	if(ct.addCliente(nombre, apellido, email, fechaNacimiento, genero)==1) {
	            		System.out.println("Se ha introducido correctamente");
	            	}else {
	            		System.out.println("Ha ocurrido un error");
	            	}
	                break;
	            case 4:
	            	System.out.println("Introduzca nombre: ");
	            	nombre = sc.nextLine();
	            	System.out.println("Introduzca apellido: ");
	            	apellido = sc.nextLine();
	            	System.out.println("Introduzca email antiguo");
	            	email = sc.nextLine();
	            	System.out.println("Introduzca email nuevo");
	            	emailNuevo = sc.nextLine();
	            	if(ct.actualizarCliente(nombre, apellido, email, emailNuevo)==1) {
	            		System.out.println("Se ha actualizado correctamente");
	            	}
	            	
	                break;
	            case 5:
	            	System.out.println("Introduzca nombre: ");
	            	nombre = sc.nextLine();
	            	System.out.println("Introduzca apellido: ");
	            	apellido = sc.nextLine();
	            	if(ct.delCliente(nombre, apellido)==1) {
	            		System.out.println("Eliminado correctamente.");
	            	}
	            	
	                break;
	            case 6:
	            	System.out.println("Introduzca estado para nuevo pedido");
	            	String estado = sc.nextLine();
	            	System.out.println("Introduzca id del cliente");
	            	idCliente = Integer.valueOf(sc.nextLine()) ;
	            	if(ct.addPedido(estado, idCliente)==1) {
	            		System.out.println("Añadido correctamente.");
	            	}
	            	
	                break;
	            case 7:
	            	System.out.println("Introduzca id del pedido a introducir producto: ");
	            	idPedido = Integer.valueOf(sc.nextLine());
	            	System.out.println("Introduzca codigo del producto: ");
	            	codigoProducto=sc.nextLine();
	            	System.out.println("Introduzca nombre del producto: ");
	            	nombreProducto=sc.nextLine();
	            	System.out.println("Introduzca cantidad: ");
	            	cantidad=Integer.valueOf(sc.nextLine());
	            	System.out.println("Introduzca precio: ");
	            	precio=Double.valueOf(sc.nextLine());
	            	try {
	            		ct.incluirLinea(idPedido, codigoProducto, nombreProducto, cantidad, precio);
						main(args);
					} catch (Exception e) {
						System.err.println("El pedido no existe");
						main(args);
					}
	                break;
	               
	            }
	        }
	        sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

		  

}
