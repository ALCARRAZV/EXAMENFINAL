/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Personal;
import java.util.ArrayList;

/**
 *
 * @author GEDEON
 */
public interface IPersonal {
    
      public abstract ArrayList<Personal> listPersonal ();
    
    public abstract boolean insertPersonal (Personal objPersonal);
    
    public abstract boolean updatePersonal (Personal objPersonal);
    
    public abstract boolean deletePersonal (Personal objPersonal);
    
}
