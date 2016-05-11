

package bean;

public class Operador {
  private String id_operador;
    private String operadora_nombre;
    private String estado;

    public Operador() {
    }

    public Operador(String id_operador, String operadora_nombre, String estado) {
        this.id_operador = id_operador;
        this.operadora_nombre = operadora_nombre;
        this.estado = estado;
    }

    public String getId_operador() {
        return id_operador;
    }

    public void setId_operador(String id_operador) {
        this.id_operador = id_operador;
    }

    public String getOperadora_nombre() {
        return operadora_nombre;
    }

    public void setOperadora_nombre(String operadora_nombre) {
        this.operadora_nombre = operadora_nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
