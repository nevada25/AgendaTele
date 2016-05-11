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
    private String dni;
    private String fecha_nac;
    private String telefono_propio;
    private String ruc;
    private String direccion;
    private String codigo_uni;
    private InputStream foto_persona;
    private String estado;

    public Persona() {
    }

    public Persona(String id_persona, String nombres, String apepat, String apemat, String genero, String dni, String fecha_nac, String telefono_propio, String ruc, String direccion, String codigo_uni, InputStream foto_persona, String estado) {
        this.id_persona = id_persona;
        this.nombres = nombres;
        this.apepat = apepat;
        this.apemat = apemat;
        this.genero = genero;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.telefono_propio = telefono_propio;
        this.ruc = ruc;
        this.direccion = direccion;
        this.codigo_uni = codigo_uni;
        this.foto_persona = foto_persona;
        this.estado = estado;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono_propio() {
        return telefono_propio;
    }

    public void setTelefono_propio(String telefono_propio) {
        this.telefono_propio = telefono_propio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo_uni() {
        return codigo_uni;
    }

    public void setCodigo_uni(String codigo_uni) {
        this.codigo_uni = codigo_uni;
    }

    public InputStream getFoto_persona() {
        return foto_persona;
    }

    public void setFoto_persona(InputStream foto_persona) {
        this.foto_persona = foto_persona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
