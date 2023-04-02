package com.rec.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BackendProgrammer extends Candidate implements Backend {

	public BackendProgrammer() {
		super();
	}

	
	public BackendProgrammer(String dni, String name, String surname, LocalDate dateOfBirth, String ct) {
		super(dni, name, surname, dateOfBirth, ct);
	}



	@Override
	public Double createWebAPIAndDBConnectionCost() {
		return WEB_API_DB_COST;
	}

	@Override
	public Double maintenanceCost() {
		return BE_MAINTENANCE_COST;
	}

	@Override
	public Double computeGrossSalary() {
		Double totalSalario;
		if(isInProject()) {
			totalSalario=this.getCt().equals(ContractType.FULLTIME)?this.createWebAPIAndDBConnectionCost():
				this.createWebAPIAndDBConnectionCost()-(this.createWebAPIAndDBConnectionCost()*REDUCCION_PARCIAL);
		}else {
	
			totalSalario=this.getCt().equals(ContractType.FULLTIME)?this.maintenanceCost():
				this.maintenanceCost()-(this.maintenanceCost()*REDUCCION_PARCIAL);
		}
		
		totalSalario=totalSalario*1*((5*(ChronoUnit.YEARS.between(getStartDate(), LocalDate.now())))/100);
		
		return totalSalario;
	}

	@Override
	public String toString() {
		return String.format("%s", super.toString());
	}
	
	
}
