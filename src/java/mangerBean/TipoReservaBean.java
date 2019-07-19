/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.TipoReservaDao;
import entidades.Tiporeserva;
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
public class TipoReservaBean {

    private Tiporeserva tiporeserva;
    private TipoReservaDao tipoReservaDao;
    boolean respuesta;
    private boolean banderaSelect = false;

    public TipoReservaBean() {
        tiporeserva = new Tiporeserva();
    }

    public ArrayList<Tiporeserva> listTiporeserva() {

        ArrayList<Tiporeserva> list = new ArrayList<>();
        tipoReservaDao = new TipoReservaDao();
        list = tipoReservaDao.listTiporeserva();
        return list;

    }

    public String insertTiporeserva() {

        tipoReservaDao = new TipoReservaDao();
        respuesta = tipoReservaDao.insertTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";

    }

    public String clean() {
        return "/TipoReserva";
    }

    public String updateTiporeserva() {

        tipoReservaDao = new TipoReservaDao();
        respuesta = tipoReservaDao.updateTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";

    }

    public String deleteTiporeserva(Tiporeserva tiporeserva) {

        tipoReservaDao = new TipoReservaDao();
        respuesta = tipoReservaDao.deleteTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";

    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
