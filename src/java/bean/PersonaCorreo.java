package bean;

public class PersonaCorreo {

    private String idpercorreo;
    private String id_correo;
    private String correo;
    private String id_area;
    private String area;
    private String id_telefono;
    private String telefono;
    private String id_persona;
    private String persona;

    public PersonaCorreo() {
    }

    public PersonaCorreo(String idpercorreo, String id_correo, String correo, String id_area, String area, String id_telefono, String telefono, String id_persona, String persona) {
        this.idpercorreo = idpercorreo;
        this.id_correo = id_correo;
        this.correo = correo;
        this.id_area = id_area;
        this.area = area;
        this.id_telefono = id_telefono;
        this.telefono = telefono;
        this.id_persona = id_persona;
        this.persona = persona;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getIdpercorreo() {
        return idpercorreo;
    }

    public void setIdpercorreo(String idpercorreo) {
        this.idpercorreo = idpercorreo;
    }

    public String getId_correo() {
        return id_correo;
    }

    public void setId_correo(String id_correo) {
        this.id_correo = id_correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId_area() {
        return id_area;
    }

    public void setId_area(String id_area) {
        this.id_area = id_area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(String id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
