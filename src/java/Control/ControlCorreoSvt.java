package Control;

import bean.Correo;
import dao1.CorreoDao;
import daoimpl1.CorreoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlCorreoSvt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // llamar a clase
        CorreoDao CoDao = new CorreoDaoImpl();
        Correo Co = new Correo();
        //llamar los datos
        String Correo = request.getParameter("Correo");
        Correo = Correo == null ? "" : Correo;
        String id_correo = request.getParameter("id_correo");
        id_correo = id_correo == null ? "" : id_correo;
        String Id_Tipo_Correo = request.getParameter("Id_Tipo_Correo");
        Id_Tipo_Correo = Id_Tipo_Correo == null ? "" : Id_Tipo_Correo;
        String Persona = request.getParameter("Persona");
        Persona = Persona == null ? "" : Persona;
        String mensaje = "";
        String alert = "";
        String opcion = request.getParameter("opcion");
        opcion = opcion == null ? "" : opcion;

        switch (opcion) {
            case "Insertar":

                Co.setCorreo(Correo);
                Co.setId_tipo_correo(Id_Tipo_Correo);
                Co.setId_persona(Persona);
                if (CoDao.InsertCorreo(Co)) {
                    alert = "success";
                    mensaje = "SE AGREGO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);

                } else {
                    alert = "error";
                    mensaje = "SE ERROR AL AGREGAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);

                }

                break;
            case "Inser":
                request.getRequestDispatcher("Correo.jsp?opcion=Agregando").forward(request, response);

                break;
            case "Actualizar":
                Co.setId_correo(id_correo);
                Co.setCorreo(Correo);
                Co.setId_tipo_correo(Id_Tipo_Correo);
                if (CoDao.UpdateCorreo(Co)) {
                    alert = "success";
                    mensaje = "SE ACTUALIZO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "SE ERROR AL ACTUALIZAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);
                }

                break;
            case "Edit":
                request.setAttribute("Correo", CoDao.BuscarId_correo(id_correo));
                request.getRequestDispatcher("Correo.jsp?opcion=Actua").forward(request, response);
                break;
            case "Eliminar":
                if (CoDao.DeleteCorreo(Integer.parseInt(id_correo))) {
                    alert = "success";
                    mensaje = "SE ELIMINO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);

                } else {
                    alert = "error";
                    mensaje = "SE ERROR AL ELIMINAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("Correo.jsp?opcion=Modificar").forward(request, response);

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
