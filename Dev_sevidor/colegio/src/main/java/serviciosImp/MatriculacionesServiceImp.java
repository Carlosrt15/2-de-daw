package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAlumnosDAO;
import dao.IAsignaturasDAO;
import dao.IMatriculacionesDAO;
import daoImp.AlumnosDAOImpl;
import daoImp.AsignaturasDAOImpl;
import daoImp.MatriculacionesDAOImpl;
import dto.MatriculacionDTO;
import servicios.IMatriculacionesService;

public class MatriculacionesServiceImp implements IMatriculacionesService {

    @Override
    public double calcularTasa(String idAlumno, String idAsignatura) {

        IAsignaturasDAO asignaturasDAO = new AsignaturasDAOImpl();
        IAlumnosDAO alumnosDAO = new AlumnosDAOImpl();

        double tasaBase = asignaturasDAO.obtenerTasaAsignatura(idAsignatura);
        int numAsignaturas = alumnosDAO.contarAsignaturasMatriculadas(idAlumno);
        boolean esFN = alumnosDAO.esFamiliaNumerosa(idAlumno);

        double tasaFinal = tasaBase;

        if (numAsignaturas >= 3 && numAsignaturas <= 5) {
            tasaFinal *= 0.7;
        } else if (numAsignaturas >= 6) {
            tasaFinal *= 0.5;
        }

        if (esFN) {
            tasaFinal *= 0.5;
        }

        return tasaFinal;
    }

    @Override
    public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) {
        IMatriculacionesDAO dao = new MatriculacionesDAOImpl();
        try {
            return dao.insertarMatriculacion(idAsignatura, idAlumno, fecha, tasa);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<MatriculacionDTO> listarMatriculaciones() {
        IMatriculacionesDAO dao = new MatriculacionesDAOImpl();
        return dao.listarMatriculaciones();
    }

    @Override
    public int modificarMatriculacion(String idMatricula, String idAsignatura, String fecha, String tasa) {
        IMatriculacionesDAO dao = new MatriculacionesDAOImpl();
        return dao.modificarMatriculacion(idMatricula, idAsignatura, fecha, tasa);
    }

    @Override
    public int borrarMatriculacion(String idMatricula) {
        IMatriculacionesDAO dao = new MatriculacionesDAOImpl();
        return dao.borrarMatriculacion(idMatricula);
    }
}
