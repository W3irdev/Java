package com.edu.dateUtils;

import com.edu.dateUtils.model.Fecha;

public class MainDate {

	public static void main(String[] args) {
		Fecha f = new Fecha(30,1,2001);
		
		try {
			System.out.println(f.formatDate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
