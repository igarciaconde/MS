/**
 * 
 */
package Integracion.Suministro;

import Negocio.Suministro.TSuministro;

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
public class DaoSuministroImp implements DaoSuministro {
	
	private final String INSERT = "INSERT INTO suministro(idProveedor, idProducto, precio) VALUES(?, ?, ?)";
	private final String READALL = "SELECT * FROM suministro" + " FOR UPDATE";
	private final String READBYID = "SELECT * FROM suministro" + " WHERE idProducto = ? AND idProveedor = ?" + " FOR UPDATE";
	private final String READBYPRODUCTO = "SELECT * FROM suministro" + " WHERE idProducto = ?" + " FOR UPDATE";
	private final String READBYPROVEEDOR = "SELECT * FROM suministro" + " WHERE idProveedor = ?" + " FOR UPDATE";
	private final String UPDATE = "UPDATE suministro SET precio = ?, activo = ? WHERE idProducto = ? AND idProveedor = ?";
	private final String DELETE = "UPDATE suministro SET activo = 0 WHERE idProducto = ? AND idProveedor = ?";
	
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoSuministro#create(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean create(TSuministro suministro) throws Exception {
		boolean exito = false;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(INSERT);
			ps.setInt(1, suministro.getIdProveedor());
			ps.setInt(2, suministro.getIdProducto());
			ps.setInt(3, suministro.getPrecio());
			
			if (ps.executeUpdate() == 1) { // si hay exito en la consulta
				exito = true;
			}
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return exito;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoSuministro#read(int producto, int proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TSuministro read(int proveedor, int producto) throws Exception {
		TSuministro suministro = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYID);
			ps.setInt(1, producto);
			ps.setInt(2, proveedor);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				suministro = new TSuministro(rs.getInt(1),rs.getInt(2),
						           rs.getInt(3),rs.getBoolean(4));
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return suministro;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoSuministro#update(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean update(TSuministro suministro) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(UPDATE);
			ps.setInt(1, suministro.getPrecio());
			ps.setBoolean(2, suministro.getActivo());
			ps.setInt(3, suministro.getIdProducto());
			ps.setInt(4, suministro.getIdProveedor());
			
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
	* @see DaoSuministro#delete(int producto, int proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean delete(int proveedor, int producto) throws Exception {
		PreparedStatement ps = null;
		Connection conexion = null;
		boolean res = false;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(DELETE);
			ps.setInt(1, producto);
			ps.setInt(2, proveedor);
			
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
	* @see DaoSuministro#readAll()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TSuministro> readAll() throws Exception {
		ArrayList<TSuministro> listaSuministros = null;
		TSuministro suministro = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READALL);
			ResultSet rs = ps.executeQuery();
			listaSuministros = new ArrayList<TSuministro>();
			
			while(rs.next()) {
				
				suministro = new TSuministro(rs.getInt(1),rs.getInt(2),
						           rs.getInt(3),rs.getBoolean(4));
				listaSuministros.add(suministro);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) ps.close();
		}
		return listaSuministros;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoSuministro#readSuministrosByIdProducto(int idProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TSuministro> readSuministrosByIdProducto(int idProducto) throws Exception {
		ArrayList<TSuministro> listaSuministro = new ArrayList<TSuministro>();
		TSuministro suministro;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			ps = conexion.prepareStatement(READBYPRODUCTO);
			ps.setInt(1, idProducto);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				suministro = new TSuministro(rs.getInt(1),rs.getInt(2),
						           rs.getInt(3),rs.getBoolean(4));
				
				listaSuministro.add(suministro);
			}
			
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			if(ps != null) { ps.close(); }
		}
	
		return listaSuministro;
	}

	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see DaoSuministro#readSuministrosByIdProveedor(int IdProveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TSuministro> readSuministrosByIdProveedor(int IdProveedor) throws Exception {
			ArrayList<TSuministro> listaSuministro = new ArrayList<TSuministro>();
			TSuministro suministro;
			PreparedStatement ps = null;
			Connection conexion = null;
			
			try {
				
				conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
				
				ps = conexion.prepareStatement(READBYPROVEEDOR);
				ps.setInt(1, IdProveedor);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					suministro = new TSuministro(rs.getInt(1),rs.getInt(2),
							           rs.getInt(3),rs.getBoolean(4));
					
					listaSuministro.add(suministro);
				}
				
				
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
			finally {
				if(ps != null) { ps.close(); }
			}
		
			return listaSuministro;
	}
	
	// Para hacer pruebas solo
		public void deleteAll() throws Exception {
			PreparedStatement ps = null;
			Connection conexion = null;
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			try {
				ps = conexion.prepareStatement("DELETE FROM suministro");
				ps.executeUpdate();
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		}
			
}