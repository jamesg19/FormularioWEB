package ComponentesIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class Imagen extends Componente implements Serializable{
    private String Url;
    
    public Imagen(String Id,   String formulario, String textoVisible, String Url ) {
        super(Id, formulario, textoVisible);
        this.Url=Url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
}
