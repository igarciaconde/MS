package Negocio.Suministro;
/**
 * 
 */


import java.util.ArrayList;

import Integracion.FactoriaDAO.FactoriaDao;
import Integracion.Producto.DaoProducto;
import Integracion.Proveedor.DaoProveedor;
import Integracion.Suministro.DaoSuministro;
import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.Producto.TProducto;
import Negocio.Proveedor.TProveedor;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SASuministroImp implements SASuministro {
	/** 
	* (non-Javadoc)
	* @see SASuministro#altaSuministro(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean altaSuministro(TSuministro suministro) {
		boolean res = false; 
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos el Proveedor y el producto
			TProveedor provLectura = FactoriaDao.getInstance().getDaoProveedor().read(suministro.getIdProveedor());
			TProducto prodLectura = FactoriaDao.getInstance().getDaoProducto().read(suministro.getIdProducto());
			
		
			// Si ambos existen y estan activos
			if (provLectura != null && provLectura.getActivo() 
			 && prodLectura != null && prodLectura.getActivo()) {	
				
				// Comprobamos que no existe ya un suministro con el mismo idProveedor e id Producto
				DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
				TSuministro sumLeido = daoSuministro.read(suministro.getIdProveedor(), suministro.getIdProducto());
				
				
				if(sumLeido == null) { // No existe
					
					res = daoSuministro.create(suministro);
					
					// Cerramos la transaccion
					if (res) {t.commit();}
					else {t.rollBack();}
						
				
				}
				else { // Existe
					
					if(!sumLeido.getActivo()) { // Reactivar
						suministro.setActivo(true);
						
						res = daoSuministro.update(suministro);
					
						// Cerramos la transaccion
						if (res) {t.commit();}
						else {t.rollBack();}
					}
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
	* @see SASuministro#bajaSuministro(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaSuministro(TSuministro suministro) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos el suministro en la BBDD
			DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
			TSuministro sumLeido = daoSuministro.read(suministro.getIdProveedor(), suministro.getIdProducto());
		
			
			//Si existe en la BBDD y esta activo
			if (sumLeido != null && sumLeido.getActivo()) {	
				
				res = daoSuministro.delete(suministro.getIdProveedor(), suministro.getIdProducto());
				
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
	* @see SASuministro#modificarSuministro(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarSuministro(TSuministro suministro) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos el suministro en la BBDD
			DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
			TSuministro sumLeido = daoSuministro.read(suministro.getIdProveedor(), suministro.getIdProducto());
		
			
			//Si existe en la BBDD y esta activo
			if (sumLeido != null && sumLeido.getActivo()) {	
				
				res = daoSuministro.update(suministro);
			
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
	* @see SASuministro#mostrarSuministro(TSuministro suministro)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	// TOA ( TRANSFER OBJECT ASSEMBLER )
	public TSuministroCompleto mostrarSuministro(TSuministro suministro) {
		TSuministroCompleto suministroCompleto = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
		
			// Recogemos todos los datos necesarios	
			DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
			TSuministro tsumimistro = daoSuministro.read(suministro.getIdProveedor(), suministro.getIdProducto());
			
			DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
			TProducto tproducto = daoProducto.read(tsumimistro.getIdProducto());
			
			DaoProveedor daoProveedor = FactoriaDao.getInstance().getDaoProveedor();
			TProveedor tproveedor = daoProveedor.read(tsumimistro.getIdProveedor());
			
			// Rellenamos el transfer con todos los datos
			suministroCompleto = new TSuministroCompleto(tsumimistro, tproveedor, tproducto);
			
			// Cerramos la transaccion
			t.commit();
						
			} catch (Exception e) {
				suministroCompleto = null;
				System.out.println(e.getMessage());
				
			} finally {
				// Eliminamos la transaccion
				if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
			}
		return suministroCompleto;
	}

	/** 
	* (non-Javadoc)
	* @see SASuministro#listarSuministros()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TSuministro> listarSuministros() {
		
		ArrayList<TSuministro> listaSuministros = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();

			//Obtenemos el total de marcas de la BBDD
			DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
			listaSuministros = daoSuministro.readAll();
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		
		return listaSuministros;	
	}
}