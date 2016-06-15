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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
      private String classFor="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost/agenda2016";
    private String usuario="root";
    private String clave="root";
    @Override
    public boolean AgregarPersonas(Persona p) {
        boolean estado = false;
        Statement st;
        String sql = "INSERT INTO `persona`(`id_persona`, `nombres`, `apepat`, `apemat`, `genero`, `cargo`, `codigo`, `foto`, `estado`) "
                   + "VALUES (null,'"+p.getNombres()+"','"+p.getApepat()+"','"+p.getApemat()+"','"+p.getGenero()+"',"
                   + "'"+p.getCargo()+"','"+p.getCodigo()+"','"+p.getEstado()+"',1)";
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
        String sql = "UPDATE `persona` SET `nombres`='"+p.getNombres()+"',`apepat`='"+p.getApepat()+"',`apemat`='"+p.getApemat()+"'"
                + ",`cargo`='"+p.getCargo()+"',`codigo`='"+p.getCodigo()+"',`foto`='"+p.getFoto()+"',`estado`= 1 WHERE `id_persona`="+p.getId_persona();
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
        String Query = "SELECT `id_persona`, UPPER(CONCAT(`nombres`,' ', `apepat`,' ', `apemat`)) as nombre , `genero`, `cargo`, `codigo`, `foto`, `estado` FROM `persona` ";
        try {
            list_pers = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                p = new Persona();
        p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setCargo(rs.getString("cargo"));
                p.setCodigo(rs.getString("codigo"));
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
        String query = "SELECT `id_persona`, `nombres`, `apepat`, `apemat`, case `genero`when 'M' then 'MASCULINO' when 'F' then 'FEMENINO' "
                     + "end as `genero`, `cargo`, `codigo`, `foto`, `estado` FROM `persona` WHERE `id_persona`="+id_persona;
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
               p.setCargo(rs.getString("cargo"));
                p.setCodigo(rs.getString("codigo"));
                p.setEstado(rs.getString("estado"));
               
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
        String Query = "SELECT `id_persona`, UPPER(CONCAT(`nombres`,' ', `apepat`,' ', `apemat`)) as nombre,"
                     + " case `genero`when 'M' then 'MASCULINO' when 'F' then 'FEMENINO' "
                     + "end as `genero`, `cargo`,`codigo`, `estado` FROM `persona` order by id_persona";
        try {
            list_pers = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                p = new Persona();
                p.setId_persona(rs.getString("id_persona"));
                p.setNombres(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setCargo(rs.getString("cargo"));
                p.setCodigo(rs.getString("codigo"));
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
    public byte[] obtenImagenPersona(int idPer) {
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        byte[] buffer = null;
        try {
            Class.forName(classFor);
            cn=DriverManager.getConnection(url, usuario,clave);
            String sql = "SELECT  `foto` FROM `persona` WHERE `id_persona` = ?";
            pr = cn.prepareStatement(sql);
            pr.setInt(1, idPer);
            rs = pr.executeQuery();
            while (rs.next()){
                Blob bin = rs.getBlob("fotoProducto");
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

  
}
