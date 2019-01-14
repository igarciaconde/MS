/**
 * 
 */
package Negocio.Empleado;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Edu
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TEmpleadoCompleto extends TEmpleado {
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
		// begin-user-code
		return sueldoMensual;
		// end-user-code
	}

	/** 
	* @param sueldoMensual the sueldoMensual to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSueldoMensual(double sueldoMensual) {
		// begin-user-code
		this.sueldoMensual = sueldoMensual;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoCompleto() {
	
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @param dni
	* @param nombre
	* @param apellidos
	* @param idLocal
	* @param sueldo
	* @param activo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoCompleto(int id, String dni, String nombre, String apellidos, int idLocal,
							 double sueldo, boolean activo) {
		super(id,dni,nombre,apellidos,idLocal,activo);
		this.sueldoMensual = sueldo;
	}
	
	public TEmpleadoCompleto(String dni, String nombre, String apellidos, int idLocal,
			 double sueldo, boolean activo) {
		super(dni,nombre,apellidos,idLocal,activo);
		this.sueldoMensual = sueldo;
	}
}