/**
 * 
 */
package Negocio.FactoriaSA;

import Negocio.Producto.SAProducto;
import Negocio.Producto.SAProductoImp;
import Negocio.Proveedor.SAProveedor;
import Negocio.Proveedor.SAProveedorImp;
import Negocio.Seccion.SASeccion;
import Negocio.Seccion.SASeccionImp;
import Negocio.Suministro.SASuministro;
import Negocio.Suministro.SASuministroImp;
import Negocio.Asociacion.SAAsociacion;
import Negocio.Asociacion.SAAsociacionImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.SAEmpleadoImp;
import Negocio.Local.SALocal;
import Negocio.Local.SALocalImp;
import Negocio.Marca.SAMarca;
import Negocio.Marca.SAMarcaImp;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class FactoriaSAImp extends FactoriaSA {
	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAProducto()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SAProducto creaSAProducto() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAProductoImp();
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAProveedor()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SAProveedor creaSAProveedor() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAProveedorImp();
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSASuministro()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SASuministro creaSASuministro() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SASuministroImp();
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SAMarca creaSAMarca() {
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAMarcaImp();
		// end-user-code
	}
	
	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SAAsociacion creaSAAsociacion(){
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAAsociacionImp();
		// end-user-code
	}
	
	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SASeccion creaSASeccion(){
		// begin-user-code
		// TODO Auto-generated method stub
		return new SASeccionImp();
		// end-user-code
	}
	
	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SAEmpleado creaSAEmpleado(){
		// begin-user-code
		// TODO Auto-generated method stub
		return new SAEmpleadoImp();
		// end-user-code
	}
	
	/** 
	* (non-Javadoc)
	* @see FactoriaSA#creaSAMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public SALocal creaSALocal(){
		// begin-user-code
		// TODO Auto-generated method stub
		return new SALocalImp();
		// end-user-code
	}
}