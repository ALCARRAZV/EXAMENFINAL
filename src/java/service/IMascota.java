/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author GEDEON
 */
public interface IMascota {
    
    public abstract ArrayList<Mascota> listMascota ();
    
    public abstract boolean insertMascota (Mascota objMascota);
    
    public abstract boolean updateMascota (Mascota objMascota);
    
    public abstract boolean deleteMascota (Mascota objMascota);
    
    public abstract ArrayList<Mascota> listMascotaRaza (Session sesion, String raza);
    
    public Mascota findMascotaNombre (Session sesion, String nombreMascota);
    
    public abstract Integer countCantidadMascotas (Session sesion);
    
}
