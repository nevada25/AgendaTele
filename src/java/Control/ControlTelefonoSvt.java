package Control;

import bean.Telefono;
import dao1.TelefonoDao;
import daoimpl1.TelefonoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlTelefonoSvt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
        opcion = opcion == null ? " " : opcion;
        String Numero = request.getParameter("Numero");
        Numero = Numero == null ? " " : Numero;
        String id_telefono = request.getParameter("id_telefono");
        id_telefono = id_telefono == null ? " " : id_telefono;
        String Persona = request.getParameter("Persona");
        Persona = Persona == null ? " " : Persona;
        String Operador = request.getParameter("Operador");
        Operador = Operador == null ? " " : Operador;
        String mensaje = "";
        String alert = "";
        //LLAMANDO A LAS ENTIDADES 
        Telefono t = new Telefono();
        // LLAMANDO A LOS DAO Y DAOIMPL
        TelefonoDao tdao = new TelefonoDaoImpl();
        switch (opcion) {
            case "Agregando":
                request.getRequestDispatcher("Telefono.jsp?opcion=AGREGAR&mensajes=AGREGAR").forward(request, response);
                break;
            case "Actualizando":
                request.setAttribute("Telefono", tdao.SearchIdTelefono(id_telefono));
                
                request.getRequestDispatcher("Telefono.jsp?opcion=Actualizar").forward(request, response);

                break;
            case "Eliminando":
                break;
            case "Agregar":
                t.setId_persona(Persona);
                t.setId_operador(Operador);
                t.setNro_telefono(Numero);
                if (tdao.AgregarTelefono(t)) {
                    alert="success";
                    mensaje="SE AGREGO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response);    
                } else {
                    alert="error";
                    mensaje="ERROR AL AGREGAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response); 
                }
                
                break;
            case "Editar":
                t.setId_telefono(id_telefono);
                 t.setId_persona(Persona);
                t.setId_operador(Operador);
                t.setNro_telefono(Numero);
                if (tdao.ActualizarTelefono(t)) {
                    alert="success";
                    mensaje="SE ACTUALIZO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response);    
                } else {
                    alert="error";
                    mensaje="ERROR AL ACTUALIZAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response); 
                }
                
                break;
            case "Eliminar":
                  if (tdao.EliminarTelefono(id_telefono)) {
                    alert="success";
                    mensaje="SE ELIMINO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response);    
                } else {
                    alert="error";
                    mensaje="ERROR AL ELIMINAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Telefono.jsp?opcion=Modificar").forward(request, response); 
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
