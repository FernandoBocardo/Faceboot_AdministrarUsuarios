/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Dominio.Usuario;

/**
 *
 * @author Carlos
 */
public interface IUsuariosDAO {
    public boolean RegistrarUsuario(Usuario usuario);
    public Usuario consultar(Long id_usuario);
}
