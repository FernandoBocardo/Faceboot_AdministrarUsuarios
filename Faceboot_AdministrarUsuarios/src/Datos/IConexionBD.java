/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import com.mongodb.client.MongoDatabase;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos
 */
public interface IConexionBD {
    public EntityManager crearConexion() throws IllegalStateException;

}
