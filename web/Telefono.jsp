<%@page import="daoimpl1.OperadorDaoImpl"%>
<%@page import="dao1.OperadorDao"%>
<%@page import="daoimpl1.PersonaDaoImpl"%>
<%@page import="dao1.PersonaDao"%>
<%@page import="bean.Persona"%>
<%@page import="bean.Operador"%>
<%@page import="daoimpl1.TelefonoDaoImpl"%>
<%@page import="dao1.TelefonoDao"%>
<%@page import="bean.Telefono"%>
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="Telefono" scope="request" class="bean.Telefono" />

<%    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? " " : opcion;
 
    String id_telefono = request.getParameter("id_telefono");
    id_telefono = id_telefono == null ? " " : id_telefono;
    String t_oper = Telefono.getId_operador(); t_oper = t_oper == null ? " " : t_oper;
    String t_per = Telefono.getId_persona(); t_per = t_per == null ? " " : t_per;
    
    //llamar entidades
    Telefono t = new Telefono();
    Persona p = new Persona();
    Operador o = new Operador();
    //llamar clasesdaoimpl y  clasesdao
    TelefonoDao tdao = new TelefonoDaoImpl();
    PersonaDao pdao = new PersonaDaoImpl();
    OperadorDao odao = new OperadorDaoImpl();
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
                    <th class="col-lg-5">NOMBRE</th>
                    <th class="col-lg-3">NUMERO</th>
                    <th class="col-lg-3">OPERADOR</th>


                </tr>
            </thead>
            <tbody>
                <%            int count = 0;
                    for (Telefono lista : tdao.ListarTelefono()) {
                        count++;
                %>
                <tr>

                    <td class="col-lg-1 text-center"><%=count%></td>
                    <td class="col-lg-5"><%=lista.getEstado()%></td>
                    <td class="col-lg-3"><%=lista.getNro_telefono()%></td>
                    <td class="col-lg-3"><%=lista.getDescripcion()%></td>

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
    <center><h1><b>TELEFONO</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-1"></div>

    <table class="table table-bordered table-hover table-responsive">
        <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

            <div class="modal-dialog" role="document">
                <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                    <div class="modal-header" >
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR TELEFONO</b></h3>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">  
                        <div id="Area_resul"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="Editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

            <div class="modal-dialog" role="document">
                <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                    <div class="modal-header" >
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b> EDITAR TELEFONO</b></h3>
                    </div>
                    <div class="modal-body" style="padding:40px 50px;">  
                        <div id="AreaEdi_resul"></div>
                    </div>
                </div>
            </div>
        </div>
        <thead>
            <tr>
                <th class="text-center">#</th>
                <th class="col-lg-4">NOMBRE</th>
                <th class="col-lg-2">NUMERO</th>
                <th class="col-lg-2">OPERADOR</th>
                <th colspan="2" class="col-lg-4 text-center">OPCIONES <a class="btn btn-info  material-icons" href="javascript:void(0)" onclick="javascript:AgregarArea()" data-toggle="modal" data-target="#agregar" >add</a></th>
            </tr>
        </thead>

        <tbody>
            <%                    int count = 0;
                for (Telefono lista : tdao.ListarTelefono()) {
                    count++;
            %>
            <tr>

                <td class="text-center"><%=count%></td>
                <td class="col-lg-4"><%=lista.getEstado()%></td>
                <td class="col-lg-2"><%=lista.getNro_telefono()%></td>
                <td class="col-lg-2"><%=lista.getDescripcion()%></td>
                <td class="col-lg-2 text-center"><a class="btn btn-warning glyphicon glyphicon-pencil" href="javascript:void(0)" onclick="javascript:EditarArea('<%=lista.getId_telefono()%>')" data-toggle="modal" data-target="#Editar"></a></td>
                <td class="col-lg-2 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" href="ControlTelefonoSvt?opcion=Eliminar&id_telefono=<%=lista.getId_telefono()%>"></a></td>
            </tr>
            <%
                }
            %>
        </tbody>

    </table>

    <div class="col-lg-1"></div>

</div>


<script type="text/javascript">
    function AgregarArea()
    {
        $("#Area_resul").hide("slow");
        $("#Area_resul").load("ControlTelefonoSvt?opcion=Agregando", function () {
            $("#Area_resul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    function EditarArea(id_telefono)
    {
        $("#AreaEdi_resul").hide("slow");
        $("#AreaEdi_resul").load("ControlTelefonoSvt?opcion=Actualizando&id_telefono=" + id_telefono, "", function () {
            $("#AreaEdi_resul").show("slow");
        });
    }
</script>
<%@include file="pie.jsp" %>
<%
    }
    if (opcion.equals("AGREGAR")) {
%>

<form name="Telefono" action="ControlTelefonoSvt" method="POST">

    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">
                    <div class="form-group">
                        <select name="Persona" class="form-control text-center">
                            <option class="text-center">SELECCIONAR NOMBRE</option>
                            <%for (Persona per : pdao.ListarPersona()) {%>
                            <option value="<%=per.getId_persona()%>"><%=per.getNombres()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Numero" name="Numero" placeholder="INGRESAR NUMERO" maxlength="9" required>    
                    </div>
                    <div class="form-group">
                        <select name="Operador" class="form-control text-center">
                            <option class="text-center">SELECCIONAR OPERADOR</option>
                            <%for (Operador op : odao.listarOperador()) {%>
                            <option value="<%=op.getId_operador()%>"><%=op.getOperadora_nombre()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="opcion" value="Agregar" class="btn btn-success glyphicon glyphicon-saved">GUARDAR</button>
                    </div>

                </div>
                <div class="col-lg-2"></div>
        </div>
    </div>
</form>
<%}
    if (opcion.equals("Actualizar")) {
        Telefono Tel = tdao.SearchIdTelefono(id_telefono);
%>

<form name="Telefono" action="ControlTelefonoSvt" method="POST">
    <input type="hidden" name="id_telefono" value="<%=id_telefono%>"/>
    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"></div>
            <center>
                <div class="">
                    <div class="form-group">
                        <select name="Persona" class="form-control text-center" selected="selected">
                            <%for (Persona per : pdao.ListarPersona()) {%>
                            <option value="<%=per.getId_persona()%>"<%if (t_per.equals(per.getId_persona())) {%> selected<%}%>><%=per.getNombres()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Numero" name="Numero" placeholder="INGRESAR NUMERO" value="<%=Tel.getNro_telefono()%>" required>    
                    </div>
                    <div class="form-group">
                        <select name="Operador" class="form-control text-center" selected="selected">
                            <%for (Operador oper: odao.listarOperador()) {%>
                            <option value="<%=oper.getId_operador()%>"<%if (t_oper.equals(oper.getId_operador())) {%> selected<%}%>><%=oper.getOperadora_nombre()%></option>
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
