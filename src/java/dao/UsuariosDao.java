/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IUsuarios;
import utilitarios.HibernateUtil;

/**
 *
 * @author GEDEON
 */
public class UsuariosDao implements IUsuarios{
    
    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Usuario> listUsuarios() {
        //from Usuario as usu left join usu.personal left join usu.cliente
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Usuario> list = new ArrayList<>();
        hql = "from Usuario as usu left join fetch usu.personal left join fetch usu.cliente";

        try {
            query = session.createQuery(hql);
            list = (ArrayList<Usuario>) query.list();
        } catch (Exception e) {
            System.out.println("Error en Usuariosdao.listUsuarios...!" + e.getMessage());
        }
        
        session.close();
        return list;
    }

    @Override
    public boolean insertUsuarios(Usuario objUsuario) {
        
         boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariosdao.insertUsuarios...!" + e.getMessage());
        }

        session.close();
        return respuesta;
        
    }

    @Override
    public boolean updateUsuarios(Usuario objUsuario) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariosdao.updateUsuarios...!" + e.getMessage());
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean deleteUsuarios(Usuario objUsuario) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariosdao.deleteUsuarios...!");
        }

        session.close();
        return respuesta;
    }
    
}
