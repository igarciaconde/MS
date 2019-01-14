package Presentacion.ApplicationController.Command.Proveedor;


import java.util.HashMap;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Proveedor.SAProveedor;
import Negocio.Proveedor.TProveedor;
import Presentacion.ApplicationController.Command.Comando;
import Presentacion.ApplicationController.Command.Context;
import Presentacion.ApplicationController.Command.Eventos;
/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/

public class MostrarProveedorNMarcas implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#execute(Object data)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object data) {
		// begin-user-code
		// TODO Auto-generated method stub
		SAProveedor saprov = FactoriaSA.getInstance().creaSAProveedor();
		HashMap<TProveedor, Integer> provs = saprov.mostrarProveedoresConMasDeNMarcas((int)data);
		Context context = new Context();
		if(provs == null) {
			context.setEvent(Eventos.MostrarProveedoresNMarcas_Error);
		}
		else {
			context.setEvent(Eventos.MostrarProveedoresNMarcas_Exito);
		}
		context.setData(provs);
		return context;
		// end-user-code
	}
}
