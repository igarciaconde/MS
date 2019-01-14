package Presentacion.ApplicationController.Command.Empleado;
/**
 * 
 */


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
public class ModificarEmpleado implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAEmpleado saprod = FactoriaSA.getInstance().creaSAEmpleado();
		TEmpleado tprod = (TEmpleado)data;
		Context context = new Context();
		if(saprod.modificarEmpleado((TEmpleado)data)){
			context.setEvent(Eventos.ModificarEmpleado_Exito);
		}
		else {
			context.setEvent(Eventos.ModificarEmpleado_Error);
		}
		context.setData(tprod);
		return context;
		// end-user-code
	}
}