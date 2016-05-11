/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.Persona;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luis Lavado
 */
public interface PersonaDao {
    
    public boolean AgregarPersonas(Persona p);
    public List<Persona> ListarPersonas();
    public List<Persona> ListarPersona();
    public List<Persona> ReadPersona();
    public boolean ActualizarPersonas(Persona p);
    public boolean EliminarPersonas(int id_persona);
    public Persona obteneridpe(String id_persona);
    //public String insertarProducto(String nombreProducto, String dirArchivo);
    //public String actualizarProducto(int codigo, String nombreProducto, String dirArchivo);
   // public String eliminarProducto(int codigo);
    //public Persona buscarProductoCodigo(int codigo);
    //public Vector<Persona> buscarProducto();
    public byte[] obtenImagenProducto(int idProducto);
}
