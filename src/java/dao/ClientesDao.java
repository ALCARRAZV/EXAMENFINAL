/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IClientes;
import utilitarios.HibernateUtil;

/**
 *
 * @author IVAN
 */
public class ClientesDao implements IClientes {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Cliente> listClientes() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Cliente> list = new ArrayList<>();
        hql = " from Cliente";

        try {
            query = session.createQuery(hql);
            list = (ArrayList<Cliente>) query.list();
        } catch (Exception e) {
            System.out.println("Error en ClientesDao.listClientes...!");
        }
        
        session.close();
        return list;

    }

    @Override
    public boolean insertClientes(Cliente objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.insertClientes...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateClientes(Cliente objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.updateClientes...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteClientes(Cliente objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.deleteClientes...!");
        }

        session.close();
        return respuesta;

    }

}
