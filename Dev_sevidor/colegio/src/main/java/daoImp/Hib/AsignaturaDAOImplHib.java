package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.IAsignaturasDAO;
import dto.AsignaturaDTO;
import entities.Asignatura;
import utils.DBUtils;

public class AsignaturaDAOImplHib implements IAsignaturasDAO {

    private AsignaturaDTO convertir(Asignatura a) {
        return new AsignaturaDTO(
                a.getId(),
                a.getNombre(),
                a.getCurso() != null ? String.valueOf(a.getCurso()) : "",
                a.getTasa() != null ? a.getTasa() : 0.0,
                a.getActivo()
        );
    }

    @Override
    public ArrayList<AsignaturaDTO> obtenerTodasAsignaturas() {
        ArrayList<AsignaturaDTO> resultado = new ArrayList<>();

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {

            List<Asignatura> lista = session.createQuery("FROM Asignatura", Asignatura.class).getResultList();

            for (Asignatura a : lista) {
                resultado.add(convertir(a));
            }
        }

        return resultado;
    }

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa, int activo) {

        ArrayList<AsignaturaDTO> resultado = new ArrayList<>();

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {

            String hql = "FROM Asignatura a WHERE 1=1";

            if (id != null && !id.isEmpty()) hql += " AND a.id = :id";
            if (nombre != null && !nombre.isEmpty()) hql += " AND a.nombre LIKE :nombre";
            if (curso != null && !curso.isEmpty()) hql += " AND a.curso = :curso";
            if (tasa != null && !tasa.isEmpty()) hql += " AND a.tasa >= :tasa";

            hql += " AND a.activo = :activo";

            Query<Asignatura> query = session.createQuery(hql, Asignatura.class);

            if (id != null && !id.isEmpty()) query.setParameter("id", Integer.parseInt(id));
            if (nombre != null && !nombre.isEmpty()) query.setParameter("nombre", "%" + nombre + "%");
            if (curso != null && !curso.isEmpty()) query.setParameter("curso", Integer.parseInt(curso));
            if (tasa != null && !tasa.isEmpty()) query.setParameter("tasa", Double.parseDouble(tasa));

            query.setParameter("activo", activo);

            List<Asignatura> lista = query.getResultList();

            for (Asignatura a : lista) {
                resultado.add(convertir(a));
            }
        }

        return resultado;
    }

    @Override
    public int insertarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        int resultado = 0;
        Transaction tx = null;

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Asignatura a = new Asignatura();
            a.setId(Integer.parseInt(id));
            a.setNombre(nombre);
            a.setCurso(Integer.parseInt(curso));
            a.setTasa(Double.parseDouble(tasa));
            a.setActivo(activo);

            session.save(a);
            tx.commit();
            resultado = 1;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

        return resultado;
    }

    @Override
    public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        int resultado = 0;
        Transaction tx = null;

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Asignatura a = session.get(Asignatura.class, Integer.parseInt(id));

            if (a != null) {
                a.setNombre(nombre);
                a.setCurso(Integer.parseInt(curso));
                a.setTasa(Double.parseDouble(tasa));
                a.setActivo(activo);

                session.update(a);
                tx.commit();
                resultado = 1;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

        return resultado;
    }

    @Override
    public int borrarAsignatura(String id) {
        int resultado = 0;
        Transaction tx = null;

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Asignatura a = session.get(Asignatura.class, Integer.parseInt(id));

            if (a != null) {
                a.setActivo(0);
                session.update(a);
                tx.commit();
                resultado = 1;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }

        return resultado;
    }

    @Override
    public double obtenerTasaAsignatura(String idAsignatura) {
        double tasa = 0.0;

        try (Session session = DBUtils.creadorSessionFactory().openSession()) {
            Asignatura a = session.get(Asignatura.class, Integer.parseInt(idAsignatura));

            if (a != null && a.getActivo() == 1) {
                tasa = a.getTasa();
            }
        }

        return tasa;
    }
}
