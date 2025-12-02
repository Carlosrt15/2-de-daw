package dto;



public class MatriculacionDTO {

    private int id;
    private String alumno;
    private String asignatura;
    private String fecha;
    private double importe;
    private int activo;

    public MatriculacionDTO(int id, String alumno, String asignatura, String fecha, double importe, int activo) {
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fecha = fecha;
        this.importe = importe;
        this.activo = activo;
    }

    public int getId() { return id; }
    public String getAlumno() { return alumno; }
    public String getAsignatura() { return asignatura; }
    public String getFecha() { return fecha; }
    public double getImporte() { return importe; }
    public int getActivo() { return activo; }

}
