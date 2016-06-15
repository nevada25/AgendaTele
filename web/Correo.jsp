
<%@page import="daoimpl1.PersonaDaoImpl"%>
<%@page import="dao1.PersonaDao"%>
<%@page import="bean.Persona"%>
<%@page import="bean.Tipo_Correo"%>
<%@page import="bean.Correo"%>
<%@page import="daoimpl1.TipoCorreoDaoImpl"%>
<%@page import="dao1.TipoCorreoDao"%>
<%@page import="dao1.CorreoDao"%>
<%@page import="daoimpl1.CorreoDaoImpl"%>
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="TipoCorreo" scope="request" class="bean.Tipo_Correo" />
<jsp:useBean id="Correo" scope="request" class="bean.Correo" />
<style>tr>th,tr>td{
    text-align: center;
}</style>

<%
    //LLAMAR A LAS DATOS ENVIADO
    String opcion = request.getParameter("opcion");
    opcion = opcion == null ? " " : opcion;

    String id_correo = request.getParameter("id_correo");
    id_correo = id_correo == null ? " " : id_correo;
    String correo = request.getParameter("correo");
    correo = correo == null ? " " : correo;
    String t_cor = Correo.getId_tipo_correo();
    t_cor = t_cor == null ? " " : t_cor;
    //LLAMANDO A LAS CLASES
    Correo c = new Correo();
    PersonaDao pdao=new PersonaDaoImpl();
    CorreoDao codao = new CorreoDaoImpl();

    if (opcion.equals("Listar")) {
%>

<%@include file="cabeza.jsp" %>

<div class="panel-info">
    <center><h1><b>CORREO</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th class="col-lg-12 text-center">Correo</th>
                </tr>
            </thead>
            <tbody>
                <%            int count = 0;
                    for (Correo lista : codao.ReadCorreo()) {
                        count++;
                %>
                <tr>

                    <td class="text-center"><%=count%></td>
                    <td class="col-lg-12"><%=lista.getCorreo()%></td>
                </tr>
                <%

                    }%>
            </tbody>
        </table>
    </div>
    <div class="col-lg-2"></div>
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
    <center><h1><b>Correo</b></h1></center>
</div>
<div class="panel-body">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-bordered table-striped">
            <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                        <div class="modal-header" >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR CORREO</b></h3>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">  
                            <div id="Correo_AResul"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade m" id="Editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                <div class="modal-dialog" role="document">
                    <div class="modal-content" >
                        <div class="modal-header " >
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b> EDITAR CORREO</b></h3>
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">  
                            <div id="CorreoEdi_resul"></div>
                        </div>
                    </div>
                </div>
            </div>
            <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th class="col-lg-10 ">Correo</th>
                    <th colspan="2" class="col-lg-2 text-center">OPCIONES <a class="btn btn-info  material-icons" href="javascript:void(0)" onclick="javascript:AgregarCorreo()" data-toggle="modal" data-target="#agregar" >add</a></th>
                </tr>
            </thead>

            <tbody>
                <%                    int x = 0;
                    for (Correo lista : codao.ReadCorreo()) {
                        x++;
                %>
                <tr>

                    <td class="text-center"><%=x%></td>
                    <td class="col-lg-10"><%=lista.getCorreo()%></td>
                    <td class="col-lg-1 text-center"><a class="btn btn-warning glyphicon glyphicon-pencil" href="javascript:void(0)" onclick="javascript:EditarCorreo('<%=lista.getId_correo()%>')" data-toggle="modal" data-target="#Editar"></a></td>
<%----                    <td class="col-lg-1 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" href="javascript:void(0)" onclick="javascript:eliminar('<%=lista.getId_correo()%>')"></a></td>-----%>
                    <td class="col-lg-1 text-center"><a class="btn btn-danger glyphicon glyphicon-trash" id="confirm" href="ControlCorreoSvt?opcion=Eliminar&id_correo=<%=lista.getId_correo()%>"></a></td>
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
    function AgregarCorreo()
    {
        $("#Correo_AResul").hide("slow");
        $("#Correo_AResul").load("ControlCorreoSvt?opcion=Inser", function () {
            $("#Correo_AResul").show("slow");
        });
    }
</script>
<script type="text/javascript">
    
    function eliminar(id_correo)
    {
$("#confirm").on( 'click', function () {
			reset();
			alertify.confirm("¿SEGURO QUE DESEAS ELIMINAR", function (e) {
				if (e) {
					alertify.success("SE ELIMINO CORRECTAMENTE");
				} else {
					alertify.error("ERRORAL EMINAR");
				}
			});
			return false;
		});
			
        
        
    }
</script>
<script type="text/javascript">
    function EditarCorreo(id_correo)
    {
        $("#CorreoEdi_resul").hide("slow");
        $("#CorreoEdi_resul").load("ControlCorreoSvt?opcion=Edit&id_correo=" + id_correo, "", function () {
            $("#CorreoEdi_resul").show("slow");
        });
    }
</script>

<%@include file="pie.jsp" %>

<%
    }
    if (opcion.equals("Agregando")) {

%>
<style>
    select.SeleTipo
    {
        width: 150px;
    }
    input#Correo
    {
        width: 250px;
    }
</style>

<form name="Correo" action="ControlCorreoSvt" method="POST">

    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">
                    <style>table#tace{padding-left: -50px;}#bur{background: #198c19;}</style>
                    <table id="tace">
                       <thead>
                           
                        </thead>
                        <tbody>
                            <tr>
                                 <th></th>
                            </tr>
                            <tr>
                               
                                <th><input type="text" class="form-control  text-center" id="Correo" name="Correo" ></th>
                                <th>
                                    <select name="Id_Tipo_Correo"  class="form-control SeleTipo " selected="selected">
                                        <option>TIPO CORREO</option>
                                        <% TipoCorreoDao TiCodao = new TipoCorreoDaoImpl();
                                            for (Tipo_Correo TiCo : TiCodao.ReadTipo_Correo()) {
                                        %>
                                        <option value="<%=TiCo.getId_tipo_correo()%>" ><%=TiCo.getDescripcion()%></option>

                                        <%}%>

                                    </select>
                                </th>
                            </tr>
                        </tbody>                    </table>
                </div>
            </center>
            <div class="col-lg-2"></div>
            <center>
                <br>

                <button value="Insertar" name="opcion" id="bur"><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>GUARDAR</button>
            </center>
        </div>
    </div>
</form>

<%
    }
    if (opcion.equals("Actua")) {

        Correo cs = codao.BuscarId_correo(id_correo);
%>
<style>
    select.SeleTipo
    {
        width: 150px;
    }
    input#Correo
    {
        width: 250px;
    }
</style>

<form name="Correo" action="ControlCorreoSvt" method="POST">
    <input type="hidden" name="id_correo" value="<%=id_correo%>"/>
    <div class="modal-body">
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <center>
                <div class="">
                    
                    <table id="tace">
                        
                        <tbody>
                            <tr>
                                 <th></th>
                            </tr>
                            <tr>
                               
                                <th><input type="text" class="form-control  text-center" id="Correo" name="Correo"  value="<%=cs.getCorreo()%>"></th>
                                <th>
                                    <select name="Id_Tipo_Correo"  class="form-control SeleTipo " selected="selected">
                                        <% TipoCorreoDao TiCodao = new TipoCorreoDaoImpl();
                                            for (Tipo_Correo TiCo : TiCodao.ReadTipo_Correo()) {
                                        %>
                                        <option value="<%=TiCo.getId_tipo_correo()%>" <%if (t_cor.equals(TiCo.getId_tipo_correo())) {%> selected<%}%>><%=TiCo.getDescripcion()%></option>

                                        <%}%>

                                    </select>
                                </th>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </center>
            <div class="col-lg-2"></div>
            <center>
                <br>

                <button value="Actualizar" name="opcion" id="bur"><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>GUARDAR</button>
            </center>
        </div>
    </div>
</form>
<%
    }
%>

