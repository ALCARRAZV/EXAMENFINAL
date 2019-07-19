/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Tiporeserva;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface ITipoReserva {
    
    public abstract ArrayList<Tiporeserva> listTiporeserva ();
    
    public abstract boolean insertTiporeserva (Tiporeserva objTiporeserva);
    
    public abstract boolean updateTiporeserva (Tiporeserva objTiporeserva);
    
    public abstract boolean deleteTiporeserva (Tiporeserva objTiporeserva);
    
}
