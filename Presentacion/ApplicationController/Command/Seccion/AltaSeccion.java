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
public class AltaSeccion implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SASeccion saSeccion = FactoriaSA.getInstance().creaSASeccion();
		TSeccion tSeccion = new TSeccion();
		tSeccion.setId(saSeccion.altaSeccion((TSeccion)data));
		Context context = new Context();
		if(tSeccion.getId() == -1){
			context.setEvent(Eventos.AltaSeccion_Error);
		}
		else{
			context.setEvent(Eventos.AltaSeccion_Exito);
		}
		context.setData(tSeccion);
		return context;
		// end-user-code
	}
}