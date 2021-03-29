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
public class AreaTexto extends Componente implements Serializable{
    private int filas;
    private int columnas;
    
    public AreaTexto(String Id, String nombreCampo, String formulario, String textoVisible, String alineacion, int filas,int columnas) {
        super(Id, nombreCampo, formulario, textoVisible, alineacion);
        this.filas=filas;
        this.columnas=columnas;
        
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    

    
    
    

}
