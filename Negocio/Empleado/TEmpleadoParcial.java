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
public class TEmpleadoParcial extends TEmpleado {
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
	* @return the sueldoPorHora
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public double getSueldoPorHora() {
		// begin-user-code
		return sueldoPorHora;
		// end-user-code
	}

	/** 
	* @param sueldoPorHora the sueldoPorHora to set
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setSueldoPorHora(double sueldoPorHora) {
		// begin-user-code
		this.sueldoPorHora = sueldoPorHora;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoParcial() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @param dni
	* @param nombre
	* @param apellidos
	* @param idLocal
	* @param activo
	* @param horas
	* @param sueldo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoParcial(int id, String dni, String nombre, String apellidos, int idLocal, boolean activo,
							int horas, double sueldo) {
		
		super(id, dni, nombre, apellidos, idLocal, activo);
		this.horas = horas;
		this.sueldoPorHora = sueldo;
	}
	
	public TEmpleadoParcial(String dni, String nombre, String apellidos, int idLocal, boolean activo,
			int horas, double sueldo) {

			super(dni, nombre, apellidos, idLocal, activo);
			this.horas = horas;
			this.sueldoPorHora = sueldo;
		}
}