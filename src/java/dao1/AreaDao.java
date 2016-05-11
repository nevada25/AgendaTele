/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.Area;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface AreaDao {
    public List<Area> listar();
    public boolean AgregarArea(Area area);
    public boolean ActualizarArea(Area area);
    public boolean EliminarArea(int id_area);
    public List<Area> listarArea();
    
    public Area obtenerid(int id_area);
}
