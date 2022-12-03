/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Datos.IUsuariosDAO;
import Dominio.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Datos.UsuariosDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class CtrlUsuario {
    
    private IUsuariosDAO usuariosDAO;
    
    public CtrlUsuario()
    {
        this.usuariosDAO = new UsuariosDAO();
    }
    
    public Usuario mapper(String json)
    {
        Usuario usuario = null;
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            usuario = objectMapper.readValue(json, Usuario.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public boolean registrarUsuario(String usuarioJson)
    {
        if(usuariosDAO.registrarUsuario(mapper(usuarioJson)))
        {
            return true;
        }
        return false;
    }
    
    public Usuario iniciarSesion(String usuarioJson)
    {
        Usuario usuario = mapper(usuarioJson);
        List<Usuario> usuarios = usuariosDAO.consultarTodos();
        for (Usuario u : usuarios)
        {
            if(u.getCorreo().equals(usuario.getCorreo()) && u.getContrasena().equals(usuario.getContrasena()))
            {
                return u;
            }
        }
        return null;
    }
    
    public boolean editarUsuario(String usuarioJson)
    {
        return usuariosDAO.editarUsuario(mapper(usuarioJson));
    }
    
    public Usuario consultarUsuario(String usuarioJson)
    {
        return usuariosDAO.consultarUsuario(mapper(usuarioJson).getId());
    }
    
}