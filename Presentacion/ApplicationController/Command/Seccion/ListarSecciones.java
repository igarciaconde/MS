/**
 * 
 */
package Presentacion.ApplicationController.Command.Seccion;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Seccion.SASeccion;
import Negocio.Seccion.TSeccion;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ListarSecciones implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SASeccion sprov = FactoriaSA.getInstance().creaSASeccion();
		ArrayList<TSeccion> provs = sprov.listarSecciones();
		Context context = new Context();
		if(provs == null)
			context.setEvent(Eventos.ListarSecciones_Error);
		else
			context.setEvent(Eventos.ListarSecciones_Exito);
		context.setData(provs);
		return context;
		// end-user-code
	}
}