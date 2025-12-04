package daoImp;

import java.sql.*;
import java.util.ArrayList;

import dao.IMatriculacionesDAO;
import dto.MatriculacionDTO;
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

            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int idMatricula = rs.getInt(1);

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, idMatricula);
            ps2.setString(2, tasa);
            ps2.executeUpdate();

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

    @Override
    public ArrayList<MatriculacionDTO> listarMatriculaciones() {

        String sql = "SELECT m.id AS idmatricula, a.nombre AS alumno, asig.nombre AS asignatura, "
                   + "m.fecha, c.importe, m.activo "
                   + "FROM matriculaciones m "
                   + "LEFT JOIN alumnos a ON m.id_alumno = a.id "
                   + "LEFT JOIN asignaturas asig ON m.id_asignatura = asig.id "
                   + "LEFT JOIN caja c ON c.idmatricula = m.id "
                   + "ORDER BY m.id DESC";

        ArrayList<MatriculacionDTO> lista = new ArrayList<>();

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new MatriculacionDTO(
                        rs.getInt("idmatricula"),
                        rs.getString("alumno"),
                        rs.getString("asignatura"),
                        rs.getString("fecha"),
                        rs.getDouble("importe"),
                        rs.getInt("activo")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public MatriculacionDTO buscarPorId(String idMatricula) {

        String sql = "SELECT m.id AS idmatricula, a.nombre AS alumno, asig.nombre AS asignatura, "
                   + "m.fecha, c.importe, m.activo "
                   + "FROM matriculaciones m "
                   + "LEFT JOIN alumnos a ON m.id_alumno = a.id "
                   + "LEFT JOIN asignaturas asig ON m.id_asignatura = asig.id "
                   + "LEFT JOIN caja c ON c.idmatricula = m.id "
                   + "WHERE m.id = ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idMatricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new MatriculacionDTO(
                        rs.getInt("idmatricula"),
                        rs.getString("alumno"),
                        rs.getString("asignatura"),
                        rs.getString("fecha"),
                        rs.getDouble("importe"),
                        rs.getInt("activo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int modificarMatriculacion(String idMatricula, String idAsignatura, String fecha, String tasa) {

        String sql1 = "UPDATE matriculaciones SET id_asignatura = ?, fecha = ? WHERE id = ?";
        String sql2 = "UPDATE caja SET importe = ? WHERE idmatricula = ?";

        Connection con = DBUtils.conexion();

        try {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, idAsignatura);
            ps1.setString(2, fecha);
            ps1.setString(3, idMatricula);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, tasa);
            ps2.setString(2, idMatricula);
            ps2.executeUpdate();

            con.commit();
            return 1;

        } catch (SQLException e) {
            try { con.rollback(); } catch (SQLException ex) {}
            return 0;

        } finally {
            try { con.setAutoCommit(true); con.close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public int borrarMatriculacion(String idMatricula) {

        String sql = "UPDATE matriculaciones SET activo = 0 WHERE id = ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int id = Integer.parseInt(idMatricula.trim());
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            System.out.println("DEBUG DAO borrarMatriculacion → filas afectadas: " + filas);
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
