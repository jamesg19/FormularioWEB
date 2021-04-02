/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorIndigo;

import java.io.DataOutputStream;
import java.io.IOException;


public class Responde extends Conexion2
{
    public Responde() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient(String mensajeACliente) //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor2 = new DataOutputStream(cs2.getOutputStream());

                //Se escribe en el servidor usando su flujo de datos
                salidaServidor2.writeUTF(mensajeACliente);

            cs2.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}