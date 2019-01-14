package Negocio.Asociacion;

import Negocio.Local.TLocal;
import Negocio.Seccion.TSeccion;

public class TAsociacionCompleta {
	
	TAsociacion asociacion;
	TLocal local;
	TSeccion seccion;
	
	public TAsociacionCompleta() {}
	
	TAsociacionCompleta(TAsociacion a, TLocal l, TSeccion s) {
		this.asociacion = a;
		this.local = l;
		this.seccion = s;
	}
	
	public TLocal getLocal() {
		return local;
	}
	
	public void setLocal(TLocal local) {
		this.local = local;
	}
	
	public TSeccion getSeccion() {
		return seccion;
	}
	
	public void setSeccion(TSeccion seccion) {
		this.seccion = seccion;
	}
	
	public TAsociacion getAsociacion() {
		return asociacion;
	}
	
	public void setAsociacion(TAsociacion asociacion) {
		this.asociacion = asociacion;
	}
}
