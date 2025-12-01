package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import dao.IAsignaturasDAO;
import utils.DBUtils;

public class AsignaturasDAOImpl implements IAsignaturasDAO {

    @Override
    public double obtenerTasaAsignatura(String idAsignatura) {
        String sql = "SELECT tasa FROM asignaturas WHERE id = ? AND activo = 1";
        double tasa = 0;

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, idAsignatura);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tasa = rs.getDouble("tasa");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasa;
    }
}
