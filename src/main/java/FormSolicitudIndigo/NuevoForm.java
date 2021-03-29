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
public class NuevoForm extends Formulario implements Serializable {
    private String usuarioCreacion;
    private String fechaCreacion;
    public NuevoForm(String Id, String Titulo, String Nombre, String Tema, String usuarioCreacion, String fechaCreacion) {
        super(Id, Titulo, Nombre, Tema);
        this.usuarioCreacion=usuarioCreacion;
        this.fechaCreacion=fechaCreacion;
    }

    public NuevoForm() {
    }
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    

}
