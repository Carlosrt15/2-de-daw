package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IMatriculacionesDAO;
import utils.DBUtils;

public class MatriculacionesDAOImpl implements IMatriculacionesDAO {

    @Override
    public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa)
            throws SQLException {

        String sql1 = "INSERT INTO matriculaciones (id_asignatura, id_alumno, fecha, activo) VALUES (?, ?, ?, 1)";
        String sql2 = "INSERT INTO caja (idmatricula, importe) VALUES (?, ?)";

        Connection con = DBUtils.conexion();
        con.setAutoCommit(false);

        try {
            
            PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, idAsignatura);
            ps1.setString(2, idAlumno);
            ps1.setString(3, fecha);

            if (ps1.executeUpdate() == 0) {
                throw new SQLException("Error insertando matriculación");
            }

            ResultSet rs = ps1.getGeneratedKeys();
            if (!rs.next()) throw new SQLException("No se generó ID de matriculación");
            int idMatriculacion = rs.getInt(1);

           
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, idMatriculacion);
            ps2.setString(2, tasa);

            if (ps2.executeUpdate() == 0) {
                throw new SQLException("Error insertando caja");
            }

            con.commit();
            return 1;

        } catch (SQLException e) {
            con.rollback();
            throw e;

        } finally {
            con.setAutoCommit(true);
            con.close();
        }
    }
}

