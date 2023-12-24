/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Empleados;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class EmpleadoDao {
    public List<Empleados> listarEmpleados() {
        List<Empleados> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Empleados";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
   // SELECT DISTINCT m FROM Manga m LEFT JOIN FETCH m.generos LEFT JOIN FETCH m.demografia
    
    public List<Empleados> findByEmpleados(String nombre) {
        List<Empleados> empleados = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "SELECT DISTINCT e FROM Empleados e LEFT JOIN FETCH e.departamentos WHERE e.nombres = :nombre";
        try {
            session.beginTransaction();
            empleados = session.createQuery(hql).setParameter("nombre", nombre).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            // Manejo del error, registro, etc.
        }
        return empleados;
    }
    
    
    public List<Empleados> listarEmpleados2() {
        List<Empleados> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Empleados e LEFT JOIN FETCH e.departamentos";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
     public void agregar(Empleados empleado) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(empleado);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void modificar(Empleados empleado) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(empleado);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void eliminar(Empleados empleado) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(empleado);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

}
