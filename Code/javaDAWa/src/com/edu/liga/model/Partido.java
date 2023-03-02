package com.edu.liga.model;



public class Partido {

	private int jornada;
	private char quiniela;
	private Equipo local;
	private Equipo visitante;
	
	
	
	public Partido(Equipo local, Equipo visitante) {
		super();
		if(!local.equals(visitante)) {
			setJornada();
			this.local = local;
			this.visitante = visitante;
		}
		
	}

	
	public void ponerResultado(String resultado) {
		StringBuilder equipo1 = new StringBuilder();
		StringBuilder equipo2 = new StringBuilder();
		boolean error=false;
		boolean guion=false;
		try {
			for (int i=0; i<resultado.length()&&!error;i++) {
				if (!Character.isDigit(resultado.charAt(i))&&resultado.charAt(i)!='-') {
					error=true;
				}else if (resultado.charAt(i)=='-') {
					guion=true;
				}else {
					if(!guion) {
						equipo1.append(resultado.charAt(i));
					}else {
						equipo2.append(resultado.charAt(i));
					}
					
				}
				
			}
			this.local.setGoles(Integer.valueOf(equipo1.toString()));
			this.visitante.setGoles(Integer.valueOf(equipo2.toString()));
			
			if(local.getGoles()>visitante.getGoles()) {
				this.setQuiniela('1');
			}else if(local.getGoles()<visitante.getGoles()) {
				this.setQuiniela('2');
			}else {
				this.setQuiniela('X');
			}
		} catch (Exception e) {
			error=true;
			System.err.println("Debe introducir formato 1-2");
			throw e;
		}
	}

	private int getJornada() {
		return jornada;
	}


	private void setJornada() {
		if (this.jornada>0&&this.jornada<=24) {
			this.jornada++;
			}
	}


	public char getQuiniela() {
		return quiniela;
	}


	private void setQuiniela(char quiniela) {
		this.quiniela = quiniela;
	}


	@Override
	public String toString() {
		String mensaje= "Partido entre equipo local " + local.getNombre() + " y equipo visitante " + visitante.getNombre() + " todavía no se ha jugado";
		
		
		if ("1X2".indexOf(getQuiniela())!=-1) {
			
			mensaje="Partido entre equipo local "+ local.getNombre() + " y el equipo visitante "+ visitante.getNombre()+" jugado en el estadio "+ local.getEstadio()+
			" de la ciudad "+ local.getEstadio()+ " ha finalizado con " + local.getGoles()+ " goles de equipo local y " +visitante.getGoles()+ " goles de equipo visitante. "
			+ "Resultado quiniela = "+ getQuiniela();
			
		}
		
		return mensaje;
	}

	
	
}
