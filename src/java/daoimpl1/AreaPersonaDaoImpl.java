package daoimpl1;

import bean.AreaPersona;
import conexion.Conexion;
import dao1.AreaPersonaDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AreaPersonaDaoImpl implements AreaPersonaDao{
Conexion cn = new Conexion();
    @Override
    public boolean AgregarAreaPersona(AreaPersona area) {
        boolean estado=false;
        Statement st;
        String sql = "";
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
    public boolean ActualizarAreaPersona(AreaPersona area) {
         boolean estado=false;
        Statement st;
        String sql = "";
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
    public boolean EliminarAreaPersona(int id_area) {
         boolean estado=false;
        Statement st;
        String sql = "";
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
    public List<AreaPersona> listarAreaPersona() {
          List<AreaPersona> lista = null;
        Statement st = null;
        ResultSet rs = null;
        AreaPersona Ap = null;
        String Query = "";
        try {
            lista = new ArrayList<AreaPersona>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Ap = new AreaPersona();
                Ap.setId_area(rs.getInt("id_correo"));
                Ap.setOpcionAreaPers(rs.getString("correo"));
                Ap.setId_area_pers(rs.getInt("id_correo"));
                Ap.setId_persona(rs.getInt(""));
                Ap.setEstado(rs.getString("estado"));
                lista.add(Ap);
                
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
    public AreaPersona obtenerid(int id_area) {
         Statement st = null;
        ResultSet rs= null;
        String query = "";
        AreaPersona Ap= null;
        
        try {
            st = cn.centroConexion().createStatement();
            rs=st.executeQuery(query);          
            if (rs.next()) {
                Ap = new AreaPersona();
                Ap.setId_area(rs.getInt("id_correo"));
                Ap.setOpcionAreaPers(rs.getString("correo"));
                Ap.setId_area_pers(rs.getInt("id_correo"));
                Ap.setId_persona(rs.getInt(""));
                Ap.setEstado(rs.getString("estado"));
            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            cn.cerrar();
            } catch (Exception ex) {
            }
        }
        return Ap;
    }

}
