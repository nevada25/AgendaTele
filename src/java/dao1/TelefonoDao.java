package dao1;

import bean.Telefono;
import java.util.List;

public interface TelefonoDao {
    public boolean AgregarTelefono(Telefono t);
    public List<Telefono> ListarTelefono();
    public boolean ActualizarTelefono(Telefono t);
    public boolean EliminarTelefono(String id_telefono);
    public Telefono SearchIdTelefono(String id_telefono);
}
