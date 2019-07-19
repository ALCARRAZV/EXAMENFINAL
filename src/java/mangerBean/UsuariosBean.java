/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.PersonalDao;
import entidades.Usuario;
import dao.UsuariosDao;
import entidades.Cliente;
import entidades.Personal;
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
public class UsuariosBean {

    private Usuario usuario;
    private final Cliente cliente;
    private final Personal personal;

    private UsuariosDao usuariosdao;
    private ClientesDao clientesDao;
    private PersonalDao personalDao;

    private ArrayList listaClientes;
    private ArrayList listaPersonal;

    private int idCliente;
    private int idPersonal;

    boolean respuesta;
    private boolean banderaSelect = false;
    private boolean visible;

    public void show() {
        visible = true;
    }

    public void hide() {
        visible = false;
    }

    public UsuariosBean() {
        usuario = new Usuario();
        cliente = new Cliente();
        personal = new Personal();
        listarCombosCliPer();
    }

    public void listarCombosCliPer() {
        clientesDao = new ClientesDao();
        personalDao = new PersonalDao();
        listaClientes = clientesDao.listClientes();
        listaPersonal = personalDao.listPersonal();
    }

    public ArrayList<Usuario> listUsuario() {

        ArrayList<Usuario> list = new ArrayList<>();
        usuariosdao = new UsuariosDao();
        list = usuariosdao.listUsuarios();
        return list;

    }

    public String insertUsuario() {

        usuariosdao = new UsuariosDao();
        if (idCliente != 0) {
            cliente.setIdCliente(idCliente);
            usuario.setCliente(cliente);
        } else if (idPersonal != 0) {
            personal.setIdPersonal(idPersonal);
            usuario.setPersonal(personal);
        }
        respuesta = usuariosdao.insertUsuarios(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";

    }

    public String clean() {
        return "/Usuario";
    }

    public String updateUsuario() {

        usuariosdao = new UsuariosDao();
        respuesta = usuariosdao.updateUsuarios(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";

    }

    public String deleteUsuario() {

        usuariosdao = new UsuariosDao();
        respuesta = usuariosdao.deleteUsuarios(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
