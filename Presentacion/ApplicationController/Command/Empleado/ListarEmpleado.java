/**
 * 
 */
package Presentacion.ApplicationController.Command.Empleado;

import java.util.ArrayList;

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
public class ListarEmpleado implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAEmpleado sprod = FactoriaSA.getInstance().creaSAEmpleado();
		ArrayList<TEmpleado> prods = sprod.listarEmpleados();
		Context context = new Context();
		if(prods == null)
			context.setEvent(Eventos.ListarEmpleados_Error);
		else
			context.setEvent(Eventos.ListarEmpleados_Exito);
		context.setData(prods);
		return context;
		// end-user-code
	}
}