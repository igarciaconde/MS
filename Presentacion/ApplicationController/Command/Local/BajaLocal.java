/**
 * 
 */
package Presentacion.ApplicationController.Command.Local;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Local.SALocal;
import Negocio.Local.TLocal;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class BajaLocal implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SALocal saLocal = FactoriaSA.getInstance().creaSALocal();
		Context context = new Context();
		TLocal tLocal = (TLocal)data;
		context.setData(tLocal);
		if(saLocal.bajaLocal(tLocal.getId()))
			context.setEvent(Eventos.BajaLocal_Exito);
		else
			context.setEvent(Eventos.BajaLocal_Error);
		return context;
		// end-user-code
	}
}