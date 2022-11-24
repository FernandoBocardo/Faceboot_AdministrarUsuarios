/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Dominio.Usuario;
import Negocios.CtrlUsuario;

/**
 *
 * @author Fernando
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CtrlUsuario ctrl = new CtrlUsuario();
        String nombre = "vege", telefono = "6441435675", correo = "bocardo@gmail.com", contraseña = "321456", sexo = "masculino";
        Usuario usuario = new Usuario(nombre, telefono, correo, contraseña, sexo);
//        ctrl.agregar(usuario);
        
    }
    
}
