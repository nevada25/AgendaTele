<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
session.setAttribute("codigoProducto", request.getParameter("cod"));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto: <%= request.getParameter("nombreProducto")%></title>
        <style type="text/css">

body {

	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

</style>
    </head>
    <body style="" >
    <center>
        <img src="SVerImagen">
    </center>
    </body>
</html>
