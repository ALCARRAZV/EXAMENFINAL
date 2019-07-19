/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Reservacita;
import java.util.ArrayList;

/**
 *
 * @author GEDEON
 */
public interface IReservaCita {
    
    public abstract ArrayList<Reservacita> listReservacita ();
    
    public abstract boolean insertReservacita (Reservacita objReservacita);
    
    public abstract boolean updateReservacita (Reservacita objReservacita);
    
    public abstract boolean deleteReservacita (Reservacita objReservacita);
    
}
