/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author GEDEON
 */
public interface IUsuarios {

    public abstract ArrayList<Usuario> listUsuarios();

    public abstract boolean insertUsuarios(Usuario objUsuario);

    public abstract boolean updateUsuarios(Usuario objUsuario);

    public abstract boolean deleteUsuarios(Usuario objUsuario);

}
