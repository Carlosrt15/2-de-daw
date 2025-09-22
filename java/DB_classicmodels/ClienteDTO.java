
public class ClienteDTO {
	private String nombre;
	private String phone;
	private String city;
	
	
	public ClienteDTO(String nombre, String phone, String city) {
		super();
		this.nombre = nombre;
		this.phone = phone;
		this.city = city;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	
	
	
	@Override
	public String toString() {
		return "ClienteDTO [nombre=" + nombre + ", phone=" + phone + ", city=" + city + "]";
	}
}
