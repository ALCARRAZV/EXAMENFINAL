/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.MascotaDao;
import dao.MascotaPorClienteDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
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
public class MascotaPorClienteBean {
    
    private ArrayList listaClientes;
     private ClientesDao objClientesDao;
     private MascotaDao mascotadao;
     private MascotaPorClienteDao mascotaPorClienteDao;
     private Mascotaporcliente mascotaPorCliente;
     MascotaporclienteId mascotaporclienteId;
     private int idCliente;
     private int idMascota;
     private ArrayList listaMascotas;
     boolean respuesta;

    public MascotaPorClienteBean() {
        
        listaClientes = new ArrayList();
        mascotaPorCliente = new Mascotaporcliente();
        mascotaporclienteId = new MascotaporclienteId();
        listarCombos();
        
    }
    
    public void listarCombos(){
        
        objClientesDao = new ClientesDao();
        mascotadao = new MascotaDao();
        listaClientes = objClientesDao.listClientes();
        listaMascotas = mascotadao.listMascota();
        
    }
    
     public String insertMascotaPorCliente(){
        
        mascotaPorClienteDao = new MascotaPorClienteDao();
        mascotaporclienteId.setIdCliente(idCliente);
        mascotaporclienteId.setIdMascota(idMascota);
        mascotaPorCliente.setId(mascotaporclienteId);
        respuesta = mascotaPorClienteDao.insertMascotaporcliente(mascotaPorCliente);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/MascotaPorCliente";
        
    }
        

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascotaporcliente getMascotaPorCliente() {
        return mascotaPorCliente;
    }

    public void setMascotaPorCliente(Mascotaporcliente mascotaPorCliente) {
        this.mascotaPorCliente = mascotaPorCliente;
    }
    
    
}
