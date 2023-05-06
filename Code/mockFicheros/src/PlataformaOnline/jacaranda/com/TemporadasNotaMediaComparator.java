package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class TemporadasNotaMediaComparator implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		int orden = 0;
		if(o1!=null && o2!=null) {
			orden=(int) (o2.getNotaMedia()-o1.getNotaMedia());
		}else if(o1==null) {
			orden=1;
		}else orden=-1;
		return orden;
	}


}
