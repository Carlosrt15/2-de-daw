package servicios;

import java.util.ArrayList;
import dto.FaltasDTO;

public interface IFaltasService {
    ArrayList<FaltasDTO> obtenerTodasFaltas();
    int insertarFalta(int alumno, int asignatura, String fecha, int justificada);
    int borrarFalta(int idfaltas);
    int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada);
    FaltasDTO obtenerFaltaPorId(int idfaltas);
}
