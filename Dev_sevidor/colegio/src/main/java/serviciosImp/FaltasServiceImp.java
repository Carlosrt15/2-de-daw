package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IFaltasDAO;
import dto.FaltasDTO;
import servicios.IFaltasService;

public class FaltasServiceImp  implements IFaltasService {
	
	@Override
	public ArrayList<FaltasDTO> obtenerFaltas() throws SQLException {
		IFaltasDAO faltas = new FaltasDAOImpl();
		
		return faltas.obtenerTodasFaltas(); 
		
	}
	
	@Override
	public  ArrayList<FaltasDTO> obtenerFaltasPorFecha(int idfaltas, int alumno, int asignatura, String fecha, int justificada);
	IFaltasDAO faltas = new FaltasDAOImpl();

}
