/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Atencion;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IAtencion;
import utilitarios.HibernateUtil;

/**
 *
 * @author GEDEON
 */
public class AtencionDao  implements IAtencion{

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;
    
    @Override
    public ArrayList<Atencion> listAtencion() {
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Atencion> list = new ArrayList<>();
        hql = " from Atencion as aten inner join fetch aten.personal left join fetch aten.tipoatencion left join fetch aten.mascotaporcliente ";

        query = session.createQuery(hql);
        list = (ArrayList<Atencion>) query.list();

        session.close();
        return list;
    }

    @Override
    public boolean insertAtencion(Atencion objAtencion) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en AtencionDao.insertAtencion...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean updateAtencion(Atencion objAtencion) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en AtencionDao.updateAtencion...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean deleteAtencion(Atencion objAtencion) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en AtencionDao.deleteAtencion...!");
        }

        session.close();
        return respuesta;
    }
    
}
