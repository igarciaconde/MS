package Presentacion.ApplicationController.Command.Suministro;
/**
 * 
 */


import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Suministro.SASuministro;
import Negocio.Suministro.TSuministro;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class AltaSuministro implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SASuministro saSuministro = FactoriaSA.getInstance().creaSASuministro();
		TSuministro tsuministro = (TSuministro)data;
		Context context = new Context();
		if(!saSuministro.altaSuministro((TSuministro)data)){
			context.setEvent(Eventos.AltaSuministro_Error);
		}
		else{
			context.setEvent(Eventos.AltaSuministro_Exito);
		}
		context.setData(tsuministro);
		return context;
		// end-user-code
	}
}