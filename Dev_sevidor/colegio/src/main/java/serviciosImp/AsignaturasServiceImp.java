package serviciosImp;

import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImp.AsignaturasDAOImpl;
import dto.AsignaturaDTO;
import servicios.IAsignaturasService;

public class AsignaturasServiceImp implements IAsignaturasService {

    @Override
    public ArrayList<AsignaturaDTO> buscarAsignaturas(String id, String nombre, String curso, String tasaMayorQue, String activo) {
        IAsignaturasDAO dao = new AsignaturasDAOImpl();
        return dao.buscarAsignaturas(id, nombre, curso, tasaMayorQue, activo);
    }

    @Override
    public int insertarAsignatura(String id, String nombre, int curso, double tasa, int activo) {
        IAsignaturasDAO dao = new AsignaturasDAOImpl();
        return dao.insertarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int actualizarAsignatura(String id, String nombre, int curso, double tasa, int activo) {
        IAsignaturasDAO dao = new AsignaturasDAOImpl();
        return dao.actualizarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int borrarAsignatura(String id) {
        IAsignaturasDAO dao = new AsignaturasDAOImpl();
        return dao.borrarAsignatura(id);
    }
}
