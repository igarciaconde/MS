/**
 * 
 */
package Integracion.Query;

import java.sql.Connection;
import java.util.HashMap;

import Integracion.Transacciones.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Negocio.Marca.TMarca;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Edu
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListarMarcasConNproveedores implements Query {
	
	private final String QUERY = "SELECT marca.id, marca.nombre, marca.pais, marca.activo, COUNT(DISTINCT idProveedor) AS Conteo FROM suministro "
			+ "JOIN producto ON suministro.idProducto=producto.id JOIN marca ON producto.idMarca=marca.id "
			+ "WHERE suministro.activo = 1 GROUP BY producto.idMarca HAVING Conteo > ?" + " FOR UPDATE";
	
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see Query#execute(Object param)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object execute(Object param) throws Exception {
		int N = (int) param;
		HashMap<TMarca, Integer> listaMarcas = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			ps = conexion.prepareStatement(QUERY);
			ps.setInt(1, N);
			
			ResultSet rs = ps.executeQuery();
			
			listaMarcas = new HashMap<TMarca,Integer> ();
			
			while(rs.next()) {
				TMarca marca = new TMarca(rs.getInt(1),rs.getString(2),
				           rs.getString(3),rs.getBoolean(4));
				listaMarcas.put(marca, rs.getInt(5));
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) { ps.close(); }
		}
		return listaMarcas;
	}
}