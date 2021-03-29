package GestorIndigo;

import java.io.Serializable;

/**
 * 
 * @author James
 */
public class ErrorSintactico implements Serializable{
    private String tokenEsperado;
    private String Linea;
    private String Columna;
    private String valor;


    public ErrorSintactico() {
    }
    
    public String getTokenEsperado() {
        return tokenEsperado;
    }

    public void setTokenEsperado(String tokenEsperado) {
        this.tokenEsperado = tokenEsperado;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public String getColumna() {
        return Columna;
    }

    public void setColumna(String Columna) {
        this.Columna = Columna;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
    
    
            

}
