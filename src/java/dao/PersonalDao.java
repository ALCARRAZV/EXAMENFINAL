/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Personal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IPersonal;
import utilitarios.HibernateUtil;

/**
 *
 * @author GEDEON
 */
public class PersonalDao implements IPersonal{
    
     private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Personal> listPersonal() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Personal> list = new ArrayList<>();
        hql = " from Personal";

        try {
            query = session.createQuery(hql);
            list = (ArrayList<Personal>) query.list();
        } catch (Exception e) {
            System.out.println("Error en PersonalDao.listPersonal...!");
        }

        session.close();
        return list;

    }

    @Override
    public boolean insertPersonal(Personal objPersonal) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objPersonal);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en PersonalDao.insertPersonal...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updatePersonal (Personal objPersonal) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objPersonal);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en PersonalDao.updatePersonal...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deletePersonal (Personal objPersonal) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objPersonal);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en PersonalDao.deletePersonal...!");
        }

        session.close();
        return respuesta;

    }
    
}
