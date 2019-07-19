/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Atencion;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface IAtencion {
    
    public abstract ArrayList<Atencion> listAtencion ();
    
    public abstract boolean insertAtencion (Atencion objAtencion);
    
    public abstract boolean updateAtencion (Atencion objAtencion);
    
    public abstract boolean deleteAtencion (Atencion objAtencion);
    
}
