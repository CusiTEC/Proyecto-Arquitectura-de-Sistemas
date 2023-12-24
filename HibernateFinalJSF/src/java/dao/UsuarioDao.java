/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class UsuarioDao {
    
   public Usuarios findByUsuario(Usuarios usuario) {
    Usuarios model = null;
    Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    String sql = "FROM Usuarios WHERE usuario = '" + usuario.getUsuario() + "'";
    try {
        sesion.beginTransaction();
        model = (Usuarios) sesion.createQuery(sql).uniqueResult();
        sesion.getTransaction().commit(); // Cambia aquí
    } catch (Exception e) {
        sesion.getTransaction().rollback(); // Cambia aquí
    }
    return model;
    }


    public Usuarios login(Usuarios usuario) {
        Usuarios model = this.findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getClave().equals(model.getClave())) {
                model = null;
            }
        }
        return model;
    }


   
    public List<Usuarios> listarUsuarios() {
        List<Usuarios> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Usuario";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
}
