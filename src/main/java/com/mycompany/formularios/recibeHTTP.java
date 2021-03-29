/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formularios;

import Analizadores.LexerCup;
import Analizadores.parser;
import GestorIndigo.ErrorSintactico;
import GestorIndigo.ErrorLexico;
import GestorIndigo.AnalizaIndigo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
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
 * @author James
 */

@WebServlet(name = "recibeHTTP", urlPatterns = {"/recibeHTTP"})
public class recibeHTTP extends HttpServlet implements Serializable {
    ArrayList<ErrorLexico> lexicoLST = new ArrayList<ErrorLexico>();
    ArrayList<ErrorSintactico> sintacticoLST = new ArrayList<ErrorSintactico>();    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //RECIBE EL PARAMETRO DE LA APP CLIENTE
        
        
        try (PrintWriter out = response.getWriter()) {
            String CodigoIndigo = request.getParameter("CodigoIndigo");
            String aut = request.getParameter("Autor");
            
            
            
//            //out.append(" JAMES ");
            //LO ENVIA A ANALIZAR
            AnalizaIndigo gestor = new AnalizaIndigo(CodigoIndigo);
            
            gestor.Analizar(CodigoIndigo);
//            
//            lexicoLST=gestor.getLexicoLST();
//            sintacticoLST=gestor.getSintacticoLST();
//            out.println("ASIFIIIIIIFIFIISNNN");
//            out.write("***********RESPUESTA SERVIDOR***************");
//            System.out.println("No. "+sintacticoLST.size());
//            System.out.println("No. "+lexicoLST.size());
//            if (lexicoLST.isEmpty()) {
//                    out.append("NO HAY ERRORES LEXICOS");
//            } else {
//            
//                for (int i = 0; i < 2; i++) {
//                    out.append("AB"+lexicoLST.size());
//                    out.append("ERROR LEXICO:"+lexicoLST.get(i).getToken()+ "lINEA:"+lexicoLST.get(i).getLinea()+"COLUMNA:"+lexicoLST.get(i).getColumna()+""); 
//                }
//            }
//            if (sintacticoLST.isEmpty()) {
//                    out.append("NO HAY ERRORES SINTACTICOS");
//            } else {
//            
//                for (int i = 0; i < 2; i++) {
//                    out.append("AB"+sintacticoLST.size());
//                    out.append("ERROR LEXICO  se esperaba: "+sintacticoLST.get(i).getTokenEsperado()+" Conflicto en: "+sintacticoLST.get(i).getValor()+ "lINEA:"+sintacticoLST.get(i).getLinea()+"COLUMNA:"+sintacticoLST.get(i).getColumna()+"");    
//                }
//            }  
        } catch (Exception e) {
            System.out.println("ERROR EN SERVLET PTM"+e);
            PrintWriter out = response.getWriter();
            Logger.getLogger(recibeHTTP.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
