/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Datos.IUsuariosDAO;
import Datos.UsuariosDAO;
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
        
        IUsuariosDAO ctrl = new UsuariosDAO();
        String nombre = "willy", telefono = "6554567865", correo = "willy@gmail.com", contraseña = "123456", sexo = "masculino";
        Usuario usuario = new Usuario(nombre, telefono, correo, contraseña, sexo);
        ctrl.RegistrarUsuario(usuario);
        
    }
    
}
