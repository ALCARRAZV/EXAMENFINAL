/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.ReservaCitaDao;
import dao.TipoReservaDao;
import dao.UsuariosDao;
import entidades.Cliente;
import entidades.Reservacita;
import entidades.Tiporeserva;
import entidades.Usuario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author GEDEON
 */
@ManagedBean
@ViewScoped
public class ReservaCitaBean {

    private ArrayList listatiporeserva;
    private ArrayList listcliente;
    private ArrayList listusuario;

    private Reservacita reservaCita;

    private ReservaCitaDao reservaCitaDao;

    private int idTipreserva;
    private int idCliente;
    private int idUsuario;

    final private Cliente cliente;
    final private Tiporeserva tiporeserva;
    final private Usuario usuario;

    private boolean banderaSelected = false;

    public ReservaCitaBean() {
        listatiporeserva = new ArrayList();
        listcliente = new ArrayList();
        listusuario = new ArrayList();
        reservaCita = new Reservacita();
        cliente = new Cliente();
        tiporeserva = new Tiporeserva();
        usuario = new Usuario();
        listarCombos();
    }

    public void listarCombos() {
        TipoReservaDao tipresrevadao = new TipoReservaDao();
        ClientesDao clientdao = new ClientesDao();
        UsuariosDao userdao = new UsuariosDao();

        listatiporeserva = tipresrevadao.listTiporeserva();
        listcliente = clientdao.listClientes();
        listusuario = userdao.listUsuarios();
    }

    public ArrayList<Reservacita> listarReservacita() {
        ArrayList<Reservacita> lista = new ArrayList<>();
        ReservaCitaDao recervdao = new ReservaCitaDao();
        lista = recervdao.listReservacita();
        return lista;
    }

    public String guardarReservacita() {
        try {
            ReservaCitaDao recervdao = new ReservaCitaDao();
            cliente.setIdCliente(idCliente);
            tiporeserva.setIdTipoReserva(idTipreserva);
            usuario.setIdUsuario(idUsuario);

            reservaCita.setCliente(cliente);
            reservaCita.setTiporeserva(tiporeserva);
            reservaCita.setUsuario(usuario);

            boolean respuest = recervdao.insertReservacita(reservaCita);
            if (respuest) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (Exception e) {
            System.out.println("Error:: " + e.getMessage());
        }

        return "/ReservaCita";
    }
    
    public String actualizarReservacita() {
        try {
            ReservaCitaDao recervdao = new ReservaCitaDao();
            boolean respuesta = recervdao.updateReservacita(reservaCita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/ReservaCita";
    }
    
    public String eliminar() {
        ReservaCitaDao recervdao = new ReservaCitaDao();
        boolean respuesta = recervdao.deleteReservacita(reservaCita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/ReservaCita";
    }
    
    public String clean(){
        return "/ReservaCita";
    }

    public void banderaSelected() {
        banderaSelected = true;
    }

    public Reservacita getReservaCita() {
        return reservaCita;
    }

    public void setReservaCita(Reservacita reservaCita) {
        this.reservaCita = reservaCita;
    }

    public ArrayList getListatiporeserva() {
        return listatiporeserva;
    }

    public void setListatiporeserva(ArrayList listatiporeserva) {
        this.listatiporeserva = listatiporeserva;
    }

    public ArrayList getListcliente() {
        return listcliente;
    }

    public void setListcliente(ArrayList listcliente) {
        this.listcliente = listcliente;
    }

    public ArrayList getListusuario() {
        return listusuario;
    }

    public void setListusuario(ArrayList listusuario) {
        this.listusuario = listusuario;
    }

    public int getIdTipreserva() {
        return idTipreserva;
    }

    public void setIdTipreserva(int idTipreserva) {
        this.idTipreserva = idTipreserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }

}
