/**
 * 
 */
package Integracion.FactoriaDAO;

import Integracion.Marca.DaoMarca;
import Integracion.Marca.DaoMarcaImp;
import Integracion.Producto.DaoProducto;
import Integracion.Producto.DaoProductoImp;
import Integracion.Proveedor.DaoProveedor;
import Integracion.Proveedor.DaoProveedorImp;
import Integracion.Suministro.DaoSuministro;
import Integracion.Suministro.DaoSuministroImp;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class FactoriaDaoImp extends FactoriaDao {
	/** 
	* (non-Javadoc)
	* @see FactoriaDao#getDaoMarca()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DaoMarca getDaoMarca() {
		return new DaoMarcaImp();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaDao#getDaoProducto()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DaoProducto getDaoProducto() {
		return new DaoProductoImp();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaDao#getDaoProveedor()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DaoProveedor getDaoProveedor() {
		return new DaoProveedorImp();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaDao#getDaoSuministro()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DaoSuministro getDaoSuministro() {
		return new DaoSuministroImp();
	}
}