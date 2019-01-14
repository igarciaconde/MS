/**
 * 
 */
package Presentacion.ApplicationController.Command.Seccion;

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
public class BajaSeccion implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SASeccion saprov = FactoriaSA.getInstance().creaSASeccion();
		TSeccion sec = (TSeccion) data;
		Context context = new Context();
		if(saprov.bajaSeccion(sec.getId()))
			context.setEvent(Eventos.BajaSeccion_Exito);
		else
			context.setEvent(Eventos.BajaSeccion_Error);
		context.setData(sec);
		return context;
		// end-user-code
	}
}