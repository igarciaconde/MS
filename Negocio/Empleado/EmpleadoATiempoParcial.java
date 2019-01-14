/**
 * 
 */
package Negocio.Empleado;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

import Negocio.Local.Local;

import javax.persistence.NamedQueries;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
@Entity (name = "EmpleadoATiempoParcial")
@NamedQueries({
		@NamedQuery(name = "Negocio.Empleado.EmpleadoATiempoParcial.findByhoras", query = "select obj from EmpleadoATiempoParcial obj where :horas = obj.horas "),
		@NamedQuery(name = "Negocio.Empleado.EmpleadoATiempoParcial.findBysueldoPorHora", query = "select obj from EmpleadoATiempoParcial obj where :sueldoPorHora = obj.sueldoPorHora ") })
public class EmpleadoATiempoParcial extends Empleado implements Serializable {
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
	public EmpleadoATiempoParcial() {}
	
	public EmpleadoATiempoParcial(String dni, String nombre, String apellidos, boolean activo, Local local,
			int horas, double sueldoPorHora) {
		super(dni, nombre, apellidos, activo, local);
		this.horas = horas;
		this.sueldoPorHora = sueldoPorHora;	
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int horas;

	/** 
	* @return the horas
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getHoras() {
		// begin-user-code
		return horas;
		// end-user-code
	}

	/** 
	* @param horas the horas to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setHoras(int horas) {
		// begin-user-code
		this.horas = horas;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private double sueldoPorHora;

	/** 
	* @return the sueldoPorHoras
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public double getSueldoPorHora() {
		// begin-user-code
		return sueldoPorHora;
		// end-user-code
	}

	/** 
	* @param sueldoPorHoras the sueldoPorHoras to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSueldoPorHora(double sueldoPorHoras) {
		// begin-user-code
		this.sueldoPorHora = sueldoPorHoras;
		// end-user-code
	}

	@Override
	public double calcularNominaEmpleado() {
		// TODO Auto-generated method stub
		return sueldoPorHora * horas;
	}
}