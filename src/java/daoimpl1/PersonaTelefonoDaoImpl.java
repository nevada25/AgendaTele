/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl1;

import bean.Persona;
import bean.Persona_telefono;
import bean.Telefono;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao1.PersonaTelefonoDao;

/**
 *
 * @author Luis Lavado
 */
public class PersonaTelefonoDaoImpl implements PersonaTelefonoDao{
   Conexion cn = new Conexion();

     Conexion cc=new Conexion();
      public Connection open(){
        return cc.centroConexion();
    }

    @Override
    public void AgregarPersona_telefono(Persona_telefono persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona_telefono> ListarPersona_telefono() {
        List<Persona_telefono> list_pertel = null;
        Statement st = null;
        ResultSet rs = null;
        Persona_telefono pt = new Persona_telefono();
        String Query = "SELECT "
                + "  per.id_persona, per.nombres, per.apepat, per.apemat, "
                + "  tel.nro_telefono, per.telefono_propio, per.correo_1, "
                + "  per.dni, per.direccion "
                + "FROM "
                + "  persona per, telefono tel, persona_telefono pertel "
                + "WHERE "
                + "  per.id_persona = pertel.id_persona AND "
                + "  pertel.id_telefono = tel.id_telefono; ";
        try {
            list_pertel = new ArrayList<>();
            st = cn.centroConexion().createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                pt = new Persona_telefono();
                
               
                list_pertel.add(pt);
                cn.cerrar();
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return list_pertel;
    }

    @Override
    public boolean ActualizarPersona_telefono(Persona_telefono persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarPersona_telefono(int id_persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
