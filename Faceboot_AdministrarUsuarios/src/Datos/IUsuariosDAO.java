/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IUsuariosDAO {
    public boolean registrarUsuario(Usuario usuario);
    public List<Usuario> consultarTodos();
    public boolean editarUsuario(Usuario usuario);
    public Usuario consultarUsuario(Long id_usuario);
}
