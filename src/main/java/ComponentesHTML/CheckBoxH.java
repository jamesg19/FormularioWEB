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
public class CheckBoxH {
    String[] parts = new String[100];
    private String TextoVisible="";
    private String Id="";
    private String Opciones=" ";
    private String Requerido="";
    private String Alineacion="";
    private String FORMATO="";
    private String Formulario="";
    private String NombreCampo="";

    public CheckBoxH(String TextoVisible, String Id,String Formulario,String NombreCampo, String Opciones, String Requerido, String Alineacion) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Opciones=Opciones;
        this.Requerido=Requerido;
        this.Alineacion=Alineacion;
        this.Formulario=Formulario;
        
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
        FORMATO="<br>\n "
            + "<div class=\"custom-control custom-checkbox\" align=\""+getAlineacion()+"\" "+getRequerido()+"> \n"
                + "<label class=\"custom-control-label\" align=\""+getAlineacion()+"\" for=\""+getId()+"\">"+getTextoVisible()+"</label>\n"
                + "";
        if(Opciones.contains("|")){
            String separador = Pattern.quote("|");
            parts = Opciones.split(separador);
            GeneraCheck(parts);
        } else{
            parts[0]=Opciones;
            parts[1]=" ";
            GeneraCheck(parts);
        }
        
    }
    public void GeneraCheck(String [] partesOpciones){
        for(int i=0; i<parts.length;i++){
        FORMATO+="<input class=\"form-check-input\" type=\"checkbox\" name=\""+Id+i+" \" id=\""+Id+"-"+i+"\">\n" +
        "  <label class=\"custom-control-label\" for=\""+Id+"-"+i+"\">"+partesOpciones[i].toString()+"</label>\n";
        }
        FORMATO+="</div>\n";
    }
    public void GeneraCheck1(String [] partesOpciones){

        FORMATO+="<input class=\"form-check-input\" type=\"checkbox\" name=\""+Id+0+" \" id=\""+Id+"-"+0+"\">\n" +
        "  <label class=\"custom-control-label\" for=\""+Id+"-"+0+"\">"+partesOpciones[0].toString()+"</label>\n";
        
        FORMATO+="</div>\n";
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

    public String getFormulario() {
        return Formulario;
    }

    public void setFormulario(String Formulario) {
        this.Formulario = Formulario;
    }

    public String getNombreCampo() {
        return NombreCampo;
    }

    public void setNombreCampo(String NombreCampo) {
        this.NombreCampo = NombreCampo;
    }
    
    
    
    
    
    
    
    
}
