/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.PersonaCorreo;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface PersonaCorreoDao {
    
    public boolean InsertPersonaCorreo(PersonaCorreo pc);
    public boolean UpdatePersonaCorreo(PersonaCorreo pc);
    public boolean DeletePersonaCorreo(String id_pc);
    public List<PersonaCorreo> ReadPersonaCorreo();
    public List<PersonaCorreo> VerPersonaCorreo();
    public List<PersonaCorreo> VerPersonaCorreo(String id_pc);
    public List<PersonaCorreo> VerPersonaCorreoArea(String id_area);
    public List<PersonaCorreo> VerPersonaCorreoCorreo(String id_correo);
    public List<PersonaCorreo> VerPersonaCorreoNumero(String id_telefono);
    public PersonaCorreo obteneridPc(String id_pc);
    public PersonaCorreo obtenerPc(PersonaCorreo pc);
}
