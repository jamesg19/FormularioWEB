/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadorHTML;

import java.io.File;
import java.io.FileOutputStream;
/**
 *
 * @author james
 */
public class GeneraJSP {

    FileOutputStream salida;
    File archivo;
    String PathFijo = "C:\\Users\\james\\Documents\\NetBeansProjects\\Formularios\\src\\main\\webapp";

    /**
     * constructor
     */
    public GeneraJSP() {

    }

    public String GuardarArchivo(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo Guardado";

        } catch (Exception e) {

        }

        return mensaje;
    }

}
