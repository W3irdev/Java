package restaurante;

import java.time.LocalDate;

import restaurante.model.Alergeno;
import restaurante.model.Bebida;
import restaurante.model.Cliente;

public class MainRestaurante {

	public static void main(String[] args) {
		
		Restaurante r = new Restaurante();
		
		Cliente clienteUno = new Cliente(LocalDate.now().minusYears(20), Alergeno.CACAHUETES);
		
		Bebida b = new Bebida("Revoltosa Sin", "Bebida dulce", null, 20, 1);
		Cliente clienteDos = new Cliente(LocalDate.now().minusYears(20), Alergeno.CACAHUETES);
		
		System.out.println(clienteUno);
		System.out.println(b);
		System.out.println(clienteDos);
		
		r.darAltaCliente(clienteDos);
		System.out.println(b.getCodigoProducto());
		

	}

}
