<%-- 
    Document   : MyForms
    Created on : Apr 1, 2021, 11:56:56 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Forms</title>
    </head>
    <body>
        <%@ include file = "../usuarioNav.jsp" %>
        <%@ page import="com.mycompany.formularios.*" %>
<%
            String mensaje=null;
            mensaje = (String) request.getAttribute("USER");
            try {
                mensaje = (String) request.getAttribute("MENSAJE");
                
            }catch(Exception e){
                
            }
            
        %>
        
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <h3>MIS FORMULARIOS</h3>
        
    </body>
</html>
