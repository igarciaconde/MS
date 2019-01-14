/**
 * 
 */
package Negocio.Proveedor;

import java.util.ArrayList;
import java.util.HashMap;

import Integracion.FactoriaDAO.FactoriaDao;
import Integracion.FactoriaQuery.FactoriaQuery;
import Integracion.Proveedor.DaoProveedor;
import Integracion.Suministro.DaoSuministro;
import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.Suministro.TSuministro;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProveedorImp implements SAProveedor {
	/** 
	* (non-Javadoc)
	* @see SAProveedor#altaProveedor(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaProveedor(TProveedor proveedor) {
		int idProveedor = -1; // si devuelve -1, operacion no realizada 
		Transaction t = null;
		
		try {
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Empezamos la operacion
			DaoProveedor daoProveedor = FactoriaDao.getInstance().getDaoProveedor();
			TProveedor proveedorLectura = daoProveedor.readByName(proveedor.getNombre());
			
			if (proveedorLectura == null) {	// el proveedor no esta en la BD
				idProveedor = daoProveedor.create(proveedor);
				
				if (idProveedor != -1) {t.commit();}
				else {t.rollBack();}
			}
			else { // el proveedor esta en la BD
				
				if (!proveedorLectura.getActivo()) { // Reactivar
					proveedor.setId(proveedorLectura.getId());
					proveedor.setActivo(true);
					boolean res = daoProveedor.update(proveedor);
					
					// Cerramos la transaccion
					if (res) {
						t.commit();
						idProveedor = proveedor.getId();
					}
					else {t.rollBack();}
				}
			}
		} catch (Exception e) {
			idProveedor = -1;
			System.out.println(e.getMessage());
			
		} finally {
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		
		return idProveedor;
	}

	/** 
	* (non-Javadoc)
	* @see SAProveedor#bajaProveedor(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaProveedor(TProveedor proveedor) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos la marca en la BBDD
			DaoProveedor daoProveedor = FactoriaDao.getInstance().getDaoProveedor();
			TProveedor proveedorLectura = daoProveedor.read(proveedor.getId());
			
			//Si existe en la BBDD y esta activa
			if (proveedorLectura != null && proveedorLectura.getActivo()) {	
				
					// Buscamos si hay algun suministro activo para ese proveedor
					DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
					ArrayList<TSuministro> suministros = daoSuministro.readSuministrosByIdProveedor(proveedor.getId());
					
					for(TSuministro sum : suministros) { // si hay algun suministro activo, cancelamos la baja
						if (sum.getActivo())
							return false;
					}
					
					//Se borra en la BBDD
					res = daoProveedor.delete(proveedor.getId());
					
					// Cerramos la transaccion
					if (res) {t.commit();}
					else {t.rollBack();}
			}
		
		} catch (Exception e) {
			res = false;
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return res;
	}

	/** 
	* (non-Javadoc)
	* @see SAProveedor#modificarProveedor(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarProveedor(TProveedor proveedor) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Empezamos la operacion
			DaoProveedor daoProveedor = FactoriaDao.getInstance().getDaoProveedor();
			TProveedor proveedorLeido = daoProveedor.read(proveedor.getId());
			
			//Si existeel proveedor y esta activo
			if(proveedorLeido != null && proveedorLeido.getActivo()) {
				TProveedor proveedorLeidoByNombre = daoProveedor.readByName(proveedor.getNombre());
				
				// No hay proveedor en la BBDD con el mismo nombre O no se modifica el nombre
				if (proveedorLeidoByNombre == null || proveedorLeido.getId() == proveedorLeidoByNombre.getId()) {
					res = daoProveedor.update(proveedor);
					
					// Cerramos la transaccion
					if (res) {t.commit();}
					else {t.rollBack();}
				}
			}
			
		} catch (Exception e) {
			res = false;
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		
		return res;
	}

	/** 
	* (non-Javadoc)
	* @see SAProveedor#mostrarProveedor(TProveedor proveedor)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProveedor mostrarProveedor(TProveedor proveedor) {
		TProveedor proveedorLeido = null;
		Transaction t = null;
		
		try {
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			// Obtenemos el probeedor
			proveedorLeido = FactoriaDao.getInstance().getDaoProveedor().read(proveedor.getId());
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			proveedorLeido = null;
			System.out.println(e.getMessage());
		} finally {
			if (t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return proveedorLeido;
	
		
	}

	/** 
	* (non-Javadoc)
	* @see SAProveedor#listarProveedores()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProveedor> listarProveedores() {
		ArrayList<TProveedor> listaProveedores = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();

			//Obtenemos el total de proveedores de la BBDD
			DaoProveedor daoProveedor = FactoriaDao.getInstance().getDaoProveedor();
			listaProveedores = daoProveedor.readAll();
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			listaProveedores = null;
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return listaProveedores;
	}

	/** 
	* (non-Javadoc)
	* @see SAProveedor#mostrarProveedoresConMasDeNMarcas(int n)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	@SuppressWarnings("unchecked")
	public HashMap<TProveedor,Integer> mostrarProveedoresConMasDeNMarcas(int n) {
		HashMap<TProveedor,Integer> listaProveedores = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Realizamos la operacion
			listaProveedores = (HashMap<TProveedor,Integer>) FactoriaQuery.getInstance().getListarProveedoresConNmarcas().execute(n);
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			
		} finally {
			// Eliminamos la transaccion
			if (t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return listaProveedores;
	}
}