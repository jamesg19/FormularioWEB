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
public class LoginUsuario extends Usuario implements Serializable{

    public LoginUsuario(String usuario, String password) {
        super(usuario, password);
    }

    public LoginUsuario() {
    }
    
}
