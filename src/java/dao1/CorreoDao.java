package dao1;

import bean.Correo;
import java.util.List;

public interface CorreoDao {
    public boolean InsertCorreo(Correo co);
    public boolean UpdateCorreo(Correo co);
    public boolean DeleteCorreo(int id_correo);
    public Correo BuscarId_correo(String id_correo);
    public List<Correo> ReadCorreo();
}
