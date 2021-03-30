///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package GestorIndigo;
//
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * 
// * @author James
// */
//public class ProcesaConexion {
//boolean bandera=false;
//    public ProcesaConexion() {
//        
//    }
//
//
//    public void ac() {
//        System.out.println("SERIDOR EN ESCUCHA");
//        
//        
//        while(bandera){
//            try {
//            ServerSocket servidor= new ServerSocket(6969);
//            Socket misocket= servidor.accept();
//            DataInputStream flujo_entrada= new DataInputStream(misocket.getInputStream());
//            String mensaje=flujo_entrada.readUTF();
//            System.out.println(mensaje);
//            //mostrar.append("\n"+mensaje);
//            misocket.close();
//             
//        } catch (IOException ex) {
//                System.out.println("error "+ex);
//            Logger.getLogger(ProcesaConexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }  
//        
//    }
//
//    public boolean isBandera() {
//        return bandera;
//    }
//
//    public void setBandera(boolean bandera) {
//        this.bandera = bandera;
//    }
//    
//    
//    
//    
//
//}
