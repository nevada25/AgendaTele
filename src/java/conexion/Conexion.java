/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DOTADO
 */
public class Conexion {
    
    public static Connection Conexiones() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda2016", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return cn;
    }

    public Connection centroConexion() {
        Connection cn = Conexion.Conexiones();
        return cn;
    }

    public void cerrar() {
        try {
            Conexion.Conexiones().close();
        } catch (Exception e) {
        }
    }

    public void restaurar() {
        try {
            Conexion.Conexiones().rollback();
        } catch (Exception e) {
        }
    }

    public void guardar() {
        try {
            Conexion.Conexiones().commit();
        } catch (Exception e) {
        }
    }
}


