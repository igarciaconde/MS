package Presentacion.ApplicationController.Command.Suministro;

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
public class BajaSuministro implements Comando{
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SASuministro sasum = FactoriaSA.getInstance().creaSASuministro();
		Context context = new Context();
		if(sasum.bajaSuministro((TSuministro)data))
			context.setEvent(Eventos.BajaSuministro_Exito);
		else
			context.setEvent(Eventos.BajaSuministro_Error);
		return context;
		// end-user-code
	}
}
