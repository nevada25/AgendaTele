package daoimpl1;

import bean.Correo;
import bean.PersonaCorreo;
import conexion.Conexion;
import dao1.PersonaCorreoDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaCorreoDaoImpl implements PersonaCorreoDao {

    Conexion cn = new Conexion();

    @Override
    public boolean InsertPersonaCorreo(PersonaCorreo pc) {
        boolean estado = false;
        Statement st;
        String sql = "INSERT INTO `persona_correo`(`idpercorreo`, `id_area`, `id_correo`, `id_telefono`, `id_persona`) "
                   + "VALUES (null ,"+pc.getId_area()+",null,"+pc.getId_telefono()+","+pc.getId_persona()+")";
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(sql);
            estado = false;
            cn.restaurar();
            cn.cerrar();

        }
        return estado;
    }

    @Override
    public boolean UpdatePersonaCorreo(PersonaCorreo pc) {
        boolean estado = false;
        Statement st;
        String sql = "UPDATE `persona_correo` SET "
                   + " `id_area`="+pc.getId_area()+", "
                   + " `id_correo`="+pc.getId_correo()+", "
                   + " `id_telefono`="+pc.getId_telefono()+" "
                   + "WHERE `idpercorreo`="+pc.getIdpercorreo()+"";
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(sql);
            estado = false;
            cn.restaurar();
            cn.cerrar();

        }
        return estado;
    }

    @Override
    public boolean DeletePersonaCorreo(String id_pc) {
        boolean estado = false;
        Statement st;
        String sql = "DELETE FROM `persona_correo` WHERE `idpercorreo`="+id_pc;
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;

        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            cn.restaurar();
            cn.cerrar();

        }
        return estado;
    }

    @Override
    public List<PersonaCorreo> ReadPersonaCorreo() {
        List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT  pec.`id_correo` as id_correo,CONCAT(c.`correo`,tc.`descripcion`) as correo,"
                + " pec.`id_area` as id_area,a.`nombre_area` as nombre_area, pec.`id_telefono` as id_telefono , t.`nro_telefono` as Nro "
                + "FROM agenda.`persona_correo` pec,agenda.`correo` c,agenda.`area` a, agenda.`telefono` t , agenda.`tipo_correo` tc "
                + "where  c.`id_correo`=pec.`id_correo` and a.`id_area`=pec.`id_area` and  t.`id_telefono`=pec.`id_telefono` "
                + "and tc.`id_tipo_correo`=c.`id_tipo_correo`";
        try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                
                Pc.setId_correo(rs.getString("id_correo"));
                Pc.setCorreo(rs.getString("correo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setArea(rs.getString("nombre_area"));
                Pc.setId_telefono(rs.getString("id_telefono"));
                Pc.setTelefono(rs.getString("Nro"));
                lista.add(Pc);

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
    public PersonaCorreo obteneridPc(String id_pc) {
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT `idpercorreo`, `id_area`, `id_correo`, `id_telefono`, `id_persona` FROM `persona_correo` WHERE `idpercorreo`= " + id_pc;
        PersonaCorreo Pc = null;

        try {
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                Pc.setId_correo(rs.getString("id_correo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setId_telefono(rs.getString("id_telefono"));
                Pc.setId_persona(rs.getString("id_persona"));

            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();

            cn.cerrar();

        }
        return Pc;
    }

    @Override
    public PersonaCorreo obtenerPc(PersonaCorreo pc) {
         Statement st = null;
        ResultSet rs = null;
        String query = "SELECT `id_correo`, `id_area`, `id_telefono` "
                     + "FROM `persona_correo` "
                     + "WHERE `id_correo`="+pc.getId_correo()+" and `id_area`="+pc.getId_area()+" and `id_telefono`="+pc.getId_telefono();
        PersonaCorreo Pc = null;

        try {
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                Pc = new PersonaCorreo();
                pc.setIdpercorreo(rs.getString(""));
                Pc.setId_correo(rs.getString("id_correo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setId_telefono(rs.getString("id_telefono"));

            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();

            cn.cerrar();

        }
        return Pc;
    }

    @Override
    public List<PersonaCorreo> VerPersonaCorreo() {
         List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT p.`idpercorreo` as idpercorreo,p.`id_area` as id_area,a.`nombre_area` as nombre_area,"
                + " t.`nro_telefono` as Nro,p.`id_telefono` as id_telefono, pe.`id_persona` as id_persona , "
                + "CONCAT(pe.`nombres`,' ',pe.`apepat`,' ',pe.`apemat`) as nombre "
                + "FROM `persona_correo` p,`area` a,`telefono` t,`persona` pe "
                + "WHERE a.`id_area`=p.`id_area` and t.`id_telefono`=p.`id_telefono` and pe.`id_persona`=p.`id_persona` ";
                try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setArea(rs.getString("nombre_area"));
                Pc.setId_telefono(rs.getString("id_telefono"));
                Pc.setTelefono(rs.getString("Nro"));
                Pc.setId_persona(rs.getString("id_persona"));
                Pc.setPersona(rs.getString("nombre"));
                lista.add(Pc);

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
    public List<PersonaCorreo> VerPersonaCorreo(String id_pc) {
          List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT p.`idpercorreo` as idpercorreo,p.`id_area` as id_area,a.`nombre_area` as nombre_area, "
                     + "p.`id_correo` as id_correo,t.`nro_telefono` as Nro,p.`id_telefono` as id_telefono, "
                     + "CONCAT(c.`correo`,tc.`descripcion`) as correo ,pe.`id_persona` as id_persona , "
                     + "CONCAT(pe.`nombres`,' ',pe.`apepat`,' ',pe.`apemat`) as nombre "
                     + "FROM `persona_correo` p,`area` a,`correo` c,`telefono` t,`tipo_correo` tc ,`persona` pe "
                     + "WHERE a.`id_area`=p.`id_area` and c.`id_correo`=p.`id_correo`and t.`id_telefono`=p.`id_telefono` "
                     + "and tc.id_tipo_correo=c.id_tipo_correo and pe.`id_persona`=p.`id_persona` and p.`id_area`="+id_pc+" order by pe.`nombres`";
                try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                Pc.setId_correo(rs.getString("id_correo"));
                Pc.setCorreo(rs.getString("correo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setArea(rs.getString("nombre_area"));
                Pc.setId_telefono(rs.getString("id_telefono"));
                Pc.setTelefono(rs.getString("Nro"));
                Pc.setId_persona(rs.getString("id_persona"));
                Pc.setPersona(rs.getString("nombre"));
                lista.add(Pc);

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
    public List<PersonaCorreo> VerPersonaCorreoArea(String id_area) {
          List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT p.`idpercorreo` as idpercorreo,p.`id_area` as id_area,a.`nombre_area` as nombre_area FROM `persona_correo` p,`area` a \n" +
        "WHERE a.`id_area`=p.`id_area` and p.`id_area`="+id_area;
                try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                Pc.setId_area(rs.getString("id_area"));
                Pc.setArea(rs.getString("nombre_area"));
                lista.add(Pc);

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
    public List<PersonaCorreo> VerPersonaCorreoCorreo(String id_correo) {
          List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT p.`idpercorreo` as idpercorreo,p.`id_correo` as id_correo,CONCAT(c.`correo`,tc.`descripcion`) as correo FROM `persona_correo` p,`correo` c,`tipo_correo` tc WHERE c.`id_correo`=p.`id_correo` and tc.id_tipo_correo=c.id_tipo_correo and p.`id_correo`="+id_correo;
                try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                Pc.setId_correo(rs.getString("id_correo"));
                Pc.setCorreo(rs.getString("correo"));
                lista.add(Pc);

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
    public List<PersonaCorreo> VerPersonaCorreoNumero(String id_telefono) {
          List<PersonaCorreo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        PersonaCorreo Pc = null;
        String Query = "SELECT p.`idpercorreo` as idpercorreo,t.`nro_telefono` as Nro,p.`id_telefono` as id_telefono FROM `persona_correo` p,`telefono` t WHERE t.`id_telefono`=p.`id_telefono` and p.`id_telefono` ="+id_telefono;
                try {
            lista = new ArrayList<PersonaCorreo>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                Pc = new PersonaCorreo();
                Pc.setIdpercorreo(rs.getString("idpercorreo"));
                
                Pc.setId_telefono(rs.getString("id_telefono"));
                Pc.setTelefono(rs.getString("Nro"));
                lista.add(Pc);

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
