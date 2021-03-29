package ComponentesHTML;
import java.util.regex.Pattern;
/**
 *
 * @author james
 */
public class RadioH {
    String[] parts = new String[20];
    private String TextoVisible;
    private String Id;
    private String Opciones;
    private String Requerido;
    private String Alineacion;
    private String FORMATO;
    private String Formulario;
    private String NombreCampo;
    
    public RadioH(String TextoVisible, String Id, String Formulario,String NombreCampo, String Opciones, String Requerido, String Alineacion){
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Opciones=Opciones;
        this.Requerido=Requerido;
        this.Alineacion=Alineacion;
        this.Formulario=Formulario;
        this.NombreCampo=NombreCampo;
        FORMATO="<br>\n<br>\n"
                + "<label class=\"custom-control-label\" for=\""+getId()+"\">"+getTextoVisible()+"</label>\n"
            + "<div class=\"custom-control custom-radio\" "+getRequerido()+" align=\""+getAlineacion()+" \"> \n"
            + "";
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
        } else if(Alineacion.trim().equalsIgnoreCase("JUSTIFICAR")){
            setAlineacion("center");
        }
        if(Opciones.contains("|")){
            String separador = Pattern.quote("|");
            parts = Opciones.split(separador);
            GeneraRadioBtn(parts);
        } else{
           
            parts[0]=Opciones;
            GeneraRadioBtn1(parts);
        }
        
    }
    
    public void GeneraRadioBtn(String [] partesOpciones){
        for(int i=0; i<parts.length;i++){
        FORMATO+="<input type=\"radio\" id=\""+Id+i+"\" name=\""+Id+i+"\" class=\"custom-control-input\">\n" +
        "<label class=\"custom-control-label\" for=\""+Id+i+"\">"+partesOpciones[i]+"</label>\n";
        }
        FORMATO+="</div>\n";
    }
    public void GeneraRadioBtn1(String [] partesOpciones){
        
        FORMATO+="<input type=\"radio\" id=\""+Id+0+"\" name=\""+Id+0+"\" class=\"custom-control-input\">\n" +
        "<label class=\"custom-control-label\" for=\""+Id+0+"\">"+partesOpciones[0]+"</label>\n";
        
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
