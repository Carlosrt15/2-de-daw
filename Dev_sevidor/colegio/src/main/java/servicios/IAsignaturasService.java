package servicios;

import java.util.ArrayList;
import dto.AsignaturaDTO;

public interface IAsignaturasService {

    ArrayList<AsignaturaDTO> buscarAsignaturas(
            String id, 
            String nombre, 
            String curso, 
            String tasaMayorQue, 
            String activo
    );

    int insertarAsignatura(String id, String nombre, int curso, double tasa, int activo);

    int actualizarAsignatura(String id, String nombre, int curso, double tasa, int activo);

    int borrarAsignatura(String id);
}
