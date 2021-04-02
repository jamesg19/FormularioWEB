/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorIndigo;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion2
{
    //http://localhost/Formularios/recibeHTTP
    private final int PUERTO = 1212; //Puerto para la conexión
    private final int PUERTO2 = 1234; //Puerto para la conexión
    private final String HOST = "localhost"; //Host para la conexión
    //protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected String mensajeServidor2; //Mensajes entrantes (recibidos) en el servidor
    //protected ServerSocket ss; //Socket del servidor
    //protected Socket cs; //Socket del cliente
    //protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
    protected ServerSocket ss2; //Socket del servidor
    protected Socket cs2; //Socket del cliente
    protected DataOutputStream salidaServidor2, salidaCliente2; //Flujo de datos de salida

    public Conexion2(String tipo) //Constructor
    {
        try{
        if(tipo.equalsIgnoreCase("servidor"))
        {
            //ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            //cs = new Socket(); //Socket para el cliente
            ss2 = new ServerSocket(PUERTO2);//Se crea el socket para el servidor en puerto 1234
            cs2 = new Socket(); //Socket para el cliente
        }
        else
        {
            //cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
            cs2 = new Socket(HOST, PUERTO2); //Socket para el cliente en localhost en puerto 1234
        }
        } catch (IOException ex) {
                System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRR    "+ex);
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}