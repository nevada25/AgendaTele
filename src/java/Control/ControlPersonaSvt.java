/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import bean.Persona;
import dao1.PersonaDao;
import daoimpl1.PersonaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControlPersonaSvt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        opcion = opcion == null ? " " : opcion;
        String Nombre = request.getParameter("Nombre");
        Nombre = Nombre == null ? " " : Nombre;
        String Apepat = request.getParameter("Apepat");
        Apepat = Apepat == null ? " " : Apepat;
        String Apemat = request.getParameter("Apemat");
        Apemat = Apemat == null ? " " : Apemat;
        String genero = request.getParameter("genero");
        genero = genero == null ? " " : genero;
        String cargo = request.getParameter("Cargo");
        cargo = cargo == null ? " " : cargo;
        String codigo = request.getParameter("Codigo");
        codigo = codigo == null ? " " : codigo;
        String Telefono = request.getParameter("Telefono");
        Telefono = Telefono == null ? " " : Telefono;
        String Ruc = request.getParameter("Ruc");
        Ruc = Ruc == null ? " " : Ruc;
        String Direccion = request.getParameter("Direccion");
        Direccion = Direccion == null ? " " : Direccion;
        String Codigo_uni = request.getParameter("Codigo_uni");
        Codigo_uni = Codigo_uni == null ? " " : Codigo_uni;

        String Id_persona = request.getParameter("Id_persona");
        Id_persona = Id_persona == null ? " " : Id_persona;

        String mensaje = "";
        String alert = "";
        //LLAMANDO A LAS ENTIDADES 
        Persona p = new Persona();
        // LLAMANDO A LOS DAO Y DAOIMPL
        PersonaDao pcdao = new PersonaDaoImpl();
        switch (opcion) {
            case "Agregando":
                request.getRequestDispatcher("Persona.jsp?opcion=AGREGAR").forward(request, response);
                break;
            case "Actualizando":
                request.setAttribute("Persona", pcdao.obteneridpe(Id_persona));
                request.getRequestDispatcher("Persona.jsp?opcion=Actualizar").forward(request, response);

                break;
            case "Eliminando":
                break;
            case "VerPersona":
                request.setAttribute("Persona", pcdao.obteneridpe(Id_persona));
                request.getRequestDispatcher("Persona.jsp?opcion=VERPersona").forward(request, response);
                break;
                    
            case "VerImagen":
                HttpSession sesion = request.getSession();
                response.setContentType("image/jpeg");
                PersonaDao pr = new PersonaDaoImpl();

                String idProducto = String.valueOf(sesion.getAttribute("codigoProducto"));
                int idProd = Integer.parseInt(idProducto);
                byte[] imag = pr.obtenImagenPersona(idProd);
                if (imag != null) {
                    ServletOutputStream out2 = response.getOutputStream();
                    out2.write(imag);
                }
                break;
            case "Agregar":
                p.setNombres(Nombre);
                p.setApepat(Apepat);
                p.setApemat(Apemat);
                p.setGenero(genero);
                p.setCargo(cargo);
                p.setCodigo(Codigo_uni);

                if (pcdao.AgregarPersonas(p)) {
                    alert = "success";
                    mensaje = "SE AGREGO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL AGREGAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                }

                break;
            case "Editar":
                p.setId_persona(Id_persona);
                p.setNombres(Nombre);
                p.setApepat(Apepat);
                p.setApemat(Apemat);
                p.setGenero(genero);
                p.setCargo(cargo);
                p.setCodigo(Codigo_uni);

                if (pcdao.ActualizarPersonas(p)) {
                    alert = "success";
                    mensaje = "SE ACTUALIZO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL ACTUALIZAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                }

                break;
            case "Eliminar":
                if (pcdao.EliminarPersonas(Integer.parseInt(Id_persona))) {
                    alert = "success";
                    mensaje = "SE ELIMINO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL ELIMINAR O DATO SE ESTA UTILIZANDO";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
                }
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
