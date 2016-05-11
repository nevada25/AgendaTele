/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.AreaPersona;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface AreaPersonaDao {
    
    public boolean AgregarAreaPersona(AreaPersona area);
    public boolean ActualizarAreaPersona(AreaPersona area);
    public boolean EliminarAreaPersona(int id_area);
    public List<AreaPersona> listarAreaPersona();
    public AreaPersona obtenerid(int id_area);
}
