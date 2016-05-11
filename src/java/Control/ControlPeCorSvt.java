package Control;
import bean.PersonaCorreo;
import dao1.PersonaCorreoDao;
import daoimpl1.PersonaCorreoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ControlPeCorSvt extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String opcion = request.getParameter("opcion");
        opcion = opcion == null ? " " : opcion;
        String Id_Per_Correo= request.getParameter("Id_Per_Correo");
        Id_Per_Correo = Id_Per_Correo == null ? " " : Id_Per_Correo;
        String id_telefono = request.getParameter("id_telefono");
        id_telefono = id_telefono == null ? " " : id_telefono;
        String id_correo = request.getParameter("id_correo");
        id_correo = id_correo == null ? " " : id_correo;
        String id_area = request.getParameter("id_area");
        id_area = id_area == null ? " " : id_area;
        String Correo = request.getParameter("Correo");
        Correo = Correo == null ? " " : Correo;
        String Area = request.getParameter("Area");
        Area = Area == null ? " " : Area;
        String Telefono = request.getParameter("Telefono");
        Telefono = Telefono == null ? " " : Telefono;
        String mensaje = "";
        String alert = "";
        //LLAMANDO A LAS ENTIDADES 
        PersonaCorreo pc = new PersonaCorreo();
        // LLAMANDO A LOS DAO Y DAOIMPL
        PersonaCorreoDao pcdao = new PersonaCorreoDaoImpl();
        switch (opcion) {
            case "Agregando":
                request.getRequestDispatcher("PersonaCorreo.jsp?opcion=AGREGAR").forward(request, response);
                break;
            case "Actualizando":
                request.setAttribute("PersonaCorreo", pcdao.obteneridPc(Id_Per_Correo));
                request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Actualizar").forward(request, response);

                break;
            case "Eliminando":
                break;
            case "Agregar":
                pc.setId_area(Area);
                pc.setId_correo(Correo);
                pc.setId_telefono(Telefono);
                if (pcdao.InsertPersonaCorreo(pc)) {
                    alert = "success";
                    mensaje = "SE AGREGO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL AGREGAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
                }

                break;
            case "Editar":
                 pc.setIdpercorreo(Id_Per_Correo);
                 pc.setId_area(Area);
                pc.setId_correo(Correo);
                pc.setId_telefono(Telefono);
                if (pcdao.UpdatePersonaCorreo(pc)) {
                    alert = "success";
                    mensaje = "SE ACTUALIZO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL ACTUALIZAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
                }

                break;
            case "Eliminar":
                if (pcdao.DeletePersonaCorreo(id_telefono)) {
                    alert = "success";
                    mensaje = "SE ELIMINO CORRECTAMENTE";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "ERROR AL ELIMINAR";
                    request.setAttribute("alert", alert);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("PersonaCorreo.jsp?opcion=Modificar").forward(request, response);
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
