/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formularios;

import AnalizadorDB.LexerDB;
import AnalizadorDB.parserDB;
import AnalizadorLogin.parserLogin;
import File.ReadFormSaved;
import GestorIndigo.ErrorLexico;
import GestorIndigo.ErrorSintactico;
import GestorLogin.*;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    ArrayList<ErrorSintactico> sintactico = new ArrayList<ErrorSintactico>();
    ArrayList<ErrorLexico> lexicoLST = new ArrayList<ErrorLexico>();

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
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("area");

            try {

                GestorLogin gst = new GestorLogin(usuario);
                ReadFormSaved leer = new ReadFormSaved("");
                leer.mostrarUsuarios();
                gst.consulta_Login();
                sintactico = gst.getSintactico();
                lexicoLST = gst.getLexicoLST();

                // si no hay errores busca ingresar y que coincidan usuario y password
                if (sintactico.isEmpty() && lexicoLST.isEmpty()) {
                    if (gst.buscarUsuarioenDB()) {

                        request.getRequestDispatcher("/MyForms.jsp").forward(request, response);
                    } else {
                        request.setAttribute("MENSAJE", "EL USUARIO Y PASSWORD SON INCORRECTOS");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);

                    }

                } else {
                    String error = " ";
                    for (int i = 0; i < sintactico.size(); i++) {
                        error += "ERROR SINTACTICO\n";
                        error += "TOKEN ESPERADO: " + sintactico.get(i).getTokenEsperado() + " LINEA: " + sintactico.get(i).getValor() + " COLUMNA: " + sintactico.get(i).getColumna() + " CONFLICTO EN: " + sintactico.get(i).getLinea() + "\n";
                    }
                    for (int j = 0; j < lexicoLST.size(); j++) {
                        error += "ERROR LEXICO\n";
                        error += "TOKEN: " + lexicoLST.get(j).getToken() + " LINEA: " + lexicoLST.get(j).getLinea() + " COLUMNA: " + lexicoLST.get(j).getColumna();
                    }

                    request.setAttribute("MENSAJE", error);
                    //response.sendRedirect(error);
                    //response.sendRedirect("/Formularios/login.jsp");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);

                }

            } catch (Exception e) {
                System.out.println("ERROR********************");
                System.out.println(e + "*******************\n\n\n\n\n*********************");
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
