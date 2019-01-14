/**
 * 
 */
package Presentacion.ApplicationController.Command.Local;

import java.util.ArrayList;

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
public class ListarLocales implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SALocal sLocal = FactoriaSA.getInstance().creaSALocal();
		ArrayList<TLocal> Locals = sLocal.listarLocales();
		Context context = new Context();
		if(Locals == null)
			context.setEvent(Eventos.ListarLocals_Error);
		else
			context.setEvent(Eventos.ListarLocals_Exito);
		context.setData(Locals);
		return context;
		// end-user-code
	}
}