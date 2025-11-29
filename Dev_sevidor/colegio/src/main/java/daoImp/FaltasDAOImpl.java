package daoImp;

import java.sql.*;
import java.util.ArrayList;
import dao.IFaltasDAO;
import dto.FaltasDTO;
import utils.DBUtils;

public class FaltasDAOImpl implements IFaltasDAO {

    @Override
    public ArrayList<FaltasDTO> obtenerTodasFaltas() {
        ArrayList<FaltasDTO> lista = new ArrayList<>();

        try (Connection connection = DBUtils.conexion();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM faltas")) {

            while (rs.next()) {
                lista.add(new FaltasDTO(
                        rs.getInt("idfaltas"),
                        rs.getInt("alumno"),
                        rs.getInt("asignatura"),
                        rs.getString("fecha"),
                        rs.getInt("justificada")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public int insertarFalta(int alumno, int asignatura, String fecha, int justificada) {
        String sql = "INSERT INTO faltas (alumno, asignatura, fecha, justificada) VALUES (?, ?, ?, ?)";
        int resultado = 0;

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, alumno);
            ps.setInt(2, asignatura);
            ps.setString(3, fecha);
            ps.setInt(4, justificada);

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int borrarFalta(int idfaltas) {
        String sql = "DELETE FROM faltas WHERE idfaltas = ?";
        int resultado = 0;

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idfaltas);
            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {
        String sql = "UPDATE faltas SET alumno=?, asignatura=?, fecha=?, justificada=? WHERE idfaltas=?";
        int resultado = 0;

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, alumno);
            ps.setInt(2, asignatura);
            ps.setString(3, fecha);
            ps.setInt(4, justificada);
            ps.setInt(5, idfaltas);

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public FaltasDTO obtenerFaltaPorId(int idfaltas) {
        String sql = "SELECT * FROM faltas WHERE idfaltas=?";
        FaltasDTO falta = null;

        try (Connection connection = DBUtils.conexion();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idfaltas);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                falta = new FaltasDTO(
                        rs.getInt("idfaltas"),
                        rs.getInt("alumno"),
                        rs.getInt("asignatura"),
                        rs.getString("fecha"),
                        rs.getInt("justificada")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return falta;
    }
}
