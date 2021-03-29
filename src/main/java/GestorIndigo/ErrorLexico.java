package GestorIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class ErrorLexico implements Serializable {
    private String token;
    private String linea;
    private String columna;


    public ErrorLexico() {
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }
    
    
    
    

}
