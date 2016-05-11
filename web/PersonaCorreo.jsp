<%@page import="daoimpl1.PersonaCorreoDaoImpl"%>
<%@page import="dao1.PersonaCorreoDao"%>
<%@page import="bean.PersonaCorreo"%>
<%@page import="daoimpl1.CorreoDaoImpl"%>
<%@page import="dao1.CorreoDao"%>
<%@page import="daoimpl1.AreaDaoImpl"%>
<%@page import="dao1.AreaDao"%>
<%@page import="daoimpl1.TelefonoDaoImpl"%>
<%@page import="dao1.TelefonoDao"%>
<%@page import="bean.Correo"%>
<%@page import="bean.Area"%>
<%@page import="bean.Telefono"%>
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="PersonaCorreo" scope="request" class="bean.PersonaCorreo" />
<%    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? " " : opcion;

    String Id_Per_Correo = request.getParameter("Id_Per_Correo");
    Id_Per_Correo = Id_Per_Correo == null ? " " : Id_Per_Correo;
    String id_correo = request.getParameter("id_correo");
    id_correo = id_correo == null ? " " : id_correo;
    String id_area = request.getParameter("id_area");
    id_area = id_area == null ? " " : id_area;
    String t_are = PersonaCorreo.getId_area();
    t_are = t_are == null ? " " : t_are;
    String t_cor = PersonaCorreo.getId_correo();
    t_cor = t_cor == null ? " " : t_cor;
    String t_tel = PersonaCorreo.getId_telefono();
    t_tel = t_tel == null ? " " : t_tel;
    String id_per_co = request.getParameter("id_per_co");
    id_per_co = id_per_co == null ? " " : id_per_co;
    //llamar entidades
    Telefono t = new Telefono();
    PersonaCorreo pc = new PersonaCorreo();
    Area a = new Area();
    Correo c = new Correo();
    //llamar clasesdaoimpl y  clasesdao
    TelefonoDao tdao = new TelefonoDaoImpl();
    PersonaCorreoDao pcdao = new PersonaCorreoDaoImpl();
    AreaDao adao = new AreaDaoImpl();
    CorreoDao cdao = new CorreoDaoImpl();
    if (opcion.equals("Listar")) {
%>
<%@include file="cabeza.jsp" %>

<div class="panel-info">
    <center><h1><b>TELEFONO</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="col-lg-1 text-center">#</th>
                    <th class="col-lg-5">AREA</th>
                    <th class="col-lg-3">CORREO</th>
                    <th class="col-lg-3">TELEFONO</th>
                </tr>
            </thead>
            <tbody>
                <%            int count = 0;
                    for (PersonaCorreo lista : pcdao.VerPersonaCorreo()) {
                        count++;
                %>
                <tr>

                    <td class="col-lg-1 text-center"><%=count%></td>
                    <td class="col-lg-5"><%=lista.getArea()%></td>
                    <td class="col-lg-3"><%=lista.getCorreo()%></td>
                    <td class="col-lg-3"><%=lista.getTelefono()%></td>

                </tr>
                <%

                    }%>
            </tbody>
        </table>
    </div>
    <div class="col-lg-1"></div>
</div>     
<%@include file="pie.jsp" %>
<%
    }

    if (opcion.equals("Modificar")) {
%>
<%@include file="cabeza.jsp" %>
<script>
    alertify.<%=alert%>("<%=mensaje%>");
</script>
<div class="panel-heading">
    <center><h1><b>PERSONA CORREO</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-1"></div>

    <table class="table table-bordered table-hover table-responsive">
        <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

            <div class="modal-dialog" role="document">
                <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                    <div class="modal-header" >
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR PERSONA CORREO</b></h3>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">  
                        <div id="pc_resul"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="Editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

            <div class="modal-dialog" role="document">
                <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                    <div class="modal-header" >
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b> EDITAR PERSONA CORREO</b></h3>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">  
                        <div id="pcEdi_resul"></div>
                    </div>
                </div>
            </div>
        </div>
        <thead>
            <tr>
                <th class="text-center">#</th>
                <th class="col-lg-5">AREA</th>
                <th class="col-lg-3">CORREO</th>
                <th class="col-lg-3">TELEFONO</th>
                <th colspan="2" class="col-lg-4 text-center">OPCIONES <a class="btn btn-info  material-icons" href="javascript:void(0)" onclick="javascript:AgregarPersonaCorreo()" data-toggle="modal" data-target="#agregar" >add</a></th>
            </tr>
        </thead>

        <tbody>
            <%            int count = 0;
                for (PersonaCorreo lista : pcdao.VerPersonaCorreo()) {
                    count++;
            %>
            <tr>

                <td class="col-lg-1 text-center"><%=count%></td>
                <td class="col-lg-5"><%=lista.getArea()%></td>
                <td class="col-lg-3"><%=lista.getCorreo()%></td>
                <td class="col-lg-3"><%=lista.getTelefono()%></td>
                <td class="col-lg-2 text-center"><a class="btn btn-warning glyphicon glyphicon-pencil" href="javascript:void(0)" onclick="javascript:EditarPerCo('<%=lista.getIdpercorreo()%>')" data-toggle="modal" data-target="#Editar" ></a></td>
                    <%----%>
                <td class="col-lg-2 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" href="ControlPeCorSvt?opcion=Eliminar&id_telefono=<%=lista.getIdpercorreo()%>"></a></td>
            </tr>
            <%
                }
            %>
        </tbody>

    </table>

    <div class="col-lg-1"></div>

</div>


<script type="text/javascript">
    function AgregarPersonaCorreo()
    {
        $("#pc_resul").hide("slow");
        $("#pc_resul").load("PersonaCorreo.jsp?opcion=AGREGAR", function () {
            $("#pc_resul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    function EditarPerCo(idpercorreo)
    {
        $("#pcEdi_resul").hide("slow");
        $("#pcEdi_resul").load("ControlPeCorSvt?opcion=Actualizando&Id_Per_Correo=" + idpercorreo, " ", function () {
            $("#pcEdi_resul").show("slow");
        });
    }
</script>
<%@include file="pie.jsp" %>
<%
    }
    if (opcion.equals("AGREGAR")) {
%>
<form name="PersonaCorreo" action="ControlPeCorSvt" method="POST">

    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">
                    <div class="form-group">

                        <select name="Correo" class="form-control text-center">
                            <option class="text-center">SELECCIONAR CORREO</option>
                            <%for (Correo cor : cdao.ReadCorreo()) {%>
                            <option value="<%=cor.getId_correo()%>"><%=cor.getCorreo()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <select name="Area" class="form-control text-center">
                            <option class="text-center">SELECCIONAR AREA</option>
                            <%for (Area ar : adao.listar()) {%>
                            <option value="<%=ar.getId_area()%>"><%=ar.getNombre_area()%></option>
                            <%}%>
                        </select>
                    </div> 
                    <div class="form-group">
                        <select name="Telefono" class="form-control text-center">
                            <option class="text-center">SELECCIONAR TELEFONO</option>
                            <%for (Telefono te : tdao.ListarTelefono()) {%>
                            <option value="<%=te.getId_telefono()%>"><%=te.getNro_telefono()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="opcion" value="Agregar" class="btn btn-success glyphicon glyphicon-saved">GUARDAR</button>
                    </div>

                </div>
            </center>
            <div class="col-lg-2"></div>
        </div>
    </div>
</form>
<%}
    if (opcion.equals("Actualizar")) {

        PersonaCorreo aco = pcdao.obteneridPc(Id_Per_Correo);
%>

<form name="Telefono" action="ControlPeCorSvt" method="POST">
    <input type="hidden" name="Id_Per_Correo" value="<%=Id_Per_Correo%>"/>
    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"></div>
            <center>
                <div class="">
                    <div class="form-group">
                        <label class="control-label text-left">AREA:</label>
                        <select name="Area" class="form-control text-center" selected="selected">
                            <option class="text-center">SELECCIONAR AREA</option>
                            <%for (Area ar : adao.listarArea()) {%>
                            <option value="<%=ar.getId_area()%>" <%if (t_are.equals(ar.getId_area())) {%> selected<%}%>><%=ar.getNombre_area()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label">CORREO:</label>
                        <select name="Correo" class="form-control text-center" selected="selected">
                            <option class="text-center">SELECCIONAR Correo</option>
                            <%for (Correo cor : cdao.ReadCorreo()) {%>
                            <option value="<%=cor.getId_correo()%>" <%if (t_cor.equals(cor.getId_correo())) {%> selected<%}%>><%=cor.getCorreo()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label text-justify">TELEFONO:</label>
                        <select name="Telefono" class="form-control text-center" selected="selected">
                            <option class="text-center">SELECCIONAR OPERADOR</option>
                            <%for (Telefono te : tdao.ListarTelefono()) {%>
                            <option value="<%=te.getId_telefono()%>" <%if (t_tel.equals(te.getId_telefono())) {%> selected<%}%>><%=te.getNro_telefono()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="opcion" value="Editar" class="btn btn-success glyphicon glyphicon-saved">GUARDAR</button>
                    </div>

                </div>
                <div class="col-lg-2"></div>
        </div>
    </div>
</form>
<%}%>
