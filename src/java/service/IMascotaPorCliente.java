/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Mascotaporcliente;
import java.util.ArrayList;

/**
 *
 * @author GEDEON
 */
public interface IMascotaPorCliente {
    
    public abstract ArrayList<Mascotaporcliente> listMascotaporcliente ();
    
    public abstract boolean insertMascotaporcliente (Mascotaporcliente objMascotaporcliente);
    
    public abstract boolean updateMascotaporcliente (Mascotaporcliente objMascotaporcliente);
    
    public abstract boolean deleteMascotaporcliente (Mascotaporcliente objMascotaporcliente);
      
}
