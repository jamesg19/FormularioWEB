package ComponentesHTML;
/**
 *
 * @author james
 */
public class CampoTextoH {
    private String TextoVisible="";
    private String Id=" ";
    private String NombreCampo="";
    private String Formulario="";
    private String Requerido=" ";
    private String Alineacion=" ";
    private String FORMATO="";

    public CampoTextoH(String TextoVisible, String Id,String NombreCampo, String Formulario, String Requerido, String Alineacion) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Requerido=Requerido;
        this.Alineacion=Alineacion;
        this.NombreCampo=NombreCampo;
        this.Formulario=Formulario;
        if(Requerido.trim().equalsIgnoreCase("SI")){
            setRequerido("Required");
        }else{
            setRequerido(" ");
        }
        if(Alineacion.trim().equalsIgnoreCase("CENTRO")){
            setAlineacion("center");
            AlineaCentro();
        } else if(Alineacion.trim().equalsIgnoreCase("IZQUIERDA")){
            setAlineacion("left");
            AlineaIzquierda();
        } else if(Alineacion.trim().equalsIgnoreCase("DERECHA")){
            setAlineacion("right");
            AlineaDerecha();
        } else if(Alineacion.trim().equalsIgnoreCase("JUSTIFICAR")){
            setAlineacion("center");
            AlineaJustificar();
        }
        
    }
    public void AlineaCentro(){
        FORMATO="<br><div align=\""+getAlineacion()+"\"><label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n<br>\n "
            +   "<div align=\""+getAlineacion()+"\" class=\"row\">"
                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div>\n" +
                "<div align=\""+getAlineacion()+"\" class=\"col\">"
                + "<input align=\""+getAlineacion()+"\" type=\"text\" class=\"form-control\" id=\""+getNombreCampo()+"\" name=\""+getNombreCampo()+"\""+getRequerido()+"/>\n"
                + "</div>"
                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div>\n"
                + "</div>\n"
                + "</div><br>\n";
    }
    public void AlineaDerecha(){
        FORMATO="<br><div align=\""+getAlineacion()+"\"><label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n<br>\n "
            +   "<div align=\""+getAlineacion()+"\" class=\"row\">"
                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div><div align=\""+getAlineacion()+"\" class=\"col\"></div>\n" +
                "<div align=\""+getAlineacion()+"\" class=\"col\">"
                + "<input align=\""+getAlineacion()+"\" type=\"text\" class=\"form-control\" id=\""+getNombreCampo()+"\" name=\""+getNombreCampo()+"\""+getRequerido()+"/>\n"
                + "</div>"
                + "\n"
                + "</div>\n"
                + "</div><br>\n";
        
    }
    public void AlineaIzquierda(){
        FORMATO="<br><div align=\""+getAlineacion()+"\"><label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n<br>\n "
            +   "<div align=\""+getAlineacion()+"\" class=\"row\">"
                + "" +
                "<div align=\""+getAlineacion()+"\" class=\"col\">"
                + "<input align=\""+getAlineacion()+"\" type=\"text\" class=\"form-control\" id=\""+getNombreCampo()+"\" name=\""+getNombreCampo()+"\""+getRequerido()+"/>\n"
                + "</div>"
                + "<div align=\""+getAlineacion()+"\" class=\"col\"></div><div align=\""+getAlineacion()+"\" class=\"col\"></div>\n"
                + "</div>\n"
                + "</div><br>\n";
        
    }
    public void AlineaJustificar(){
        FORMATO="<br><div align=\""+getAlineacion()+"\"><label for=\""+getNombreCampo()+"\">"+getTextoVisible()+"</label>\n<br>\n "
            +   "<div align=\""+getAlineacion()+"\" class=\"row\">"
                + "" +
                "<div align=\""+getAlineacion()+"\" class=\"col\">"
                + "<input align=\""+getAlineacion()+"\" type=\"text\" class=\"form-control\" id=\""+getNombreCampo()+"\" name=\""+getNombreCampo()+"\""+getRequerido()+"/>\n"
                + "</div>"
                + ""
                + "</div>\n"
                + "</div><br>\n";
        
    
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

    public String getFORMATO() {
        return FORMATO;
    }

    public void setFORMATO(String FORMATO) {
        this.FORMATO = FORMATO;
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

    public String getNombreCampo() {
        return NombreCampo;
    }

    public void setNombreCampo(String NombreCampo) {
        this.NombreCampo = NombreCampo;
    }

    public String getFormulario() {
        return Formulario;
    }

    public void setFormulario(String Formulario) {
        this.Formulario = Formulario;
    }
    
    
    
}
