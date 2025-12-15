package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IFaltasDAO;
import daoImp.Hib.FaltasDAOImplHib;
import dto.FaltaDTO;
import servicios.IFaltasService;

public class FaltasServiceImp implements IFaltasService {

    private IFaltasDAO faltasDAO = new FaltasDAOImplHib();

    @Override
    public ArrayList<FaltaDTO> obtenerFaltas() throws SQLException {
        return faltasDAO.obtenerTodasFaltas();
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltros(
            String nombreAlumno, String asignatura, String fecha, int justificada) {

        return faltasDAO.obtenerFaltasPorFiltros(nombreAlumno, asignatura, fecha, justificada);
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltrosSinFecha(
            String nombreAlumno, String asignatura, int justificada) {

        return faltasDAO.obtenerFaltasPorFiltrosSinFecha(nombreAlumno, asignatura, justificada);
    }

    @Override
    public int insertarFalta(String idAlumno, String idAsignatura, String fecha, int justificada) {
        return faltasDAO.insertarFalta(idAlumno, idAsignatura, fecha, justificada);
    }

    @Override
    public int actualizarFalta(
            String idFalta, String idAlumno, String idAsignatura, String fecha, int justificada) {

        return faltasDAO.actualizarFalta(idFalta, idAlumno, idAsignatura, fecha, justificada);
    }

    @Override
    public int borrarFalta(String idFalta) {
        return faltasDAO.borrarFalta(idFalta);
    }
}
