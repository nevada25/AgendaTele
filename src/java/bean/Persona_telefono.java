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
public class Persona_telefono {
    private String idpercorreo;
    private String id_persona;
    private String id_telefono;
    private String estado;
    private String opcPersotel;

    public Persona_telefono() {
    }

    public Persona_telefono(String idpercorreo, String id_persona, String id_telefono, String estado, String opcPersotel) {
        this.idpercorreo = idpercorreo;
        this.id_persona = id_persona;
        this.id_telefono = id_telefono;
        this.estado = estado;
        this.opcPersotel = opcPersotel;
    }

    public String getIdpercorreo() {
        return idpercorreo;
    }

    public void setIdpercorreo(String idpercorreo) {
        this.idpercorreo = idpercorreo;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(String id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOpcPersotel() {
        return opcPersotel;
    }

    public void setOpcPersotel(String opcPersotel) {
        this.opcPersotel = opcPersotel;
    }



}
