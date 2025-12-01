package dao;

import java.sql.SQLException;

public interface IMatriculacionesDAO {
    int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException;
}
