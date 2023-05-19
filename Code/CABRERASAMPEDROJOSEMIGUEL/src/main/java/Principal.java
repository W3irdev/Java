package main.java;

import java.time.LocalDate;

import com.google.gson.GsonBuilder;

import main.java.model.Departamento;
import main.java.model.Empleado;
import main.java.model.Oficina;
import main.java.model.Rol;
import main.java.model.exceptions.ArchivosException;
import main.java.model.exceptions.DepartamentoException;

public class Principal {

	public static void main(String[] args) {
		try {
			Oficina ofi = cargarDatosMuestra();
			
		} catch (DepartamentoException e) {
			e.printStackTrace();
		}
	}
	
	//Este método crea una oficina con dos departamentos y 4 empleados cada uno: un jefe de departamento
	//un analista y dos programadores
	private static Oficina cargarDatosMuestra() throws DepartamentoException {
		Oficina oficina = new Oficina("Sevilla", "STI1");
		/*String[] nombres = {"Ernesto Echevarne", "Rodrigo Rodríguez", "Melania Maldívar", "Jacinto Jiménez", 
							"Gabino Gámez", "Lucrecia Lusa", "Carla Costa", "Fernanda Fernández"};
		int codigo = 1;
		LocalDate fechaBase = LocalDate.now().minusYears(40);
		for(int i =0; i<2; i++) {
			Departamento departamento = new Departamento("SEVDEPT_"+(i+1));
			
			departamento.addEmpleado(new Empleado(nombres[i*(nombres.length/2)], "SEVEMP_"+codigo++, fechaBase.plusYears(i*20).toString(), Rol.JEFE_DEPARTAMENTO));
			departamento.addEmpleado(new Empleado(nombres[i*(nombres.length/2)+1], "SEVEMP_"+codigo++, fechaBase.plusYears(i*20-6).toString(), Rol.ANALISTA));
			departamento.addEmpleado(new Empleado(nombres[i*(nombres.length/2)+2], "SEVEMP_"+codigo++, fechaBase.plusYears(i*20-10).toString(), Rol.PROGRAMADOR));
			departamento.addEmpleado(new Empleado(nombres[i*(nombres.length/2)+3], "SEVEMP_"+codigo++, fechaBase.plusYears(i*20-12).toString(), Rol.PROGRAMADOR));
			oficina.addDepartamento(departamento);
			
		}
		
		oficina.guardarDepartamentos("files");*/
		try {
			//oficina.escribirDepartamentos("files/STI1.csv");
			//oficina.cargarDesdeJSON("files/oficina.json");
			oficina.toXML(oficina.cargarDesdeJSON("files/oficina.json"));
			System.out.println(oficina);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return oficina;
	}

}





