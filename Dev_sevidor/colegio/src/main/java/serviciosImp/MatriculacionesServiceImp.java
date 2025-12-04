package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IMatriculacionesDAO;
import daoImp.MatriculacionesDAOImpl;
import dto.MatriculacionDTO;
import servicios.IMatriculacionesService;

public class MatriculacionesServiceImp implements IMatriculacionesService {

    @Override
    public double calcularTasa(String idAlumno, String idAsignatura) {
        
        return 0;
    }

    @Override
    public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) {
        IMatriculacionesDAO dao = new MatriculacionesDAOImpl();
        try {
            return dao.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public ArrayList<MatriculacionDTO> listarMatriculaciones() {
        return new MatriculacionesDAOImpl().listarMatriculaciones();
    }

    @Override
    public MatriculacionDTO buscarPorId(String idMatricula) {
        return new MatriculacionesDAOImpl().buscarPorId(idMatricula);
    }

    @Override
    public int modificarMatriculacion(String idMatricula, String idAsignatura, String fecha, String tasa) {
        return new MatriculacionesDAOImpl().modificarMatriculacion(idMatricula, idAsignatura, fecha, tasa);
    }

    @Override
    public int borrarMatriculacion(String idMatricula) {
        return new MatriculacionesDAOImpl().borrarMatriculacion(idMatricula);
    }
}
