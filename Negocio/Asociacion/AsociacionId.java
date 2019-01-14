/**
 * 
 */
package Negocio.Asociacion;

import java.io.Serializable;
import javax.persistence.Embeddable;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
@Embeddable
public class AsociacionId implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static final long serialVersionUID = 0;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public AsociacionId() {
	}

	public AsociacionId(int idLocal, int idSeccion) {
		this.idLocal = idLocal;
		this.idSeccion = idSeccion;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int idLocal;

	/** 
	* @return the idLocal
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getIdLocal() {
		// begin-user-code
		return idLocal;
		// end-user-code
	}

	/** 
	* @param idLocal the idLocal to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setIdLocal(int idLocal) {
		// begin-user-code
		this.idLocal = idLocal;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int idSeccion;

	/** 
	* @return the idSeccion
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getIdSeccion() {
		// begin-user-code
		return idSeccion;
		// end-user-code
	}

	/** 
	* @param idSeccion the idSeccion to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setIdSeccion(int idSeccion) {
		// begin-user-code
		this.idSeccion = idSeccion;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AsociacionId))
			return false;
		AsociacionId pk = (AsociacionId) obj;
		if (!(idLocal == pk.idLocal))
			return false;
		if (!(idSeccion == pk.idSeccion))
			return false;
		return true;
	}


	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int hashCode() {
		int hashCode = 0;
		hashCode += idSeccion;
		hashCode += idLocal;
		return hashCode;
	}
}