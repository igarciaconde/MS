/**
 * 
 */
package Negocio.Marca;

import java.util.ArrayList;
import java.util.HashMap;

import Integracion.FactoriaDAO.FactoriaDao;
import Integracion.FactoriaQuery.FactoriaQuery;
import Integracion.Marca.DaoMarca;
import Integracion.Producto.DaoProducto;
import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.Producto.TProducto;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAMarcaImp implements SAMarca {
	/** 
	* (non-Javadoc)
	* @see SAMarca#altaMarca(TMarca marca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaMarca(TMarca marca) {
		
		int idMarca = -1; // si devuelve -1, operacion no realizada 
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos las marca
			DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
			TMarca marcaLectura = daoMarca.readByName(marca.getNombre());
			
			if (marcaLectura == null) {	// la marca no esta en la BBDD
				
				idMarca = daoMarca.create(marca);
				
				//Confirmamos la transaccion
				if (idMarca != -1) {t.commit();}
				else {t.rollBack();}
			}
			else { // la marca esta en la BBDD
				
				if (!marcaLectura.getActivo()) { // Reactivar
					marca.setId(marcaLectura.getId());
					marca.setActivo(true);
					boolean res = daoMarca.update(marca);
					
					//Cerramos la transaccion
					if (res) {
						t.commit();
						idMarca = marca.getId();
					}
					else {t.rollBack();}
				}
			}
		} catch (Exception e) {
			idMarca = -1; 
			System.out.println(e.getMessage());
			
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		
		return idMarca;
	}

	/** 
	* (non-Javadoc)
	* @see SAMarca#modificarMarca(TMarca marca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarMarca(TMarca marca) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Empezamos la operacion
			DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
			TMarca marcaLeida = daoMarca.read(marca.getId());
			
			//Si existe la marca y esta activo
			if(marcaLeida != null && marcaLeida.getActivo()) {
				TMarca marcaLeidaByNombre = daoMarca.readByName(marca.getNombre());
				
				//No hay marca en la BBDD con el mismo nombre O no se modifica el nombre
				if (marcaLeidaByNombre == null || marcaLeida.getId() == marcaLeidaByNombre.getId()) {
					res = daoMarca.update(marca);
					
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
	* @see SAMarca#mostrarMarca(TMarca marca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMarca mostrarMarca(TMarca marca) {
		TMarca marcaLeida = null;
		Transaction t = null;
		
		try {
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Hacemos la operacion
			marcaLeida = FactoriaDao.getInstance().getDaoMarca().read(marca.getId());
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			marcaLeida = null;
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return marcaLeida;
	}

	/** 
	* (non-Javadoc)
	* @see SAMarca#bajaMarca(TMarca marca)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaMarca(TMarca marca) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Buscamos la marca en la BBDD
			DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
			TMarca marcaLectura = daoMarca.read(marca.getId());
			
			//Si existe en la BBDD y esta activo
			if (marcaLectura != null && marcaLectura.getActivo()) {	
				
				DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
				ArrayList<TProducto> productos = daoProducto.readProductosByMarca(marca.getId());
				
				for(TProducto prod : productos) {	// Buscar si hay algun producto activo
					if (prod.getActivo())
						return false;
				}
				
				// Se borra en la BBDD
				res = daoMarca.delete(marca.getId());
				
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
	* @see SAMarca#listarMarcas()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TMarca> listarMarcas() {
		ArrayList<TMarca> listaMarcas = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();

			//Obtenemos el total de marcas de la BBDD
			DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
			listaMarcas = daoMarca.readAll();
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return listaMarcas;
	}

	/** 
	* (non-Javadoc)
	* @see SAMarca#mostrarMarcasConMasDeNProveedores(int n)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	@SuppressWarnings("unchecked")
	public HashMap<TMarca,Integer> mostrarMarcasConMasDeNProveedores(int n) {
		HashMap<TMarca,Integer> listaMarcas = null;
		Transaction t = null;
		try {
			//Creamos una transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			//Realizamos la operacion
			listaMarcas = (HashMap<TMarca,Integer>) FactoriaQuery.getInstance().getListarMarcasConNproveedores().execute(n);
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			
		} finally {
			//Cerramos la transaccion
			if (t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return listaMarcas;
	}
}