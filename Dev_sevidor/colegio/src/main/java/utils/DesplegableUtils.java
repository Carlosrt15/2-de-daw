package utils;

import java.util.ArrayList;

import dao.IDesplegableDAO;
import daoImp.DesplegableDAOImp;
import dto.DesplegableDTO;
import jakarta.servlet.http.HttpServletRequest;

public class DesplegableUtils {
    
    public static void recuperarDesplegableMunicipios(HttpServletRequest request) {
        IDesplegableDAO desplegableMunicipios = new DesplegableDAOImp();
        ArrayList<DesplegableDTO> listaMunicipios = desplegableMunicipios.desplegableMunicipios();
        request.setAttribute("desplegableMunicipios", listaMunicipios);
    }

    // NUEVO: DESPLEGABLE ALUMNOS
    public static void recuperarDesplegableAlumnos(HttpServletRequest request) {
        IDesplegableDAO dao = new DesplegableDAOImp();
        ArrayList<DesplegableDTO> listaAlumnos = dao.desplegableAlumnos();
        request.setAttribute("desplegableAlumnos", listaAlumnos);
    }

    // NUEVO: DESPLEGABLE ASIGNATURAS
    public static void recuperarDesplegableAsignaturas(HttpServletRequest request) {
        IDesplegableDAO dao = new DesplegableDAOImp();
        ArrayList<DesplegableDTO> listaAsignaturas = dao.desplegableAsignaturas();
        request.setAttribute("desplegableAsignaturas", listaAsignaturas);
    }
}
