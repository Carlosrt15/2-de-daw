package serviciosImp;

import java.util.ArrayList;
import dao.IFaltasDAO;
import daoImp.FaltasDAOImpl;
import dto.FaltasDTO;
import servicios.IFaltasService;

public class FaltasServiceImp implements IFaltasService {

    private IFaltasDAO dao = new FaltasDAOImpl();

    public ArrayList<FaltasDTO> obtenerTodasFaltas() {
        return dao.obtenerTodasFaltas();
    }

    public int insertarFalta(int alumno, int asignatura, String fecha, int justificada) {
        return dao.insertarFalta(alumno, asignatura, fecha, justificada);
    }

    public int borrarFalta(int idfaltas) {
        return dao.borrarFalta(idfaltas);
    }

    public int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
        return dao.actualizarFalta(idfaltas, alumno, asignatura, fecha, justificada);
    }

    public FaltasDTO obtenerFaltaPorId(int idfaltas) {
        return dao.obtenerFaltaPorId(idfaltas);
    }
}
