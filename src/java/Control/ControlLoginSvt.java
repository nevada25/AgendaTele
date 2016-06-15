/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import bean.Usuario;
import dao1.UsuarioDao;
import daoimpl1.UsuarioDaoImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author DOTADO
 */
public class ControlLoginSvt extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String usuario = request.getParameter("usuario");
        usuario = usuario == null ? "" : usuario;
        String clave = request.getParameter("clave");
        clave = clave == null ? "" : clave;
        String correo = request.getParameter("correo");
        correo = correo == null ? "" : correo;
        String tipo_rol = request.getParameter("tipo_rol");
        tipo_rol = tipo_rol == null ? "" : tipo_rol;
        String acciones = request.getParameter("acciones");
        acciones = acciones == null ? "" : acciones;
        String salir = request.getParameter("salir");
        salir = salir == null ? "" : salir;
        String mensaje = "";
        String alert = "";
        String id_usuario = request.getParameter("id_usuario");id_usuario = id_usuario == null ? "" : id_usuario;
        mensaje = mensaje == null ? "" : mensaje;
        String texto=request.getParameter("texto");
        HttpSession session = request.getSession();
        Usuario u = new Usuario();
        UsuarioDao usdao = new UsuarioDaoImpl();
        
        if(acciones.equals("VerImagen")){
        
         HttpSession sesion=request.getSession();
        response.setContentType("image/jpeg");
        UsuarioDao p = new UsuarioDaoImpl();
        
        String idProducto = String.valueOf(sesion.getAttribute("id_usuario"));
        int idProd = Integer.parseInt(idProducto);
        byte[] imag = p.obtenImagenProducto(idProd);
        if (imag != null) {
            ServletOutputStream out2 = response.getOutputStream();
            out2.write(imag);
        }
        }
        
        
        if (acciones.equals("AGREGAR")) {
//            u.setLogin(usuario);
//            u.setClave(clave);
//            u.setCorreo(correo);
//            if (usdao.AgregarUsuario(u)) {
//               mensaje="SE AGREGO CORRECTAMENTE";
//               alert = "success";
//               request.setAttribute("mensaje", mensaje);
//               request.setAttribute("alert", alert);
//               request.getRequestDispatcher("login.jsp").forward(request, response);
//            } else {
//                mensaje="Usuario o password incorrecto...";
//                alert = "error";
//                request.setAttribute("mensaje", mensaje);
//                request.setAttribute("alert", alert);
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//                 
//            }
            
//imagenes
 FileItemFactory file_factory=new DiskFileItemFactory();
        ServletFileUpload sfu= new ServletFileUpload(file_factory);
        
        ArrayList<String> campos=new ArrayList<>();
        ArrayList<String> imgs=new ArrayList<>();
        
        try {
            List items=sfu.parseRequest(request);
             for (int i = 0; i < items.size(); i++) {
                 FileItem  item= (FileItem) items.get(i);
                 if (!item.isFormField()) {
                     File archivo = new File("C:\\Users\\DOTADO\\Documents\\NetBeansProjects\\AgendaTelefonica\\web\\img\\user\\"+item.getName());
                 item.write(archivo);
                 imgs.add("img/user/"+item.getName());
                 }else{
                 campos.add(item.getString());
                 }
            }
        } catch (Exception e) {
        
        }
        Usuario ue=new Usuario(0, campos.get(0), campos.get(1), campos.get(2), imgs.get(0), "1");
        if (usdao.AgregarUsuario(ue)) {
         alert = "success";
                    mensaje = "SE AGREGO CORRECTAMENTE";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                
        }else{
         alert = "error";
                    mensaje = "SE ERROR AL AGREGAR";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
    
        }
                    
        }
        
        
        
        if (acciones.equals("Actualizar")) {
            UsuarioDao as = new UsuarioDaoImpl();
            u.setLogin(usuario);
            u.setClave(clave);

            if (usdao.ActualizarUsuario(u)) {
                response.sendRedirect("menu.jsp?mensaje=SE ACTUALIZO CORRECTAMENTE ");

            } else {
                response.sendRedirect("menu.jsp?mensaje=ERROR AL ACTUALIZAR");
            }

        }

        if (acciones.equals("validar")) {
                if (usdao.validarUsuario(usuario, clave) != null) {
                    u=usdao.validarUsuario(usuario, clave);
                    session.setAttribute("id_usuario", u.getId_usuario());
                    session.setAttribute("usuario", u.getLogin());
                    session.setAttribute("correo", u.getCorreo());
                    session.setAttribute("foto", u.getImg());
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                } else {
                    mensaje="Usuario o password incorrecto...";
                    alert = "warning";
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    
                    
                }
              
            
        }

        if (acciones.equals("cerrar")) {
            session.removeAttribute("id_usuario");
            session.removeAttribute("usuario");
            session.removeAttribute("correo");
            session.removeAttribute("foto");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if (request.getParameter("salir") == null) {
            salir = "";
        }

        if (acciones.equals("Eliminar")) {
            UsuarioDao as = new UsuarioDaoImpl();
            if (as.EliminarUsuario(Integer.parseInt(id_usuario))) {
                response.sendRedirect("menu.jsp?mensaje=ELIMINO correctamente&alert=infor");
                request.getAttribute("alert,info");
            } else {
                response.sendRedirect("menu.jsp?mensaje=ERROR AL ELIMINAR&alert=danger");
                request.getAttribute("alert,danger");
            }
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
