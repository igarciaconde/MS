/**
 * 
 */
package Negocio.Producto;

import java.sql.Date;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TProductoAlimentacion extends TProducto {
	
	
	public TProductoAlimentacion() {
		
	}
	
	public TProductoAlimentacion(int id, int marca, String nombre, 
			int stock, String descripcion, boolean activo, Date fecha) {
		
		super(id, marca, nombre, stock, descripcion, activo);
		this.fechaCaducidad = fecha;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Date fechaCaducidad;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Date getFechaCaducidad() {
		
		return this.fechaCaducidad;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param fecha
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setFechaCaducidad(Date fecha) {
		
		this.fechaCaducidad = fecha;
	}
	
	@Override
	public String toString() {
		return "TProducto [id=" + this.getId() + ", marca=" + getMarca() + ", nombre=" + getNombre() + 
				", stock=" +getStock() + ", descripcion="
				+ getDescripcion() + ", activo=" + getActivo() + " fechaCaducidad=" + fechaCaducidad + "]";

	}

}