/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class InicioSvt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
      String opcion=request.getParameter("opcion"); opcion = opcion ==  null  ?  " "  : opcion;
       switch(opcion)
       {
       case "inicio":
           request.getRequestDispatcher("Principal.jsp").forward(request, response);
           break;
           case "area":
           request.getRequestDispatcher("FormArea.jsp?opcion=Listar").forward(request, response);
           break;
           case "ControlArea":
               request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);
           break;
          case "correo":
           request.getRequestDispatcher("Correo.jsp?opcion=Listar").forward(request, response);
           break;
           case "ControlCorreo":
               request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);
           break;
          case "Telefono":
              request.getRequestDispatcher("Telefono.jsp?opcion=Listar").forward(request, response);
           break;
           case "ControlTelefono":
               request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response);
           break;
           case "PersonaCorreo":
              request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Listar").forward(request, response);
           break;
           case "ControlPersonaCorreo":
               request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
           break;
            case "Persona":
              request.getRequestDispatcher("Persona.jsp?opcion=Listar").forward(request, response);
           break;
           case "ControlPersona":
               request.getRequestDispatcher("Persona.jsp?opcion=Modificar").forward(request, response);
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
