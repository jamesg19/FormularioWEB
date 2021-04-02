/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UsuarioIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class Usuario implements Serializable {
    private String usuario;
    private String password;
    private String usuarioAnt;
    private String usuarioNue;
    private String nuevoPass;
    private String clase;
    private String FechaCreacion;
    private String FechaModif;
    
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario() {
    }
    
    public Usuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuarioAnt() {
        return usuarioAnt;
    }

    public void setUsuarioAnt(String usuarioAnt) {
        this.usuarioAnt = usuarioAnt;
    }

    public String getUsuarioNue() {
        return usuarioNue;
    }

    public void setUsuarioNue(String usuarioNue) {
        this.usuarioNue = usuarioNue;
    }

    public String getNuevoPass() {
        return nuevoPass;
    }

    public void setNuevoPass(String nuevoPass) {
        this.nuevoPass = nuevoPass;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getFechaModif() {
        return FechaModif;
    }

    public void setFechaModif(String FechaModif) {
        this.FechaModif = FechaModif;
    }
    
    
    

}
