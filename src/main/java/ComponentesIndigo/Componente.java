package ComponentesIndigo;

import java.io.Serializable;
/**
 * 
 * @author James
 */
public class Componente implements Serializable {
    private String Id;
    private String nombreCampo;
    private String formulario;
    
    private int indice=1;
    private String clase;
    private String textoVisible;
    private String alineacion;
    private String requerido;
    private String opciones;
    private int filas=-1;
    private int columnas=-1;
    private String Url;

    public Componente(String Id, String nombreCampo, String formulario, int indice, String clase, String textoVisible, String alineacion, String requerido, String opciones, int filas, int columnas) {
        this.Id = Id;
        this.nombreCampo = nombreCampo;
        this.formulario = formulario;
        this.indice = indice;
        this.clase = clase;
        this.textoVisible = textoVisible;
        this.alineacion = alineacion;
        this.requerido = requerido;
        this.opciones = opciones;
        this.filas = filas;
        this.columnas = columnas;
    }

    public Componente(String Id, String nombreCampo, String formulario, String textoVisible, String alineacion) {
        this.Id = Id;
        this.nombreCampo = nombreCampo;
        this.formulario = formulario;
        this.textoVisible = textoVisible;
        this.alineacion = alineacion;
    }

    public Componente(String Id, String formulario, String clase, String textoVisible) {
        this.Id = Id;
        this.formulario = formulario;
        this.clase = clase;
        this.textoVisible = textoVisible;
    }

    public Componente(String Id, String formulario, String textoVisible) {
        this.Id = Id;
        this.formulario = formulario;
        this.textoVisible = textoVisible;
    }

    public Componente() {
    }
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String textoVisible) {
        this.textoVisible = textoVisible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
}
