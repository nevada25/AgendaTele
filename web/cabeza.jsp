
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>AGENDA TELEFONICA</title>

    
    <link  href = "css/bootstrap.min.css"  rel = "stylesheet" >
    <link href='https://fonts.googleapis.com/css?family=Bree+Serif' rel='stylesheet' type='text/css'>
    <Script src = "js/html5shiv.min.js"></script>
    <Script src = "js/respond.min.js"></script>
    <link rel="shortcut icon" href="recursos/icon1.ico">
    <link rel="stylesheet" type="text/css" href="css/cerrarsecion.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="css/alertify.core.css" />
    <link rel="stylesheet" href="css/alertify.default.css" id="toggleCSS" />
    <script src="js/alertify.min.js"></script>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link href="vendors/material-icons/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="vendors/socicon/socicon.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js_ajaxper/funcionajax.js"></script>
    <script type="text/javascript" src="js_ajaxper/jquery-1.2.1.pack.js"></script>
    <script type="text/javascript" src="js_ajaxper/eventos.js"></script>
    <script type="text/javascript" src="js_ajaxper/funciones.js"></script>
</head>
<%
    HttpSession session1 = request.getSession();
    String usuario = (String) session1.getAttribute("usuario");
    if (usuario == null) {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<body> 
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="InicioSvt?opcion=inicio">
                    <span class="glyphicon glyphicon-text-background" aria-hidden="true"></span>T
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="InicioSvt?opcion=inicio">Inicio <span class="glyphicon glyphicon-home" aria-hidden="true"></span><span class="sr-only">(current)</span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>Vistas<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="InicioSvt?opcion=area"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Area</a></li>
                            <li><a href="InicioSvt?opcion=correo"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Correo</a></li>
                            <li><a href="InicioSvt?opcion=Telefono"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Telefono</a></li>
                            <li><a href="InicioSvt?opcion=PersonaCorreo"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Persona Correo</a></li>
                            <li><a href="InicioSvt?opcion=Persona"><span class="glyphicon glyphicon-picture" aria-hidden="true"></span> Persona</a></li>

                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>Configuraci&oacute;n<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="InicioSvt?opcion=ControlArea"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Area</a></li>
                            <li><a href="InicioSvt?opcion=ControlCorreo"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Correo</a></li>
                            <li><a href="InicioSvt?opcion=ControlTelefono"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Telefono</a></li>
                            <li><a href="InicioSvt?opcion=ControlPersonaCorreo"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Persona Correo</a></li>
                            <li><a href="InicioSvt?opcion=ControlPersona"><span class="glyphicon glyphicon-picture" aria-hidden="true"></span> Persona</a></li>
                            <li role="separator" class="divider"></li>

                        </ul>
                    </li>
                    
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="<%= session.getAttribute("foto")%>" style="width: 15px; height:20px;" >
                                    <strong><%= session.getAttribute("usuario")%></strong>
                                    <span class="glyphicon glyphicon-chevron-down"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="navbar-login">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <p class="text-center">
                                                        <img src="<%= session.getAttribute("foto")%>" style="width: 90px; height:120px;" >
                                                    </p>
                                                </div>
                                                <div class="col-lg-8">
                                                    <p class="text-left"><strong><%= session.getAttribute("usuario")%></strong></p>
                                                    <p class="text-left small"><%= session.getAttribute("correo")%></p>
                                                    <p class="text-left">
                                                        <%--a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a---%>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="navbar-login navbar-login-session">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <p>
                                                        <a href="ControlLoginSvt?acciones=cerrar" class="btn btn-danger btn-block">Cerrar Sesion <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>



                    </div><!-- /.navbar-collapse -->
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>  	
    <div class="col-lg-2"></div>
    <div class="" >
        <div class="container-fluid main-container">

            <div class="col-lg-12  content" style=" margin-top: -22px;">
                <div class="panel panel-danger" style="height: 550px;">