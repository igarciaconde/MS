/**
 * 
 */
package Presentacion.ApplicationController.Command.Empleado;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class AltaEmpleado implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAEmpleado saEmpleado = FactoriaSA.getInstance().creaSAEmpleado();
		TEmpleado tEmpleado = new TEmpleado();
		tEmpleado.setId(saEmpleado.altaEmpleado((TEmpleado)data));
		Context context = new Context();
		if(tEmpleado.getId() == -1){
			context.setEvent(Eventos.AltaEmpleado_Error);
		}
		else{
			context.setEvent(Eventos.AltaEmpleado_Exito);
		}
		context.setData(tEmpleado);
		return context;
		// end-user-code
	}
}