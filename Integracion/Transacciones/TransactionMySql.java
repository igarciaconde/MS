/**
 * 
 */
package Integracion.Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TransactionMySql implements Transaction {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Connection connection;
	
	//Si se cambia el username o password de la BBDD, hay que actualizar estos valores:
	private final String username = "root";
	private final String password = "root";
	private final String url = "jdbc:mysql://localhost:3306/fowlersfood?autoReconnect=true&useSSL=false";

	/*
	Servidor en el WampServer (meter BBDD en el servidor MySQL):
			private final String url = "jdbc:mysql://localhost:3306/fowlersfood?autoReconnect=true&useSSL=false";
	
	Servidor en el MariaDB:
			private final String url = "jdbc:mysql://localhost:3306/fowlersfood"
	*/
	/** 
	* (non-Javadoc)
	* @see Transaction#start()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void start() {
		
		try {
			
			connection = DriverManager.getConnection(url,username, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/** 
	* (non-Javadoc)
	* @see Transaction#commit()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void commit() {
		
		try {
			connection.commit();
		} catch (SQLException e) {
			System.err.println("No se han podido comprometer los cambios " + e.getMessage());
		}
		
		
	}

	/** 
	* (non-Javadoc)
	* @see Transaction#rollBack()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void rollBack() {
		
		try {
			connection.rollback();
		} catch (SQLException e) {
			System.err.println("No se han podido deshacer los cambios");
		}
		
	}
	
	/** 
	* (non-Javadoc)
	* @see Transaction#rollBack()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("No se han podido deshacer los cambios");
		}
	}

	/** 
	* (non-Javadoc)
	* @see Transaction#getResource()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object getResource() {
	
		return connection;
	}
}