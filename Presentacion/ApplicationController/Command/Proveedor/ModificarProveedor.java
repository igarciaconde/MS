/**
 * 
 */
package Presentacion.ApplicationController.Command.Proveedor;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Proveedor.SAProveedor;
import Negocio.Proveedor.TProveedor;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ModificarProveedor implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProveedor saprov = FactoriaSA.getInstance().creaSAProveedor();
		TProveedor tprov = new TProveedor();
		Context context = new Context();
		if(saprov.modificarProveedor((TProveedor)data)){
			context.setEvent(Eventos.ModificarProveedor_Exito);
		}
		else {
			context.setEvent(Eventos.ModificarProveedor_Error);
		}
		context.setData(tprov);
		return context;
		// end-user-code
	}
}