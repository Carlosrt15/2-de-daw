package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IFaltasDAO;
import daoImp.FaltasDAOImpl;
import dto.FaltasDTO;
import servicios.IFaltasService;

public class FaltasServiceImp implements IFaltasService {

	private IFaltasDAO faltasDao = new FaltasDAOImpl();

	@Override
	public ArrayList<FaltasDTO> obtenerTodasFaltas() throws SQLException {
		return faltasDao.obtenerTodasFaltas();
	}

	@Override
	public ArrayList<FaltasDTO> obtenerFaltaPorFecha(int idfaltas, int alumno, int asignatura, String fecha,
			int justificada) {
		return faltasDao.obtenerFaltaPorFecha(idfaltas, alumno, asignatura, fecha, justificada);
	}

	@Override
	public int insertarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
		return faltasDao.insertarFalta(idfaltas, alumno, asignatura, fecha, justificada);
	}

	@Override
	public int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
		return faltasDao.actualizarFalta(idfaltas, alumno, asignatura, fecha, justificada);
	}

	@Override
	public int borrarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
		return faltasDao.borrarFalta(idfaltas, alumno, asignatura, fecha, justificada);
	}
}
