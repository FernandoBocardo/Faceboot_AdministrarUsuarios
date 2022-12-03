/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public class UsuariosDAO implements IUsuariosDAO{
    
    private IConexionUsuariosBD conexion;

    public UsuariosDAO() 
    {
        this.conexion = ConexionUsuariosBD.getInstance();
    }
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo registrar el usuario");
            ex.printStackTrace();
            return false;
        }
    }
    
    
    
    @Override
    public Usuario consultarUsuario(Long id_usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Usuario.class, id_usuario);
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo encontrar al usuario con el ID: " + id_usuario);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.merge(consultarUsuario(usuario.getId()));
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo editar el usuario");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Usuario> consultarTodos() {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery(
                "SELECT u FROM Usuario u")
                .getResultList();
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar los usuarios");
            ex.printStackTrace();
            return null;
        }
    }
    
}
