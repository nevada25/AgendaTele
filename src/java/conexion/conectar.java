/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import bean.Area;
import bean.Correo;
import bean.Persona;
import bean.PersonaCorreo;
import bean.Telefono;

import bean.Usuario;
import dao1.AreaDao;
import dao1.CorreoDao;
import dao1.PersonaCorreoDao;
import dao1.PersonaDao;
import dao1.TelefonoDao;

import dao1.UsuarioDao;
import daoimpl1.AreaDaoImpl;
import daoimpl1.CorreoDaoImpl;
import daoimpl1.PersonaCorreoDaoImpl;
import daoimpl1.PersonaDaoImpl;
import daoimpl1.RolDaoImpl;
import daoimpl1.TelefonoDaoImpl;
import daoimpl1.UsuarioDaoImpl;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import org.apache.commons.codec.digest.DigestUtils;

public class conectar {

    public static void main(String[] args) {
        UsuarioDao dao = new UsuarioDaoImpl();
        conectar c = new conectar();
        Conexion cc = new Conexion();

        AreaDao ar = new AreaDaoImpl();
//     c.listarPEr();
    c.conecctar();
//area llamadas
//    c.listaarea();
//    c.agregararea();
//        c.actuarea();
//c.TelefonoId();
//c.PErsomaCorreoid();
//c.PersonaId();
//c.agregarper();
//c.actualizarpers();
//      c.eliminararea();
//c.areaid();
//c.listaCorreo();
//c.Correid();
//c.agregarcorreo();
//c.agregarusu();

////if (cc!= null) {
////            System.out.println("Conección Establecida");
////            
////        }else{
////     System.out.println("ERROR");
////}
    }

    public void conecctar() {
        UsuarioDao dao = new UsuarioDaoImpl();

        if (dao.validarUsuario("kevin", "kevin").getLogin() != null) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    //Area pruebas
    public void areaid() {
        AreaDao ar = new AreaDaoImpl();
        Area a = ar.obtenerid(2);

        System.out.println("NOMBRE:" + a.getNombre_area());

    }

    public void Correid() {
        CorreoDao co = new CorreoDaoImpl();
        Correo aco = co.BuscarId_correo("1");

        System.out.println("NOMBRE:" + aco.getCorreo());
        System.out.println("ID TIPO CORREO:" + aco.getId_tipo_correo());
        System.out.println("Tipo:" + aco.getId_tipo_correo());

    }
    public void PErsomaCorreoid() {
        PersonaCorreoDao co = new  PersonaCorreoDaoImpl();
        PersonaCorreo pc=new PersonaCorreo();
        PersonaCorreo aco = co.obteneridPc("1");
System.out.println("PERSONA CORREO:" + aco.getIdpercorreo());
        System.out.println("AREA:" + aco.getId_area());
        System.out.println("CORREO:" + aco.getId_correo());
        System.out.println("TELEFONO:" + aco.getId_telefono());

    }

    public void TelefonoId() {
        TelefonoDao te = new TelefonoDaoImpl();
        Telefono ate = te.SearchIdTelefono("2");
        System.out.println("DEscripcion:" + ate.getDescripcion());
        System.out.println("ESTADO:" + ate.getEstado());
        System.out.println("id_operador:" + ate.getId_operador());
        System.out.println("ID PERSONA:" + ate.getId_persona());
        System.out.println("Id_TElefono:" + ate.getId_telefono());
        System.out.println("Numero:" + ate.getNro_telefono());
        

    }
    public void PersonaId() {
        PersonaDao te = new PersonaDaoImpl();
        Persona ate = te.obteneridpe("1");
        System.out.println("nombre:" + ate.getNombres());
        System.out.println("papa:" + ate.getApepat());
        System.out.println("mama:" + ate.getApemat());
        
        

    }
public void actualizarpers(){
Persona p=new Persona();
PersonaDao dao=new PersonaDaoImpl();

p.setId_persona("7");
p.setNombres("JOSE");
p.setApemat("LOZANO");
p.setApepat("LINARES");
p.setCargo("AGRICULTOR");
p.setCodigo("789456132");
    if (dao.ActualizarPersonas(p)) {
        System.out.println("ok");
    } else {
        System.out.println("ERROR");
    }

}

    public void listaarea() {

        AreaDao ar = new AreaDaoImpl();
        for (Area com : ar.listar()) {
            System.out.println("NOMBRE:" + com.getNombre_area());
            System.out.println("Empresa:" + com.getNombre_empresa());

        }
    }

    public void listarPEr() {

        PersonaDao ar = new PersonaDaoImpl();
        for (Persona com : ar.ListarPersona()) {
            System.out.println("Id:" + com.getId_persona());
            System.out.println("NOMBRE:" + com.getNombres());

        }
    }

    public void listaCorreo() {
        CorreoDao ar = new CorreoDaoImpl();
        for (Correo com : ar.ReadCorreo()) {
            System.out.println("NOMBRE:" + com.getCorreo());

        }
    }

    public void agregarper() {
        PersonaDao dao=new PersonaDaoImpl();
        Persona p= new Persona();
         p.setId_persona("2");
                p.setNombres("JJOSE");
                p.setApepat("erwrw");
                p.setApemat("wqe");
                p.setGenero("F");
                
        if (dao.ActualizarPersonas(p)) {
            System.out.println("SE actu CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL actu");
        }

    }
    public void agregararea() {
        AreaDao ar = new AreaDaoImpl();
        Area a = new Area();
        a.setNombre_area("INGENIERIA");
        if (ar.AgregarArea(a)) {
            System.out.println("SE AGREGO CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL AGREGAR");
        }

    }

    public void agregarcorreo() {
        CorreoDao corda = new CorreoDaoImpl();
        Correo co = new Correo();
        co.setCorreo("calderon200396");
        co.setId_tipo_correo("1");
        if (corda.InsertCorreo(co)) {
            System.out.println("SE AGREGO CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL AGREGAR");
        }

    }

//    public void agregarusu() {
//        UsuarioDao usu = new UsuarioDaoImpl();
//        Usuario u = new Usuario();
//        u.setId_personas(1);
//        u.setLogin("yessy");
//        String claveEmcrip = DigestUtils.md5Hex("yessy");
//        u.setClave(claveEmcrip);
//
//        if (usu.AgregarUsuario(u)) {
//            System.out.println("SE AGREGO CORRECTAMENTE");
//        } else {
//            System.out.println("ERROR AL AGREGAR");
//        }
//
//    }

    public void actuarea() {
        AreaDao ar = new AreaDaoImpl();
        Area a = new Area();
        a.setId_area("3");
        a.setNombre_area("ADMISIOn2");
        a.setId_empresa("1");
        if (ar.ActualizarArea(a)) {
            System.out.println("SE ACTUALIZO CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL ACTUALIZAR");
        }

    }

    public void eliminararea() {
        AreaDao ar = new AreaDaoImpl();
        Area a = new Area();
        if (ar.EliminarArea(5)) {
            System.out.println("SE ELIMINO CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL ELIMINAR");
        }
    }
}
