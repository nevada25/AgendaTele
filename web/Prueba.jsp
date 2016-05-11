<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%

String texto=request.getParameter("texto");
 String encriptMD5=DigestUtils.md5Hex(texto);

%>
 
<h1 ><%=encriptMD5%></h1>
    

<%%>

