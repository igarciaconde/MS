package Presentacion.ApplicationController.Command.Asociacion;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Asociacion.SAAsociacion;
import Negocio.Asociacion.TAsociacion;
import Negocio.Asociacion.TAsociacionCompleta;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class MostrarAsociacionLocalSeccion implements Comando{
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAAsociacion sasum = FactoriaSA.getInstance().creaSAAsociacion();
		TAsociacion taso = (TAsociacion)data;
		TAsociacionCompleta tasoc = sasum.mostrarAsociacion(taso.getIdLocal(), taso.getIdSeccion());
		Context context = new Context();
		if(tasoc ==null){
			context.setEvent(Eventos.MostrarAsociacionLocalSeccion_Error);
		}
		else{
			context.setEvent(Eventos.MostrarAsociacionLocalSeccion_Exito);
		}
		context.setData(tasoc);
		return context;
		// end-user-code
	}
}
