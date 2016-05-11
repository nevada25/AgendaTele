package daoimpl1;

import bean.Tipo_Correo;
import conexion.Conexion;
import dao1.TipoCorreoDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoCorreoDaoImpl  implements TipoCorreoDao{
 Conexion cn = new Conexion();
    @Override
    public List<Tipo_Correo> ReadTipo_Correo() {
          List<Tipo_Correo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Tipo_Correo ti_co = null;
        String Query = " SELECT `id_tipo_correo`, `descripcion` FROM `tipo_correo`";
        try {
            lista= new ArrayList<Tipo_Correo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                ti_co = new Tipo_Correo();
                ti_co.setId_tipo_correo(rs.getString("id_tipo_correo"));
                ti_co.setDescripcion(rs.getString("descripcion"));
                lista.add(ti_co);
                
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
