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
        String reporteFinal="";    
        try{
            StringReader readerr = new StringReader(cod);
            LexerCup lexico = new LexerCup(readerr);
            parser parser = new parser(lexico);
            parser.parse();
            usuarios=parser.getLstUsuario();
            formularios=parser.getLstFormulario();
            componentes=parser.getLstComponente();
            lexicoLST=lexico.getLexicoERROR();
            //obtiene los errores sintacticos
            sintacticoLST=parser.getSintacticoERROR();
            //obtiene lo serrores lexicos
            //lexicoLST=new LexerCup(new StringReader(cod)).getLexicoERROR();
            //lexicoLST=lexico.getLexicoERROR();
            Responde resp= new Responde();
            //SI NO HAY ERRORES LEXICOS Y SINTACTICOS
            
            if(lexicoLST.isEmpty()&&sintacticoLST.isEmpty()){
                
            
            Verificar semantico= new Verificar(usuarios,formularios,componentes);
            
            semantico.AnalisisUsuarios();
            //analiza los formularios

            //CREAR FORMULARIOS
            semantico.AnalisisFormularios();
            //analiza los componentes
            //CREAR COMPONENTES
            semantico.AnalisisComponentes();
            //verifica si hay errores semanticos
            if(semantico.getLstErrSementico().size()>0){
                for(int k=0;k<semantico.getLstErrSementico().size();k++ ){
                    //resp.startClient(semantico.getLstErrSementico().get(k));
                    reporteFinal+=semantico.getLstErrSementico().get(k);
                }
                
            }
            semantico.HayErrores();
            //guarda los USUARIOS A CREAR
            
            semantico.GenerarDocUsuario();
            //elimina los usuarios
            
            semantico.EliminarUser();
            //modifica usuarios
            semantico.ModifUser();

            //semantico.modificarUsuarios();
            //elimina formularios
            semantico.eliminarFormularios();

            
            
            semantico.getINFO();
            for(int l=0;l<semantico.getINFO().size();l++){
                reporteFinal+=semantico.getINFO().get(l)+"\n";
            }
            
            
            System.out.println(reporteFinal);
            resp.startClient(reporteFinal);
            
            }else{
                
                if(lexicoLST.size()>0){
                    for(int m=0;m<lexicoLST.size();m++){
                        //resp.startClient("Error LEXICO Token:"+lexicoLST.get(m).getToken()+" Linea: "+lexicoLST.get(m).getLinea()+" Columna: "+lexicoLST.get(m).getColumna());
                        reporteFinal+="Error LEXICO Token:"+lexicoLST.get(m).getToken()+" Linea: "+lexicoLST.get(m).getLinea()+" Columna: "+lexicoLST.get(m).getColumna()+"\n";
                       
                }
                }
                if(sintacticoLST.size()>0){
                    for(int m=0;m<sintacticoLST.size();m++){
                        //resp.startClient("Error SINTACTICO se esperaba: "+sintacticoLST.get(m).getTokenEsperado()+" Linea: "+sintacticoLST.get(m).getLinea()+" Columna: "+sintacticoLST.get(m).getColumna()+" CONFLICTO en: "+sintacticoLST.get(m).getValor());
                        reporteFinal+="Error SINTACTICO se esperaba: "+sintacticoLST.get(m).getTokenEsperado()+" COLUMNA: "+sintacticoLST.get(m).getValor()+" LINEA:: "+sintacticoLST.get(m).getColumna()+" CONFLICTO en: "+sintacticoLST.get(m).getLinea()+"\n";
                        
                    }
                }
                 resp.startClient(reporteFinal);
            
            }
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
