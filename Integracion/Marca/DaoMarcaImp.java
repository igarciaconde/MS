/**
 * 
 */
package Integracion.Marca;

import Negocio.Marca.TMarca;

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
public class DaoMarcaImp implements DaoMarca {
	
	
	private final String INSERT = "INSERT INTO marca(nombre, pais) VALUES(?, ?)";
	private final String READALL = "SELECT * FROM marca" + " FOR UPDATE";
	private final String READBYID = "SELECT * FROM marca" + " WHERE id = ?" + " FOR UPDATE";
	private final String READBYNAME = "SELECT * FROM marca" + " WHERE nombre = ?" + " FOR UPDATE";
	private final String UPDATE = "UPDATE marca SET nombre = ?, pais = ?, activo = ? WHERE id = ?";
	private final String DELETE = "UPDATE marca SET activo = 0 WHERE id = ?";
	
	
	
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoMarca#create(TMarca tmarca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int create(TMarca tmarca) throws Exception {
		int idMarca = -1;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {

			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(INSERT);
			ps.setString(1, tmarca.getNombre());
			ps.setString(2, tmarca.getPais());
			
			if (ps.executeUpdate() == 1) { // si hay exito en la consulta
				ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
				if(rs.next()) {
					idMarca = rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return idMarca;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoMarca#read(int id)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMarca read(int id) throws Exception {
		
		TMarca marca = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				marca = new TMarca(rs.getInt(1),rs.getString(2),
						           rs.getString(3),rs.getBoolean(4));
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return marca;
	
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoMarca#update(TMarca tmarca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean update(TMarca tmarca) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(UPDATE);
			ps.setString(1, tmarca.getNombre());
			ps.setString(2, tmarca.getPais());
			ps.setBoolean(3, tmarca.getActivo());
			ps.setInt(4, tmarca.getId());
			
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
	* @see DaoMarca#delete(int id)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean delete(int id) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(DELETE);
			ps.setInt(1, id);
			
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
	* @see DaoMarca#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TMarca> readAll() throws Exception {
		ArrayList<TMarca> listaMarcas = null;
		TMarca marca = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READALL);
			ResultSet rs = ps.executeQuery();
			listaMarcas = new ArrayList<TMarca>();
			
			while(rs.next()) {
				
				marca = new TMarca(rs.getInt(1),rs.getString(2),
						           rs.getString(3),rs.getBoolean(4));
				listaMarcas.add(marca);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) ps.close();
		}
		return listaMarcas;
	}

	/** 
	* (non-Javadoc)
	* @see DaoMarca#readByName(String name)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMarca readByName(String name) throws Exception {
		TMarca marca = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYNAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				marca = new TMarca(rs.getInt(1),rs.getString(2),
						           rs.getString(3),rs.getBoolean(4));
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return marca;
	}
	
	// Para hacer pruebas solo
	public void deleteAll() throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
		
		try {
			ps = conexion.prepareStatement("DELETE FROM marca");
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	
	
}