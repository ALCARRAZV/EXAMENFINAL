/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.TipoAtencionDao;
import entidades.Tipoatencion;
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
public class TipoAtencionBean {

    private Tipoatencion tipoatencion;
    private TipoAtencionDao tipoAtencionDao;
    boolean respuesta;
    private boolean banderaSelect = false;

    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();
    }

    public ArrayList<Tipoatencion> listTipoatencion() {

        ArrayList<Tipoatencion> list = new ArrayList<>();
        tipoAtencionDao = new TipoAtencionDao();
        list = tipoAtencionDao.listTipoatencion();
        return list;

    }

    public String insertTipoatencion() {

        tipoAtencionDao = new TipoAtencionDao();
        respuesta = tipoAtencionDao.insertTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";

    }

    public String clean() {
        return "/TipoAtencion";
    }

    public String updateTipoatencion() {

        tipoAtencionDao = new TipoAtencionDao();
        respuesta = tipoAtencionDao.updateTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";

    }

    public String deleteTipoatencion(Tipoatencion tipoatencion) {

        tipoAtencionDao = new TipoAtencionDao();
        respuesta = tipoAtencionDao.deleteTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";

    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
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
