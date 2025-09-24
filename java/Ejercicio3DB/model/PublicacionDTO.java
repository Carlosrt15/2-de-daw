package model;

public class PublicacionDTO {
    private String idpublicacion;
    private String titulo;
    private String autor;
    private int nroedicion;
    private double precio;
    private int stock;
    private String idtipo;
    private String descripcionTipo;   // <--- NUEVO CAMPO

    public PublicacionDTO(String idpublicacion, String titulo, String autor,
                          int nroedicion, double precio, int stock,
                          String idtipo) {
        this.idpublicacion = idpublicacion;
        this.titulo = titulo;
        this.autor = autor;
        this.nroedicion = nroedicion;
        this.precio = precio;
        this.stock = stock;
        this.idtipo = idtipo;
    }

    // --- NUEVO getter / setter ---
    public String getDescripcionTipo() {
        return descripcionTipo;
    }
    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    // ... (resto de getters/setters)

    @Override
    public String toString() {
        return "PublicacionDTO [idpublicacion=" + idpublicacion +
                ", titulo=" + titulo +
                ", autor=" + autor +
                ", nroedicion=" + nroedicion +
                ", precio=" + precio +
                ", stock=" + stock +
                ", idtipo=" + idtipo +
                ", tipo=" + descripcionTipo + "]";
    }
}
