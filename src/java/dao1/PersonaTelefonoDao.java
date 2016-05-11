/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.Persona_telefono;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface PersonaTelefonoDao {
 public void AgregarPersona_telefono(Persona_telefono persona);
    public List<Persona_telefono> ListarPersona_telefono();
    public boolean ActualizarPersona_telefono(Persona_telefono persona);
    public boolean EliminarPersona_telefono(int id_persona);
}
