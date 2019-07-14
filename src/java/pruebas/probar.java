/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dao.MascotaDao;
import dao.PersonalDao;
import entidades.Mascota;
import entidades.Personal;
import java.util.ArrayList;
import mangerBean.MascotaBean;
import mangerBean.PersonalBean;
import org.hibernate.Session;
import utilitarios.HibernateUtil;

/**
 *
 * @author IVAN
 */
public class probar {
    
    public static void main(String[] args) {
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        PersonalDao objMascotaDao = new PersonalDao();
        PersonalBean masbean = new PersonalBean();
        
        // Prueba Insertar
//        Mascota objMascota = new Mascota(5, "Sandor", "Joaquin Altamirano", "Mini Lop");
//        objMascotaDao.insertMascota(objMascota);
        
         //Prueba Listar
        ArrayList<Personal> list = new ArrayList<>();
        list = masbean.listPersonal();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Nombre: " + list.get(i).getNombres()+ " Apellidos: " + list.get(i).getApellidos());
        }

        //Actualizar registro
//       Mascota objMascota = new Mascota(4, "Crocki", "Kevin Altamirano", "Bodtail Americano");
//       objMascotaDao.updateMascota(sesion, objMascota);

        // Listar mascota: raza Pastor Aleman
//        ArrayList<Mascota> list = new ArrayList<>();
//        list = objMascotaDao.listMascotaRaza(sesion, "Pastor Aleman");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("nombre: " + list.get(i).getNombreMascota() + "Raza: " + list.get(i).getRaza());
//        }

         // Listar mascota: nombre Sandor
//         Mascota objMascota;
//        int Mascota = objMascotaDao.countCantidadMascotas(sesion);
//        
//        System.out.println(Mascota);

        /*while(objMascota != null){
            System.out.println("Mascota: " + objMascota.getNombreMascota() + "Propietario: " + objMascota.getNombreCliente() + "Raza: " + objMascota.getRaza());
            break;
        }*/
        
    }
    
}
