package main.java.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.model.exceptions.ArchivosException;
import main.java.model.exceptions.DepartamentoException;

public class Oficina {

	private static final String FORMATOSALIDA = ".csv";
	private Set<Departamento> departamentos;
	private String ubicacion;
	private String codigoOficina;
	
	public Oficina() {
		super();
	}
	
	public Oficina(String ubicacion, String codigoOficina) {
		this.ubicacion=ubicacion;
		this.codigoOficina=codigoOficina;
		departamentos=new HashSet<>();
	}
	
	
	public void addDepartamento(Departamento departamento) throws DepartamentoException {
		if(this.departamentos.contains(departamento)) {
			throw new DepartamentoException("Ese departamento ya existe.");
		}
		this.departamentos.add(departamento);
	}
	
	
	
	public Collection<String> obtenerEmpleadosConNombre(String nombre){
		Set<String> empleados = new HashSet<>();
		for(Departamento d: this.departamentos) {
			empleados.addAll(d.obtenerEmpleadosConNombre(nombre)) ;
		}
		return empleados;
	}
	
	
	public List<String> obtenerEmpleadosPorDepartamentoYRol(){
		List<String> empleadosPorDep = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(Departamento d: this.departamentos) {
			sb.append(d+"\n");
		}
		empleadosPorDep.add(sb.toString());
		return empleadosPorDep;
	}

	public void escribirDepartamentos(String rutaArchivo) throws ArchivosException {
		if(!rutaArchivo.endsWith(".csv")) {
			throw new ArchivosException("El formato no es correcto");
		}
		File archivo = new File(rutaArchivo);
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String linea = br.readLine();
			while(linea!=null) {
				String[] lineaSep = linea.split(",");
				Departamento d = new Departamento(lineaSep[0]);
				
				if(!this.departamentos.contains(d)) {
					this.departamentos.add(d);
				}
				if(this.departamentos.contains(d)) {
					Empleado e = new Empleado(lineaSep[1],lineaSep[2],lineaSep[3], Rol.valueOf(lineaSep[4]));
					d.addEmpleado(e);
				}
				
				linea=br.readLine();
			}
			br.close();
			fr.close();
		
		} catch (IOException | DepartamentoException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void guardarDepartamentos(String rutaArchivo) {
		File archivo = new File(rutaArchivo+"/"+this.codigoOficina+FORMATOSALIDA);
		try {
			archivo.createNewFile();
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("DEPARTAMENTO,NOMBRE_COMPLETO,CODIGO_EMP,FECHA_NACIMIENTO,ROL\n");
			for(Departamento d:this.departamentos) {
				for(Empleado e:d.getEmpleados()) {
					bw.append(String.format("%s,%s,%s,%s,%s", d.getCodigoDepartamento(), e.getNombreCompleto(), e.getCodigoEmpleado(), e.getFechaNacimiento(), e.getRol()));
					bw.newLine();
				}
			}
			
			bw.close();
			fw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Oficina cargarDesdeJSON(String path) {
		File archivo = new File(path);
		Gson gson = new GsonBuilder().create();
		Oficina o=null;
		
		try {
			FileReader fr = new FileReader(archivo);
			o = gson.fromJson(fr, Oficina.class);
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
		
	}
	
	public void toXML(Oficina o) {
		File archivo = new File("files/oficinaXML.xml");
		try {
			Document doc = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
			Element oficina = doc.createElement("Oficina");
			Attr ubicacion = doc.createAttribute("ubicacion");
			Attr codigo = doc.createAttribute("codigoOficina");
			codigo.setValue(o.codigoOficina);
			ubicacion.setValue(o.ubicacion);
			oficina.setAttributeNode(codigo);
			oficina.setAttributeNode(ubicacion);
			doc.appendChild(oficina);
			
			
			Element departamentos = doc.createElement("departamentos");
			for(Departamento d:o.departamentos) {
				Element codigoDepartamento = doc.createElement("codigoDepartamento");
				codigoDepartamento.setTextContent(d.getCodigoDepartamento());
				Element empleados = doc.createElement("Empleados");
				for(Empleado e:d.getEmpleados()) {
					
					Element empleado = doc.createElement("Empleado");
					Element nombreCompleto = doc.createElement("nombreCompleto");
					Element codigoEmpleado = doc.createElement("codigoEmpleado");
					Element fechaNacimiento = doc.createElement("fechaNacimiento");
					Element rol = doc.createElement("rol");
					nombreCompleto.setTextContent(e.getNombreCompleto());
					codigoEmpleado.setTextContent(e.getCodigoEmpleado());
					fechaNacimiento.setTextContent(e.getFechaNacimiento());
					rol.setTextContent(String.valueOf(e.getRol()));
					empleado.appendChild(nombreCompleto);
					empleado.appendChild(codigoEmpleado);
					empleado.appendChild(fechaNacimiento);
					empleado.appendChild(rol);
					empleados.appendChild(empleado);
				}
				departamentos.appendChild(empleados);
			}
			
			oficina.appendChild(departamentos);
			

			
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(doc), new StreamResult(archivo));
			
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

}
