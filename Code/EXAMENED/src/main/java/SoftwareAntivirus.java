package main.java;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoftwareAntivirus {
	
	
	private static final int TAMANNIO_MAX_CLAVE = 25;
	private LocalDate fechaAlta;
	private LocalDate fechaCaducidad;
	private List<String> licencias;
	private Random rnd = new Random();
	
	
	public SoftwareAntivirus(int cantidad, LocalDate fechaAlta) {
		super();
		this.fechaAlta=fechaAlta;
		this.fechaCaducidad=fechaAlta.plusYears(1);
		this.licencias = generarPaqueteDeCodigos(cantidad);
		
	}
	
	/**
	 * Indica si el producto está activo actualmente
	 * @return true si se encuentra activo
	 */
	public boolean esActivo() {
		//Refactorizacion del metodo, copiaba codigo de esActivoEnFecha, y se podia reutilizar.
		return esActivoEnFecha(LocalDate.now());
	}
	
	/**
	 * Indica si para la fecha facilitada el producto está activo
	 * @param fecha parámetro que contiene la fecha a comprobar
	 * @return true si se encuentra activo
	 */
	public boolean esActivoEnFecha(LocalDate fecha) {
		return fecha.isBefore(fechaCaducidad) && (fecha.isAfter(fechaAlta) || fecha.isEqual(fechaAlta));
	}
	
	/**
	 * Indica los días de licencia restante del producto para una fecha determinada si está activo
	 * @param fecha para la que se quiere conocer cuántos días de uso restan 
	 * @return días restantes a partir de una fecha
	 */
	public int calcularDiasRestantesEnFecha(LocalDate fecha) {
		// Refactorizacion, uso de esActivoEnFecha para realizar la misma comprobacion que antes.
		return esActivoEnFecha(fecha)?
				(int)ChronoUnit.DAYS.between(fecha, fechaCaducidad)		:0;
	}
	
	/**
	 * Informa de cuántas licencias se pueden otorgar
	 * @return número de licencias
	 */
	public int licenciasRestantes() {
		return this.licencias.size();
	}
	
	
	/**
	 * Devuelve un código de uso y reduce el número de licencias activas si aún están disponibles
	 * @return código de activación
	 * @throws Exception cuando no existen licencias restantes
	 */
	public String activarLicencia() throws LicenseException {
		String codigo = "";
		if(!this.licencias.isEmpty()) {
			codigo = this.licencias.remove(0);
		}else {
			throw new LicenseException("Ya se han activado todas las licencias.");
		}
		return codigo;
	}
	
	
	/**
	 * Genera una lista de códigos de activación del antivirus
	 * @param cantidad número de licencias a activar
	 * @return lista con los códigos generados
	 */
	protected List<String> generarPaqueteDeCodigos(int cantidad){
		List<String> codigosAleatorios=new ArrayList<>();
		for(int i=0; i<cantidad; i++) {
			codigosAleatorios.add(generarCodigoLicenciaDeUso());
		}
		return codigosAleatorios;
	}
	
	/**
	 * Crea un código formado por 25 caracteres alfanuméricos con letras en mayúsculas
	 * y números del 0 al 9 separados por <b>"-"</b> cada cinco caracteres
	 * @return código alfanumérico
	 */
	protected String generarCodigoLicenciaDeUso() {
		//Refactorizacion, extraccion del tamaño maximo de clave, al poder considerarse constante y cambio de valores a constantes.
		final String VALORES = "ABCDEFGHIJ0123456789";
		StringBuilder codigo = new StringBuilder();
		for(int i=0; i<25; i++) {
			codigo.append(VALORES.charAt(rnd.nextInt(VALORES.length()))) ;
			codigo.append(((i+1)%5==0 && (i+1)<TAMANNIO_MAX_CLAVE)?"-":"") ;
		}
		return codigo.toString();
	}

}
