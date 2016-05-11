package Control;

import bean.Area;
import dao1.AreaDao;
import daoimpl1.AreaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlAreaSvt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // llamar a clase
        AreaDao dao = new AreaDaoImpl();
        Area a = new Area();
        //llamar los datos
        String Empresa = request.getParameter("Empresa");
        Empresa = Empresa == null ? "" : Empresa;
        String Area = request.getParameter("Area");
        Area = Area == null ? "" : Area;
        String id_area = request.getParameter("id_area");
        id_area = id_area == null ? "" : id_area;
        String mensaje = "";
        String alert = "";
        String confir = "";
        String opcion = request.getParameter("opcion");
        opcion = opcion == null ? "" : opcion;

        switch (opcion) {
            case "Agregar":
                a.setNombre_area(Area);
                a.setId_empresa(Empresa);
                if (dao.AgregarArea(a)) {
                    alert = "success";
                    mensaje = "SE AGREGO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "SE ERROR AL AGREGAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);

                }

                break;
            case "Editar":
                a.setId_area(id_area);
                a.setNombre_area(Area);
                a.setId_empresa(Empresa);
                if (dao.ActualizarArea(a)) {
                    alert = "success";
                    mensaje = "SE EDITO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);
                } else {
                    alert = "error";
                    mensaje = "SE ERROR AL EDITAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);

                }

                break;
            case "ControlAreaAgregar":
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("FormArea.jsp?opcion=AGREGAR&mensajes=AGREGAR").forward(request, response);

                break;
            case "ControlAreaEditar":
                request.setAttribute("Empresa", dao.obtenerid(Integer.parseInt(id_area)));
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("FormArea.jsp?opcion=Actualizar&mensaje=AGREGAR").forward(request, response);

                break;
            case "Eliminar":
                    if (dao.EliminarArea(Integer.parseInt(id_area))) {
                    alert = "success";
                    mensaje = "SE ELIMINO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);
                } else {
                    request.getRequestDispatcher("FormArea.jsp?opcion=Modificar").forward(request, response);
                    alert = "error";
                    mensaje = "SE ERROR AL ELIMINAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
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
