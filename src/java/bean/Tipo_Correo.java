package bean;
public class Tipo_Correo {
private String id_tipo_correo;
private String descripcion;

    public Tipo_Correo() {
    }

    public Tipo_Correo(String id_tipo_correo, String descripcion) {
        this.id_tipo_correo = id_tipo_correo;
        this.descripcion = descripcion;
    }

    public String getId_tipo_correo() {
        return id_tipo_correo;
    }

    public void setId_tipo_correo(String id_tipo_correo) {
        this.id_tipo_correo = id_tipo_correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }





}
