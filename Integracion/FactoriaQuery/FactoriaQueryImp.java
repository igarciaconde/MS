/**
 * 
 */
package Integracion.FactoriaQuery;

import Integracion.Query.ListarMarcasConNproveedores;
import Integracion.Query.ListarProveedoresConNmarcas;
import Integracion.Query.Query;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Edu
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaQueryImp extends FactoriaQuery {

	@Override
	public Query getListarProveedoresConNmarcas() {
		return new ListarProveedoresConNmarcas();
	}

	@Override
	public Query getListarMarcasConNproveedores() {
		return new ListarMarcasConNproveedores();
	}
}