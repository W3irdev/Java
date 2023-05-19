package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class TemporadasNumCapitulosComparator implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		int comparador =0;
		if(o1!=null && o2!=null) {
			comparador = o1.getNumCapitulos()-o2.getNumCapitulos();
		}else if(o1==null) {
			comparador = 1;
		}else {
			comparador =-1;
		}
		
		return comparador;
	}

}
