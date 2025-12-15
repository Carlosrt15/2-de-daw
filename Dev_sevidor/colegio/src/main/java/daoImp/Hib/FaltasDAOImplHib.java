package daoImp.Hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.IFaltasDAO;
import dto.FaltaDTO;
import entities.Falta;
import utils.DBUtils;

public class FaltasDAOImplHib implements IFaltasDAO {

    private FaltaDTO convertir(Falta f) {
        return new FaltaDTO(
                String.valueOf(f.getIdfaltas()),
                String.valueOf(f.getAlumno()),
                String.valueOf(f.getAsignatura()),
                f.getFecha().toString(),
                f.getJustificada()
        );
    }

    @Override
    public ArrayList<FaltaDTO> obtenerTodasFaltas() {
        ArrayList<FaltaDTO> lista = new ArrayList<>();

        Session session = null;
        try {
            session = DBUtils.creadorSessionFactory().openSession();
            List<Falta> faltas = session.createQuery("FROM Falta", Falta.class).getResultList();

            for (Falta f : faltas) {
                lista.add(convertir(f));
            }
        } finally {
            if (session != null) session.close();
        }

        return lista;
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltros(
            String nombreAlumno, String asignatura, String fecha, int justificada) {

        ArrayList<FaltaDTO> lista = new ArrayList<>();
        Session session = null;

        try {
            session = DBUtils.creadorSessionFactory().openSession();

            String hql = "FROM Falta f WHERE 1=1";

            if (asignatura != null && !asignatura.trim().isEmpty())
                hql += " AND f.asignatura = :asignatura";

            if (fecha != null && !fecha.trim().isEmpty())
                hql += " AND f.fecha = :fecha";

            if (justificada != -1)
                hql += " AND f.justificada = :justificada";

            Query<Falta> query = session.createQuery(hql, Falta.class);

            if (asignatura != null && !asignatura.trim().isEmpty())
                query.setParameter("asignatura", Integer.parseInt(asignatura));

            if (fecha != null && !fecha.trim().isEmpty())
            	query.setParameter("fecha", java.sql.Date.valueOf(
            	        fecha.contains("-")
            	                ? fecha
            	                : fecha.substring(0,4) + "-" + fecha.substring(4,6) + "-" + fecha.substring(6,8)
            	));


            if (justificada != -1)
                query.setParameter("justificada", justificada);

            for (Falta f : query.getResultList()) {
                lista.add(convertir(f));
            }

        } finally {
            if (session != null) session.close();
        }

        return lista;
    }

    @Override
    public ArrayList<FaltaDTO> obtenerFaltasPorFiltrosSinFecha(
            String nombreAlumno, String asignatura, int justificada) {

        ArrayList<FaltaDTO> lista = new ArrayList<>();
        Session session = null;

        try {
            session = DBUtils.creadorSessionFactory().openSession();

            String hql = "FROM Falta f WHERE 1=1";

            if (asignatura != null && !asignatura.trim().isEmpty())
                hql += " AND f.asignatura = :asignatura";

            if (justificada != -1)
                hql += " AND f.justificada = :justificada";

            Query<Falta> query = session.createQuery(hql, Falta.class);

            if (asignatura != null && !asignatura.trim().isEmpty())
                query.setParameter("asignatura", Integer.parseInt(asignatura));

            if (justificada != -1)
                query.setParameter("justificada", justificada);

            for (Falta f : query.getResultList()) {
                lista.add(convertir(f));
            }

        } finally {
            if (session != null) session.close();
        }

        return lista;
    }

    @Override
    public int insertarFalta(String idAlumno, String idAsignatura, String fecha, int justificada) {
        Transaction tx = null;
        Session session = null;

        try {
            session = DBUtils.creadorSessionFactory().openSession();
            tx = session.beginTransaction();

            Falta f = new Falta();
            f.setAlumno(Integer.parseInt(idAlumno));
            f.setAsignatura(Integer.parseInt(idAsignatura));
            f.setFecha(java.sql.Date.valueOf(fecha));
            f.setJustificada(justificada);

            session.save(f);
            tx.commit();
            return 1;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return 0;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public int actualizarFalta(String idFalta, String idAlumno, String idAsignatura, String fecha, int justificada) {
        Transaction tx = null;
        Session session = null;

        try {
            session = DBUtils.creadorSessionFactory().openSession();
            tx = session.beginTransaction();

            Falta f = session.get(Falta.class, Integer.parseInt(idFalta));

            if (f != null) {
                f.setAlumno(Integer.parseInt(idAlumno));
                f.setAsignatura(Integer.parseInt(idAsignatura));
                f.setFecha(java.sql.Date.valueOf(fecha));
                f.setJustificada(justificada);

                session.update(f);
                tx.commit();
                return 1;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }

        return 0;
    }

    @Override
    public int borrarFalta(String idFalta) {
        Transaction tx = null;
        Session session = null;

        try {
            session = DBUtils.creadorSessionFactory().openSession();
            tx = session.beginTransaction();

            Falta f = session.get(Falta.class, Integer.parseInt(idFalta));

            if (f != null) {
                session.delete(f);
                tx.commit();
                return 1;
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }

        return 0;
    }
}
