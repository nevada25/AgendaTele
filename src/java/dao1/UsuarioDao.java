/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao1;

import bean.Usuario;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface UsuarioDao {
    public boolean AgregarUsuario(Usuario usu);
    public List<Usuario> ListarUsuario();
    public Usuario validarUsuario(String login,String clave);
    public Usuario obtenerid(String id_us);
    public boolean ActualizarUsuario(Usuario usu);
    public boolean EliminarUsuario(int id_usuario);
    public byte[] obtenImagenProducto(int id_usuario);
    public String insertarProducto(String nombreProducto, String dirArchivo);
}
