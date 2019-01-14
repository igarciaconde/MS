package Presentacion.ApplicationController.Command.Producto;
/**
 * 
 */


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
public class ModificarProducto implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProducto saprod = FactoriaSA.getInstance().creaSAProducto();
		TProducto tprod = (TProducto)data;
		Context context = new Context();
		if(saprod.modificarProducto((TProducto)data)){
			context.setEvent(Eventos.ModificarProducto_Exito);
		}
		else {
			context.setEvent(Eventos.ModificarProducto_Error);
		}
		context.setData(tprod);
		return context;
		// end-user-code
	}
}