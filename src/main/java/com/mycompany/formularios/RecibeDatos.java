///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.mycompany.formularios;
//
//import Objetos.*;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * 
// * @author James
// */
//public class RecibeDatos implements Runnable{
//
//    public RecibeDatos() {
//        Thread mihilo = new Thread(this);
//        mihilo.start();
//    }
//
//    @Override
//    public void run() {
//        System.out.println(" ESCUCHA");
//        // ServerSocket
//        // pone la app "A LA ESCUCHA PARA QUE ENTRE INFO" en un puerto determinado
//        try {
//            ServerSocket servidor = new ServerSocket(9999);
//            LoginUsuario recibe= new LoginUsuario();
//            
//            while (true) {
//                
////                //leemos lo que viene en el flujo de datos
//                Socket misocket = servidor.accept();
//                  ObjectInputStream paquete_datos= new ObjectInputStream(misocket.getInputStream());
//                  // agregar lo que le llega por la red
//                  recibe = (LoginUsuario) paquete_datos.readObject();
//                  System.out.println("SI \n \n \n SIIIIIIIIIIII");
//                  System.out.println("USUARIO: "+recibe.getUser());             
//                misocket.close();
//            }
//        } catch (IOException e) {
//            System.out.println("ERRORRRRR  \n \n \n  DONDE RECIBEEEEEE" + e);
//            //Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
//        } catch (ClassNotFoundException ex) {
//            System.out.println("erorr de la claseee    "+ex);
//        //Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//    }
//        
//        
//        
//       
//    }
//    
//    
//    
//}
