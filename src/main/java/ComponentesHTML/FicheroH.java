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
public class FicheroH {
    private String Id;
    private String TextoVisible;
    private String Requerido;
    private String Alineacion;
    private String FORMATO;
    private String Formulario;
    private String NombreCampo;
    
    public FicheroH(String TextoVisible,String Id, String Formulario, String NombreCampo, String Requerido, String Alineacion){
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Requerido=Requerido;
        this.Alineacion=Alineacion;
        
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
        FORMATO="<br><div align=\""+getAlineacion()+"\" class=\"custom-file\"> \n"
                + "<label class=\"custom-file-label\" for=\""+getId()+"\">"+getTextoVisible()+"</label>\n"
            + "<input align=\""+getAlineacion()+"\" type=\"file\" class=\"custom-file-input\" id=\""+getId()+"\" "+getRequerido()+"> \n"
            + "</div>";
    }

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
