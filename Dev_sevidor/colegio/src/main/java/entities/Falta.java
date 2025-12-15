package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "faltas")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfaltas")
    private int idfaltas;

    @Column(name = "alumno")
    private int alumno;

    @Column(name = "asignatura")
    private int asignatura;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "justificada")
    private int justificada;

    public Falta() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getJustificada() {
        return justificada;
    }

    public void setJustificada(int justificada) {
        this.justificada = justificada;
    }
}
