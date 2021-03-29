
package UsuarioIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class ModificarUsuario extends Usuario implements Serializable{
    private String fechaModif;

    public ModificarUsuario(String nuevoUsuario, String usuario, String password) {
        super(usuario, password);
    }

    public ModificarUsuario() {
    }
    
  

    public String getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(String fechaModif) {
        this.fechaModif = fechaModif;
    }
    

}
