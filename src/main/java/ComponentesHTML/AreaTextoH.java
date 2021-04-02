package ComponentesHTML;

import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class AreaTextoH {
    private String TextoVisible="";
    private String Id="";
    private String Filas;
    private String Columnas;
    private String Requerido="";
    private String Alineacion="";
    private String FORMATO="";
    private String Formulario="";
    private String NombreCampo="";
/**
 * 
 * @param TextoVisible
 * @param Formulario
 * @param Id
 * @param Filas
 * @param Columnas
 * @param Requerido
 * @param Alineacion
 * @param NombreCampo 
 */    
    public AreaTextoH(String TextoVisible,String Formulario, String Id, String Filas, String Columnas, String Requerido,String Alineacion, String NombreCampo) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Filas=Filas;
        this.Columnas=Columnas;
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
            setAlineacion("center");
            AlineacionCentar();
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
        else if(Alineacion.trim().equals(null)){
            setAlineacion("center");
            AlineacionCentar();
        } 
    }
//<div  class="row">
//<div  class="col">
//<div class="col"></div>

    public void AlineacionIzquierda(){
        setFORMATO("<br>\n"
                + "<div  class=\"row\">"
                + "<div  class=\"col\">"  
                + "<label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n" +
                "<textarea id=\""+getNombreCampo()+"\" rows=\""+getFilas()+"\" cols=\""+getColumnas()+"\" "+getRequerido()+" ></textarea>\n"
                + "</div>\n"
                + "<div class=\"col\"></div>"
                + "</div>\n"
                + "<br>\n");
        
    }
    public void AlineacionDerecha(){
        setFORMATO("<br>\n"
                + "<div  class=\"row\">"
                + "<div class=\"col\"></div>"
                + "<div class=\"col\">"  
                + "<label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n" +
                "<textarea id=\""+getNombreCampo()+"\" rows=\""+getFilas()+"\" cols=\""+getColumnas()+"\" "+getRequerido()+" ></textarea>\n"
                + "</div>\n"
                + "</div>\n"
                + "<br>\n");
        
    }
    public void AlineacionCentar(){
        setFORMATO("<br>\n"
                + "<div  class=\"row\">"
                + ""
                + "<div  class=\"col\">"  
                + "<label for=\""+getId()+"\">"+getTextoVisible()+"</label>\n" +
                "<textarea id=\""+getNombreCampo()+"\" rows=\""+getFilas()+"\" cols=\""+getColumnas()+"\" "+getRequerido()+" ></textarea>\n"
                + "</div>\n"
                + "</div>\n"
                + "<br>\n");
        
    }
    public void AlineacionJustificar(){
                setFORMATO("<br>\n"
                + "<div>"
                + "<label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n" +
                "<textarea id=\""+getNombreCampo()+"\" rows=\""+getFilas()+"\" cols=\""+getColumnas()+"\" "+getRequerido()+" ></textarea>\n"
                + "</div>\n"
                + "<br>\n");
        
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

    public String getFilas() {
        return Filas;
    }

    public void setFilas(String Filas) {
        this.Filas = Filas;
    }

    public String getColumnas() {
        return Columnas;
    }

    public void setColumnas(String Columnas) {
        this.Columnas = Columnas;
    }

    public String getRequerido() {
        return Requerido;
    }

    public void setRequerido(String Requerido) {
        this.Requerido = Requerido;
    }

    public String getFORMATO() {
        return FORMATO;
    }

    public void setFORMATO(String FORMATO) {
        this.FORMATO = FORMATO;
    }

    public String getAlineacion() {
        return Alineacion;
    }

    public void setAlineacion(String Alineacion) {
        this.Alineacion = Alineacion;
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
