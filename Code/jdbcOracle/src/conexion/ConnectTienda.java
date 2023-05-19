package conexion;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.mysql.cj.xdevapi.Result;

public class ConnectTienda {
	private static String USER;
	private final static String DB_USER_KEY="db.user";

	private static String PASS;
	private final static String DB_PASS_KEY="db.pass";
	
	private static String JDBC_URL;
	private final static String DB_URL_KEY="db.url";
	
	private final static String PROPERTIES_URI = "resources/db.properties";
	private Connection connect;
	private Statement statement;
	private static String codigoPedido;
	private static int contador;
	

	/*
	 * Creamos objeto de conexion a base de datos, obteniendo los parametros del archivo db.properties.
	 */
	public ConnectTienda() throws SQLException {
		super();
		loadProperties();
		this.contador=0;
	}
	
	/**
	 * Genera un codigo de pedido.
	 * @return
	 * String con nuevo codigo de pedido.
	 */
	private String nextCodigoPedido() {
		LocalDate fecha = LocalDate.now();
		return this.codigoPedido=fecha.format(DateTimeFormatter.ofPattern("uuuuMMdd"))+String.valueOf(this.contador++);
	}
	
	/**
	 * Carga las propiedades de conexion de la base de datos.
	 * @return
	 *
	 */
	public void loadProperties() {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(PROPERTIES_URI));
			USER = properties.getProperty(DB_USER_KEY);
			PASS = properties.getProperty(DB_PASS_KEY);
			JDBC_URL = properties.getProperty(DB_URL_KEY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para abrir conexion a nuestra base de datos, en los metodos solicitados.
	 * @return
	 * Statement
	 */
	private Statement connect() {
		try {
			this.connect = DriverManager.getConnection(JDBC_URL, USER, PASS);
			//Creamos el objeto Statement
			Statement statement = connect.createStatement(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return statement;
	}
	
	/**
	 * Realiza una consulta de todos los clientes de nuestra base de datos
	 * @return
	 * String con todos los clientes.
	 */
	public String mostrarClientes() throws SQLException {
		StringBuilder sb = new StringBuilder();
		try {
			connect();  

			//Query de la consulta de datos.
			
			PreparedStatement ps = connect.prepareStatement("SELECT C.NOMBRE, C.APELLIDO, C.EMAIL, C.GENERO, YEAR(NOW())-YEAR(C.FECHANACIMIENTO) FROM Cliente C;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			sb.append(String.format("%s -- %s -- %s -- %s -- %s%n", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4) ));
			
		}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connect.close();
		}
	
		return sb.toString();
	}
	
	
	/**
	 * Realiza una consulta de todos los pedidos ordenados por precio descendente.
	 * @return
	 * String
	 */
	public String mostrarPedidosPorPrecio() throws SQLException {
		StringBuilder sb = new StringBuilder();
		try {
			connect();
			//Statement de la consulta a realizar.
			PreparedStatement ps = connect.prepareStatement("SELECT p.codigo , p.status , c.nombre , c.apellido , count(l.id), sum(l.precio) FROM Pedido p , Cliente c , Linea l WHERE p.id = l.idPedido and c.id = p.idCliente group by p.id  order by sum(l.precio) DESC ;");
			//Añadimos al StringBuilder el formato para mostrar.
			sb.append("Codigo -- Status -- Nombre Completo Cliente -- Num Productos -- Importe\n_______________________________________\n");
			ResultSet rs = ps.executeQuery();
			
			//Recorremos los datos obtenidos y recogidos en el ResultSet
			while(rs.next()) {
				sb.append(String.format("%s -- %s -- %s %s -- %s -- %s%n", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6) ));
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connect.close();
		}
	
		return sb.toString();
	}
	
	/**
	 * Realiza un DML INSERT para añadir un nuevo cliente a la base de datos.
	 * @return
	 * int 1 si realiza la inserción, 0 si no consigue insertar.
	 */
	public int addCliente (String nombre, String apellido, String email, String fechaNacimiento, String genero) throws SQLException {
		int insertado = 0;
		try {
			
			connect();
			
			//Statement de la consulta para añadir cliente.
			PreparedStatement ps = connect.prepareStatement("INSERT INTO Cliente (nombre,apellido,email,fechaNacimiento,genero)" + "VALUES (?,?,?,?,?)");
			
			//Seteamos los parametros de entrada en orden.
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, email);
			ps.setString(4, fechaNacimiento);
			ps.setString(5, genero);
			insertado = ps.executeUpdate();
			
			
			
			ps.close();
			
        } catch (SQLException e) {
        }finally {
			connect.close();
		}
		return insertado;
	}
	
	
	/**
	 * Realiza un DML DELETE para eliminar un cliente de la base de datos.
	 * @return
	 * int 1 si elimina, 0 si no consigue eliminar.
	 */
	public int delCliente(String nombre, String apellido) throws SQLException {
		int borrado =0;
		try {
			connect();
			
			PreparedStatement ps = connect.prepareStatement("DELETE from Cliente c WHERE c.nombre = ? and c.apellido = ? ;");
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			borrado = ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			connect.close();
		}
		return borrado;
	}
	
	/**
	 * Realiza un DML UPDATE para actualizar el email de un cliente de la base de datos.
	 * @return
	 * int 1 si actualiza, 0 si no consigue actualizar.
	 */
	public int actualizarCliente ( String nombre, String apellido, String emailAntiguo, String nuevoEmail) {
		int actualizado = 0;
		try {
			
			connect();
			PreparedStatement ps = connect.prepareStatement("UPDATE Cliente c SET c.email = ? where c.nombre = ? and c.apellido = ? and c.email = ?;");
			ps.setString(1, nuevoEmail);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setString(4, emailAntiguo);
			
			actualizado = ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actualizado;
	}
	
	/**
	 * Realiza un DML INSERT para insertar un pedido a la base de datos.
	 * @return
	 * int 1 si inserta, 0 si no consigue insertar.
	 */
	public int addPedido(String status, int idCliente) throws SQLException {
		int anadido=0;
		try {
			
			connect();
			PreparedStatement ps = connect.prepareStatement("INSERT INTO Pedido(codigo, status, idCliente) "
					+ "VALUES (?,?,?);");
			
			ps.setString(1, nextCodigoPedido());
			ps.setString(2, status);
			ps.setInt(3, idCliente);
			anadido= ps.executeUpdate();
		}catch (SQLException e) {
		} finally {
			connect.close();
		}
		return anadido;
	}

	/**
	 * Realiza un DML INSERT para insertar una linea a un pedido existente en estado PROCESANDO a la base de datos.
	 * @return
	 * int 1 si el pedido existe y consigue insertar, 0 si no consigue insertar.
	 */
	public int incluirLinea (int idPedido, String codigoProducto, String nombreProducto, int cantidad, double precio) throws Exception {
		int incluido = 0;
		int idPedidoObtenido=0;
		connect();
		PreparedStatement ps = connect.prepareStatement("select p.id from Pedido p where p.id = ? and p.status = 'PROCESANDO';");
		ps.setInt(1, idPedido);
		ResultSet rdo = ps.executeQuery();
		if(rdo.next()) {
			
			idPedidoObtenido=rdo.getInt(1);
		}
		ps.close();
	 ps = connect.prepareStatement("INSERT INTO Linea(codigo, nombreProducto, idPedido, cantidad, precio) VALUES (?,?,?,?,?);");
	ps.setString(1, codigoProducto);
	ps.setString(2, nombreProducto);
	ps.setInt(3, idPedidoObtenido);
	ps.setInt(4, cantidad);
	ps.setDouble(5, precio);
	incluido = ps.executeUpdate();
	ps.close();
	connect.close();
	
	return incluido;
	
}

}


