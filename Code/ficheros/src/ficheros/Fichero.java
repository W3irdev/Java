package ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class Fichero {

	private String nombre;
	private String path;
	private long size;
	private String permisos;
	private boolean esDirectorio;
	private String extension;
	private String ficherosHijos;
	private String directoriosHijos;
	private FileTime fechaCreacion;
	private File file;
	
	public Fichero(String rutaAbsoluta) throws IOException {
		this.file=new File(rutaAbsoluta);
		if(!file.exists()) file.mkdir();
		BasicFileAttributes attrs;
		attrs=Files.readAttributes(file.toPath(), BasicFileAttributes.class);
		this.nombre=file.getName();
		if(file.exists())this.path=file.getAbsolutePath();
		this.size=file.length();
		this.permisos=getPermisos();
		this.extension=file.getName().substring(file.getName().lastIndexOf("."), file.getName().length()) ;
		this.esDirectorio=file.isDirectory();
		this.fechaCreacion=attrs.creationTime();
		this.ficherosHijos=getFicherosHijos();
		this.directoriosHijos=getDirectoriosHijos();
	
		
	}

	public String getPermisos() {
		StringBuilder sb = new StringBuilder();
		if(file.canWrite()) sb.append("Escritura ");
		if(file.canRead()) sb.append("Lectura ");
		if(file.canExecute()) {
			sb.append("Ejecucion ");
		}
		return sb.toString();
	}
	
	public String getFicherosHijos() {
		StringBuilder sb = new StringBuilder();
		for(File f:file.listFiles()) {
			if(!f.isDirectory()) sb.append(f.toString()+" ");
		}
		return sb.toString();
	}
	
	public String getDirectoriosHijos() {
		StringBuilder sb = new StringBuilder();
		for(File f:file.listFiles()) {
			if(f.isDirectory()) sb.append(f.toString()+" ");
		}
		return sb.toString();
	}


	@Override
	public String toString() {
		return String.format(
				"Fichero [nombre=%s, path=%s, size=%s, permisos=%s, esDirectorio=%s, extension=%s, ficherosHijos=%s, directoriosHijos=%s, fechaCreacion=%s]",
				nombre, path, size, permisos, esDirectorio, extension, ficherosHijos, directoriosHijos, fechaCreacion.toString());
	}
	
	
	
	
}
