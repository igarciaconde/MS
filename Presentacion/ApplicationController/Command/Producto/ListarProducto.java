/**
 * 
 */
package Presentacion.ApplicationController.Command.Producto;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Producto.SAProducto;
import Negocio.Producto.TProducto;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ListarProducto implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProducto sprod = FactoriaSA.getInstance().creaSAProducto();
		ArrayList<TProducto> prods = sprod.listarProductos();
		Context context = new Context();
		if(prods == null)
			context.setEvent(Eventos.ListarProductos_Error);
		else
			context.setEvent(Eventos.ListarProductos_Exito);
		context.setData(prods);
		return context;
		// end-user-code
	}
}