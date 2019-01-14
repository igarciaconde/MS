package Presentacion.ApplicationController.Command.Asociacion;
/**
 * 
 */


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
public class AltaAsociacionLocalSeccion implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAAsociacion saAsociacion = FactoriaSA.getInstance().creaSAAsociacion();
		TAsociacion tAsociacion = (TAsociacion)data;
		Context context = new Context();
		context.setData(tAsociacion);
		if(!saAsociacion.altaAsociacion(tAsociacion)){
			context.setEvent(Eventos.AltaAsociacionLocalSeccion_Error);
		}
		else{
			context.setEvent(Eventos.AltaAsociacionLocalSeccion_Exito);
		}
		context.setData(tAsociacion);
		return context;
		// end-user-code
	}
}