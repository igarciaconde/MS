package Presentacion.ApplicationController.Command.Asociacion;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Asociacion.SAAsociacion;
import Negocio.Asociacion.TAsociacion;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ListarAsociacionesLocalSeccion implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAAsociacion sasum = FactoriaSA.getInstance().creaSAAsociacion();
		ArrayList<TAsociacion> sums = sasum.listarAsociaciones();
		Context context = new Context();
		if(sums == null)
			context.setEvent(Eventos.ListarAsociacionesLocalSeccion_Error);
		else
			context.setEvent(Eventos.ListarAsociacionesLocalSeccion_Exito);
		context.setData(sums);
		return context;
		// end-user-code
	}
}
