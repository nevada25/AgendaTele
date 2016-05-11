<%@page import="daoimpl.UsuarioDaoImpl"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="bean.Usuario"%>

<%
    String usuario = request.getParameter("usuario"); 
    usuario = usuario == null ? "" : usuario;
    String clave = request.getParameter("clave");
    clave = clave == null ? "" : clave;
    String correo = request.getParameter("correo");
    correo = correo == null ? "" : correo;
    String tipo_rol=request.getParameter("tipo_rol");
    tipo_rol = tipo_rol == null ? "" : tipo_rol;
    String acciones = request.getParameter("acciones");
    acciones = acciones == null ? "" : acciones;
    String salir = request.getParameter("salir");
    salir = salir == null ? "" : salir;
    String mensaje = "";
    String alert = "";
     
    String id_usuario = request.getParameter("id_usuario");mensaje = mensaje==null?"":mensaje;
    id_usuario = id_usuario == null ? "" : id_usuario;
    Usuario user = new Usuario();
    UsuarioDao dao = new UsuarioDaoImpl();
if (acciones.equals("Actualizar")) {
     UsuarioDao as=new UsuarioDaoImpl();
     user.setNombre_usuario(usuario);
     user.setPassword(clave);
     user.setEmail(correo);
    if (dao.updateUsuario(user)) {
        response.sendRedirect("menu.jsp?mensaje=SE ACTUALIZO CORRECTAMENTE ");
      
    } else {
        response.sendRedirect("menu.jsp?mensaje=ERROR AL ACTUALIZAR");
    }

}

  
  
if(acciones.equals("validar")){
 if(usuario !=null & clave !=null ){
    if(dao.validarUsuario(usuario, clave).getNombre_usuario() !=null){
        session.setAttribute("usuario",dao.validarUsuario(usuario, clave).getNombre_usuario());
        session.setAttribute("correo",dao.validarUsuario(usuario, clave).getEmail());
        response.sendRedirect("../principal/index.jsp");
    }else{
        response.sendRedirect("menu.jsp?mensaje=USUARIO NO EXISTE INTENTE NUEVAMENTE&alert=danger");
        request.getAttribute("alert,danger");
    }   
}
 }
 if (acciones.equals("cerrar")) {
    session.removeAttribute("usuario");
    session.removeAttribute("correo");
 }
 if (request.getParameter("salir")==null) {
    salir="";
 }
 
 
 
 
 if (acciones.equals("Eliminar")) {
       UsuarioDao as=new UsuarioDaoImpl();
        if (as.deleteUsuario(Integer.parseInt(id_usuario))) {
            response.sendRedirect("menu.jsp?mensaje=ELIMINO correctamente&alert=infor");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("menu.jsp?mensaje=ERROR AL ELIMINAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
%>

<%
    if (!id_usuario.equals("") && !acciones.equals("Eliminar")) {
        UsuarioDao das = new UsuarioDaoImpl();
        Usuario usera = das.datosServicio(Integer.parseInt(id_usuario));
%>
<form name="usuario" method="post" action="login_form.jsp" autocomplete="off">
    <input type="hidden" name="id_usuario" value="<%=id_usuario%>"/>
    <div class="modal-body">
        <div class="form-group">
            <input type="text" class="form-control" id="servicio" name="usuario" value="<%=usera.getNombre_usuario()%>" placeholder="">
            <br>
            <input type="text" class="form-control" id="servicio" name="correo" value="<%=usera.getPassword()%>" placeholder="">
            <br>
            <input type="text" class="form-control" id="servicio" name="clave" value="<%=usera.getEmail()%>" placeholder="">
            <br>
            <select name="tipo_rol">
                <option>SELECCIONAR TIPO DE ROL</option>
                <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                <option value="USUARIO">USUARIO</option>
            </select>
            <br>
            <center>
             <button  type="submit" name="acciones" value="Actualizar" class="btn btn-primary glyphicon glyphicon-saved"></button>
            <button type="button" class="btn btn-default glyphicon glyphicon-remove" data-dismiss="modal"></button>
            </center>
        </div>
      
    </div>
</form>
<%} else {%>

<script>
    
           $(function (){
               $('#agre_usu').validate()({
           rules :{
             usuario:{
              required:true   
             },
              clave:{
              required:true   
             },
              email:{
              required:true   
             }
               
           },
           messages:{
             usuario:{
              required:'EL CAMPO DE USUARIO ES OBLIGATORIO'   
             },
              clave:{
              required:'EL CAMPO DE CLAVE ES OBLIGATORIA'   
             },
              email:{
              required:'EL CAMPO EMAIL ES OBLIGARIA'  
             }
         },
          submitHandler: function (form){
              
          
          var data=$('#agre_usu').serialize();
              console.log(data);
             $.post("login_form.jsp",data,function (res,est,jqXHR){
                 alert(res);
                 
             });
                
    }
                   
               });
           });

</script>


<form name="agre_usu"  id="agre_usu" action="login_form.jsp" method="POST">

    <div class="modal-body">
        <center>
            <h1><b>AGREGAR USUARIO</b></h1>
        </center>
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <div class="col-lg-8">
                <div class="form-group">
                    <input type="email" class="form-control" id="servicio" name="correo" placeholder="INGRESE CORREO">
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" id="servicio" name="usuario"  placeholder="INGRESE USUARIO">
                </div>
                <div class="form-group">
            <input type="password" class="form-control" id="servicio" name="clave"  placeholder="INGRESE CLAVE O CONTRASE&Ntilde;A">
                </div>
                <div class="form-group">
                    <select name="tipo_rol" style="color: black;" class="form-control">
                <option>SELECCIONAR TIPO DE ROL</option>
                <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                <option value="USUARIO">USUARIO</option>
            </select>    </div>
                 
            </div>
            <div class="col-lg-2"></div>
            <center>
                <button value="Registrar" name="acciones" class="btn-lg btn-success" ><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success " ></span>GUARDAR</button>
            </center>
        </div>
    </div>
</form>

<%}%>