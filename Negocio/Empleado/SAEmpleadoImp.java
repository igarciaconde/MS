/**
 * 
 */
package Negocio.Empleado;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Negocio.Local.Local;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Edu
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class SAEmpleadoImp implements SAEmpleado {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tEmpleado
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int altaEmpleado(TEmpleado tEmpleado) {
		
		int idEmpleado = -1;// si devuelve -1, operacion no realizada
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Local localLeido = em.find(Local.class, tEmpleado.getIdLocal());
		
		if(localLeido != null && localLeido.isActivo()) { // si existe el local y esta activo
			
			// Buscamos al empleado por dni
			TypedQuery<Empleado> empleadoLectura = em.createNamedQuery("Negocio.Empleado.Empleado.findBydni",Empleado.class);
			empleadoLectura.setParameter("dni",tEmpleado.getDni());
		
			if(empleadoLectura.getResultList().size() == 0){ // si no hay empleados con el mismo dni
				
				Empleado emp = null;
				
				if(tEmpleado instanceof TEmpleadoCompleto){ // empleado a tiempo completo
					
					emp = new EmpleadoATiempoCompleto();
					((EmpleadoATiempoCompleto) emp).setSueldoMensual(((TEmpleadoCompleto) tEmpleado).getSueldoMensual());
					
				}
				else { // empleado a tiempo parcial
					
					emp = new EmpleadoATiempoParcial();
					
					((EmpleadoATiempoParcial) emp).setSueldoPorHora(((TEmpleadoParcial) tEmpleado).getSueldoPorHora());
					((EmpleadoATiempoParcial) emp).setHoras(((TEmpleadoParcial) tEmpleado).getHoras());
				}
				
				emp.setDni(tEmpleado.getDni());
				emp.setNombre(tEmpleado.getNombre());
				emp.setApellidos(tEmpleado.getApellidos());
				emp.setActivo(true);
				emp.setLocal(localLeido);
				
				// Le damos de alta
				em.persist(emp);
				em.getTransaction().commit();
				idEmpleado = emp.getId();
				
			}
			else { // reactivar
				
				Empleado e = empleadoLectura.getSingleResult();
		
				if(!e.isActivo()){ //No esta activo
					e.setDni(tEmpleado.getDni());
					e.setNombre(tEmpleado.getNombre());
					e.setApellidos(tEmpleado.getApellidos());
					e.setLocal(localLeido);
					e.setActivo(true);
					
					if(tEmpleado instanceof TEmpleadoCompleto){
						EmpleadoATiempoCompleto eCom = (EmpleadoATiempoCompleto) empleadoLectura.getSingleResult();
						eCom.setSueldoMensual(((TEmpleadoCompleto) tEmpleado).getSueldoMensual());
					}
					else {
						EmpleadoATiempoParcial ePar = (EmpleadoATiempoParcial) empleadoLectura.getSingleResult();
						ePar.setSueldoPorHora(((TEmpleadoParcial) tEmpleado).getSueldoPorHora());
						ePar.setHoras(((TEmpleadoParcial) tEmpleado).getHoras());
					}
					
					em.getTransaction().commit();
					idEmpleado = e.getId();
					
				}
				else
					em.getTransaction().rollback();
			}
		
		}
		else { //No existe el local 
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
		
		return idEmpleado;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean bajaEmpleado(int id) {
		boolean res = false;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el empleado por id
		Empleado empleadoLectura = em.find(Empleado.class, id);
		
		//Si existe en la BBDD y esta activo
		if(empleadoLectura != null && empleadoLectura.isActivo()){ 
			empleadoLectura.setActivo(false);
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
	* @param tEmpleado
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public boolean modificarEmpleado(TEmpleado tEmpleado) {
		boolean res = false;// si devuelve -1, operacion no realizada
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Empleado emp = em.find(Empleado.class, tEmpleado.getId());
		Local localDestino = em.find(Local.class, tEmpleado.getIdLocal());
		
		if(emp != null && emp.isActivo()  // si existe el empleado y esta activo
				&& localDestino != null && localDestino.isActivo()) {  // si existe el local y esta activo
			
			//BLOQUEOS OPTIMISTAS
			
			//if los locales son diferentes, bloqueamos ambos
			//else cualquiera de los 2
			
			//Cogemos Entidad Empleado Sin bloquear el empleado
			
			//Cogemos el local del transfer y lo bloqueamos IncrementoForzado
			
			//if (Comprobamos que los locales son diferentes)
				//READBYID(empleado.getIdLocal, bloqueoIncrementoForzado)
			
			// Buscamos al empleado por dni
			TypedQuery<Empleado> empleadoLectura = em.createNamedQuery("Negocio.Empleado.Empleado.findBydni",Empleado.class);
			empleadoLectura.setParameter("dni",tEmpleado.getDni());
			
			if(empleadoLectura.getResultList().size() == 0
					|| empleadoLectura.getSingleResult().getId() == tEmpleado.getId()) { // si no hay empleados con el mismo dni
				
				emp.setNombre(tEmpleado.getNombre());
				emp.setApellidos(tEmpleado.getApellidos());
				emp.setLocal(localDestino);
				
				if(tEmpleado instanceof TEmpleadoCompleto){ // empleado a tiempo completo
					
					((EmpleadoATiempoCompleto) emp).setSueldoMensual(((TEmpleadoCompleto) tEmpleado).getSueldoMensual());
					
				}
				else { // empleado a tiempo parcial
					
					((EmpleadoATiempoParcial) emp).setSueldoPorHora(((TEmpleadoParcial) tEmpleado).getSueldoPorHora());
					((EmpleadoATiempoParcial) emp).setHoras(((TEmpleadoParcial) tEmpleado).getHoras());
				}
				
				// Actualizamos
				em.getTransaction().commit();
				res = true;
				
			} else 
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
	* @param id
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleado mostrarEmpleado(int id) {
		// begin-user-code
		// TODO Auto-generated method stub
		TEmpleado tEmp = null;
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Buscamos el empleado
		Empleado emp = em.find(Empleado.class, id);
		
		if (emp != null) {
			if(emp instanceof EmpleadoATiempoCompleto) { //Empleado a tiempo completo
				tEmp = new TEmpleadoCompleto();
				((TEmpleadoCompleto) tEmp).setSueldoMensual(((EmpleadoATiempoCompleto) em).getSueldoMensual());
				
			} else { //Empleado a tiempo parcial
				tEmp = new TEmpleadoParcial();
				((TEmpleadoParcial) tEmp).setSueldoPorHora(((EmpleadoATiempoParcial) emp).getSueldoPorHora());
				((TEmpleadoParcial) tEmp).setHoras(((EmpleadoATiempoParcial) emp).getHoras());
			}
			
			tEmp.setId(emp.getId());
			tEmp.setNombre(emp.getNombre());
			tEmp.setApellidos(emp.getApellidos());
			tEmp.setDni(emp.getDni());
			tEmp.setActivo(emp.isActivo());
			tEmp.setIdLocal(emp.getLocal().getId());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return tEmp;
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public ArrayList<TEmpleado> listarEmpleados() {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<TEmpleado> empleados = new ArrayList<TEmpleado>();
		
		//Iniciamos la transaccion
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("fowlersfood");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Buscamos el empleado
		TypedQuery<Empleado> empleadosLeidos = em.createQuery("SELECT obj FROM empleado obj", Empleado.class);
		
		
		for(Empleado emp : empleadosLeidos.getResultList()) {
			TEmpleado tEmp = null;
			if (emp instanceof EmpleadoATiempoCompleto) { //Empleado a tiempo completo
				tEmp = new TEmpleadoCompleto(emp.getId(), emp.getDni(), emp.getNombre(), emp.getApellidos(), 
						emp.getLocal().getId(), ((EmpleadoATiempoCompleto) emp).getSueldoMensual(), emp.isActivo());
			}
			else { //Empleado a tiempo parcial
				tEmp = new TEmpleadoParcial(emp.getId(), emp.getDni(), emp.getNombre(), emp.getApellidos(), 
						emp.getLocal().getId(), emp.isActivo(),((EmpleadoATiempoParcial) emp).getHoras(),
						((EmpleadoATiempoParcial) emp).getSueldoPorHora());
			}
			empleados.add(tEmp);
		}
		
		return empleados;
		// end-user-code
	}
}