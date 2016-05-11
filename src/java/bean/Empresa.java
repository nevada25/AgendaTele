package bean;
public class Empresa {

    private String id_empresa;
    private String nombre_empresa;
    private String id_tipo_empresa;
    private String estado;
    private String id_padre_empresa;

    public Empresa() {
    }

    public Empresa(String id_empresa, String nombre_empresa, String id_tipo_empresa, String estado, String id_padre_empresa) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.id_tipo_empresa = id_tipo_empresa;
        this.estado = estado;
        this.id_padre_empresa = id_padre_empresa;
    }

    public String getId_padre_empresa() {
        return id_padre_empresa;
    }

    public void setId_padre_empresa(String id_padre_empresa) {
        this.id_padre_empresa = id_padre_empresa;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getId_tipo_empresa() {
        return id_tipo_empresa;
    }

    public void setId_tipo_empresa(String id_tipo_empresa) {
        this.id_tipo_empresa = id_tipo_empresa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
