/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.AtencionDao;
import dao.ClientesDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.TipoAtencionDao;
import entidades.Atencion;
import entidades.Cliente;
import entidades.Mascota;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import entidades.Personal;
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
public class AtencionBean {

    private Atencion atencion;

    private AtencionDao atencionDao;

    private ArrayList listaPersonal;
    private ArrayList listaMascota;
    private ArrayList listaCliente;
    private ArrayList listaTipoAtencion;

    private int idPersonal;
    private int idMascota;
    private int idCliente;
    private int idTipoAtencion;

    private final Personal personal;
    private final Cliente clientes;
    private final Mascota mascota;
    private final Tipoatencion tipoAtencion;
    private final Mascotaporcliente mascotaPorCliente;
    private final MascotaporclienteId mascotaporclienteId;

    private boolean respuesta;
    private boolean banderaSelect = false;

    public AtencionBean() {
        atencion = new Atencion();
        personal = new Personal();
        clientes = new Cliente();
        mascota = new Mascota();
        tipoAtencion = new Tipoatencion();
        mascotaPorCliente = new Mascotaporcliente();
        mascotaporclienteId = new MascotaporclienteId();
        listarCombosAtencion();
    }

    public void listarCombosAtencion() {
        MascotaDao mascotaDao = new MascotaDao();
        PersonalDao personalDao = new PersonalDao();
        ClientesDao clientesDao = new ClientesDao();
        TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();

        listaPersonal = personalDao.listPersonal();
        listaMascota = mascotaDao.listMascota();
        listaCliente = clientesDao.listClientes();
        listaTipoAtencion = tipoAtencionDao.listTipoatencion();

    }

    public ArrayList<Atencion> listTipoAtencion() {
        ArrayList<Atencion> lista = new ArrayList<>();
        atencionDao = new AtencionDao();
        lista = atencionDao.listAtencion();
        return lista;
    }

    public String insertAtencion() {
        atencionDao = new AtencionDao();
        
        personal.setIdPersonal(idPersonal);
        tipoAtencion.setIdTipoAtencion(idTipoAtencion);
        mascotaporclienteId.setIdCliente(idCliente);
        mascotaporclienteId.setIdMascota(idMascota);
        mascotaPorCliente.setId(mascotaporclienteId);
        
        atencion.setPersonal(personal);
        atencion.setTipoatencion(tipoAtencion);
        atencion.setMascotaporcliente(mascotaPorCliente);
        respuesta = atencionDao.insertAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Atencion";

    }

    public String clean() {
        return "/Atencion";
    }

    public String updateAtencion() {

        atencionDao = new AtencionDao();
        respuesta = atencionDao.updateAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Atencion";

    }

    public String deleteAtencion() {

        atencionDao = new AtencionDao();
        respuesta = atencionDao.deleteAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Atencion";

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

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public ArrayList getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(ArrayList listaMascota) {
        this.listaMascota = listaMascota;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList getListaTipoAtencion() {
        return listaTipoAtencion;
    }

    public void setListaTipoAtencion(ArrayList listaTipoAtencion) {
        this.listaTipoAtencion = listaTipoAtencion;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

}
