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
public class AltaProveedor implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProveedor saProveedor = FactoriaSA.getInstance().creaSAProveedor();
		TProveedor tproveedor = new TProveedor();
		tproveedor.setId(saProveedor.altaProveedor((TProveedor)data));
		Context context = new Context();
		if(tproveedor.getId() == -1){
			context.setEvent(Eventos.AltaProveedor_Error);
		}
		else{
			context.setEvent(Eventos.AltaProveedor_Exito);
		}
		context.setData(tproveedor);
		return context;
		// end-user-code
	}
}