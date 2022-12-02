/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table (name="usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column (name="id_usuario",length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="nombre",nullable=false,length=45)
    private String nombre;
    
    @Column (name="foto",nullable=true,length=45)
    private String foto;
    
    @Column (name="numeroTelefono",nullable=false,length=45)
    private String numeroTelefono;
    
    @Column (name="correo",nullable=false,length=45)
    private String correo;
    
    @Column (name="contrasena",nullable=false,length=45)
    private String contrasena;

    @Column (name="sexo",nullable=false,length=45)
    private String sexo;
    
    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String nombre, String foto, String numeroTelefono, String correo, String contrasena, String sexo) {
        this.nombre = nombre;
        this.foto = foto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.sexo = sexo;
    }

    public Usuario(String nombre, String numeroTelefono, String correo, String contrasena, String sexo) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.sexo = sexo;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", numeroTelefono=" + numeroTelefono + ", correo=" + correo + ", contrasena=" + contrasena + ", sexo=" + sexo + '}';
    }
 
}
    
    

