/**
 * 
 */
package Integracion.Producto;

import Negocio.Producto.TProducto;
import Negocio.Producto.TProductoAlimentacion;
import Negocio.Producto.TProductoHogar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Integracion.Transacciones.TransactionManager;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class DaoProductoImp implements DaoProducto {
	
	// Insert
	private final String INSERT = "INSERT INTO producto(idMarca, nombre, stock, descripcion) VALUES(?, ?, ?, ?)";
	private final String INSERTALIMENTACION = "INSERT INTO productoalimentacion(id, fechaCaducidad) VALUES(?, ?)";
	private final String INSERTHOGAR = "INSERT INTO productohogar(id, toxico) VALUES(?, ?)";
	
	// Update
	private final String UPDATE = "UPDATE producto SET idMarca = ?, nombre = ?, stock = ?, descripcion = ?, activo = ? WHERE id = ?";
	private final String UPDATE_ALIMENTACION = "UPDATE productoalimentacion SET fechaCaducidad = ? WHERE id = ?";
	private final String UPDATE_HOGAR = "UPDATE productoHogar SET toxico = ? WHERE id = ?";
	
	
	// Read
	private final String READ_ALL = "SELECT * FROM producto LEFT JOIN productoalimentacion USING(id) LEFT JOIN productohogar USING(id)" + " FOR UPDATE";
	private final String READ_BY_ID =  "SELECT * FROM producto LEFT JOIN productoalimentacion USING(id) LEFT JOIN productohogar USING(id)" + " WHERE id = ?" + " FOR UPDATE";
	private final String READ_BY_NAME =  "SELECT * FROM producto LEFT JOIN productoalimentacion USING(id) LEFT JOIN productohogar USING(id)" + " WHERE nombre = ?" + " FOR UPDATE";
	private final String READ_BY_MARCA = "SELECT * FROM producto LEFT JOIN productoalimentacion USING(id) LEFT JOIN productohogar USING(id)" + " WHERE idMarca = ?"+ " FOR UPDATE";

	
	// Delete
	private final String DELETE = "UPDATE producto SET activo = 0 WHERE id = ?";
	

	
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#create(TProducto Producto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int create(TProducto producto) throws Exception {
		int idProducto = -1;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
	
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			// Insertamos un producto en la tabla producto
			ps = conexion.prepareStatement(INSERT);
			ps.setInt(1, producto.getMarca());
			ps.setString(2, producto.getNombre());
			ps.setInt(3, producto.getStock());
			ps.setString(4, producto.getDescripcion());
			
			
			if (ps.executeUpdate() == 1) { // si hay exito en la consulta
				
				ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
				
				if(rs.next()) {
					idProducto = rs.getInt(1);
					
					// cerramos la antigua consulta
					ps.close();
					
					// Insertar producto especifico
					if(producto instanceof TProductoAlimentacion) { // es alimentacion
						 ps = conexion.prepareStatement(INSERTALIMENTACION);
						 ps.setInt(1, idProducto);
						 ps.setDate(2, ((TProductoAlimentacion) producto).getFechaCaducidad());
						 
						 if (ps.executeUpdate() != 1) { // si no hay exito en la consulta
								idProducto = -1;
						 }
				
					}
					else if(producto instanceof TProductoHogar) { // es hogar
						 ps = conexion.prepareStatement(INSERTHOGAR);
						 ps.setInt(1, idProducto);
						 ps.setBoolean(2, ((TProductoHogar) producto).getToxico());
						 
						 if (ps.executeUpdate() != 1) { // si no hay exito en la consulta
								idProducto = -1;
						 }
					}
					
				}
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return idProducto;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#read(int idProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProducto read(int idProducto) throws Exception {
		TProducto producto = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			// leemos el producto en la tabla producto
			ps = conexion.prepareStatement(READ_BY_ID);
			ps.setInt(1, idProducto);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				// leemos el producto especifico
				if(rs.getString("toxico") == null) { // producto alimentacion
					
					producto = new TProductoAlimentacion(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getDate("fechaCaducidad"));
					
				}
				else { // producto del hogar
					
					producto = new TProductoHogar(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("toxico"));
						
				}
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
		
		return producto;	
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#update(TProducto producto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean update(TProducto producto) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean result = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
		
				
				
				
				// insertar producto especifico
				if(producto instanceof TProductoAlimentacion) { // es alimentacion
					 ps = conexion.prepareStatement(UPDATE_ALIMENTACION);
					 ps.setDate(1, ((TProductoAlimentacion) producto).getFechaCaducidad());
					 ps.setInt(2, producto.getId());
					 ps.executeUpdate();
					 if (ps.executeUpdate() == 1) { // si hay exito en la consulta
							result = true;
					 }
			
				}
				else if(producto instanceof TProductoHogar) { // es hogar
					 ps = conexion.prepareStatement(UPDATE_HOGAR);
					 ps.setBoolean(1, ((TProductoHogar) producto).getToxico());
					 ps.setInt(2, producto.getId());
					 ps.executeUpdate();
					 if (ps.executeUpdate() == 1) { // si hay exito en la consulta
							result = true;
					 }
				}
				// cerramos la antigua consulta
				ps.close();
				if(result) {
					// Actualizamos un producto en la tabla producto
					ps = conexion.prepareStatement(UPDATE);
					ps.setInt(1, producto.getMarca());
					ps.setString(2, producto.getNombre());
					ps.setInt(3, producto.getStock());
					ps.setString(4, producto.getDescripcion());
					ps.setBoolean(5, producto.getActivo());
					ps.setInt(6, producto.getId());
					
					
					if (ps.executeUpdate() == 1) { // si hay exito en la consulta
						result = true;
				}
				
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
		return result;
	
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#delete(int idProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean delete(int idProducto) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(DELETE);
			ps.setInt(1, idProducto);
			
			if (ps.executeUpdate() == 1)
				res = true;
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
		return res;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProducto> readAll() throws Exception {

		ArrayList<TProducto> listaProductos = null;
		TProducto producto = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READ_ALL);
			ResultSet rs = ps.executeQuery();
			listaProductos = new ArrayList<TProducto>();
			
			while(rs.next()) {
				
				// leemos el producto especifico
				if(rs.getString("toxico") == null) { // producto alimentacion
					
					producto = new TProductoAlimentacion(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getDate("fechaCaducidad"));
					
				}
				else { // producto del hogar
					
					producto = new TProductoHogar(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("toxico"));
						
				}
				
				listaProductos.add(producto);
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) ps.close();
		}
		
		return listaProductos;	
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#readByName(String nombreProd)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProducto readByName(String nombreProd) throws Exception {
		TProducto producto = null;
		PreparedStatement ps = null;
		Connection conexion = null;

		try {
		
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			// leemos el producto en la tabla producto
			ps = conexion.prepareStatement(READ_BY_NAME);
			ps.setString(1, nombreProd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				// leemos el producto especifico
				if(rs.getString("toxico") == null) { // producto alimentacion
					
					producto = new TProductoAlimentacion(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getDate("fechaCaducidad"));
					
				}
				else { // producto del hogar
					
					producto = new TProductoHogar(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("toxico"));
						
				}
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
		
		return producto;	
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProducto#readProductosByMarca(int idmarca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProducto> readProductosByMarca(int idmarca) throws Exception {
	
		ArrayList<TProducto> listaProductos = new ArrayList<TProducto>();
		TProducto producto = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READ_BY_MARCA);
			ps.setInt(1, idmarca);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				// leemos el producto especifico
				if(rs.getString("toxico") == null) { // producto alimentacion
					
					producto = new TProductoAlimentacion(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getDate("fechaCaducidad"));
					
				}
				else { // producto del hogar
					
					producto = new TProductoHogar(rs.getInt("id"), rs.getInt("idMarca"), rs.getString("nombre"),
					rs.getInt("stock"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("toxico"));
						
				}
				
				listaProductos.add(producto);
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) ps.close();
		}
		
		return listaProductos;		
		
	}
	
	
	// Para hacer pruebas solo
	public void deleteAll() throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
		
		try {
			ps = conexion.prepareStatement("DELETE FROM productoalimentacion");
			ps.executeUpdate();
			ps.close();
			ps = conexion.prepareStatement("DELETE FROM productohogar");
			ps.executeUpdate();
			ps.close();
			ps = conexion.prepareStatement("DELETE FROM producto");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}
}