package restaurante;

import java.util.Arrays;

import restaurante.model.Cliente;
import restaurante.model.ClienteNoExistenteException;
import restaurante.model.Producto;
import restaurante.model.ProductosAlergenosComparator;
import restaurante.model.ServicioNoDisponibleException;

public class Restaurante {

	
	private Producto[] cartaProducto;
	private int ultimoProductoCarta;
	private static final int NUM_MAXIMO_PRODUCTOS = 100;
	
	private Cliente[] clientes;
	private int ultimoCliente;
	private static final int NUM_MAXIMO_CLIENTES = 20;

	public static int secuenciaGlobal;

	//ToDo
	public Restaurante() {
		this.cartaProducto=new Producto[NUM_MAXIMO_PRODUCTOS];
		this.clientes=new Cliente[NUM_MAXIMO_CLIENTES];

		
	}
	

	public boolean darAltaCliente(Cliente cliente) {
		boolean dadoAlta=false;
		
		if(cliente!=null && !dadoAlta && obtenerPosicionCliente(cliente.getCodigoCliente())==-1) {
			clientes[ultimoCliente++%NUM_MAXIMO_CLIENTES]=cliente;
			dadoAlta=true;
			
		}
		
		return dadoAlta;
	}
	

	public boolean darAltaProducto(Producto bebidaOPlato) {
		boolean dadoAlta=false;
		
		if(bebidaOPlato!=null && !dadoAlta && obtenerPosicionProducto(bebidaOPlato.getCodigoProducto())==-1) {
			cartaProducto[ultimoProductoCarta++%NUM_MAXIMO_PRODUCTOS]=bebidaOPlato;
			dadoAlta=true;
			
		}
		
		return dadoAlta;
		
	}
	

	public boolean darBajaProducto(Producto bebidaOPlato) {
		boolean dadoBaja=false;
		if(obtenerPosicionProducto(bebidaOPlato.getCodigoProducto())!=-1) {
			cartaProducto[obtenerPosicionProducto(bebidaOPlato.getCodigoProducto())]=null;
			dadoBaja=true;
		}
		
		return dadoBaja;
	}
	

	private int obtenerPosicionCliente(String codigo) {
		int posicion=-1;
		for(int i=0; i<clientes.length && posicion==-1 ;i++) {
			if (clientes[i]!=null && clientes[i].getCodigoCliente().equals(codigo)) {
				posicion=i;
			}
		}
		return posicion;
	}
	

	private int obtenerPosicionProducto(String codigo) {
		int posicion=-1;
		for(int i=0; i<cartaProducto.length && posicion ==-1;i++) {
			if (cartaProducto[i].getCodigoProducto().equals(codigo)) {
				posicion=i;
			}
		}
		return posicion;
	}
	

	public boolean registrarProductoACliente(String codigoCliente, String codigoProducto ) throws ClienteNoExistenteException, ServicioNoDisponibleException {
		if (obtenerPosicionCliente(codigoCliente)!=-1) {
			if(obtenerPosicionProducto(codigoProducto)!=-1) {
				clientes[obtenerPosicionCliente(codigoProducto)].solicitarServicio(cartaProducto[obtenerPosicionProducto(codigoProducto)]);
				
			}else throw new ServicioNoDisponibleException("El producto no existe");
			
		}else throw new ClienteNoExistenteException("El cliente no existe");
		return false;
	}
	
	//ToDo
	public boolean registrarServicioACliente(Cliente cliente, Producto producto) {
		return false;
	}

	//ToDo
	public String obtenerProductosPorAlergenos() {
	
		Arrays.sort(cartaProducto, new ProductosAlergenosComparator());
		
		for(int i = 0; i<cartaProducto.length;i++) {
			//NO ME DIO TIEMPO
		}
		
		return cartaProducto.toString();
	
	}
	
	//ToDo
	public String obtenerClientesPorAlergiaEdad() { return "";}
	
	//ToDo: Subir nota
	public String obtenerClientesNoBebedores() { return "";}
	
	//ToDo: Subir nota
	public String obtenerClientesPorConsumo() { return "";}

	
	
}
