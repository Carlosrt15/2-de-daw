package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IDesplegableDAO;
import dto.DesplegableDTO;
import utils.DBUtils;

public class DesplegableDAOImp implements IDesplegableDAO {

    @Override
    public ArrayList<DesplegableDTO> desplegableMunicipios() {
        String sql = "SELECT id_municipio, nombre FROM municipios ORDER BY nombre";
        ArrayList<DesplegableDTO> lista = new ArrayList<>();

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new DesplegableDTO(
                        rs.getInt("id_municipio"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<DesplegableDTO> desplegableAlumnos() {
        String sql = "SELECT id, CONCAT(nombre, ' ', apellidos) AS descripcion FROM alumnos WHERE activo = 1 ORDER BY nombre";
        ArrayList<DesplegableDTO> lista = new ArrayList<>();

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new DesplegableDTO(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<DesplegableDTO> desplegableAsignaturas() {
        String sql = "SELECT id, nombre AS descripcion FROM asignaturas WHERE activo = 1 ORDER BY nombre";
        ArrayList<DesplegableDTO> lista = new ArrayList<>();

        try {
            Connection connection = DBUtils.conexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new DesplegableDTO(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
