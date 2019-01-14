package Negocio.Producto;
/**
 * 
 */


import java.util.ArrayList;

import Integracion.FactoriaDAO.FactoriaDao;
import Integracion.Marca.DaoMarca;
import Integracion.Producto.DaoProducto;
import Integracion.Suministro.DaoSuministro;
import Integracion.Transacciones.Transaction;
import Integracion.Transacciones.TransactionManager;
import Negocio.Marca.TMarca;
import Negocio.Suministro.TSuministro;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProductoImp implements SAProducto {
	/** 
	* (non-Javadoc)
	* @see SAProducto#altaProducto(TProducto producto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaProducto(TProducto producto) {
		int idProducto = -1; // si devuelve -1, operacion no realizada 
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			// Buscamos el producto en la BBDD
			DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
			TProducto prodLectura = daoProducto.readByName(producto.getNombre());
			
			// Buscamos la marca en la BBDD
			DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
			TMarca marcaLectura = daoMarca.read(producto.getMarca());
			
			// Si el producto no existia previamente y existe la marca en la BBDD
			// para poder asociarla al nuevo producto, podemos crearlo
			if (prodLectura == null) {
				if(marcaLectura != null && marcaLectura.getActivo()) {
					
					idProducto = daoProducto.create(producto);
					
					// Confirmamos la transaccion
					if (idProducto != -1) {t.commit();}
					else {t.rollBack();}
				}
			}
			else { // el producto esta en la BBDD
				
					if (!prodLectura.getActivo()) { // Reactivar
						
						// La marca tb sigue en la BBDD para poder reactivar
						if(marcaLectura != null && marcaLectura.getActivo()) { 
							
							producto.setId(prodLectura.getId());
							producto.setActivo(true);
							
							boolean res = daoProducto.update(producto);
							
							//Cerramos la transaccion
							if (res) {
								t.commit();
								idProducto = producto.getId();
							}
							else {t.rollBack();}
						}
					}
				
			}
		} catch (Exception e) {
			idProducto = -1; 
			System.out.println(e.getMessage());
			
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		
		return idProducto;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#bajaProducto(TProducto producto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean bajaProducto(TProducto producto) {
	
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			// Buscamos el producto en la BBDD
			DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
			TProducto prodLectura = daoProducto.read(producto.getId());
			
			//Si existe en la BBDD y esta activo
			if (prodLectura != null && prodLectura.getActivo()) {	
				
					// Comprobamos que no hay suministros activos para el producto
					DaoSuministro daoSuministro = FactoriaDao.getInstance().getDaoSuministro();
					ArrayList<TSuministro> suministros = daoSuministro.readSuministrosByIdProducto(producto.getId());
					
					for(TSuministro sum : suministros) {	
						if (sum.getActivo())
							return false;
					}
					
					// Comprobamos que no hay stock para el producto
					if(prodLectura.getStock() == 0) {
						
						// Se borra en la BBDD
						res = daoProducto.delete(producto.getId());
						
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
	* @see SAProducto#modificarProducto(TProducto producto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public boolean modificarProducto(TProducto producto) {
		boolean res = false;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			// Buscamos el producto en la BBDD
			DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
			TProducto prodLectura = daoProducto.read(producto.getId());
			
			//Si existe y esta activo
			if(prodLectura != null && prodLectura.getActivo()) {
				
				// Buscamos por nombre
				TProducto productoLeidoByNombre = daoProducto.readByName(producto.getNombre());
				
				// No hay producto en la BBDD con el mismo nombre O no se modifica el nombre
				if (productoLeidoByNombre == null || prodLectura.getId() == productoLeidoByNombre.getId()) {
					
					// Buscamos la marca en la BBDD
					DaoMarca daoMarca = FactoriaDao.getInstance().getDaoMarca();
					TMarca marcaLectura = daoMarca.read(producto.getMarca());
					
					// La marca existe en la BBDD y esta activa
					if(marcaLectura != null && marcaLectura.getActivo()) { 
					
						res = daoProducto.update(producto);
						
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
	* @see SAProducto#mostrarProducto(TProducto prodcuto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProducto mostrarProducto(TProducto prodcuto) {
		TProducto prodLeido = null;
		Transaction t = null;
		
		try {
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();
			
			// Hacemos la operacion
			prodLeido = FactoriaDao.getInstance().getDaoProducto().read(prodcuto.getId());
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			prodLeido = null;
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return prodLeido;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#listarProductos()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProducto> listarProductos() {
		ArrayList<TProducto> listaProductos = null;
		Transaction t = null;
		
		try {
			
			//Iniciamos la transaccion
			TransactionManager.getInstance().nuevaTransaccion();
			t = TransactionManager.getInstance().getTransaction();
			t.start();

			//Obtenemos el total de productos de la BBDD
			DaoProducto daoProducto = FactoriaDao.getInstance().getDaoProducto();
			listaProductos = daoProducto.readAll();
			
			// Cerramos la transaccion
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Eliminamos la transaccion
			if(t != null) {TransactionManager.getInstance().eliminaTransaccion();}
		}
		return listaProductos;
	}
}