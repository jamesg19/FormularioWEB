<%-- 
    Document   : newjsplogin.jsp
    Created on : Apr 1, 2021, 11:51:56 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JamesForms</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="Resources/funcion.js">
        <script src="Resources/funcion.js"></script>
    </head>
    <body>
        <%@ include file = "../navLgoin.jsp" %>
        <%@ page import="com.mycompany.formularios.*" %>
        <%
            String mensaje="  ";
            mensaje = (String) request.getAttribute("USER");
            try {
                mensaje = (String) request.getAttribute("MENSAJE");
                if(mensaje==null){
                    mensaje=" ";
                }
            }catch(Exception e){
                
            }
            
        %>
        <form action="login" method="POST" >
            <br>
            <br>
            <div align="center" >
                <div  class="rows"></div>
            <div  class="form-group" align="center">
                <h3>Ingresa tu usuario y password en FORMATO INDIGO</h3>
                <br>
                <br>
                <textarea align="center" class="form-control" id="area" name="area" rows="10" cols="1"></textarea>
            </div>
                
                <br>

                <button type="submit" class="btn btn-info">Iniciar Sesion</button>
                <button type="button" onclick="limpiar()" class="btn btn-secondary">Limpiar Area Texto</button>

                
                
            </div>
            <h3>INFORMACION SI HAY ERRORES: </h3>
            <h5><%=mensaje%></h5>
            
        </form>
    </body>
</html>
