/**
 * 
 */
package Integracion.Transacciones;

import java.util.concurrent.ConcurrentHashMap;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TransactionManagerImp extends TransactionManager {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	private ConcurrentHashMap<Thread, Transaction> mapaTransacciones = new ConcurrentHashMap<Thread, Transaction>();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	 * @throws Exception 
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void nuevaTransaccion() throws Exception{

		if (mapaTransacciones != null) {
			Thread currentThread = Thread.currentThread();
			Transaction currentTransaction = mapaTransacciones.get(currentThread);

			if (currentTransaction == null) {
				currentTransaction = TransactionFactory.getInstance().createTransaction();
				mapaTransacciones.put(currentThread, currentTransaction);
			}
			else
				throw new Exception("No se ha podido iniciar la transaccion");
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Transaction getTransaction() {
		return mapaTransacciones.get(Thread.currentThread());
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void eliminaTransaccion() {
		Transaction t = mapaTransacciones.remove(Thread.currentThread());
		t.closeConnection();
	}
	
}