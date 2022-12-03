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
    
    public boolean agregar(String usuarioJson)
    {
        if(usuariosDAO.RegistrarUsuario(mapper(usuarioJson)))
        {
            return true;
        }
        return false;
    }
}