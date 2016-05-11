package daoimpl1;

import bean.Empresa;
import conexion.Conexion;
import dao1.EmpresaDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDaoImpl implements EmpresaDao{
 Conexion cn = new Conexion();
    @Override
    public List<Empresa> ListarEmpresa() {
        List<Empresa> lista= null;
        Statement st = null;
        ResultSet rs = null;
        Empresa e = null;
        String Query = "SELECT `id_empresa`, `nombre_empresa`, `id_tipo_empresa`, `estado`, `id_padre_empresa` FROM `empresa`" +
"";
        try {
            lista= new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
               e= new Empresa();
               e.setId_empresa(rs.getString("id_empresa"));
               e.setNombre_empresa(rs.getString("nombre_empresa"));
               e.setId_tipo_empresa(rs.getString("id_tipo_empresa"));
               e.setEstado(rs.getString("estado"));
               e.setId_padre_empresa(rs.getString("id_padre_empresa"));
                
                lista.add(e);
                
            }
            cn.cerrar();
        } catch (Exception s) {
            System.out.println("ERROR:" + s.getMessage());
            s.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }

    @Override
    public boolean InsertEmpresa(Empresa e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateEmpresa(Empresa e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteEmpresa(Empresa e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa SearchEmpresaid(String id_empresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
