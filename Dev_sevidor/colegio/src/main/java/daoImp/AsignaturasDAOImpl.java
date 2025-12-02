package daoImp;

import java.sql.*;
import java.util.ArrayList;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import utils.DBUtils;

public class AsignaturasDAOImpl implements IAsignaturasDAO {

    // ==========================================
    // MÉTODO QUE YA TENÍAS (NO SE TOCA)
    // ==========================================
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

    // ==========================================
    // CRUD DE ASIGNATURAS
    // ==========================================

    @Override
    public ArrayList<AsignaturaDTO> buscarAsignaturas(
            String id, String nombre, String curso, String tasaMayorQue, String activo) {

        ArrayList<AsignaturaDTO> lista = new ArrayList<>();

        String sql = "SELECT * FROM asignaturas WHERE "
                + "id LIKE ? AND "
                + "nombre LIKE ? AND "
                + "curso LIKE ? AND "
                + "tasa >= ? AND "
                + "activo LIKE ?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + id + "%");
            ps.setString(2, "%" + nombre + "%");
            ps.setString(3, "%" + curso + "%");
            ps.setString(4, tasaMayorQue.equals("") ? "0" : tasaMayorQue);
            ps.setString(5, "%" + activo + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new AsignaturaDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("curso"),
                        rs.getDouble("tasa"),
                        rs.getInt("activo")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public int insertarAsignatura(String id, String nombre, int curso, double tasa, int activo) {
        String sql = "INSERT INTO asignaturas (id, nombre, curso, tasa, activo) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, nombre);
            ps.setInt(3, curso);
            ps.setDouble(4, tasa);
            ps.setInt(5, activo);

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int actualizarAsignatura(String id, String nombre, int curso, double tasa, int activo) {
        String sql = "UPDATE asignaturas SET nombre=?, curso=?, tasa=?, activo=? WHERE id=?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, curso);
            ps.setDouble(3, tasa);
            ps.setInt(4, activo);
            ps.setInt(5, Integer.parseInt(id));

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int borrarAsignatura(String id) {
        String sql = "UPDATE asignaturas SET activo = 0 WHERE id=?";

        try (Connection con = DBUtils.conexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(id));
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
