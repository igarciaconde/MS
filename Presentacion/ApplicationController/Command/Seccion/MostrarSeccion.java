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
public class MostrarSeccion implements Comando {
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
		TSeccion tsec = saprov.mostrarSeccion(sec.getId());
		Context context = new Context();
		if(tsec ==null){
			context.setEvent(Eventos.MostrarSeccion_Error);
		}
		else{
			context.setEvent(Eventos.MostrarSeccion_Exito);
		}
		context.setData(tsec);
		return context;
		// end-user-code
	}
}