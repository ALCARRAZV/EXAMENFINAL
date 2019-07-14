/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.MascotaDao;
import entidades.Mascota;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.IMascota;

/**
 *
 * @author IVAN
 */
@ManagedBean
@ViewScoped
public class MascotaBean {

    /*Session session;
    Transaction transaction;*/
    private Mascota mascota;
    public MascotaDao mascotadao;
    boolean respuesta;
    private boolean banderaSelect = false;    

    public MascotaBean() {
        this.mascota = new Mascota();
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public ArrayList<Mascota> listMascota() {

        ArrayList<Mascota> list = new ArrayList<>();
        mascotadao = new MascotaDao();
        list = mascotadao.listMascota();
        return list;

    }
    
    public String insertMascota(){
        
        mascotadao = new MascotaDao();
        respuesta = mascotadao.insertMascota(mascota);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Mascota";
        
    }
    
    public String clean(){
        return "/Mascota";
    }
    
    public String updateMascota(){
        
        mascotadao = new MascotaDao();
        respuesta = mascotadao.updateMascota(mascota);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Mascota";
        
    }
    
    public String deleteMascota(){
        
        mascotadao = new MascotaDao();
        respuesta = mascotadao.deleteMascota(mascota);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Mascota";
        
    }
    
    public void selectBandera(){
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
