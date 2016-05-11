/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl1;

import conexion.Conexion;
import java.sql.Connection;

/**
 *
 * @author Luis Lavado
 */
public class RolDaoImpl {
      Conexion cc=new Conexion();
      public Connection open(){
        return cc.centroConexion();
    }
}
