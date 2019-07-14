package service;

import entidades.Vacuna;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface IVacuna {
    
    public abstract ArrayList<Vacuna> listVacuna();
    
    public abstract boolean insertVacuna(Vacuna objVacuna);
    
    public abstract boolean updateVacuna (Vacuna objVacuna);
    
    public abstract boolean deleteVacuna(Vacuna objVacuna);
    
}
