/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Dominio.Usuario;

/**
 *
 * @author Fernando
 */
public class UsuarioBuilder {
    
    private Usuario resultado;
    
    public UsuarioBuilder()
    {
        resultado = new Usuario();
    }
    
    public Usuario getResultado()
    {
        return resultado;
    }
    
    public void buildNombre(String nombre)
    {
        resultado.setNombre(nombre);
    }
    
    public void buildFoto(byte[] foto)
    {
        resultado.setFoto(foto);
    }
    
    public void buildNumeroTelefono(String numeroTelefono)
    {
        resultado.setNumeroTelefono(numeroTelefono);
    }
    
    public void buildCorreo(String correo)
    {
        resultado.setCorreo(correo);
    }
    
    public void buildContrasena(String contrasena)
    {
        resultado.setContrasena(contrasena);
    }
    
    public void buildSexo(String sexo)
    {
        resultado.setSexo(sexo);
    }
    
}
