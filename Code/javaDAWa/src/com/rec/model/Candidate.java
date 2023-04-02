package com.rec.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Candidate implements Comparable<Candidate>{
	
	private LocalDate dateOfBirth;
	private LocalDateTime startDate;
	private String dni;
	private String name;
	private String surname;
	private ContractType ct;
	private boolean inProject;
	protected static final Double REDUCCION_PARCIAL=0.33;
	
	
	
	

	public Candidate() {
		super();
		this.startDate=LocalDateTime.now();
	}
	


	public Candidate(String dni, String name, String surname, LocalDate dateOfBirth, String ct) {
		super();
		setDni(dni);
		setName(name);
		setSurname(surname);
		setDateOfBirth(dateOfBirth);
		this.ct = ContractType.valueOf(ct);
		this.startDate=LocalDateTime.now();
		
	}



	public abstract Double computeGrossSalary();

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ContractType getCt() {
		return ct;
	}

	public void setCt(ContractType ct) {
		this.ct = ct;
	}

	public boolean isInProject() {
		return inProject;
	}

	public void setInProject(boolean inProject) {
		this.inProject = inProject;
	}

	@Override
	public int compareTo(Candidate o) {
		
		return this.dni.compareTo(o.dni);
	}



	@Override
	public String toString() {
		return String.format(
				"El empleado %s %s %s con dni %s nacido el %s empezo con nosotros el %s"
				+ " con un contrato a %s", getClass().getSimpleName(),name,
				surname, dni, dateOfBirth.toString(), startDate.toString(), ct.name());
	}
	
	

}
