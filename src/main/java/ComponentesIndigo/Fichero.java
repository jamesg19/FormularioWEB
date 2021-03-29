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
public class Fichero extends Componente implements Serializable{
 
    public Fichero(String Id, String nombreCampo, String formulario, String textoVisible, String alineacion) {
        super(Id, nombreCampo, formulario, textoVisible, alineacion);
    }

}
