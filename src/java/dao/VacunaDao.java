/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Vacuna;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IVacuna;
import utilitarios.HibernateUtil;

/**
 *
 * @author IVAN
 */
public class VacunaDao implements IVacuna{
    
     private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Vacuna> listVacuna() {
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Vacuna> list;
        hql = " from Vacuna";

        query = session.createQuery(hql);
        list = (ArrayList<Vacuna>) query.list();

        session.close();
        return list;
    }

    @Override
    public boolean insertVacuna(Vacuna objVacuna) {
         boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objVacuna);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.insertVacuna...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean updateVacuna(Vacuna objVacuna) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objVacuna);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.updateVacuna...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean deleteVacuna(Vacuna objVacuna) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objVacuna);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en VacunaDao.deleteVacuna...!");
        }

        session.close();
        return respuesta;
    }
    
}
