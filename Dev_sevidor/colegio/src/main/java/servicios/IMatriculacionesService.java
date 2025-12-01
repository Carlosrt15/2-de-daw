package servicios;

public interface IMatriculacionesService {
    double calcularTasa(String idAlumno, String idAsignatura);
    int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa);
}
