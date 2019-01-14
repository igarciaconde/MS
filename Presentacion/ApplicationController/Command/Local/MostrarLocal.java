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
public class MostrarLocal implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SALocal saLocal = FactoriaSA.getInstance().creaSALocal();
		TLocal tLocal = (TLocal)data;
		TLocal aux  = saLocal.mostrarLocal(tLocal.getId());
		Context context = new Context();
		if(aux ==null){
			context.setEvent(Eventos.MostrarLocal_Error);
		}
		else{
			context.setEvent(Eventos.MostrarLocal_Exito);
		}
		context.setData(aux);
		return context;
		// end-user-code
	}
}