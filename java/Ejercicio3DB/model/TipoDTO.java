package model;

public class TipoDTO {
    private String id;
    private String descripcion;

    // Constructor
    public TipoDTO(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return "TipoDTO{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
