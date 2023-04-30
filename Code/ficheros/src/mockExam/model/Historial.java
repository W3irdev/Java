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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Historial {

	private Map<LocalDate,Combinacion> sorteos;
	private FileReader combinaciones;
	private Map<Integer, Integer> estadisticas;
	private File euromillones;

	public Historial() throws IOException {
		super();
		sorteos=new TreeMap<>();
		//No encuentro forma de ponerlo con ruta relativa.
		this.euromillones=new File("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Code\\ficheros\\src\\mockExam\\model\\Euromillones.csv");
		this.combinaciones=new FileReader(euromillones);
		this.estadisticas=estadisticas();
	}

	public Map<Integer,Integer> estadisticas() throws IOException {
		
		BufferedReader br = new BufferedReader(combinaciones);
		Map<Integer,Integer> numeros = new HashMap<>();
		String linea="";
		int numeroCapturado=0;
		boolean sigue=true;
		while(linea!=null) {
			
			String[] digitos = linea.split(",*,");
			for(String digito:digitos) {
				if(!digito.isBlank() && sigue) {
					try {
						numeroCapturado=Integer.valueOf(digito);
						if(numeros.containsKey(numeroCapturado)) {
							numeros.replace(numeroCapturado, numeros.get(numeroCapturado)+1);
						}else numeros.put(numeroCapturado, 0);
						
					} catch (NumberFormatException e) {
						sigue=true;
					}
					
				}
			}
			linea=br.readLine();
		}
		
		
		
		
		return numeros;
	}
	
	public int numeroMasRepetido() throws IOException {
		
		List<Integer> ordenado = new ArrayList<>(this.estadisticas.values()) ;
		Collections.sort(ordenado);
		Integer masRepe = ordenado.get(ordenado.size()-1);
		
		boolean encontrado=false;
		/*for(Integer i:mapa.keySet()) {
			if(!encontrado && mapa.get(i).equals(masRepe)) {
				encontrado = true;
				masRepe=i;
			}
		}*/
		
		for(int i=1;i<estadisticas.size() && !encontrado;i++) {
			if(estadisticas.get(i).equals(masRepe)) {
				encontrado = true;
				masRepe=i;
			}
		}
		
		return masRepe;
		
	}
	
	public int maximoAciertosEstadistico(Combinacion combinacion) throws IOException, CombinacionException {
		this.combinaciones=new FileReader(this.euromillones);
		BufferedReader br = new BufferedReader(combinaciones);
		String linea=br.readLine();
		int numeroCapturado=0;
		boolean sigue=true;
		int[] numeros=new int[7];
		int contador=0;
		Combinacion combi = null;
		int maximoAciertos=0;
		while(linea!=null) {
			String[] digitos = linea.split(",*,");
			contador=0;
			for(String digito:digitos) {
				if(!digito.isBlank() && sigue) {
					try {
						numeroCapturado=Integer.valueOf(digito);
						numeros[contador]=numeroCapturado;
						contador++;
					} catch (NumberFormatException e) {
						sigue=true;
					}
				}

				if(numeros[6]!=0) {
					
					combi=new Combinacion(numeros[0],numeros[1],numeros[2],numeros[3],numeros[4],numeros[5],numeros[6]);
					maximoAciertos = combinacion.comprobarCombinacion(combi)>maximoAciertos?combinacion.comprobarCombinacion(combi):maximoAciertos;
					
				}
				
			}
			linea=br.readLine();
		}
		
		return maximoAciertos;
	}
	
	public int maximoConsecutivos() throws IOException{
		this.combinaciones=new FileReader(this.euromillones);
		BufferedReader br = new BufferedReader(combinaciones);
		String linea=br.readLine();
		int numeroCapturado=0;
		boolean sigue=true;
		int[] numeros=new int[7];
		int contador=0;
		int consecutivos=0;
		int consecutivosAnterior=0;
		while(linea!=null) {
			String[] digitos = linea.split(",*,");
			contador=0;
			for(String digito:digitos) {
				if(!digito.isBlank() && sigue) {
					try {
						numeroCapturado=Integer.valueOf(digito);
						numeros[contador]=numeroCapturado;
						contador++;
					} catch (NumberFormatException e) {
						sigue=true;
					}
				}

				if(numeros[6]!=0) {
					for(int i=1; i<numeros.length;i++) {
						consecutivos=(numeros[i]==numeros[i-1]+1)?consecutivos+1:consecutivos;
					}
					consecutivosAnterior=consecutivos>consecutivosAnterior?consecutivos:consecutivosAnterior;
					consecutivos=0;
				}
				
			}
			linea=br.readLine();
		}
		
		return consecutivosAnterior;
	}
	
	public int numeroMenosRepetido() throws IOException {
		List<Integer> ordenado = new ArrayList<>(estadisticas.values()) ;
		Collections.sort(ordenado);
		Integer menosRepe = ordenado.get(0);
		boolean encontrado = false;
		for(int i=1;i<estadisticas.size() && !encontrado;i++) {
			if(estadisticas.get(i).equals(menosRepe)) {
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


