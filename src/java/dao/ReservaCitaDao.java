/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import entidades.Reservacita;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IReservaCita;
import utilitarios.HibernateUtil;

/**
 *
 * @author GEDEON
 */
public class ReservaCitaDao implements IReservaCita{
    
    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Reservacita> listReservacita() {
         session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Reservacita> list = new ArrayList<>();
        hql = " from Reservacita";

        query = session.createQuery(hql);
        list = (ArrayList<Reservacita>) query.list();

        session.close();
        return list;
    }

    @Override
    public boolean insertReservacita(Reservacita objReservacita) {
         boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objReservacita);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ReservaCitaDao.insertReservacita...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean updateReservacita(Reservacita objReservacita) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objReservacita);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ReservaCitaDao.updateReservacita...!");
        }

        session.close();
        return respuesta;
    }

    @Override
    public boolean deleteReservacita(Reservacita objReservacita) {
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objReservacita);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ReservaCitaDao.deleteReservacita...!");
        }

        session.close();
        return respuesta;
    }
    
}
