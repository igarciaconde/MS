/**
 * 
 */
package Presentacion.ApplicationController.Command.Producto;

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
public class MostrarProducto implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProducto saprod = FactoriaSA.getInstance().creaSAProducto();
		TProducto tprod = saprod.mostrarProducto((TProducto)data);
		Context context = new Context();
		if(tprod ==null){
			context.setEvent(Eventos.MostrarProducto_Error);
		}
		else{
			context.setEvent(Eventos.MostrarProducto_Exito);
		}
		context.setData(tprod);
		return context;
		// end-user-code
	}
}