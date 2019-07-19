/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Tipoatencion;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface ITipoAtencion {
    
    public abstract ArrayList<Tipoatencion> listTipoatencion ();
    
    public abstract boolean insertTipoatencion (Tipoatencion objTipoatencion);
    
    public abstract boolean updateTipoatencion (Tipoatencion objTipoatencion);
    
    public abstract boolean deleteTipoatencion (Tipoatencion objTipoatencion);
    
}
