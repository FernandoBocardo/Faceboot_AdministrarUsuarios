/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */
public class ConexionUsuariosBD implements IConexionUsuariosBD{
    
    private static volatile ConexionUsuariosBD instance;
    private EntityManager em;
    
    public static ConexionUsuariosBD getInstance() 
    {
        ConexionUsuariosBD result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ConexionUsuariosBD.class) 
        {
            if(instance == null) 
            {
                instance = new ConexionUsuariosBD();
            }
        return instance;
        }
    }
    
    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        if(this.em == null)
        {
            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Faceboot_AdministrarUsuariosPU");
            this.em = emFactory.createEntityManager();
        }
        return em;
    }
}
