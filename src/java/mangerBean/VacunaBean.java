/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.VacunaDao;
import entidades.Vacuna;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author IVAN
 */
@ManagedBean
@ViewScoped
public class VacunaBean {
    
    private Vacuna vacuna;
    private VacunaDao vacunaDao;
    private boolean respuesta;
    private boolean banderaSelect = false;
    
     public VacunaBean() {
         this.vacuna = new Vacuna();
    }
    
    public void banderaSelect(){
        banderaSelect = true;
    }
    
    public ArrayList<Vacuna> listVacunas() {

        ArrayList<Vacuna> list = new ArrayList<>();
        vacunaDao = new VacunaDao();
        list = vacunaDao.listVacuna();
        return list;

    }

    public String insertVacuna() {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.insertVacuna(vacuna);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar", "No se pudo registrar"));
        }
        return "/Vacuna";

    }

    public String clean() {
        return "/Vacuna";
    }

    public String updateVacuna() {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.updateVacuna(vacuna);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al ", "No se pudo registrar"));
        }
        return "/Vacuna";

    }

    public String deleteVacuna(Vacuna vacuna) {

        vacunaDao = new VacunaDao();
        respuesta = vacunaDao.deleteVacuna(vacuna);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar", "No se pudo registrar"));
        }
        return "/Vacuna";

    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    
}
