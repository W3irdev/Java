package mockExam.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Historial {

	private Map<LocalDate,Combinacion> sorteos;
	private FileReader combinaciones;
	private Map<LocalDate, Combinacion> estadisticas;
	private File euromillones;

	public Historial() throws IOException, CombinacionException {
		super();
		sorteos=new TreeMap<>();
		
		
	}
	public Historial(String uri) throws IOException, CombinacionException {
		this();
		this.euromillones=new File(uri);
		this.combinaciones=new FileReader(euromillones);
		this.estadisticas=estadisticas();
		
	}

	public Map<LocalDate,Combinacion> estadisticas() throws IOException, CombinacionException {
		//Remodelado, pasamos de archivo a mapa.
		BufferedReader br = new BufferedReader(combinaciones);
		Map<LocalDate,Combinacion> numeros = new HashMap<>();
		br.readLine();
		String linea=br.readLine();
		int[] combinacion = new int[7];
		boolean sigue=true;
		LocalDate fecha = null;
		while(linea!=null) {
			String[] digitos = linea.split(",*,");
			int contador=0;
			for(String digito:digitos) {
				if(!digito.isBlank() && sigue) {
					if(digito.length()>2) {
						fecha = LocalDate.parse(digito, DateTimeFormatter.ofPattern("d/MM/yyyy"));
					}else {
						combinacion[contador]=Integer.parseInt(digito);
						contador++;
					}
					
				}
				}
			if(fecha!=null && !numeros.containsKey(fecha)) {
				numeros.put(fecha, new Combinacion(combinacion[0], combinacion[1], combinacion[2], combinacion[3], combinacion[4], combinacion[5], combinacion[6]));
			}
			linea=br.readLine();
		}
		
		return numeros;
	}
	
	private Map<Integer, Integer> repetidos(){
		Combinacion comb;
		Set<Combinacion> toList = new HashSet<>(this.estadisticas.values());
		List<Integer> total = new ArrayList<>();
		Map<Integer,Integer> repeticiones = new HashMap<>();
		Iterator<Combinacion> it = toList.iterator();
		while(it.hasNext()) {
			comb=it.next();
			total.addAll(comb.getNumeros());
			total.addAll(comb.getEstrellas());
		}
		
		for(Integer i:total) {
			if(!repeticiones.containsKey(i)) {
				repeticiones.put(i, 0);
			}
			repeticiones.replace(i, repeticiones.get(i)+1);
		}
		return repeticiones;
	}
	
	public int numeroMasRepetido() {
		//Remodelado, pasar de mapa a int.
		boolean encontrado = false;
		List<Integer> vecesRepetidas = new ArrayList<>(repetidos().values());
		Collections.sort(vecesRepetidas);
		
		Integer masRepe = vecesRepetidas.get(vecesRepetidas.size()-1);
		
		for(int i=1;i<vecesRepetidas.size() && !encontrado;i++) {
			if(repetidos().get(i).equals(masRepe)) {
				encontrado = true;
				masRepe=i;
			}
		}
		
		return masRepe;
		
	}
	
	public int maximoAciertosEstadistico(Combinacion combinacion) throws CombinacionException {
		int maximo=0;
		Set<Combinacion> combinaciones = new HashSet<>(this.estadisticas.values());
		
		for(Combinacion combi:combinaciones) {
			maximo=combinacion.comprobarCombinacion(combi)>maximo?combinacion.comprobarCombinacion(combi):maximo;
		}
		
		
		return maximo;
	}
	
	public int maximoConsecutivos(){
		int consecutivosAnterior=0;
		
		Set<Combinacion> combinaciones = new HashSet<>(this.estadisticas.values());
		List<Integer> linea = new ArrayList<>();
		for(Combinacion combi:combinaciones) {
			int contador=0;
			int anterior=-1;
			linea.clear();
			linea.addAll(combi.getNumeros());
			linea.addAll(combi.getEstrellas());
			for(int i:linea) {
				if(i==anterior+1) {
					contador++;
				}
				anterior=i;
			}
			consecutivosAnterior=contador>consecutivosAnterior?contador:consecutivosAnterior;
		}
		return consecutivosAnterior;
	}
	
	public int numeroMenosRepetido(){
		//Remodelado, pasar de mapa a int.
		boolean encontrado = false;
		List<Integer> vecesRepetidas = new ArrayList<>(repetidos().values());
	
		Integer menosRepe = vecesRepetidas.get(0);
		
		for(int i=1;i<vecesRepetidas.size() && !encontrado;i++) {
			if(repetidos().get(i).equals(menosRepe)) {
				encontrado = true;
				menosRepe=i;
			}
		}
		
		return menosRepe;
		
	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion sorteo) throws HistorialException {
		boolean guardado = false;
		if(fecha!=null && sorteo!=null && !sorteos.containsKey(fecha)) {
			sorteos.put(fecha, sorteo);
			guardado = true;
		}else throw new HistorialException("Ese sorteo existe, o los datos no son correcto");
		return guardado;
	}
	
	public boolean addSorteo(int dia, int mes, int anno, Combinacion sorteo) throws HistorialException {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		return addSorteo(fecha, sorteo);
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion sorteo) {
		return sorteos.replace(fecha, sorteo)!=null;
	}
	
	public boolean actualizarSorteo(int dia, int mes, int anno, Combinacion sorteo) {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		return actualizarSorteo(fecha, sorteo);
	}
	
	public boolean borrarSorteo(LocalDate fecha) {
		
		return sorteos.remove(fecha)!=null;
	}
	
	public List<String> listarSorteosDesdeFecha(LocalDate fecha){
		List<String> listado = new ArrayList<>();
		
		for (LocalDate d : sorteos.keySet()) {
			if(fecha==null || d.isAfter(fecha)) {
				listado.add(sorteos.get(d).toString());
			}
		}
		return listado;
		}
	
	public List<String> mostrarHistorico(){
		/*List<String> listado = new ArrayList<>();
		for(LocalDate d : sorteos.keySet()) {
			listado.add(sorteos.get(d).toString());
		}

		return listado;*/
		return listarSorteosDesdeFecha(null);
		
	}

	
	/*public List mostrarHistorico () {

        Set <Map.Entry <LocalDate, Combinacion>> histSorteos = sorteos.entrySet();
        List <Map.Entry<LocalDate, Combinacion>> historico = new ArrayList<>(histSorteos);

        return historico;
    }*/
	
	public Map<String,Integer> comprobarAciertos(LocalDate fecha, Combinacion numeros) throws HistorialException{
		Map<String,Integer> aciertos = new HashMap<>();
		
		if(fecha!=null && numeros!=null && sorteos.containsKey(fecha)) {
			aciertos.put(fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), sorteos.get(fecha).comprobarCombinacion(numeros));
			
		}else throw new HistorialException("El sorteo no se ha celebrado");
		return aciertos;
	}
	
}


