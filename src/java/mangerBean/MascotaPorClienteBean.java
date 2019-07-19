/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.MascotaDao;
import dao.MascotaPorClienteDao;
import dao.PersonalDao;
import entidades.Mascota;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author GEDEON
 */
@ManagedBean
@ViewScoped
public class MascotaPorClienteBean {

    private ArrayList listaClientes;
    private ArrayList listaMascotas;

    private ClientesDao objClientesDao;
    private MascotaDao mascotadao;
    private MascotaPorClienteDao mascotaPorClienteDao;

    private Mascotaporcliente mascotaPorCliente;
    MascotaporclienteId mascotaporclienteId;
    private Mascota mascota;

    private int idCliente;
    private int idMascota;

    boolean respuesta;

    public MascotaPorClienteBean() {
        mascota = new Mascota();
        mascotaPorCliente = new Mascotaporcliente();
        mascotaporclienteId = new MascotaporclienteId();
        listarCombos();
    }

    public void listarCombos() {
        objClientesDao = new ClientesDao();
        mascotadao = new MascotaDao();
        listaClientes = objClientesDao.listClientes();
        listaMascotas = mascotadao.listMascota();
    }

    public ArrayList<Mascotaporcliente> listMascotaporcliente() {
        ArrayList<Mascotaporcliente> list = new ArrayList<>();
        mascotaPorClienteDao = new MascotaPorClienteDao();
        list = mascotaPorClienteDao.listMascotaporcliente();
        return list;
    }

    public String insertMascotaPorCliente() {

        mascotaPorClienteDao = new MascotaPorClienteDao();
        mascotaporclienteId.setIdCliente(idCliente);
        mascotaporclienteId.setIdMascota(idMascota);
        mascotaPorCliente.setId(mascotaporclienteId);
        respuesta = mascotaPorClienteDao.insertMascotaporcliente(mascotaPorCliente);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/MascotaPorCliente";

    }
    
       public String deleteMascotaCliente(Mascotaporcliente mascotaporcliente) {

        mascotaPorClienteDao = new MascotaPorClienteDao();
        respuesta = mascotaPorClienteDao.deleteMascotaporcliente(mascotaporcliente);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error...No se pudo eliminar"));
        }
        return "/MascotaPorCliente";

    }
       
    public Mascotaporcliente getMascotaPorCliente() {
        return mascotaPorCliente;
    }
    public void setMascotaPorCliente(Mascotaporcliente mascotaPorCliente) {
        this.mascotaPorCliente = mascotaPorCliente;
    }
    

    public ArrayList getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }
    public ArrayList getListaMascotas() {
        return listaMascotas;
    }
    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
    

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdMascota() {
        return idMascota;
    }
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
}
