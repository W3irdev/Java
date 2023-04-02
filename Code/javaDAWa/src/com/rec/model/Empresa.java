package com.rec.model;

import java.util.Arrays;

public class Empresa {

	private static final int NUM_MAXIMO_EMPLEADOS=11;
	private Candidate[] empresa;
	private int numEmpleado;
	
	public Empresa() {
		empresa=new Candidate[NUM_MAXIMO_EMPLEADOS];
	}

	
	public void darAlta(Candidate c) throws Exception {
		
		if(numEmpleado<NUM_MAXIMO_EMPLEADOS) {
			
			if(c instanceof WebDesigner fe) {
				empresa[numEmpleado++]=fe;
			}else if(c instanceof BackendProgrammer be) {
				empresa[numEmpleado++]=be;
			}else if(c instanceof FullStackDeveloper fs) {
				empresa[numEmpleado++]=fs;
			}
		}else throw new Exception("La empresa ha llegado a su limite de empleados");
		
	}
	
	public String consultarInfo(String dni) {
		String mensaje="No existe ese empleado";
		for (Candidate candidate : empresa) {
			if(candidate!=null && candidate.getDni().equalsIgnoreCase(dni)) {
				mensaje=candidate.toString();
			}
		}
		return mensaje;
		
	}
	
	public String ordenarPorExperiencia() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(empresa, new CandidatosExperienciaComparator());
		
		for(Candidate c:empresa) {
			if(c!=null) {
				sb.append(c.toString()+ "\n");
			}
		}
		return sb.toString();
	}


	@Override
	public String toString() {
		return String.format("%s", ordenarPorExperiencia());
	}
	
	
	
}
