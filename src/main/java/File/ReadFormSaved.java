package File;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 * 
 * @author James
 */
public class ReadFormSaved {
    private String ContenidoArchivo;
    private boolean ExisteArchivo;
    FileInputStream entrada;
    File archivo;
    String idForm="";
    String PathFijo="C:\\Users\\james\\Documents\\NetBeansProjects\\Formularios\\src\\main\\java\\DataBase\\";
    
    public ReadFormSaved(String idForm) {
        this.idForm=idForm;
        
        //buscarFormulario();
    }
    //http://localhost/Formularios/FormGoogle?Form=aa
    public void buscarFormulario(){
        
        String fichero=PathFijo+idForm+".txt";
        try{
        archivo= new File(fichero);
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String documento = AbrirArchivo(archivo);
                    ContenidoArchivo=documento;
                    ExisteArchivo=true;
                    JOptionPane.showMessageDialog(null, ExisteArchivo);
                } else {
                    ExisteArchivo=false;
                    System.out.println("archivo invalido");
                }
            } else{
                //NO HAY ARCHIVO
                ExisteArchivo=false;
            }
        } catch(Exception e){
            ExisteArchivo=false;
            
        }
    }
    
    public String AbrirArchivo(File fichero) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int a;
            while ((a = entrada.read()) != -1) {
                char caracter = (char) a;
                documento += caracter;
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        //jTextArea.setText(documento);
        return documento;
    }

    
    
    
    
    public String getContenidoArchivo() {
        return ContenidoArchivo;
    }

    public void setContenidoArchivo(String ContenidoArchivo) {
        this.ContenidoArchivo = ContenidoArchivo;
    }

    public boolean isExisteArchivo() {
        return ExisteArchivo;
    }

    public void setExisteArchivo(boolean ExisteArchivo) {
        this.ExisteArchivo = ExisteArchivo;
    }
    
    
    
    

}
