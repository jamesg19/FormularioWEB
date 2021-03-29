/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FormSolicitudIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class ModificarForm extends Formulario implements Serializable{

    public ModificarForm(String Id, String Titulo, String Nombre, String Tema) {
        super(Id, Titulo, Nombre, Tema);
    }

    public ModificarForm() {
    }

}
