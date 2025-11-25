package dto;

public class FaltasDTO {
	private int idfaltas;
	private int alumno;
	private int asignatura;
	private String fecha;
	private int jusftificada;

	public FaltasDTO(int idfaltas, int alumno, int asignatura, String fecha, int jusftificada) {
		super();
		this.idfaltas = idfaltas;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.fecha = fecha;
		this.jusftificada = jusftificada;
	}

	public int getIdfaltas() {
		return idfaltas;
	}

	public void setIdfaltas(int idfaltas) {
		this.idfaltas = idfaltas;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public int getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getJusftificada() {
		return jusftificada;
	}

	public void setJusftificada(int jusftificada) {
		this.jusftificada = jusftificada;
	}

}
