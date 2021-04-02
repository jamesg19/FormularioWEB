/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorDB;

import ComponentesHTML.*;
import ComponentesIndigo.*;
import FormSolicitudIndigo.Formulario;
import java.util.ArrayList;

/**
 * 
 * @author James
 */
public class LecturaBaseDatos {
//    Componente comp;
//    Formulario form;
    ArrayList<Formulario> formularios;
    ArrayList<Componente> componentes;
    private String formatoHTML="";

    public LecturaBaseDatos(ArrayList<Formulario> formularios, ArrayList<Componente> componentes) {
        this.formularios = formularios;
        this.componentes = componentes;
        
        
    }
    public void ObtenerHTML(){
        
        
        for(int i=0;i<componentes.size();i++){
            
            //CAMPO DE TEXTO
            System.out.println("CLASE COMPONNENTE ENCONTRADA: "+componentes.get(i).getClase());
        if(componentes.get(i).getClase().equalsIgnoreCase("CAMPO_TEXTO")){
            CampoTextoH c= new CampoTextoH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getNombreCampo(),componentes.get(i).getFormulario(),componentes.get(i).getRequerido(),componentes.get(i).getAlineacion());
            formatoHTML+="\n";
            formatoHTML+=c.getFORMATO();
            
        } else if(componentes.get(i).getClase().equalsIgnoreCase("BOTON")){
            BotonH btn=new BotonH(componentes.get(i).getTextoVisible(), componentes.get(i).getId(), componentes.get(i).getFormulario(), componentes.get(i).getAlineacion(), "Blue");
            formatoHTML+="\n";
            formatoHTML+=btn.getFORMATO();
        }
        else if(componentes.get(i).getClase().equalsIgnoreCase("AREA_TEXTO")){
            //AreaTextoH(String TextoVisible,String Formulario, String Id, String Filas, String Columnas, String Requerido,String Alineacion, String NombreCampo)
            AreaTextoH btn=new AreaTextoH(componentes.get(i).getTextoVisible(),componentes.get(i).getFormulario(), componentes.get(i).getId(), componentes.get(i).getFilas()+"", componentes.get(i).getColumnas()+"", componentes.get(i).getRequerido(),componentes.get(i).getAlineacion(), componentes.get(i).getNombreCampo());
            formatoHTML+="\n";
            formatoHTML+=btn.getFORMATO();
        }
        else if(componentes.get(i).getClase().equalsIgnoreCase("CHECKBOX")){
            
            //(String TextoVisible, String Id,String Formulario,String NombreCampo, String Opciones, String Requerido, String Alineacion)
            CheckBoxH ch= new CheckBoxH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getFormulario(),componentes.get(i).getNombreCampo(),componentes.get(i).getOpciones(),componentes.get(i).getRequerido(),componentes.get(i).getAlineacion());
            formatoHTML+="\n";
            formatoHTML+=ch.getFORMATO();
            
        } else if(componentes.get(i).getClase().equalsIgnoreCase("COMBO")){
            
            //(String TextoVisible, String Id,String Formulario,String NombreCampo, String Opciones, String Requerido, String Alineacion)
            ComboH com= new ComboH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getFormulario(),componentes.get(i).getNombreCampo(),componentes.get(i).getOpciones(),componentes.get(i).getRequerido(),componentes.get(i).getAlineacion());
            formatoHTML+="\n";
            formatoHTML+=com.getFORMATO();
            
        } else if(componentes.get(i).getClase().equalsIgnoreCase("RADIO")){
            //(String TextoVisible, String Id,String Formulario,String NombreCampo, String Opciones, String Requerido, String Alineacion)
            RadioH rad= new RadioH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getFormulario(),componentes.get(i).getNombreCampo(),componentes.get(i).getOpciones(),componentes.get(i).getRequerido(),componentes.get(i).getAlineacion());
            formatoHTML+="\n";
            formatoHTML+=rad.getFORMATO();
            
        } else if(componentes.get(i).getClase().equalsIgnoreCase("FICHERO")){
            //(String TextoVisible,String Id, String Formulario, String NombreCampo, String Requerido, String Alineacion)
            FicheroH fi= new FicheroH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getFormulario(),componentes.get(i).getNombreCampo(),componentes.get(i).getRequerido(),componentes.get(i).getAlineacion());
            formatoHTML+="\n";
            formatoHTML+=fi.getFORMATO();
            
        } else if(componentes.get(i).getClase().equalsIgnoreCase("IMAGEN")){
            //(String TextoVisible, String Id, String Formulario, String Url)
            ImagenH fi= new ImagenH(componentes.get(i).getTextoVisible(),componentes.get(i).getId(),componentes.get(i).getFormulario(),componentes.get(i).getUrl());
            formatoHTML+="\n";
            formatoHTML+=fi.getFORMATO();
            
        }
    }
        
        
    }
    
    
    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public String getFormatoHTML() {
        return formatoHTML;
    }

    public void setFormatoHTML(String formatoHTML) {
        this.formatoHTML = formatoHTML;
    }
    

}
