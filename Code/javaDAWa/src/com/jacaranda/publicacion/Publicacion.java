package com.jacaranda.publicacion;

import java.time.LocalDateTime;

public class Publicacion implements Valorable{

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente=0;
	
	
	@Override
	public boolean valorar(String valoracion) {
		boolean valorado = false;
		if (Valoraciones.valueOf(valoracion) != null) {
			valorado = true;
			
			if (valoracion.equals("MUYBUENA")) {
				this.valoracion+=2;
			}else if (valoracion.equals("NORMAL")) {
				this.valoracion++;
			}else if (valoracion.equals("MUYMALA")){
				this.valoracion-=2;
				
			}
			
		}
		return valorado;
	}

}
	
