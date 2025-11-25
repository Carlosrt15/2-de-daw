package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IFaltasDAO;
import dto.FaltasDTO;
import utils.DBUtils;

public class FaltasDAOImpl implements IFaltasDAO {

    private static Logger logger = LoggerFactory.getLogger(FaltasDAOImpl.class);

    @Override
    public ArrayList<FaltasDTO> obtenerTodasFaltas() {

        Connection connection = DBUtils.conexion();
        ArrayList<FaltasDTO> lista = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM faltas");

            while (rs.next()) {
                lista.add(new FaltasDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }

            connection.close();

        } catch (Exception e) {
            logger.error("Error en obtenerTodasFaltas()", e);
        }

        return lista;
    }

    @Override
    public ArrayList<FaltasDTO> obtenerFaltaPorFecha(int idfaltas, int alumno, int asignatura, String fecha,
            int justificada) {

        ArrayList<FaltasDTO> lista = new ArrayList<>();

        String sql = "SELECT * FROM faltas WHERE 1=1";

        if (idfaltas != 0)
            sql += " AND idfaltas = " + idfaltas;
        if (alumno != 0)
            sql += " AND alumno = " + alumno;
        if (asignatura != 0)
            sql += " AND asignatura = " + asignatura;
        if (fecha != null && !fecha.isEmpty())
            sql += " AND fecha >= '" + fecha + "'";
        if (justificada != -1)
            sql += " AND justificada = " + justificada;

        logger.debug("Query a ejecutar: " + sql);

        try {
            Connection connection = DBUtils.conexion();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new FaltasDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }

            connection.close();

        } catch (Exception e) {
            logger.error("Error en obtenerFaltaPorFecha()", e);
        }

        return lista;
    }

    @Override
    public int insertarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {

        String sql = "INSERT INTO faltas (alumno, asignatura, fecha, justificada) VALUES (?, ?, ?, ?)";
        int resultado = 0;

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, alumno);
            ps.setInt(2, asignatura);
            ps.setString(3, fecha);
            ps.setInt(4, justificada);

            resultado = ps.executeUpdate();
            connection.close();

        } catch (Exception e) {
            logger.error("Error en insertarFalta()", e);
        }

        return resultado;
    }

    @Override
    public int borrarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {

        String sql = "DELETE FROM faltas WHERE idfaltas = ?";
        int resultado = 0;

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idfaltas);

            resultado = ps.executeUpdate();
            connection.close();

        } catch (Exception e) {
            logger.error("Error en borrarFalta()", e);
        }

        return resultado;
    }

    @Override
    public int actualizarFalta(int idfaltas, int alumno, int asignatura, String fecha, int justificada) {

        String sql = "UPDATE faltas SET alumno=?, asignatura=?, fecha=?, justificada=? WHERE idfaltas=?";
        int resultado = 0;

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, alumno);
            ps.setInt(2, asignatura);
            ps.setString(3, fecha);
            ps.setInt(4, justificada);
            ps.setInt(5, idfaltas);

            resultado = ps.executeUpdate();
            connection.close();

        } catch (Exception e) {
            logger.error("Error en actualizarFalta()", e);
        }

        return resultado;
    }
}
