
package daoimpl1;

import bean.Area;
import bean.Correo;
import conexion.Conexion;
import dao1.CorreoDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CorreoDaoImpl implements CorreoDao{
  Conexion cn = new Conexion();
 
    @Override
    public boolean InsertCorreo(Correo co) {
         boolean estado=false;
        Statement st;
        String sql = "INSERT INTO `correo`(`id_correo`, `id_tipo_correo`, `correo`, `estado`)"
                   + " VALUES (null,"+co.getId_tipo_correo()+",'"+co.getCorreo()+"','1')";
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
            try {
                cn.restaurar();
                cn.cerrar();
            } catch (Exception ex) {
            }
        }
      return estado;
    }

    @Override
    public boolean UpdateCorreo(Correo co) {
           boolean estado=false;
        Statement st;
        String sql = "UPDATE `correo` SET `correo`='"+co.getCorreo()+"',`id_tipo_correo`="+co.getId_tipo_correo()+",`estado`='1' WHERE `id_correo`="+co.getId_correo()+"";
        try {
            st=cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado=true;
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();    
            System.out.println(sql);
            estado=false;
            try {
                cn.restaurar();
                 cn.cerrar();
            } catch (Exception ex) {
            }
        }
      return estado;
  

    }

    @Override
    public boolean DeleteCorreo(int id_correo) {
         boolean estado=false;
        Statement st;
        String sql = "DELETE FROM `correo` WHERE `id_correo` = "+id_correo+"";
        try {
            st=cn.centroConexion().createStatement();
            st.executeUpdate(sql);
           cn.guardar();
           cn.cerrar();
            estado=true;
            
        } catch (Exception e) {
            e.printStackTrace();    
            estado=false;
            try {
                cn.restaurar();
                cn.cerrar();
            } catch (Exception ex) {
            }
        }
      return estado;
    }

    @Override
    public Correo BuscarId_correo(String id_correo) {
        Statement st = null;
        ResultSet rs= null;
        String Query = "SELECT `id_correo`, `id_tipo_correo`, `correo`, `estado` FROM `correo` where `id_correo`="+id_correo;
        Correo co= null;
        
        try {
            st = cn.centroConexion().createStatement();
            rs=st.executeQuery(Query);          
            if (rs.next()) {
                co= new Correo();
                co.setId_correo(rs.getString("id_correo"));
                co.setId_tipo_correo(rs.getString("id_tipo_correo"));
                co.setCorreo(rs.getString("correo"));
                co.setEstado(rs.getString("estado"));
            }
            System.out.println(Query);
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Query);
            cn.cerrar();
        }
        return co;
    }

    @Override
    public List<Correo> ReadCorreo() {
         List<Correo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Correo co = null;
        String Query = "SELECT co.`id_correo` as id_correo,CONCAT(co.`correo`,tc.`descripcion`) as correo " 
                      +"FROM `correo` co,`tipo_correo` tc " 
                      +"WHERE  tc.`id_tipo_correo`=co.`id_tipo_correo`";
        try {
            lista = new ArrayList<Correo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                co = new Correo();
                co.setId_correo(rs.getString("id_correo"));
                co.setCorreo(rs.getString("correo"));
                lista.add(co);
                
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }
    
}
