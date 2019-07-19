/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import service.IMascota;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author GEDEON
 */
public class MascotaDao implements IMascota {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Mascota> listMascota() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascota> list = new ArrayList<>();
        hql = " from Mascota";

        query = session.createQuery(hql);
        list = (ArrayList<Mascota>) query.list();

        session.close();
        return list;

    }

    @Override
    public boolean insertMascota(Mascota objMascota) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objMascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Mascotadao.insertMascota...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateMascota(Mascota objMascota) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objMascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Mascotadao.updateMascota...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteMascota(Mascota objMascota) {
        
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objMascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Mascotadao.deleteMascota...!");
        }

        session.close();
        return respuesta;
        
    }

    @Override
    public ArrayList<Mascota> listMascotaRaza(Session sesion, String raza) {

        ArrayList<Mascota> list;
        hql = "FROM Mascota WHERE raza = '" + raza + "'";
        query = sesion.createQuery(hql);
        list = (ArrayList<Mascota>) query.list();

        return list;

    }

    @Override
    public Mascota findMascotaNombre(Session sesion, String nombreMascota) {

        return (Mascota) sesion.get(Mascota.class, nombreMascota);

    }

    @Override
    public Integer countCantidadMascotas(Session sesion) {

        hql = "SELECT COUNT(*) FROM Mascota";
        query = sesion.createQuery(hql);
        Long numMascotas = (Long) query.uniqueResult();
        Integer count = numMascotas.intValue();

        return count;
    }

}
