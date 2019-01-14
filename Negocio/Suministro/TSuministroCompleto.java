package Negocio.Suministro;

import Negocio.Producto.TProducto;
import Negocio.Proveedor.TProveedor;

public class TSuministroCompleto {

	
	TSuministro suministro;
	TProveedor proveedor;
	TProducto producto;
	
	
	public TSuministroCompleto() { }
	
	public TSuministroCompleto(TSuministro suministro,TProveedor proveedor, TProducto producto) {
		this.suministro = suministro;
		this.proveedor = proveedor;
		this.producto = producto;
	}

	public TSuministro getTSuministro() {
		return suministro;
	}

	public void setTSuministro(TSuministro suministro) {
		this.suministro = suministro;
	}

	public TProveedor getTProveedor() {
		return proveedor;
	}

	public void setTProveedor(TProveedor proveedor) {
		this.proveedor = proveedor;
	}

	public TProducto getTProducto() {
		return producto;
	}

	public void setTProducto(TProducto producto) {
		this.producto = producto;
	}
	
	
	@Override
	public String toString() {
		return "TSuministroCompleto [suministro=" + suministro + ", "
				+ "proveedor=" + proveedor + ","
				+ " producto=" + producto
				+ "]";
	}
	
	
	
	
}
