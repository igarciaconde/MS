/**
 * 
 */
package Negocio.Asociacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.persistence.NamedQueries;
import Negocio.Local.Local;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import Negocio.Seccion.Seccion;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findByid", query = "select obj from Asociacion obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findByversion", query = "select obj from Asociacion obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findBymetrosCuadrados", query = "select obj from Asociacion obj where :metrosCuadrados = obj.metrosCuadrados "),
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findBylocal", query = "select obj from Asociacion obj where :local = obj.local "),
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findByactivo", query = "select obj from Asociacion obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Asociacion.Asociacion.findByseccion", query = "select obj from Asociacion obj where :seccion = obj.seccion ") })
public class Asociacion implements Serializable {
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
	public Asociacion() {
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@EmbeddedId @GeneratedValue(strategy = GenerationType.IDENTITY)
	private AsociacionId id;

	
	public Asociacion(int idLocal, int idSeccion) {
		id = new AsociacionId(idLocal, idSeccion);
	}

	/** 
	* @return the id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public AsociacionId getId() {
		return id;
	}

	/** 
	* @param id the id to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setId(AsociacionId id) {
		this.id = id;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Version
	private int version;

	/** 
	* @return the version
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getVersion() {
		// begin-user-code
		return version;
		// end-user-code
	}

	/** 
	* @param version the version to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setVersion(int version) {
		// begin-user-code
		this.version = version;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int metrosCuadrados;

	/** 
	* @return the metrosCuadrados
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getMetrosCuadrados() {
		// begin-user-code
		return metrosCuadrados;
		// end-user-code
	}

	/** 
	* @param metrosCuadrados the metrosCuadrados to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setMetrosCuadrados(int metrosCuadrados) {
		// begin-user-code
		this.metrosCuadrados = metrosCuadrados;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	@MapsId("idLocal")
	private Local local;

	/** 
	* @return the local
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Local getLocal() {
		// begin-user-code
		return local;
		// end-user-code
	}

	/** 
	* @param local the local to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setLocal(Local local) {
		// begin-user-code
		this.local = local;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private boolean activo;

	/** 
	* @return the activo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean isActivo() {
		// begin-user-code
		return activo;
		// end-user-code
	}

	/** 
	* @param activo the activo to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setActivo(boolean activo) {
		// begin-user-code
		this.activo = activo;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	@MapsId("idSeccion") 
	private Seccion seccion;

	/** 
	* @return the seccion
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Seccion getSeccion() {
		// begin-user-code
		return seccion;
		// end-user-code
	}

	/** 
	* @param seccion the seccion to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSeccion(Seccion seccion) {
		// begin-user-code
		this.seccion = seccion;
		// end-user-code
	}
}