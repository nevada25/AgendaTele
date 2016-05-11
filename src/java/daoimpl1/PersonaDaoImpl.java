/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl1;

import bean.Persona;
import bean.Persona_telefono;
import bean.Telefono;

import dao1.PersonaDao;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Luis Lavado
 */
public class PersonaDaoImpl implements PersonaDao {

    Conexion cn = new Conexion();

    @Override
    public boolean AgregarPersonas(Persona p) {
        boolean estado = false;
        Statement st;
        String sql = "INSERT INTO `persona`(`id_persona`, `nombres`, `apepat`, `apemat`, `genero`, "
                + "`dni`, `fecha_nac`, `telefono_propio`, `ruc`, `direccion`, `codigo_uni`, `foto_persona`, `estado`) "
                + "VALUES (null,'"+p.getNombres()+"','"+p.getApepat()+"','"+p.getApemat()+"','"+p.getGenero()+"',"
                + " '"+p.getDni()+"','"+p.getFecha_nac()+"','"+p.getTelefono_propio()+"','"+p.getRuc()+"','"+p.getDireccion()+"',"
                + "'"+p.getCodigo_uni()+"','"+p.getFoto_persona()+"','1')";
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
        return estado;
    }

    @Override
    public List<Persona> ListarPersonas() {
        List<Persona> list_pers = null;
        Statement st = null;
        ResultSet rs = null;
        Persona p = null;
        Telefono t = null;
        String Query = "SELECT "
                + "  per.nombres, per.apepat, per.apemat, "
                + "  tel.nro_telefono, per.telefono_propio, per.correo_1, "
                + "  per.dni, per.direccion "
                + "FROM "
                + "  persona per, telefono tel, persona_telefono pertel "
                + "WHERE "
                + "  per.id_persona = pertel.id_persona AND "
                + "  pertel.id_telefono = tel.id_telefono; ";
        try {
            list_pers = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                p = new Persona();
                t = new Telefono();
                //pt = new Persona_telefono();
                //p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombres"));
                p.setApepat(rs.getString("apepat"));
                p.setApemat(rs.getString("apemat"));
                t.setNro_telefono(rs.getString("nro_telefono"));
                p.setTelefono_propio(rs.getString("telefono_propio"));

                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                list_pers.add(p);
                cn.cerrar();
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return list_pers;
    }

    @Override
    public boolean ActualizarPersonas(Persona p) {
        boolean estado = false;
        Statement st;
        String sql = "UPDATE `persona` SET `nombres`='"+p.getNombres()+"',"
                   + "`apepat`='"+p.getApepat()+"',`apemat`='"+p.getApemat()+"',`genero`='"+p.getGenero()+"',`dni`='"+p.getDni()+"',"
                   + "`fecha_nac`='"+p.getFecha_nac()+"',`telefono_propio`='"+p.getTelefono_propio()+"',`ruc`='"+p.getRuc()+"',`"
                   + "direccion`='"+p.getDireccion()+"',`codigo_uni`='"+p.getCodigo_uni()+"',`foto_persona`='"+p.getFoto_persona()+"',"
                   + "`estado`='1' WHERE `id_persona`="+p.getId_persona();
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
        return estado;
    }

    @Override
    public boolean EliminarPersonas(int id_persona) {
        boolean estado = false;
        Statement st;
        String sql = "DELETE FROM `persona` WHERE `id_persona`="+id_persona;
        try {
            st = cn.centroConexion().createStatement();
            st.executeUpdate(sql);
            cn.guardar();
            cn.cerrar();
            estado = true;
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            System.out.println(sql);
                cn.restaurar();
                cn.cerrar();
            
        }
        return estado;
    }

    @Override
    public List<Persona> ListarPersona() {
        List<Persona> list_pers = null;
        Statement st = null;
        ResultSet rs = null;
        Persona p = null;
        String Query = "SELECT `id_persona`,CONCAT( `nombres`,' ', `apepat`, ' ',`apemat`) as nombre, "
                + " `genero`, `dni`, `fecha_nac`, `telefono_propio`, `ruc`, `direccion`,"
                + " `codigo_uni`, `foto_persona`, `estado` FROM `persona` ";
        try {
            list_pers = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                p = new Persona();
                p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setDni(rs.getString("dni"));
                p.setFecha_nac(rs.getString("fecha_nac"));
                p.setDireccion(rs.getString("direccion"));
                p.setCodigo_uni(rs.getString("codigo_uni"));
                p.setEstado(rs.getString("estado"));
                list_pers.add(p);
                cn.cerrar();
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return list_pers;
    }

    @Override
    public Persona obteneridpe(String id_persona) {
        Statement st = null;
        ResultSet rs= null;
        String query = "SELECT `id_persona`, `nombres`, `apepat`, `apemat`, `genero`, `dni`,"
                + " `fecha_nac`, `telefono_propio`, `ruc`, `direccion`, `codigo_uni`, `foto_persona`, `estado` "
                + "FROM `persona` WHERE `id_persona`= "+id_persona;
        Persona p= null;
        
        try {
            st = cn.centroConexion().createStatement();
            rs=st.executeQuery(query);          
            if (rs.next()) {
               p = new Persona();
                p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombres"));
                p.setApepat(rs.getString("apepat"));
                p.setApemat(rs.getString("apemat"));
                p.setGenero(rs.getString("genero"));
                p.setDni(rs.getString("dni"));
                p.setTelefono_propio(rs.getString("telefono_propio"));
                p.setFecha_nac(rs.getString("fecha_nac"));
                p.setDireccion(rs.getString("direccion"));
                p.setRuc(rs.getString("ruc"));
                p.setCodigo_uni(rs.getString("codigo_uni"));
                p.setEstado(rs.getString("estado"));
                p.setFoto_persona(rs.getBinaryStream("foto_persona"));
            }
            cn.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
            try {
            cn.cerrar();
            } catch (Exception ex) {
            }
        }
        return p;
    }

    @Override
    public List<Persona> ReadPersona() {
         List<Persona> list_pers = null;
        Statement st = null;
        ResultSet rs = null;
        Persona p = null;
        String Query = "SELECT `id_persona`, CONCAT(`nombres`,' ', `apepat`,' ', `apemat`) as nombre, "
                + "case `genero`when 'M' then 'MASCULINO' when 'F' then 'FEMENINO' end as `genero`, `dni`, "
                + "`fecha_nac`, `ruc`,`telefono_propio`, `direccion`, `codigo_uni`, `estado` FROM `persona`";
        try {
            list_pers = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                p = new Persona();
                p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setDni(rs.getString("dni"));
                p.setTelefono_propio(rs.getString("telefono_propio"));
                p.setFecha_nac(rs.getString("fecha_nac"));
                p.setDireccion(rs.getString("direccion"));
                p.setRuc(rs.getString("ruc"));
                p.setCodigo_uni(rs.getString("codigo_uni"));
                p.setEstado(rs.getString("estado"));
                list_pers.add(p);
                cn.cerrar();
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return list_pers;
    }

    
    @Override
    public byte[] obtenImagenProducto(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
