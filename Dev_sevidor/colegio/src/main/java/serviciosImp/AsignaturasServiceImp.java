package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImp.Hib.AsignaturaDAOImplHib;

import dto.AsignaturaDTO;
import servicios.IAsignaturasService;

public class AsignaturasServiceImp implements IAsignaturasService {

	// camvio esto por el hib
   
    private IAsignaturasDAO asignaturasDAO = new AsignaturaDAOImplHib();

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
        return asignaturasDAO.obtenerTodasAsignaturas();
    }

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa,
            int activo) {
        return asignaturasDAO.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
    }

    @Override
    public int insertarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        return asignaturasDAO.insertarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        return asignaturasDAO.actualizarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int borrarAsignatura(String id) {
        return asignaturasDAO.borrarAsignatura(id);
    }
}
