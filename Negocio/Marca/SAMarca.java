/**
 * 
 */
package Negocio.Marca;

import java.util.ArrayList;
import java.util.HashMap;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SAMarca {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param marca
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaMarca(TMarca marca);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param marca
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarMarca(TMarca marca);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param marca
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMarca mostrarMarca(TMarca marca);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param marca
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaMarca(TMarca marca);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TMarca> listarMarcas();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param n
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public HashMap<TMarca,Integer> mostrarMarcasConMasDeNProveedores(int n);
}