package com.rec.model;

import java.util.Comparator;

public class CandidatosExperienciaComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		int comparable=0;
		if(o1!=null && o2!=null) {
			comparable = o1.getStartDate().isBefore(o2.getStartDate())?1:-1;
		}else if(o1==null) {
			comparable = 1;
		}else if(o2==null) {
			comparable = -1;
		}
		
		return comparable;
	}



}
