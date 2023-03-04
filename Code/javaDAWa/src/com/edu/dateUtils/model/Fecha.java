package com.edu.dateUtils.model;

public class Fecha {
	
	private static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
			"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	
	private int day;
	private int month;
	private int year;
	private Exception mensaje = new Exception("Fecha incorrecta");
	
	
	
	
	public Fecha(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String formatDate() throws Exception {
		
		boolean bisiesto = (year%4==0&&(year%100!=0||year%400==0));
		
		
		if((bisiesto&&this.month==2&&this.day>29)||this.month<1||this.month>12||this.day>31||this.day<1
				||(!bisiesto&&this.month==2&&this.day>28)) {
			
			throw this.mensaje;
		}else {
			
			return "La fecha en formato largo es " + String.valueOf(getDay()) +" de "+ getMonthLargo()+" de "+ getYear() ;
			
		}
		
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonthLargo() {
		return MONTHS[month-1];
	}

	public void setMonth(int month) {
		this.month = month;
	}

	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	
}
