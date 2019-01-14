/**
 * 
 */
package Negocio.Empleado;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

import Negocio.Local.Local;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
@Entity
@NamedQuery(name = "Negocio.Empleado.EmpleadoATiempoCompleto.findBysueldoMensual", query = "select obj from EmpleadoATiempoCompleto obj where :sueldoMensual = obj.sueldoMensual ")
public class EmpleadoATiempoCompleto extends Empleado implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static final long serialVersionUID = 0;
	
	
	public EmpleadoATiempoCompleto(String dni, String nombre, String apellidos, boolean activo, Local local, double sueldo) {
		super(dni, nombre, apellidos, activo, local);
		this.sueldoMensual = sueldo;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public EmpleadoATiempoCompleto() {}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private double sueldoMensual;
	
	/** 
	* @return the sueldoMensual
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public double getSueldoMensual() {
		return sueldoMensual;
	}

	/** 
	* @param sueldoMensual the sueldoMensual to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	@Override
	public double calcularNominaEmpleado() {
		return sueldoMensual;
	}
}