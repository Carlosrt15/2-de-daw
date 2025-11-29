package dto;

public class FaltasDTO {
    private int idfaltas;
    private int alumno;
    private int asignatura;
    private String fecha;
    private int justificada;

    public FaltasDTO(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
        this.idfaltas = idfaltas;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha = fecha;
        this.justificada = justificada;
    }

    public int getIdfaltas() { return idfaltas; }
    public int getAlumno() { return alumno; }
    public int getAsignatura() { return asignatura; }
    public String getFecha() { return fecha; }
    public int getJustificada() { return justificada; }

    public void setIdfaltas(int idfaltas) { this.idfaltas = idfaltas; }
    public void setAlumno(int alumno) { this.alumno = alumno; }
    public void setAsignatura(int asignatura) { this.asignatura = asignatura; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setJustificada(int justificada) { this.justificada = justificada; }
}
