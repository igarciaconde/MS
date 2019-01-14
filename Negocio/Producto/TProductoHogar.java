/**
 * 
 */
package Negocio.Producto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Edu
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TProductoHogar extends TProducto {
	
	public TProductoHogar() {
		
	}
	
	public TProductoHogar(int id, int marca, String nombre, int stock, 
			String descripcion, boolean activo, boolean toxico) {
		
		super(id, marca, nombre, stock, descripcion, activo);
		this.toxico = toxico;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private boolean toxico;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean getToxico() {
		return this.toxico;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setToxico(boolean toxico) {
		this.toxico = toxico;
	}
	
	@Override
	public String toString() {
		return "TProducto [id=" + this.getId() + ", marca=" + getMarca() + ", nombre=" + getNombre() + 
				", stock=" +getStock() + ", descripcion="
				+ getDescripcion() + ", activo=" + getActivo() + " toxico=" + toxico + "]";
	}

}