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
public class Formulario implements Serializable {
    private String Id;
    private String Titulo;
    private String Nombre;
    private String Tema;
    private String usuarioCreacion;
    private String fechaCreacion;

    public Formulario(String Id, String Titulo, String Nombre, String Tema) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Nombre = Nombre;
        this.Tema = Tema;
    }
    
    public Formulario(String Id) {
        this.Id = Id;
    }

    public Formulario() {
    }
    
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
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
