package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.FaltasDTO;

public interface IFaltasService {
	
	ArrayList<FaltasDTO> obtenerTodasFaltas() throws SQLException;
	ArrayList<FaltasDTO> obtenerFaltaPorFecha(int idfaltas, int alumno, int asignatura, String fecha, int justificada);
	int insertarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada);
	int borrarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada);
	int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada);

}
