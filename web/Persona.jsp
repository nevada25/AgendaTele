<%@page import="daoimpl1.PersonaDaoImpl"%>
<%@page import="dao1.PersonaDao"%>
<%@page import="bean.Persona"%>
<%@page import="daoimpl1.EmpresaDaoImpl"%>
<%@page import="dao1.EmpresaDao"%>
<%@page import="bean.Empresa"%>
<%@page import="daoimpl1.AreaDaoImpl"%>
<%@page import="dao1.AreaDao"%>
<%@page import="bean.Area"%>
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="Persona" scope="request" class="bean.Persona" />
<style>tr>th,tr>td{
    text-align: center;
}</style>
<%    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? " " : opcion;

    String id_area = request.getParameter("id_area");
    id_area = id_area == null ? " " : id_area;
    String Id_persona = request.getParameter("Id_persona");
    Id_persona = Id_persona == null ? " " : Id_persona;
    //llamar entidades
    Persona p = new Persona();
    //llamar clasesdaoimpl y  clasesdao
    PersonaDao pdao = new PersonaDaoImpl();

    if (opcion.equals("Listar")) {
%>
<%@include file="cabeza.jsp" %>
<div class="panel-info">
    <center><h1><b>PERSONA</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-1"></div>
    <div  class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class= text-center">#</th>
                    <th class="col-lg-4">NOMBRE</th>
                    <th class="col-lg-2">GENERO</th>
                    <th class="col-lg-3">CODIGO UNIVERSITARIO</th>
                    <th class="col-lg-3">CARGO</th>

                </tr>
            </thead>
            <tbody>
                <%            int count = 0;
                    for (Persona lista : pdao.ReadPersona()) {
                        count++;
                %>
                <tr>

                    <td class="text-center"><%=count%></td>
                    <td class="col-lg-4"><%=lista.getNombres()%></td>
                    <td class="col-lg-2"><%=lista.getGenero()%></td>
                    <td class="col-lg-3"><%=lista.getCodigo()%></td>
                    <td class="col-lg-3"><%=lista.getCargo()%></td>


                    </td>

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
<div class="panel-info">
    <center><h1><b>PERSONA</b></h1></center>
</div>
<div class="panel-body">
    <div></div>
    <div class="table-responsive" >

        <table class="table table-bordered table-hover ">
            <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                        <div class="modal-header" >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR PERSONA</b></h3>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">  
                            <div id="Persona_resul"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="ListarDatos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                        <div class="modal-header" >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR PERSONA</b></h3>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">  
                            <div id="Persona_resul"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="Editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                        <div class="modal-header" >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b> EDITAR PERSONA</b></h3>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">  
                            <div id="PersonaEdi_resul"></div>
                        </div>
                    </div>
                </div>
            </div>
            <thead>
                <tr>
                    <th class=" text-center">#</th>
                    <th class="col-lg-3">NOMBRE</th>
                    <th class="col-lg-2">GENERO</th>
                    <th class="col-lg-2">CODIGO UNIVERSITARIO</th>
                    <th class="col-lg-3">CARGO</th>

                    <th colspan="2" class="col-lg-2 text-center">OPCIONES <a class="btn btn-info  material-icons" href="javascript:void(0)" onclick="javascript:AgregarArea()" data-toggle="modal" data-target="#agregar" >add</a></th>
                </tr>
            </thead>

            <tbody>
                <%            int count = 0;
                    for (Persona lista : pdao.ReadPersona()) {
                        count++;
                %>
                <tr>

                    <td class="text-center"><%=count%></td>
                    <td class="col-lg-3"><%=lista.getNombres()%></td>
                    <td class="col-lg-2"><%=lista.getGenero()%></td>
                    <td class="col-lg-2"><%=lista.getCodigo()%></td>
                    <td class="col-lg-3"><%=lista.getCargo()%></td>
                    <%--<td class="col-lg-1 text-center"><a class="btn btn-warning glyphicon glyphicon-zoom-in" href="Persona.jsp?opcion=Datos&Id_persona=<%=lista.getId_persona()%>" data-toggle="modal" data-target="#ListarDatos"></a></td>---%>
                    <td class="col-lg-1 text-center"><a class="btn btn-warning glyphicon glyphicon-pencil" href="javascript:void(0)" onclick="javascript:EditarPersona('<%=lista.getId_persona()%>')" data-toggle="modal" data-target="#Editar"></a></td>
                    <td class="col-lg-1 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" href="ControlPersonaSvt?opcion=Eliminar&Id_persona=<%=lista.getId_persona()%>"></a></td>
                </tr>
                <%

                    }%>
            </tbody>

        </table>
    </div>
    <div class="col-lg-1"></div>

</div>


<script type="text/javascript">
    function AgregarArea()
    {
        $("#Persona_resul").hide("slow");
        $("#Persona_resul").load("ControlPersonaSvt?opcion=Agregando", function () {
            $("#Persona_resul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    function EditarPersona(Id_persona)
    {
        $("#PersonaEdi_resul").hide("slow");
        $("#PersonaEdi_resul").load("ControlPersonaSvt?opcion=Actualizando&Id_persona=" + Id_persona, "", function () {
            $("#PersonaEdi_resul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    function VerPersona(Id_persona)
    {
        $("#PersonaEdi_resul").hide("slow");
        $("#PersonaEdi_resul").load("ControlPersonaSvt?opcion=VerPersona&Id_persona=" + Id_persona, "", function () {
            $("#PersonaEdi_resul").show("slow");
        });
    }
</script>
<%@include file="pie.jsp" %>
<%
    }
    if (opcion.equals("AGREGAR")) {
%>

<form name="Persona" action="ControlPersonaSvt" method="POST">

    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">

                    <div class="form-group">

                        <input type="text" class="form-control text-center text-success" id="Nombre" name="Nombre" placeholder="INGRESAR NOMBRE">    
                    </div>
                    <div class="form-group">

                        <input type="text" class="form-control text-center text-success" id="Apepat" name="Apepat" placeholder="INGRESAR APELLIDO PATERNO">    
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Apemat" name="Apemat" placeholder="INGRESAR APELLIDO MATERNO" >    
                    </div>
                    <div class="form-group"><table border="0">
                            <thead>
                                <tr class="form-group form-control">

                                    <th>MASCULINO</th>
                                    <th><input type="radio" name="genero" value="M" /></th>
                                    <th>FEMENINO</th>
                                    <th><input type="radio" name="genero" value="F" /></th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Cargo"  name="Cargo"  placeholder="INGRESAR CARGO">    
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control text-center text-success" id="Codigo_uni" maxlength="9" name="Codigo_uni"  placeholder="INGRESAR CODIGO UNIVERSITARIO">    
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
        Persona pao = pdao.obteneridpe(Id_persona);
%>

<form name="Persona" action="ControlPersonaSvt" method="POST">
    <input type="hidden" name="Id_persona" value="<%=Id_persona%>"/>
    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"></div>
            <center>
                <div class="">

                    <div class="form-group">
                        <label>NOMBRE:</label>
                        <input type="text" class="form-control text-center text-success" id="Nombre" name="Nombre" placeholder="INGRESAR NOMBRE" value="<%=pao.getNombres()%>" >    
                    </div>
                    <div class="form-group">
                        <label>APELLIDO PATERNO:</label>
                        <input type="text" class="form-control text-center text-success" id="Apepat" name="Apepat" placeholder="INGRESAR APELLIDO PATERNO" value="<%=pao.getApepat()%>" >    
                    </div>
                    <div class="form-group">
                        <label>APELLIDO MATERNO:</label>
                        <input type="text" class="form-control text-center text-success" id="Apemat" name="Apemat" placeholder="INGRESAR APELLIDO MATERNO" value="<%=pao.getApemat()%>" >    
                    </div>
                    <div class="form-group">
                        <label>GENERO:</label>
                        <input type="text" class="form-control text-center text-success" id="Genero" name="Genero" placeholder="INGRESAR APELLIDO MATERNO" value="<%=pao.getGenero()%>" disabled>    
                    </div>
                    <div class="form-group">
                        <label>CARGO:</label>
                        <input type="text" class="form-control text-center text-success" id="Cargo"  name="Cargo" value="<%=pao.getCargo()%>" placeholder="INGRESAR CODIGO UNIVERSITARIO" >    
                    </div>
                    <div class="form-group">
                        <label>CODIGO UNIVERSITARIO:</label>
                        <input type="text" class="form-control text-center text-success" id="Codigo_uni" maxlength="9" name="Codigo_uni" value="<%=pao.getCodigo()%>" placeholder="INGRESAR CODIGO UNIVERSITARIO" >    
                    </div>

                    <div class="form-group">
                        <button type="submit" name="opcion" value="Editar" class="btn btn-success glyphicon glyphicon-saved">GUARDAR</button>
                    </div>

                </div>
                <div class="col-lg-2"></div>
        </div>
    </div>
</form>
<%}
if(opcion.equals("Datos")){
Persona pao = pdao.obteneridpe(Id_persona);
%>

<h1><%=pao.getNombres()%></h1>
<h1><%=pao.getApepat()%></h1>
<h1><%=pao.getApemat()%></h1>
<%}%>