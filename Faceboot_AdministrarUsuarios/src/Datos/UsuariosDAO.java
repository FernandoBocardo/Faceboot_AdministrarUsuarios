/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public class UsuariosDAO implements IUsuariosDAO{
        private IConexionUsuariosBD conexion;

        public UsuariosDAO() {
        this.conexion = new ConexionUsuariosBD();
    }
    @Override
    public boolean RegistrarUsuario(Usuario usuarios) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(usuarios);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo registrar el usuario");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Usuario consultar(Long id_usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Usuario.class, id_usuario);
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo encontrar al usuario con el ID: " + id_usuario);
            ex.printStackTrace();
            return null;
        }
    }
    
}
