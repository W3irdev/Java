package com.rec;

import java.time.LocalDate;
import com.rec.model.BackendProgrammer;
import com.rec.model.Empresa;
import com.rec.model.FullStackDeveloper;

public class MainEmpresa {

	public static void main(String[] args) {

		Empresa e1 = new Empresa();
		
		
		try {
			FullStackDeveloper emple1 = new FullStackDeveloper("2502145C", "Jacinto", "Delas Pruebas", LocalDate.of(1992, 07, 20), "FULLTIME");
			
			BackendProgrammer emple2 = new BackendProgrammer("2502576C", "Prueba", "Delos Jacintos", LocalDate.of(1986, 03, 29), "PARTIAL");
			
			
			//System.out.println(emple1);
			//System.out.println(emple2);
			e1.darAlta(emple2);
			e1.darAlta(emple1);
			
			//System.out.println(e1.consultarInfo("2502145C"));
			
			//System.out.println(e1.ordenarPorExperiencia());
			System.out.println(e1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
