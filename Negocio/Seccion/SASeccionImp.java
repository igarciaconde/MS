/**
 * 
 */
package Negocio.Seccion;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Asociacion.Asociacion;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class SASeccionImp implements SASeccion {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param seccion
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int altaSeccion(TSeccion seccion) {
		int idSeccion = -1;// si devuelve -1, operacion no realizada
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos la seccion por nombre
		TypedQuery<Seccion> seccionLectura = em.createNamedQuery("Negocio.Seccion.Seccion.findBynombre",Seccion.class);
		seccionLectura.setParameter("nombre", seccion.getNombre());
		
		// Creamos la seccion
		Seccion sec;
		
		if(seccionLectura.getResultList().size() == 0){ // si no hay ninguna seccion con el mismo nombre
			
			// asignamos los atributos
			sec = new Seccion();
			sec.setNombre(seccion.getNombre());
			sec.setTemperatura(seccion.getTemperatura());
			sec.setActivo(true);
			
			// La damos de alta
			em.persist(sec);
			em.getTransaction().commit();
			idSeccion = sec.getId();
			
		}
		else{ // Reactivar
			 sec = seccionLectura.getSingleResult();
			
			if(!sec.isActivo()){
				// Actualizamos los valores
				sec.setNombre(seccion.getNombre());
				sec.setTemperatura(seccion.getTemperatura());
				// reactivamos
				sec.setActivo(true);
				em.getTransaction().commit();
				idSeccion = sec.getId();
			}
			else
				em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
		
		return idSeccion;
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean bajaSeccion(int id) {
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos la seccion
		Seccion seccionLectura = em.find(Seccion.class, id);
		
		//Si existe en la BBDD y esta activa
		if(seccionLectura != null && seccionLectura.isActivo()){ 
			
			boolean asociacionActiva = false;
			
			for(Asociacion a: seccionLectura.getListaAsociaciones()){ // comprueba si hay alguna asociacion activa
				if(a.isActivo()){
					asociacionActiva = true;
				}
			}
		
			if(!asociacionActiva){
				seccionLectura.setActivo(false);
				em.getTransaction().commit();
				res = true;
			}
			else
				em.getTransaction().rollback();
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
	* @param seccion
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean modificarSeccion(TSeccion seccion) {
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos la seccion 
		Seccion seccionLectura = em.find(Seccion.class, seccion.getId());
		
		// si existe en la base de datos y esta activa
		if(seccionLectura != null && seccionLectura.isActivo()){ 
			
			// Buscamos si hay una seccion con el mismo nombre 
			TypedQuery<Seccion> seccionLecturaPorNombre = em.createNamedQuery("Negocio.Seccion.Seccion.findBynombre",Seccion.class);
			seccionLecturaPorNombre.setParameter("nombre", seccion.getNombre());
			
			//Si no hay una seccion con el mismo nombre
			if (seccionLecturaPorNombre.getResultList().size() == 0 ||
					seccionLecturaPorNombre.getSingleResult().getId() == seccionLectura.getId()) {
				
				seccionLectura.setNombre(seccion.getNombre());
				seccionLectura.setTemperatura(seccion.getTemperatura());
				em.getTransaction().commit();
				res = true;
			}
			else
				em.getTransaction().rollback();
		} else
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
	public TSeccion mostrarSeccion(int id) {
		TSeccion res = null;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		Seccion s = em.find(Seccion.class, id);
		
		if (s != null) {
			res = new TSeccion();
			res.setId(s.getId());
			res.setNombre(s.getNombre());
			res.setTemperatura(s.getTemperatura());
			res.setActivo(s.isActivo());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return res;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<TSeccion> listarSecciones() {
		ArrayList<TSeccion> secciones = new ArrayList<TSeccion>();
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		TypedQuery<Seccion> seccionesLeidas = em.createQuery("SELECT obj FROM seccion obj", Seccion.class);
		
		//Metemos las secciones en la lista
		for(Seccion s : seccionesLeidas.getResultList()) {
			TSeccion res = new TSeccion();
			res.setId(s.getId());
			res.setNombre(s.getNombre());
			res.setTemperatura(s.getTemperatura());
			res.setActivo(s.isActivo());
			secciones.add(res);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return secciones;
	}
}