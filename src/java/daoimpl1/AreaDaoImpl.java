package daoimpl1;

import bean.Area;

import dao1.AreaDao;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl implements AreaDao {

    Conexion cn = new Conexion();
 
      public Connection open(){
        return cn.centroConexion();
    }
  

    @Override
    public List<Area> listarArea() {
        List<Area> lista_area = null;
        Statement st = null;
        ResultSet rs = null;
        Area a = null;
        String Query = "SELECT `id_area`, UPPER(`nombre_area`) as nombre_area, `estado` FROM `area` order by `nombre_area`";
        try {
            lista_area = new ArrayList<Area>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                a = new Area();
                a.setId_area(rs.getString("id_area"));
                a.setNombre_area(rs.getString("nombre_area"));
                a.setEstado(rs.getString("estado"));
                lista_area.add(a);
                
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista_area;
    }

    @Override
    public boolean AgregarArea(Area a) {
      boolean estado=false;
        Statement st;
        String sql = "INSERT INTO `area`(`id_area`, `nombre_area`, `estado`, `id_empresa`, `id_area_padre`) "
                   + "VALUES (null,'"+a.getNombre_area()+"','1',"+a.getId_empresa()+","+a.getId_area_padre()+")";
        try {
            st=open().createStatement();
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
    public boolean ActualizarArea(Area a) {
            boolean estado=false;
        Statement st;
        String sql = "UPDATE `area` SET `nombre_area`='"+a.getNombre_area()+"' , "
                   + " `estado` = 1,`id_empresa`="+a.getId_empresa()+",`id_area_padre`="+a.getId_area_padre()+" WHERE `id_area`="+a.getId_area();
        try {
            st=open().createStatement();
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
    public boolean EliminarArea(int id_area) {
            boolean estado=false;
        Statement st;
        String sql = "DELETE FROM `area` WHERE `id_area`= "+id_area+"";
        try {
            st=open().createStatement();
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
    public Area obtenerid(int id_area) {
        Statement st = null;
        ResultSet rs= null;
        String query = "SELECT `id_area`, `nombre_area`, `estado`, `id_area_padre`, `id_empresa` FROM `area` WHERE `id_area` = "+id_area;
        Area are= null;
        
        try {
            st = cn.centroConexion().createStatement();
            rs=st.executeQuery(query);          
            if (rs.next()) {
                are= new Area();
                are.setId_area(rs.getString("id_area"));
                are.setNombre_area(rs.getString("nombre_area"));
                are.setEstado(rs.getString("estado"));
                are.setId_area_padre(rs.getString("id_area_padre"));
                are.setId_empresa(rs.getString("id_empresa"));
            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            cn.cerrar();
            } catch (Exception ex) {
            }
        }
        return are;
    }

    @Override
    public List<Area> listar() {
        List<Area> lista_area = null;
        Statement st = null;
        ResultSet rs = null;
        Area a = null;
        String Query = "SELECT a.`id_area` as id_area, UPPER(a.`nombre_area`) as nombre_area, a.`estado` as estado, a.`id_area_padre` as id_area_padre, a.`id_empresa` as id_empresa,UPPER(e.`nombre_empresa`) as nombre_empresa"
                     + " FROM `area` a,`empresa` e WHERE e.`id_empresa`=a.`id_empresa` order by `nombre_area`" +
"";
        try {
            lista_area = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                a = new Area();
                a.setId_area(rs.getString("id_area"));
                a.setNombre_area(rs.getString("nombre_area"));
                a.setNombre_empresa(rs.getString("nombre_empresa"));
                a.setEstado(rs.getString("estado"));
                a.setId_area_padre(rs.getString("id_area_padre"));
                a.setId_empresa(rs.getString("id_empresa"));
                lista_area.add(a);
                
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista_area;
    }

}
