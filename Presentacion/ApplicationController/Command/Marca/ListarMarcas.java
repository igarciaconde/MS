/**
 * 
 */
package Presentacion.ApplicationController.Command.Marca;

import java.util.ArrayList;

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
public class ListarMarcas implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAMarca smarca = FactoriaSA.getInstance().creaSAMarca();
		ArrayList<TMarca> marcas = smarca.listarMarcas();
		Context context = new Context();
		if(marcas == null)
			context.setEvent(Eventos.ListarMarcas_Error);
		else
			context.setEvent(Eventos.ListarMarcas_Exito);
		context.setData(marcas);
		return context;
		// end-user-code
	}
}