/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formularios;

import AnalizadorDB.LexerDB;
import AnalizadorDB.parserDB;
import ComponentesIndigo.Componente;
import File.*;
import FormSolicitudIndigo.Formulario;
import GestorDB.LecturaBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "FormGoogle", urlPatterns = {"/FormGoogle"})
public class FormGoogle extends HttpServlet {
private ArrayList<Formulario> lstFORM = new ArrayList<Formulario>();
private ArrayList<Componente> lstCOMP = new ArrayList<Componente>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contenidoArchivo="";
        String IDFORM = request.getParameter("IDform");
        
        //buscar un formulario solicitado
        try (PrintWriter out = response.getWriter()) {

        ReadFormSaved leer=new ReadFormSaved(IDFORM);
        leer.buscarFormulario();
        if(leer.isExisteArchivo()){
            contenidoArchivo=leer.getContenidoArchivo();
            String entrada=contenidoArchivo;
            StringReader readerr = new StringReader(entrada);

            try {
                out.write("<html>\n" +
"<head>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"Resources/css/bootstrap.min.css\" />\n" +
"        <script type=\"text/css\" src=\"Resources/js/bootstrap.min.js\"></script>\n" +
"        <link rel=\"stylesheet\" href=\"Resources/css/bootstrap.min.css\">\n" +
//"	<link rel=\"stylesheet\" href=\"resources/CSSS/bootstrap.min.css\">\n" +
//"    	<link rel=\"stylesheet\" href=\"resources/CSSS/dh-navbar-inverse.css\">\n" +
//"    	<link rel=\"stylesheet\" href=\"esources/CSSS/styles.css\">\n" +
//"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">"+
//"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">"+
"    	<script src=\"resources/JSS/jquery.min.js\"></script>\n" +
"    	<script src=\"resources/JSS/bootstrap.min.js\"></script>\n" +
"</head>\n" +
"<body>\n"
                        + "<footer>\n" +
"            <iframe src=\"navbar.html\" width=\"1536\" height=\"99\"  ></iframe>\n" +
"        </footer>" +
"");


                LexerDB lexico = new LexerDB(readerr);
                parserDB parser = new parserDB(lexico);
                parser.parse();
                lstFORM=parser.getLstFormulario();
                String id=lstFORM.get(0).getId();
                out.write("<form target=\"_blank\" action=\"Export?id="+id+"\" >"
                        + "<input value=\""+id+"\" class=\"form-control\" type=\"hidden\" name=\"pth\">"
                        + "<button align=\"right\" type=\"submit\" class=\"btn btn-danger\">Exportar formulario PDF</button>"
                                + "</form>");
                lstCOMP=parser.getLstComponente();
                LecturaBaseDatos lec= new LecturaBaseDatos(lstFORM,lstCOMP);
                lec.ObtenerHTML();
                out.write(lec.getFormatoHTML());
                out.write("</form></div></body></html>");
                out.close();
                
            } catch (Exception ex) {
                Logger.getLogger(FormGoogle.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            
        }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
