/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesHTML;

/**
 *
 * @author james
 */
public class BotonH {
    private String Id="";
    private String TextoVisible=" ";
    private String Alineacion="";
    private String Tema="Blue";
    private String FORMATO=" ";
    String TemaB="";

    public BotonH(String TextoVisible, String Id, String Formulario, String Alineacion, String Tema) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Alineacion=Alineacion;
        this.Tema=Tema;
        
        if(Tema.trim().equalsIgnoreCase("Dark")){
            TemaB="btn btn-dark";
            
        } else if(Tema.trim().equalsIgnoreCase("White")){
            TemaB="btn btn-light";
        } else if(Tema.trim().equalsIgnoreCase("Blue")){
            TemaB="btn btn-info";
        } else{
            TemaB="btn btn-info";
        }
        if(Alineacion.trim().equalsIgnoreCase("CENTRO")){
            setAlineacion("Center");
            AlineacionCentro();
        } else if(Alineacion.trim().equalsIgnoreCase("IZQUIERDA")){
            setAlineacion("left");
            AlineacionIzquierda();
        } else if(Alineacion.trim().equalsIgnoreCase("DERECHA")){
            setAlineacion("right");
            AlineacionDerecha();
        } else if(Alineacion.trim().equalsIgnoreCase("JUSTIFICAR")){
            setAlineacion("center");
            AlineacionJustificar();
        }
        
    }
    public void AlineacionIzquierda(){
        FORMATO="<br>"
                + "<div  class=\"row\">\""
                + "<div  class=\"col\">"
                + "<button align=\""+getAlineacion()+"\" id=\""+Id+"\" name=\""+Id+"\" type=\"button\" class=\""+TemaB+"\">"+getTextoVisible()+"</button> "
                + "</div>"
                + "<div class=\"col\"></div>"
                + "<div class=\"col\"></div>"
                + "</div>";
    }
    public void AlineacionDerecha(){
        FORMATO="<br>"
                + "<div  class=\"row\">\""
                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div>"
                + "<div  class=\"col\">"
                + "<button align=\""+getAlineacion()+"\" id=\""+Id+"\" name=\""+Id+"\" type=\"button\" class=\""+TemaB+"\">"+getTextoVisible()+"</button> "
                + "</div>"
                + ""
                + ""
                + "</div>";
    }
    public void AlineacionCentro(){
        FORMATO="<br>"
                + "<div  class=\"row\">\""
                + ""
                + "<div  class=\"col\">"
                + "<button align=\""+getAlineacion()+"\" id=\""+Id+"\" name=\""+Id+"\" type=\"button\" class=\""+TemaB+"\">"+getTextoVisible()+"</button> "
                + "</div>"
                + ""
                + ""
                + "</div>";
    }
    public void AlineacionJustificar(){
        FORMATO="<br>"
                + "<div  class=\"row\">\""
                + ""
                + "<button  id=\""+Id+"\" name=\""+Id+"\" type=\"button\" class=\""+TemaB+"\">"+getTextoVisible()+"</button> "
                + "</div>";
    }
    
    // azul
//<button type="button" class="btn btn-info">Info</button>
    //blanco
//<button type="button" class="btn btn-light">Light</button>
    //dark
//<button type="button" class="btn btn-dark">Dark</button>
//    <div align=\""+getAlineacion()+"\" class=\"row\">"
//                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div>
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTextoVisible() {
        return TextoVisible;
    }

    public void setTextoVisible(String TextoVisible) {
        this.TextoVisible = TextoVisible;
    }

    public String getAlineacion() {
        return Alineacion;
    }

    public void setAlineacion(String Alineacion) {
        this.Alineacion = Alineacion;
    }

    public String getFORMATO() {
        return FORMATO;
    }

    public void setFORMATO(String FORMATO) {
        this.FORMATO = FORMATO;
    }

    
    
}
