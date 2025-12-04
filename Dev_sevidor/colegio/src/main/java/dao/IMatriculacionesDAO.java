package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MatriculacionDTO;

public interface IMatriculacionesDAO {
    int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException;
    MatriculacionDTO buscarPorId(String idMatricula);

    ArrayList<MatriculacionDTO> listarMatriculaciones();
    
    int modificarMatriculacion(String idMatricula, String idAsignatura, String fecha, String tasa);
    int borrarMatriculacion(String idMatricula);


}
