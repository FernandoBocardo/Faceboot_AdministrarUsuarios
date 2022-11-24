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
        private IConexionBD conexion;

        public UsuariosDAO() {
        this.conexion = new ConexionBD();
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
}
