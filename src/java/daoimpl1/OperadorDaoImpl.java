package daoimpl1;

import bean.Operador;
import conexion.Conexion;
import dao1.OperadorDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperadorDaoImpl implements OperadorDao{
Conexion cn = new Conexion();
  

    @Override
    public List<Operador> listarOperador() {
          List<Operador> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Operador Op = null;
        String Query = "SELECT `id_operador`, `operadora_nombre`, `estado` FROM `operador`";
        try {
            lista = new ArrayList<Operador>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Op= new Operador();
                Op.setId_operador(rs.getString("id_operador"));
                Op.setOperadora_nombre(rs.getString("operadora_nombre"));
                Op.setEstado(rs.getString("estado"));
                lista.add(Op);
                
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
