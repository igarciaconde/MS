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
public class AltaProducto implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProducto saProducto = FactoriaSA.getInstance().creaSAProducto();
		TProducto tproducto = new TProducto();
		tproducto.setId(saProducto.altaProducto((TProducto)data));
		Context context = new Context();
		if(tproducto.getId() == -1){
			context.setEvent(Eventos.AltaProducto_Error);
		}
		else{
			context.setEvent(Eventos.AltaProducto_Exito);
		}
		context.setData(tproducto);
		return context;
		// end-user-code
	}
}