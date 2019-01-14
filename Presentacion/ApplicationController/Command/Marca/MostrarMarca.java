/**
 * 
 */
package Presentacion.ApplicationController.Command.Marca;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Marca.SAMarca;
import Negocio.Marca.TMarca;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class MostrarMarca implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAMarca samarca = FactoriaSA.getInstance().creaSAMarca();
		TMarca tmarca = samarca.mostrarMarca((TMarca)data);
		Context context = new Context();
		if(tmarca ==null){
			context.setEvent(Eventos.MostrarMarca_Error);
		}
		else{
			context.setEvent(Eventos.MostrarMarca_Exito);
		}
		context.setData(tmarca);
		return context;
		// end-user-code
	}
}