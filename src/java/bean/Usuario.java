/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Luis Lavado
 */
public class Usuario  extends Persona{

    private int id_usuario;
    private int id_rol;
    private int id_personas;
    private String login;
    private String correo;
    private String clave;
    private String estado;

    public Usuario() {
    }

    public Usuario(int id_usuario, int id_rol, int id_personas, String login, String correo, String clave, String estado) {
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
        this.id_personas = id_personas;
        this.login = login;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_personas() {
        return id_personas;
    }

    public void setId_personas(int id_personas) {
        this.id_personas = id_personas;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    }
