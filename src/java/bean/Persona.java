/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.InputStream;

/**
 *
 * @author Luis Lavado
 */
public class Persona {

    private String id_persona;
    private String nombres;
    private String apepat;
    private String apemat;
    private String genero;
    private String cargo;
    private String codigo;
    private InputStream foto;
    private String estado;

    public Persona() {
    }

    public Persona(String id_persona, String nombres, String apepat, String apemat, String genero, String cargo, String codigo, InputStream foto, String estado) {
        this.id_persona = id_persona;
        this.nombres = nombres;
        this.apepat = apepat;
        this.apemat = apemat;
        this.genero = genero;
        this.cargo = cargo;
        this.codigo = codigo;
        this.foto = foto;
        this.estado = estado;
    }

    public Persona(int i, String luis_miguel, String linares, String lozano, String f, String otros, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    
    

}
