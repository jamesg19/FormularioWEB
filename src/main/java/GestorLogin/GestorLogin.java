/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorLogin;

import AnalizadorDB.LexerDB;
import AnalizadorLogin.parserLogin;
import AnalizadorUsuario.LexerU;
import AnalizadorUsuario.parserU;
import Analizadores.LexerCup;
import File.ReadFormSaved;
import GestorIndigo.ErrorLexico;
import GestorIndigo.ErrorSintactico;
import GestorIndigo.Verificar;
import UsuarioIndigo.CrearUsuario;
import UsuarioIndigo.LoginUsuario;
import com.mycompany.formularios.login;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class GestorLogin {
    ArrayList<ErrorSintactico> sintactico = new ArrayList<ErrorSintactico>();
    ArrayList<ErrorLexico> lexicoLST = new ArrayList<ErrorLexico>();
    LoginUsuario objLogin= new LoginUsuario();
    LoginUsuario log;
    private String codigo;

    public GestorLogin(String codigo) {
        this.codigo = codigo;

    }

    public void consulta_Login() {

        try {
            StringReader readerr = new StringReader(codigo);
            LexerCup lexico = new LexerCup(readerr);
            parserLogin parser = new parserLogin(lexico);
            parser.parse();
            objLogin=parser.getLogin();
            lexicoLST=lexico.getLexicoERROR();
            sintactico=parser.getSintacticoERROR();
            //obtiene los datos recopilados con la gramatica correcta
            log=parser.getLogin();
            System.out.println("LOGIN:\n USUARIO: "+log.getUsuario()+" PASSWORD: "+log.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(GestorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    public boolean buscarUsuarioenDB(){
        boolean existe=false;
        
        ArrayList<CrearUsuario> lstUser = new ArrayList<CrearUsuario>();
        ReadFormSaved leer= new ReadFormSaved("");
        lstUser=leer.leerUserobjLogin();
        
        if(lstUser.get(0).getUsuario().equals(log.getUsuario()) && lstUser.get(0).getPassword().equals(log.getPassword())  ){
            
            existe=true;
            return existe;
        } else{
            existe=false;
            return existe;
        }

    }
    public boolean buscarUsuario(){
        boolean bandera=false;
        ArrayList<CrearUsuario> lst = new ArrayList<CrearUsuario>();
        ArrayList<CrearUsuario> lstFIn = new ArrayList<CrearUsuario>();
        try {
        String FormatoUsuario="";
        ReadFormSaved rd= new ReadFormSaved("");
        FormatoUsuario=rd.buscarUsuarios();
        
        StringReader readerr = new StringReader(FormatoUsuario);
        LexerU lexico = new LexerU(readerr);
        parserU parser = new parserU(lexico);
        parser.parse();
        lst=parser.getUsuarios();
        
        for(int i=0;i<lst.size();i++){
            if(lst.get(i).getUsuario().equals(objLogin.getUsuario()) && lst.get(i).getPassword().equals(objLogin.getPassword())    ){
                return true;
            }
            
        }
        
       
        
        
        return bandera;
        } catch (Exception ex) {
            return bandera;
            //Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<ErrorSintactico> getSintactico() {
        return sintactico;
    }

    public void setSintactico(ArrayList<ErrorSintactico> sintactico) {
        this.sintactico = sintactico;
    }

    public ArrayList<ErrorLexico> getLexicoLST() {
        return lexicoLST;
    }

    public void setLexicoLST(ArrayList<ErrorLexico> lexicoLST) {
        this.lexicoLST = lexicoLST;
    }

}
