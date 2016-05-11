/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl1;

import bean.Usuario;
import conexion.Conexion;
import dao1.UsuarioDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public class UsuarioDaoImpl implements UsuarioDao{
    Conexion cc=new Conexion();
      public Connection open(){
        return cc.centroConexion();
    }
      private String classFor="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost/agenda2016";
    private String usuario="root";
    private String clave="root";
    @Override
    public boolean AgregarUsuario(Usuario usu) {
         boolean estado=false;
        Statement st;
        String sql = "INSERT INTO `usuario`(`id_usuario`, `login`, `clave`, `correo`, `estado`)"
                   + " VALUES (null,'"+usu.getLogin()+"','"+usu.getClave()+"','"+usu.getCorreo()+"','1')";
        try {
            st=open().createStatement();
            st.executeUpdate(sql);
            cc.guardar();
            cc.cerrar();
            estado=true;
            
        } catch (Exception e) {
            e.printStackTrace();    
            estado=false;
            try {
                cc.restaurar();
                cc.cerrar();
            } catch (Exception ex) {
            }
        }
      return estado;
    }

    @Override
    public List<Usuario> ListarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario validarUsuario(String login, String clave) {
         Statement st = null;
        ResultSet rs= null;
        String query = "SELECT * FROM `usuario` WHERE  login='"+login+"' and clave='"+clave+"' and estado='1'";
        Usuario u = null;
        
        try {
            st = open().createStatement();
            rs=st.executeQuery(query);          
            while (rs.next()) {
                u= new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setClave(rs.getString("clave"));      
                u.setCorreo(rs.getString("correo"));
                
            }
            open().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                open().close();
            } catch (Exception ex) {
            }
        }
    return u;
    }

    @Override
    public boolean ActualizarUsuario(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarUsuario(int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerid(String id_us) {
          Statement st = null;
        ResultSet rs= null;
        String query = "";
        Usuario u = null;
        
        try {
            st = open().createStatement();
            rs=st.executeQuery(query);          
            while (rs.next()) {
                u= new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setClave(rs.getString("clave"));             
                
            }
            open().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                open().close();
            } catch (Exception ex) {
            }
        }
    return u;
    }

    @Override
    public byte[] obtenImagenProducto(int id_usuario) {
         Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        byte[] buffer = null;
        try {
            Class.forName(classFor);
            cn=DriverManager.getConnection(url, usuario,clave);
            String sql = "SELECT `foto` FROM `usuario` WHERE `id_usuario`= ?";
            pr = cn.prepareStatement(sql);
            pr.setInt(1, id_usuario);
            rs = pr.executeQuery();
            while (rs.next()){
                Blob bin = rs.getBlob("foto");
                if (bin != null) {
                    InputStream inStream = bin.getBinaryStream();
                    int size = (int) bin.length();
                    buffer = new byte[size];
                    int length = -1;
                    int k = 0;
                    try {
                        inStream.read(buffer, 0, size);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            return null;
        } finally {
            cn=null;
            rs = null;
            pr = null;
        }
        return buffer;
    }

    @Override
    public String insertarProducto(String nombreProducto, String dirArchivo) {
        String inserto="";
        Connection cn=null;
        PreparedStatement pr=null;
        String sql="INSERT INTO Producto(nombreProducto, nombreImagen, tamannoImagen, fotoProducto) ";
        sql+="VALUES(?,?,?,?)";
        try{
            Class.forName(classFor);
            cn=DriverManager.getConnection(url, usuario,clave);
            pr=cn.prepareStatement(sql);
            pr.setString(1, nombreProducto);
            pr.setString(2, nombreProducto+".jpg");
            //Parametros de la imagen
            File fichero = new File(dirArchivo);
            FileInputStream streamEntrada = new FileInputStream(fichero);
            int tamañoImagen = streamEntrada.available();
            //Establecer los parametros a la BD
            pr.setInt(3, tamañoImagen);
            pr.setBinaryStream(4, streamEntrada, (int) fichero.length());
            if(pr.executeUpdate()==1){
                inserto="Se inserto el producto de forma correcta";
            }else{
                inserto="No se pudo insertar al producto";
            }
        }catch(Exception ex){
            inserto=ex.getMessage();
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(Exception ex){

            }
        }
        return inserto;
    }


 }
