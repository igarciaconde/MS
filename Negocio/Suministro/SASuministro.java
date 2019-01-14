/**
 * 
 */
package Negocio.Suministro;

import java.util.ArrayList;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SASuministro {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param suministro
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean altaSuministro(TSuministro suministro);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param suministro
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaSuministro(TSuministro suministro);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param suministro
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarSuministro(TSuministro suministro);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param suministro
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TSuministroCompleto mostrarSuministro(TSuministro suministro);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TSuministro> listarSuministros();
}