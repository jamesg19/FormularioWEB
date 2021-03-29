/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponentesIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class AgregarComponente extends Componente implements Serializable {

    public AgregarComponente(String Id, String nombreCampo, String formulario, int indice, String clase, String textoVisible, String alineacion, String requerido, String opciones, int filas, int columnas) {
        super(Id, nombreCampo, formulario, indice, clase, textoVisible, alineacion, requerido, opciones, filas, columnas);
    }

    public AgregarComponente() {
    }
    
    
    

}
