
public class ClienteDTO {
	private String nombre;
	private String phone;
	public ClienteDTO(String nombre, String phone) {
		super();
		this.nombre = nombre;
		this.phone = phone;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ClienteDTO [nombre=" + nombre + ", phone=" + phone + "]";
	}
	
}
