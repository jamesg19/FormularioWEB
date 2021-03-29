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
public class ImagenH {
    private String Id;
    private String TextoVisible;
    private String Url;
    private String FORMATO;
   

    public ImagenH(String TextoVisible, String Id, String Formulario, String Url) {
        this.TextoVisible=TextoVisible;
        this.Id=Id;
        this.Url=Url;
        FORMATO="<br><br><label for=\""+getId()+"\">"+getTextoVisible()+"</label>\n"
            + "<input type=\"image\" id=\""+getId()+"\" src=\""+getUrl()+"\" />";
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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
    
    
    
    
    
}
