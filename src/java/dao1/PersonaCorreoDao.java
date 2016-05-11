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
    public PersonaCorreo obteneridPc(String id_pc);
    public PersonaCorreo obtenerPc(PersonaCorreo pc);
}
