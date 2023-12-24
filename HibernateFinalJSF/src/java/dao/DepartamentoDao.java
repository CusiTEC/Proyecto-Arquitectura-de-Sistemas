/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Departamentos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class DepartamentoDao {
    public List<Departamentos> listarDepartamentos() {
        List<Departamentos> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = sesion.beginTransaction();
            lista = sesion.createQuery("FROM Departamentos").list();
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }

        return lista;
    }
    
    public Departamentos findById(Departamentos depa) {
    Departamentos model = null;
    Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    String sql = "FROM Departamentos WHERE iddepartamento = '" + depa.getIddepartamento() + "'";
    try {
        sesion.beginTransaction();
        model = (Departamentos) sesion.createQuery(sql).uniqueResult();
        sesion.getTransaction().commit();
    } catch (Exception e) {
        if (sesion.getTransaction() != null) {
            sesion.getTransaction().rollback();
        }
        e.printStackTrace(); // Maneja el error según tu lógica
    }
    return model;
}
}
