<%@page import="daoimpl1.EmpresaDaoImpl"%>
<%@page import="dao1.EmpresaDao"%>
<%@page import="bean.Empresa"%>
<%@page import="daoimpl1.AreaDaoImpl"%>
<%@page import="dao1.AreaDao"%>
<%@page import="bean.Area"%>
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="Empresa" scope="request" class="bean.Empresa" />

<%    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? " " : opcion;

    String id_area = request.getParameter("id_area");
    id_area = id_area == null ? " " : id_area;
    String t_emp = Empresa.getId_empresa();
    t_emp = t_emp == null ? " " : t_emp;
    //llamar entidades
    Area a = new Area();
    //llamar clasesdaoimpl y  clasesdao
    AreaDao areo = new AreaDaoImpl();
    EmpresaDao e = new EmpresaDaoImpl();
    if (opcion.equals("Listar")) {
%>
<%@include file="cabeza.jsp" %>

<div class="panel-info">
    <center><h1><b>AREA</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="col-sm-2 text-center">#</th>
                    <th class="col-sm-4">EMPRESA</th>
                    <th class="col-sm-4">AREA</th>

                </tr>
            </thead>
            <tbody>
                <%            int count = 0;
                    for (Area lista : areo.listar()) {
                        count++;
                %>
                <tr>

                    <td class="col-sm-2 text-center"><%=count%></td>
                    <td class="col-sm-4"><%=lista.getNombre_empresa()%></td>
                    <td class="col-sm-4"><%=lista.getNombre_area()%></td>

                </tr>
                <%

                    }%>
            </tbody>
        </table>
    </div>
    <div class="col-lg-3"></div>
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
    <center><h1><b>AREA</b></h1></center>
</div>
<div class="panel-body">
    <div></div>
    <div >
        <table class="table table-bordered table-hover table-responsive">
            <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                        <div class="modal-header" >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR AREA</b></h3>
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
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b> EDITAR AREA</b></h3>
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
                    <th class="col-lg-4">EMPRESA</th>
                    <th class="col-lg-4">AREA</th>
                    <th colspan="2" class="col-lg-2 text-center">OPCIONES <a class="btn btn-info  material-icons" href="javascript:void(0)" onclick="javascript:AgregarArea()" data-toggle="modal" data-target="#agregar" >add</a></th>
                </tr>
            </thead>

            <tbody>
                <%                    int count = 0;
                    for (Area lista : areo.listar()) {
                        count++;
                %>
                <tr>

                    <td class=" text-center"><%=count%></td>
                    <td class="col-lg-4"><%=lista.getNombre_empresa()%></td>
                    <td class="col-lg-4"><%=lista.getNombre_area()%></td>
                    <td class="col-lg-1 text-center"><a class="btn btn-warning glyphicon glyphicon-pencil" href="javascript:void(0)" onclick="javascript:EditarArea('<%=lista.getId_area()%>')" data-toggle="modal" data-target="#Editar"></a></td>
                    <td class="col-lg-1 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" href="ControlAreaSvt?opcion=Eliminar&id_area=<%=lista.getId_area()%>"></a></td>
                </tr>
                <%
                    }
                %>
            </tbody>

        </table>
    </div>
    <div class="col-lg-1"></div>

</div>

<script type="text/javascript">
    function AgregarArea()
    {
        $("#Area_resul").hide("slow");
        $("#Area_resul").load("ControlAreaSvt?opcion=ControlAreaAgregar", function () {
            $("#Area_resul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    function EditarArea(id_area)
    {
        $("#AreaEdi_resul").hide("slow");
        $("#AreaEdi_resul").load("ControlAreaSvt?opcion=ControlAreaEditar&id_area=" + id_area, "", function () {
            $("#AreaEdi_resul").show("slow");
        });
    }
</script>
<%@include file="pie.jsp" %>
<%
    }
    if (opcion.equals("AGREGAR")) {
%>

<form name="Area" action="ControlAreaSvt" method="POST">

    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">

                    <div class="form-group">
                        <select name="Empresa" class="form-control text-center">
                            <option class="text-center">SELECCIONAR EMPRESA</option>
                            <%for (Empresa em : e.ListarEmpresa()) {%>
                            <option value="<%=em.getId_empresa()%>"><%=em.getNombre_empresa()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Area" name="Area" placeholder="INGRESAR AREA" required>    
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
        Area Acarea = areo.obtenerid(Integer.parseInt(id_area));
%>

<form name="Area" action="ControlAreaSvt" method="POST">
    <input type="hidden" name="id_area" value="<%=id_area%>"/>
    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"></div>
            <center>
                <div class="">

                    <div class="form-group">
                        <select name="Empresa" class="form-control text-center" selected="selected">
                            <option class="text-center">SELECCIONAR EMPRESA</option>
                            <%for (Empresa em : e.ListarEmpresa()) {%>
                            <option value="<%=em.getId_empresa()%>" <%if (t_emp.equals(em.getId_empresa())) {%> selected<%}%>><%=em.getNombre_empresa()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Area" name="Area" placeholder="INGRESAR AREA" value="<%=Acarea.getNombre_area()%>" required>    
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
