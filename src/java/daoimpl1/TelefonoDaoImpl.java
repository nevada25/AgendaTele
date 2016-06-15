package daoimpl1;
import bean.Telefono;
import conexion.Conexion;
import dao1.TelefonoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TelefonoDaoImpl implements TelefonoDao{

    Conexion cn = new Conexion();
    @Override
    public boolean AgregarTelefono(Telefono t) {
         boolean estado=false;
        Statement st;
        String sql = "INSERT INTO `telefono`(`id_telefono`, `id_operador`, `nro_telefono`, `descripcion`, `estado`)"
                    +" VALUES (null,"+t.getId_operador()+",'"+t.getNro_telefono()+"','"+t.getDescripcion()+"',1)";
        try {
            st=cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado=true;
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();    
            estado=false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
      return estado;
    }

    @Override
    public List<Telefono> ListarTelefono() {
         List<Telefono> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Telefono t = null;
        String Query = "SELECT t.`id_telefono` as id_telefono ,t.`id_operador` as id_operador , "
                     + "o.`operadora_nombre` as operadora_nombre ,t.`nro_telefono` as nro_telefono ,"
                     + "t.`descripcion` as descripcion,t.`estado` as estado FROM `telefono` t ,`operador` o "
                     + "WHERE o.`id_operador`=t.`id_operador` order by operadora_nombre";
        try {
            lista= new ArrayList<Telefono>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                t= new Telefono();
                t.setId_telefono(rs.getString("id_telefono"));
                t.setId_operador(rs.getString("id_operador"));
                t.setNro_telefono(rs.getString("nro_telefono"));
                t.setDescripcion(rs.getString("operadora_nombre"));
                lista.add(t);
                
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }

    @Override
    public boolean ActualizarTelefono(Telefono t) {
         boolean estado=false;
        Statement st;
        String sql = "UPDATE `telefono` SET `id_operador` = "+t.getId_operador()+" , `nro_telefono`='"+t.getNro_telefono()+"' , "
                   + "`descripcion` = '"+t.getDescripcion()+"', `estado` = 1  WHERE `id_telefono` = "+t.getId_telefono();
        try {
            st=cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado=true;
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();    
            estado=false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
      return estado;
    }

    @Override
    public boolean EliminarTelefono(String id_telefono) {
         boolean estado=false;
        Statement st;
        String sql = "DELETE FROM `telefono` WHERE `id_telefono` = "+id_telefono;
        try {
            st=cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado=true;
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();    
            estado=false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
      return estado;
    }

    @Override
    public Telefono SearchIdTelefono(String id_telefono) {
        Statement st = null;
        ResultSet rs= null;
        String query = "SELECT `id_telefono`, `id_operador`, `nro_telefono`, `descripcion`, `estado` FROM `telefono` WHERE  `id_telefono` = "+id_telefono;
        Telefono te= null;
        
        try {
            st = cn.centroConexion().createStatement();
            rs=st.executeQuery(query);          
            if (rs.next()) {
                te= new Telefono();
                te.setId_telefono(rs.getString("id_telefono"));
                te.setId_operador(rs.getString("id_operador"));
                te.setNro_telefono(rs.getString("nro_telefono"));
                te.setDescripcion(rs.getString("descripcion"));
                te.setEstado(rs.getString("estado"));
                
            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            cn.cerrar();
            } catch (Exception ex) {
            }
        }
        return te;
    }

  }
