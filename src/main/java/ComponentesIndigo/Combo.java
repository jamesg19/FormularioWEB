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
public class Combo extends Componente implements Serializable{
    private String Opciones;
    public Combo(String Id, String nombreCampo, String formulario, String textoVisible, String alineacion, String Opciones) {
        super(Id, nombreCampo, formulario, textoVisible, alineacion);
        this.Opciones=Opciones;
    }

    public String getOpciones() {
        return Opciones;
    }

    public void setOpciones(String Opciones) {
        this.Opciones = Opciones;
    }
    

}
