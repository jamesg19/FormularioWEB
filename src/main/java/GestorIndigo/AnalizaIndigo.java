package GestorIndigo;

import GestorIndigo.ErrorLexico;
import GestorIndigo.ErrorSintactico;
import Analizadores.*;
import java.io.Serializable;
import UsuarioIndigo.*;
import java.io.StringReader;
import java.util.ArrayList;
import FormSolicitudIndigo.*;
import UsuarioIndigo.*;
import ComponentesIndigo.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalizaIndigo implements Serializable {
    ArrayList<ErrorLexico> lexicoLST = new ArrayList<ErrorLexico>();
    ArrayList<ErrorSintactico> sintacticoLST = new ArrayList<ErrorSintactico>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Formulario> formularios = new ArrayList<Formulario>();
    ArrayList<Componente> componentes = new ArrayList<Componente>();
    private String codigo;

    public AnalizaIndigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void Analizar(String cod){
        String entrada = codigo;
            
        try{
            StringReader readerr = new StringReader(cod);
            LexerCup lexico = new LexerCup(readerr);
            parser parser = new parser(lexico);
            parser.parse();
            usuarios=parser.getLstUsuario();
            formularios=parser.getLstFormulario();
            componentes=parser.getLstComponente();
            
            sintacticoLST=parser.getSintacticoERROR();
            lexicoLST=new LexerCup(new StringReader(cod)).getLexicoERROR();
            Verificar semantico= new Verificar(usuarios,formularios,componentes);
            semantico.AnalisisUsuarios();
            semantico.AnalisisFormularios();
            semantico.AnalisisComponentes();
            
            //System.out.println(parser.getSintacticoERROR().size()+"NUMERO TOTAL");
            } catch(Exception ex){

            System.out.println("errrrrrrrrrorrrrrrrrrrrrrrrrrrrr de analizadoressss  "+ex);
            Logger.getLogger(AnalizaIndigo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<ErrorLexico> getLexicoLST() {
        return lexicoLST;
    }

    public void setLexicoLST(ArrayList<ErrorLexico> lexicoLST) {
        this.lexicoLST = lexicoLST;
    }

    public ArrayList<ErrorSintactico> getSintacticoLST() {
        return sintacticoLST;
    }

    public void setSintacticoLST(ArrayList<ErrorSintactico> sintacticoLST) {
        this.sintacticoLST = sintacticoLST;
    }
    
    
}
