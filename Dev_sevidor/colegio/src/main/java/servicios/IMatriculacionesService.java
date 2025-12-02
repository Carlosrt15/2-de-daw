package servicios;

import java.util.ArrayList;
import dto.MatriculacionDTO;

public interface IMatriculacionesService {

    double calcularTasa(String idAlumno, String idAsignatura);

    int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa);

    ArrayList<MatriculacionDTO> listarMatriculaciones();

    int modificarMatriculacion(String idMatricula, String idAsignatura, String fecha, String tasa);

    int borrarMatriculacion(String idMatricula);
}
