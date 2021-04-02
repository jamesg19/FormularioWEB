package File;

import UsuarioIndigo.CrearUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author James
 */
public class ReadFormSaved {
    private String ContenidoArchivo;
    private boolean ExisteArchivo;
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    String idForm="";
    String PathFijo="C:\\Users\\james\\Documents\\NetBeansProjects\\Formularios\\BaseDatos\\";
    
    public ReadFormSaved(String idForm) {
        this.idForm=idForm;
        //buscarFormulario();
    }
    //http://localhost/Formularios/FormGoogle?Form=aa
    public void buscarFormulario(){
        
        String fichero=PathFijo+idForm+".form";
        try{
        archivo= new File(fichero);
            if (archivo.canRead()) {
                
                    String documento = AbrirArchivo(archivo);
                    ContenidoArchivo=documento;
                    ExisteArchivo=true;
                    //JOptionPane.showMessageDialog(null, ContenidoArchivo);
                
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
            entrada.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        //jTextArea.setText(documento);
        return documento;
    }
    
    
    
    public boolean GuardarArchivo(String id, String documento) {
        String mensaje = null;
        boolean bandera=false;
        try {
            File fil= new File(PathFijo+id+".form");
            salida = new FileOutputStream(fil);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            salida.close();
            bandera=true;
            salida.close();
        } catch (Exception e) {

        }

        return bandera;
    }
    
    public String eliminarFicheroForm(String id) { 
        String R="";
        File arch= new File(PathFijo+id+".form");
    if (!arch.exists()) {
        System.out.println("El archivo data no existe.");
        R="ERROR AL ELIMINAR FORMULARIO CON ID:"+id+" NO EXISTE";
    } else {
        arch.delete();
        
        System.out.println("El archivo data fue eliminado.");
        R="SE HA ELIMINADO EL FORMULARIO CON ID:"+id;
    }
    return R;
}
    public void buscarArchivoCliente(){
        
        String fichero=PathFijo+"USUARIOS"+".txt";
        try{
        archivo= new File(fichero);
            if (archivo.canRead()) {
                
                    String documento = AbrirArchivo(archivo);
                    ContenidoArchivo=documento;
                    ExisteArchivo=true;
                    //JOptionPane.showMessageDialog(null, ContenidoArchivo);
                
            } else{
                //NO HAY ARCHIVO
                ExisteArchivo=false;
            }
        } catch(Exception e){
            ExisteArchivo=false;
            
        }
    }
    public boolean GuardarUsuario(String documento) {
        String mensaje = null;
        boolean bandera=false;
        try {
            File fil= new File(PathFijo+"USUARIOS.txt");
            salida = new FileOutputStream(fil);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            salida.close();
            bandera=true;
            salida.close();
        } catch (Exception e) {

        }

        return bandera;
    }
    //guarda la lista de objetos Usuarios
    public void guardaUserObjt(ArrayList<CrearUsuario> user){
        
        
        try {
            ObjectOutputStream escribe_fichero= new ObjectOutputStream(new FileOutputStream(PathFijo+"USUARIOS.txt"));
            escribe_fichero.writeObject(user);
            escribe_fichero.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public ArrayList<CrearUsuario> leerUserobj(){
        ArrayList<CrearUsuario> usuariosGuardados = new ArrayList<CrearUsuario>();
        CrearUsuario users;
        try {
            
            ObjectInputStream recupera=new ObjectInputStream(new FileInputStream(PathFijo+"USUARIOS.txt"));

            usuariosGuardados=(ArrayList<CrearUsuario>) recupera.readObject();
            recupera.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuariosGuardados;
    }
    public ArrayList<CrearUsuario> leerUserobjLogin(){
        ArrayList<CrearUsuario> usuariosGuardados = new ArrayList<CrearUsuario>();
        CrearUsuario users;
        try {
            
            ObjectInputStream recupera=new ObjectInputStream(new FileInputStream(PathFijo+"USUARIOS.txt"));

            usuariosGuardados=(ArrayList<CrearUsuario>) recupera.readObject();
            recupera.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuariosGuardados;
    }
    public void mostrarUsuarios(){
        ArrayList<CrearUsuario> usuariosGuardados = new ArrayList<CrearUsuario>();
        CrearUsuario users;
        try {
            
            ObjectInputStream recupera=new ObjectInputStream(new FileInputStream(PathFijo+"USUARIOS.txt"));

            usuariosGuardados=(ArrayList<CrearUsuario>) recupera.readObject();
            recupera.close();

        
        } catch (FileNotFoundException ex) {
            
            //Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            
            //Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           
            //Logger.getLogger(ReadFormSaved.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    public String buscarUsuarios(){
        String formato="";
        String fichero=PathFijo+"USUARIO"+".txt";
        try{
        archivo= new File(fichero);
            if (archivo.canRead()) {
                
                    String documento = AbrirArchivo(archivo);
                    formato=documento;
                    return formato;
                    //JOptionPane.showMessageDialog(null, ContenidoArchivo);
                
            } else{
                return formato;
            }
        } catch(Exception e){
            return formato;
            
        }
    }
    public boolean GuardarArchivoUsuario(String id, String documento) {
        String mensaje = null;
        boolean bandera=false;
        try {
            File fil= new File(PathFijo+id+".txt");
            salida = new FileOutputStream(fil);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            salida.close();
            bandera=true;
            salida.close();
        } catch (Exception e) {

        }

        return bandera;
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
