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
            Usuario usuarioConsultado = consultarUsuario(usuario.getId());
            usuarioConsultado.setNombre(usuario.getNombre());
            usuarioConsultado.setContrasena(usuario.getContrasena());
            if(usuario.getFoto() != null)
            {
                usuarioConsultado.setFoto(usuario.getFoto());
            }
            usuarioConsultado.setSexo(usuario.getSexo());
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

    @Override
    public Usuario consultarPorNombre(String nombreUsuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            List<Usuario> usuarioConsultado = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nombre = ?1")
                .setParameter(1, nombreUsuario)
                .getResultList();
            return usuarioConsultado.get(0);
        } catch (IllegalStateException ex) {
            System.err.print("No se pudo consultar las publicaciones");
            ex.printStackTrace();
            return null;
        }
    }
    
}
