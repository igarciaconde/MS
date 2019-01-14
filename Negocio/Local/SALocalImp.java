/**
 * 
 */
package Negocio.Local;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Asociacion.Asociacion;
import Negocio.Empleado.Empleado;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class SALocalImp implements SALocal {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tLocal
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int altaLocal(TLocal tLocal) {
		// begin-user-code
		// TODO Auto-generated method stub
		int idLocal = -1;// si devuelve -1, operacion no realizada
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el local por direccion
		TypedQuery<Local> localLectura = em.createNamedQuery("Negocio.Local.Local.findBydireccion",Local.class);
		localLectura.setParameter("direccion", tLocal.getDireccion());
		
		// Creamos el local
		Local local;
		
		if(localLectura.getResultList().size() == 0){ // si no hay ningun local con la misma direccion
			
			// asignamos los atributos
			local = new Local();
			local.setDireccion(tLocal.getDireccion());
			local.setCodigoPostal(tLocal.getCodigoPostal());
			local.setAforo(tLocal.getAforo());
			local.setActivo(true);
			
			// La damos de alta
			em.persist(local);
			em.getTransaction().commit();
			idLocal = local.getId();
			
		}
		else{ // Reactivar
			 local = localLectura.getSingleResult();
			
			if(!local.isActivo()){
				// Actualizamos los valores
				local.setDireccion(tLocal.getDireccion());
				local.setCodigoPostal(tLocal.getCodigoPostal());
				local.setAforo(tLocal.getAforo());
				// reactivamos
				local.setActivo(true);
				em.getTransaction().commit();
				idLocal = local.getId();
			}
			else
				em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
		
		return idLocal;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean bajaLocal(int id) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el local por id
		Local localLectura = em.find(Local.class, id);
		
		//Si existe en la BBDD y esta activo
		if(localLectura != null && localLectura.isActivo()){ 
			
			boolean tieneAsociacionOEmpleado = false;
			
			for(Asociacion a: localLectura.getListaAsociaciones()){ // comprueba si hay alguna asociacion activa
				if(a.isActivo()){
					tieneAsociacionOEmpleado = true;
				}
			}
			
			for(Empleado e: localLectura.getListaEmpleados()){ // comprueba si hay algun empleado activo
				if(e.isActivo()){
					tieneAsociacionOEmpleado = true;
				}
			}
		
			if(!tieneAsociacionOEmpleado){
				localLectura.setActivo(false);
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
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tLocal
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean modificarLocal(TLocal tLocal) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el local 
		Local localLectura = em.find(Local.class, tLocal.getId());
		
		// si existe en la base de datos y esta activo
		if(localLectura != null && localLectura.isActivo()){ 
			
			// Buscamos si hay un local con la misma direccion 
			TypedQuery<Local> localLecturaPorDireccion = em.createNamedQuery("Negocio.Local.Local.findBydireccion",Local.class);
			localLecturaPorDireccion.setParameter("direccion", tLocal.getDireccion());
			
			//Si no hay un local con la misma direccion
			if (localLecturaPorDireccion.getResultList().size() == 0 ||
					localLecturaPorDireccion.getSingleResult().getId() == localLectura.getId()) {
				
				localLectura.setDireccion(tLocal.getDireccion());
				localLectura.setCodigoPostal(tLocal.getCodigoPostal());
				localLectura.setAforo(tLocal.getAforo());
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
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TLocal mostrarLocal(int id) {
		// begin-user-code
		// TODO Auto-generated method stub
		TLocal res = null;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		Local l = em.find(Local.class, id);
		
		if (l != null) {
			res = new TLocal();
			res.setId(l.getId());
			res.setDireccion(l.getDireccion());
			res.setCodigoPostal(l.getCodigoPostal());
			res.setAforo(l.getAforo());
			res.setActivo(l.isActivo());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return res;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<TLocal> listarLocales() {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<TLocal> locales = new ArrayList<TLocal>();
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		TypedQuery<Local> localesLeidos = em.createQuery("SELECT obj FROM local obj", Local.class);
		
		//Metemos las secciones en la lista
		for(Local l : localesLeidos.getResultList()) {
			TLocal res = new TLocal();
			res.setId(l.getId());
			res.setDireccion(l.getDireccion());
			res.setCodigoPostal(l.getCodigoPostal());
			res.setAforo(l.getAforo());
			res.setActivo(l.isActivo());
			locales.add(res);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return locales;
		// end-user-code
	}

	@Override
	public double calcularNominaLocal(int idLocal) {
		// TODO Auto-generated method stub
		int nominaTotal = -1;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		Local l = em.find(Local.class, idLocal);
		
		if (l != null) {
			nominaTotal = 0;
			
			//Calculamos la nomina de todos los empleados
			for(Empleado e : l.getListaEmpleados()) {
				nominaTotal += e.calcularNominaEmpleado();
			}
			
			em.getTransaction().commit();
		} else
			em.getTransaction().rollback();
		
		em.close();
		emf.close();
		
		return nominaTotal;
	}
}