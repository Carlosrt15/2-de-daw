package model;

public class VentaDTO {
    private int idventa;
    private String cliente;
    private String fecha;
    private int idempleado;
    private String idpublicacion;
    private int cantidad;
    private double precio;
    private double dcto;
    private double impuesto;
    
	public VentaDTO(int idventa, String cliente, String fecha, int idempleado, String idpublicacion, int cantidad,
			double precio, double dcto, double impuesto) {
		super();
		this.idventa = idventa;
		this.cliente = cliente;
		this.fecha = fecha;
		this.idempleado = idempleado;
		this.idpublicacion = idpublicacion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.dcto = dcto;
		this.impuesto = impuesto;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(String idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDcto() {
		return dcto;
	}

	public void setDcto(double dcto) {
		this.dcto = dcto;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	@Override
	public String toString() {
		return "VentaDTO [idventa=" + idventa + ", cliente=" + cliente + ", fecha=" + fecha + ", idempleado="
				+ idempleado + ", idpublicacion=" + idpublicacion + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", dcto=" + dcto + ", impuesto=" + impuesto + "]";
	}

	

}
