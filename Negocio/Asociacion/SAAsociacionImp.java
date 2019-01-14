/**
 * 
 */
package Negocio.Asociacion;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Negocio.Local.Local;
import Negocio.Local.TLocal;
import Negocio.Seccion.Seccion;
import Negocio.Seccion.TSeccion;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class SAAsociacionImp implements SAAsociacion {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param asociacion
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean altaAsociacion(TAsociacion asociacion) {
		
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el local y la seccion por id
		Local localLectura = em.find(Local.class, asociacion.getIdLocal());
		Seccion seccionLectura = em.find(Seccion.class, asociacion.getIdSeccion());
		
		//Si ambos existen y estan activos
		if(localLectura != null && localLectura.isActivo() 
				&& seccionLectura != null && seccionLectura.isActivo()){
			
			// Buscamos la asociacion por el id
			AsociacionId id = new AsociacionId(asociacion.getIdLocal(), asociacion.getIdSeccion());
			Asociacion asocLectura = em.find(Asociacion.class,id);
			
			// Comprobamos que no existe ya una asociacion con el mismo idLocal e idSuministro
			if(asocLectura == null){
				
				Asociacion asoc = new Asociacion(asociacion.getIdLocal(),asociacion.getIdSeccion()); 
				asoc.setLocal(localLectura);
				asoc.setSeccion(seccionLectura);
				asoc.setMetrosCuadrados(asociacion.getMetrosCuadrados());
				asoc.setActivo(true);
				
				em.persist(asoc);
				
				em.getTransaction().commit();
				res = true;
			}
			else{ // si ya existe, reactivamos
				
				if(!asocLectura.isActivo()){ 
					
					asocLectura.setActivo(true);
					asocLectura.setMetrosCuadrados(asociacion.getMetrosCuadrados());
					
					em.getTransaction().commit();
					res = true;
				}
				else
					em.getTransaction().rollback();
			}
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		emf.close();
		return res;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean bajaAsociacion(int idLocal, int idSeccion) {
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos la asociacion por el id
		AsociacionId id = new AsociacionId(idLocal, idSeccion);
		Asociacion asocLectura = em.find(Asociacion.class,id);
		
		//Si existe en la BBDD y esta activo
		if(asocLectura != null && asocLectura.isActivo()){ 
			asocLectura.setActivo(false);
			em.getTransaction().commit();
			res = true;
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		emf.close();
		return res;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param asociacion
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean modificarAsociacion(TAsociacion asociacion) {
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos la asociacion por el id
		AsociacionId id = new AsociacionId(asociacion.getIdLocal(), asociacion.getIdSeccion());
		Asociacion asocLectura = em.find(Asociacion.class,id);
		
		//Si existe en la BBDD y esta activo
		if(asocLectura != null && asocLectura.isActivo()){ 
			asocLectura.setMetrosCuadrados(asociacion.getMetrosCuadrados());
			em.getTransaction().commit();
			res = true;
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		emf.close();
		return res;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	// Transfer Object Assembler (TOA)
	public TAsociacionCompleta mostrarAsociacion(int idLocal, int idSeccion) {
		TAsociacionCompleta asociacionCom = null;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		Local l = em.find(Local.class, idLocal);
		Seccion s = em.find(Seccion.class, idSeccion);
		AsociacionId idAso = new AsociacionId(idLocal, idSeccion);
		Asociacion a = em.find(Asociacion.class, idAso);
		
		if (s != null && l != null && a != null) {
			//El local
			TLocal tLoc = new TLocal();
			tLoc.setId(l.getId());
			tLoc.setDireccion(l.getDireccion());
			tLoc.setCodigoPostal(l.getCodigoPostal());
			tLoc.setAforo(l.getAforo());
			tLoc.setActivo(l.isActivo());
			
			//La seccion
			TSeccion tSec = new TSeccion();
			tSec.setId(s.getId());
			tSec.setNombre(s.getNombre());
			tSec.setTemperatura(s.getTemperatura());
			tSec.setActivo(s.isActivo());
			
			//La asociacion
			TAsociacion tAso = new TAsociacion();
			tAso.setIdLocal(tLoc.getId());
			tAso.setIdSeccion(tSec.getId());
			tAso.setMetrosCuadrados(a.getMetrosCuadrados());
			tAso.setActivo(a.isActivo());
			
			//El transfer completo
			asociacionCom = new TAsociacionCompleta(tAso, tLoc, tSec);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return asociacionCom;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<TAsociacion> listarAsociaciones() {
		ArrayList<TAsociacion> asociaciones = new ArrayList<TAsociacion>();
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		TypedQuery<Asociacion> asociacionesLeidas = em.createQuery("SELECT obj FROM asociacion obj", Asociacion.class);
		
		//Metemos las secciones en la lista
		for(Asociacion a : asociacionesLeidas.getResultList()) {
			TAsociacion res = new TAsociacion();
			res.setIdLocal(a.getId().getIdLocal());
			res.setIdSeccion(a.getId().getIdSeccion());
			res.setMetrosCuadrados(a.getMetrosCuadrados());
			res.setActivo(a.isActivo());
			asociaciones.add(res);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return asociaciones;
	}
}