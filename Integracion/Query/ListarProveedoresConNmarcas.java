/**
 * 
 */
package Integracion.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import Integracion.Transacciones.TransactionManager;
import Negocio.Proveedor.TProveedor;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Edu
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListarProveedoresConNmarcas implements Query {
	
	private final String QUERY = "SELECT proveedor.id, proveedor.nombre, proveedor.telefono, proveedor.sede, proveedor.activo, COUNT(DISTINCT idMarca) AS Conteo FROM suministro "
			+ "JOIN producto ON suministro.idProducto=producto.id JOIN proveedor ON suministro.idProveedor=proveedor.id"
			+ " WHERE suministro.activo = 1 GROUP BY suministro.idProveedor HAVING Conteo > ?" + " FOR UPDATE";
	
	/** 
	* (non-Javadoc)
	 * @throws Exception 
	* @see Query#execute(Object param)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object execute(Object param) throws Exception {
		int N = (int) param;
		HashMap<TProveedor, Integer> listaProveedores = null;
		PreparedStatement ps = null;
		Connection conexion = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			ps = conexion.prepareStatement(QUERY);
			ps.setInt(1, N);
			
			ResultSet rs = ps.executeQuery();
			
			listaProveedores = new HashMap<TProveedor, Integer> ();
			
			while(rs.next()) {
				TProveedor proveedor = new TProveedor(rs.getInt(1),rs.getString(2),
				           rs.getInt(3), rs.getString(4), rs.getBoolean(5));
				
				listaProveedores.put(proveedor, rs.getInt(6));
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) { ps.close(); }
		}
		return listaProveedores;
	}
}