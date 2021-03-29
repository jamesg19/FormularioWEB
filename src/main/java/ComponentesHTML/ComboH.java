/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesHTML;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author james
 */
public class ComboH {
    String[] parts = new String[20];
    private String TextoVisible;
    private String Id;
    private String Opciones;
    private String Requerido;
    private String Alineacion;
    private String FORMATO;
    private String Formulario;
    private String NombreCampo;

    public ComboH(String TextoVisible, String Id,String Formulario, String NombreCampo, String Opciones, String Requerido, String Alineacion) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Opciones=Opciones;
        this.Requerido=Requerido;
        this.Alineacion=Alineacion;
        this.Formulario=Formulario;
        this.NombreCampo=NombreCampo;
        
        if(Requerido.trim().equalsIgnoreCase("SI")){
            setRequerido("Required");
        }else{
            setRequerido(" ");
        }
        if(Alineacion.trim().equalsIgnoreCase("CENTRO")){
            setAlineacion("Center");
        } else if(Alineacion.trim().equalsIgnoreCase("IZQUIERDA")){
            setAlineacion("left");
        } else if(Alineacion.trim().equalsIgnoreCase("DERECHA")){
            setAlineacion("right");
        }
        FORMATO="<br>\n<div align=\""+getAlineacion()+"\" class=\"form-row align-items-center\">\n" +
    "      <div align=\""+getAlineacion()+"\" class=\"col-auto my-1\">\n" +
    "      <label class=\"mr-sm-2\" for=\""+getId()+"\">"+getTextoVisible()+" </label>\n" +
    "      <select class=\"custom-select mr-sm-2\" id=\""+getId()+"\" "+getRequerido()+"\n>";
        if(Opciones.contains("|")){
            String separador = Pattern.quote("|");
            parts = Opciones.split(separador);
            GeneraCombo(parts);
        } else{
            parts[0]=Opciones;
            parts[1]=" ";
            GeneraCombo1(parts);
        }
    }               
    public void GeneraCombo(String [] partesOpciones){
        for(int i=0; i<parts.length;i++){
        FORMATO+="<option value=\""+partesOpciones[i].toString().trim()+"\">"+partesOpciones[i].toString().trim()+"</option>\n";
        }
        FORMATO+="</select>\n" +
        "</div>\n" +
        "</div>\n";
    }
    public void GeneraCombo1(String [] partesOpciones){

        FORMATO+="<option value=\""+partesOpciones[0].toString().trim()+"\">"+partesOpciones[0].toString().trim()+"</option>\n";
        
        FORMATO+="</select>\n" +
        "</div>\n" +
        "</div>\n";
    }
    public String getTextoVisible() {
        return TextoVisible;
    }
    public void setTextoVisible(String TextoVisible) {
        this.TextoVisible = TextoVisible;
    }
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public String getOpciones() {
        return Opciones;
    }
    public void setOpciones(String Opciones) {
        this.Opciones = Opciones;
    }
    public String getRequerido() {
        return Requerido;
    }
    public void setRequerido(String Requerido) {
        this.Requerido = Requerido;
    }
    public String getAlineacion() {
        return Alineacion;
    }
    public void setAlineacion(String Alineacion) {
        this.Alineacion = Alineacion;
    }
    public String[] getParts() {
        return parts;
    }
    public void setParts(String[] parts) {
        this.parts = parts;
    }
    public String getFORMATO() {
        return FORMATO;
    }
    public void setFORMATO(String FORMATO) {
        this.FORMATO = FORMATO;
    }
}
