
package bean;

/**
 *
 * @author Luis Lavado
 */
public class Telefono {

    private String id_telefono;
    private String id_operador;
    private String nro_telefono;
    private String descripcion;
    private String estado;
    private String id_persona;
    private String opcTel;

    public Telefono() {
    }

    public Telefono(String id_telefono, String id_operador, String nro_telefono, String descripcion, String estado, String id_persona, String opcTel) {
        this.id_telefono = id_telefono;
        this.id_operador = id_operador;
        this.nro_telefono = nro_telefono;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_persona = id_persona;
        this.opcTel = opcTel;
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

    public String getId_operador() {
        return id_operador;
    }

    public void setId_operador(String id_operador) {
        this.id_operador = id_operador;
    }

    public String getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(String nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOpcTel() {
        return opcTel;
    }

    public void setOpcTel(String opcTel) {
        this.opcTel = opcTel;
    }
    

}
