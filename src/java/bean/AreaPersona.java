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
public class AreaPersona {

    private int id_area_pers;
    private int id_area;
    private int id_persona;
    private String estado;
    private String opcionAreaPers;

    public AreaPersona() {
    }

    public AreaPersona(int id_area_pers, int id_area, int id_persona, String estado, String opcionAreaPers) {
        this.id_area_pers = id_area_pers;
        this.id_area = id_area;
        this.id_persona = id_persona;
        this.estado = estado;
        this.opcionAreaPers = opcionAreaPers;
    }

    public int getId_area_pers() {
        return id_area_pers;
    }

    public void setId_area_pers(int id_area_pers) {
        this.id_area_pers = id_area_pers;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOpcionAreaPers() {
        return opcionAreaPers;
    }

    public void setOpcionAreaPers(String opcionAreaPers) {
        this.opcionAreaPers = opcionAreaPers;
    }

    
    
    
}
