/**
 * 
 */
package Negocio.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.ArrayList;
import Negocio.Empleado.Empleado;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Asociacion.Asociacion;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Local.Local.findByid", query = "select obj from Local obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Local.Local.findByversion", query = "select obj from Local obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Local.Local.findBydireccion", query = "select obj from Local obj where :direccion = obj.direccion "),
		@NamedQuery(name = "Negocio.Local.Local.findBycodigoPostal", query = "select obj from Local obj where :codigoPostal = obj.codigoPostal "),
		@NamedQuery(name = "Negocio.Local.Local.findByaforo", query = "select obj from Local obj where :aforo = obj.aforo "),
		@NamedQuery(name = "Negocio.Local.Local.findByactivo", query = "select obj from Local obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Local.Local.findBylistaEmpleados", query = "select obj from Local obj where :listaEmpleados MEMBER OF obj.listaEmpleados "),
		@NamedQuery(name = "Negocio.Local.Local.findBylistaAsociaciones", query = "select obj from Local obj where :listaAsociaciones MEMBER OF obj.listaAsociaciones ") })
public class Local implements Serializable {
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
	public Local() {
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** 
	* @return the id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getId() {
		return id;
	}

	/** 
	* @param id the id to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setId(int id) {
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
	private String direccion;

	/** 
	* @return the direccion
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public String getDireccion() {
		// begin-user-code
		return direccion;
		// end-user-code
	}

	/** 
	* @param direccion the direccion to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setDireccion(String direccion) {
		// begin-user-code
		this.direccion = direccion;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int codigoPostal;

	/** 
	* @return the codigoPostal
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getCodigoPostal() {
		// begin-user-code
		return codigoPostal;
		// end-user-code
	}

	/** 
	* @param codigoPostal the codigoPostal to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setCodigoPostal(int codigoPostal) {
		// begin-user-code
		this.codigoPostal = codigoPostal;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int aforo;

	/** 
	* @return the aforo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getAforo() {
		// begin-user-code
		return aforo;
		// end-user-code
	}

	/** 
	* @param aforo the aforo to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setAforo(int aforo) {
		// begin-user-code
		this.aforo = aforo;
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
	@OneToMany(mappedBy = "local")
	private ArrayList<Empleado> listaEmpleados;

	/** 
	* @return the listaEmpleados
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<Empleado> getListaEmpleados() {
		// begin-user-code
		return listaEmpleados;
		// end-user-code
	}

	/** 
	* @param listaEmpleados the listaEmpleados to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		// begin-user-code
		this.listaEmpleados = listaEmpleados;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "local")
	private ArrayList<Asociacion> listaAsociaciones;

	/** 
	* @return the listaAsociaciones
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<Asociacion> getListaAsociaciones() {
		// begin-user-code
		return listaAsociaciones;
		// end-user-code
	}

	/** 
	* @param listaAsociaciones the listaAsociaciones to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setListaAsociaciones(ArrayList<Asociacion> listaAsociaciones) {
		// begin-user-code
		this.listaAsociaciones = listaAsociaciones;
		// end-user-code
	}
}