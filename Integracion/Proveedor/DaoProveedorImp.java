/**
 * 
 */
package Integracion.Proveedor;

import Negocio.Proveedor.TProveedor;
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
public class DaoProveedorImp implements DaoProveedor {
	
	private final String INSERT = "INSERT INTO proveedor(nombre, telefono, sede) VALUES(?, ?, ?)";
	private final String READALL = "SELECT * FROM proveedor" + " FOR UPDATE";
	private final String READBYID = "SELECT * FROM proveedor" + " WHERE id = ?" + " FOR UPDATE";
	private final String READBYNAME = "SELECT * FROM proveedor" + " WHERE nombre = ?" + " FOR UPDATE";
	private final String UPDATE = "UPDATE proveedor SET nombre = ?, telefono = ?, sede = ?, activo = ? WHERE id = ?";
	private final String DELETE = "UPDATE proveedor SET activo = 0 WHERE id = ?";
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProveedor#create(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int create(TProveedor proveedor) throws Exception {
		int idProveedor = -1;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
	
			ps = conexion.prepareStatement(INSERT);
			ps.setString(1, proveedor.getNombre());
			ps.setInt(2, proveedor.getTelefono());
			ps.setString(3, proveedor.getSede());
			
			if (ps.executeUpdate() == 1) { // si hay exito en la consulta
				ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
				if(rs.next()) {
					idProveedor = rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return idProveedor;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProveedor#read(int idProv)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProveedor read(int idProv) throws Exception {
		TProveedor proveedor = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
	
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYID);
			ps.setInt(1, idProv);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				proveedor = new TProveedor(rs.getInt(1),rs.getString(2),
						           rs.getInt(3), rs.getString(4), rs.getBoolean(5));
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return proveedor;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProveedor#update(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean update(TProveedor proveedor) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(UPDATE);
			ps.setString(1, proveedor.getNombre());
			ps.setInt(2, proveedor.getTelefono());
			ps.setString(3, proveedor.getSede());
			ps.setBoolean(4, proveedor.getActivo());
			ps.setInt(5, proveedor.getId());
			
			if (ps.executeUpdate() == 1)
				res = true;
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return res;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProveedor#delete(int idProveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean delete(int idProveedor) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(DELETE);
			ps.setInt(1, idProveedor);
			
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
	* @see DaoProveedor#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProveedor> readAll() throws Exception {
		ArrayList<TProveedor> listaProveedores = null;
		TProveedor proveedor = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READALL);
			ResultSet rs = ps.executeQuery();
			listaProveedores = new ArrayList<TProveedor>();
			
			while(rs.next()) {
				
				proveedor = new TProveedor(rs.getInt(1),rs.getString(2),
				           rs.getInt(3), rs.getString(4), rs.getBoolean(5));
				listaProveedores.add(proveedor);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) ps.close();
		}
		
		return listaProveedores;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoProveedor#readByName(String nombreProv)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProveedor readByName(String nombreProv) throws Exception {
		TProveedor proveedor = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYNAME);
			ps.setString(1, nombreProv);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				proveedor = new TProveedor(rs.getInt(1),rs.getString(2),
				           rs.getInt(3), rs.getString(4), rs.getBoolean(5));
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return proveedor;
	}
	
	// Para hacer pruebas solo
	public void deleteAll() throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		
		conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
		
		try {
			ps = conexion.prepareStatement("DELETE FROM proveedor");
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}
}