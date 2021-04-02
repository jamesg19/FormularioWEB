package Analizadores;

import static Analizadores.sym.*;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import GestorIndigo.*;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%unicode
%full
%line
%column
%char
%public
espacio=[ |\r|\t|\n]+
esp=[ ]+
numeros=[0-9]+
Jsimbolos=[@_"-"%#&?\|.]+
letras=[A-Za-z]+
INI_SOLICITUDESS = [Ii][Nn][Ii]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd][Ee][Ss]
FIN_SOLICITUDESS = [Ff][Ii][Nn]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd][Ee][Ss]
INI_SOLICITUDD = [Ii][Nn][Ii]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd]
FIN_SOLICITUDD = [Ff][Ii][Nn]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd]
Fecha = ([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))


%{
	//parentesis ()
	//corchetes []
	//llaves{}
	private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
	ArrayList<ErrorLexico> lexico = new ArrayList<ErrorLexico>();


	public ArrayList<ErrorLexico> getLexicoERROR() {
        return lexico;
    }


%}
%%

<YYINITIAL>{

"<" {return new Symbol(sym.DipleL,yyline+1, yycolumn+1,yytext());}
">" {return new Symbol(sym.DipleR,yyline+1, yycolumn+1,yytext());}
"!" {return new Symbol(sym.Exclamation,yyline+1, yycolumn+1,yytext());}
{INI_SOLICITUDESS} {return new Symbol(sym.IniSolicitudes,yyline+1, yycolumn+1,yytext());}
{FIN_SOLICITUDESS} {return new Symbol(sym.FinSolicitudes,yyline+1, yycolumn+1,yytext());}
{INI_SOLICITUDD} {return new Symbol(sym.IniSolicitud,yyline+1, yycolumn+1,yytext());}
{FIN_SOLICITUDD} {return new Symbol(sym.FinSolicitud,yyline+1, yycolumn+1,yytext());}


//Signos de Agrupacion
"(" {return new Symbol(sym.Parentesis_L,yyline+1, yycolumn+1,yytext());}
")" {return new Symbol(sym.Parentesis_R,yyline+1, yycolumn+1,yytext());}
"[" {return new Symbol(sym.Corchete_L,yyline+1, yycolumn+1,yytext());}
"]" {return new Symbol(sym.Corchete_R,yyline+1, yycolumn+1,yytext());}
"{" {return new Symbol(sym.Llave_L,yyline+1, yycolumn+1,yytext());}
"}" {return new Symbol(sym.Llave_R,yyline+1, yycolumn+1,yytext());}
"|" {return new Symbol(sym.Separador,yyline+1, yycolumn+1,yytext());}

//signos
":" {return new Symbol(sym.DosP,yyline+1, yycolumn+1,yytext());}
"," {return new Symbol(sym.Coma,yyline+1, yycolumn+1,yytext());}
"\"" {return new Symbol(sym.Comilla,yyline+1, yycolumn+1,yytext());}
"\'" {return new Symbol(sym.Apostrofe,yyline+1, yycolumn+1,yytext());}

//*********Aplicacion Cliente**********//
"CREDENCIALES_USUARIO" {return new Symbol(sym.CredencialUser,yyline+1, yycolumn+1,yytext());}
// CREAR USUARIOS EN SISTEMA
"CREAR_USUARIO" {return new Symbol(sym.CrearUsuario,yyline+1, yycolumn+1,yytext());}
"USUARIO" {return new Symbol(sym.Usuario,yyline+1, yycolumn+1,yytext());}
"PASSWORD" {return new Symbol(sym.Password,yyline+1, yycolumn+1,yytext());}
//MODIFICAR USUARIO
"MODIFICAR_USUARIO" {return new Symbol(sym.ModificarUser,yyline+1, yycolumn+1,yytext());}
"USUARIO_ANTIGUO" {return new Symbol(sym.UserAntiguo,yyline+1, yycolumn+1,yytext());}
"USUARIO_NUEVO" {return new Symbol(sym.UserNuevo,yyline+1, yycolumn+1,yytext());}
"NUEVO_PASSWORD" {return new Symbol(sym.NuevoPassword,yyline+1, yycolumn+1,yytext());}
"FECHA_MODIFICACION" {return new Symbol(sym.FechaModif,yyline+1, yycolumn+1,yytext());}
//ELIMINAR USUARIO
"ELIMINAR_USUARIO" {return new Symbol(sym.EliminarUsuario,yyline+1, yycolumn+1,yytext());}
//LOGIN
"LOGIN_USUARIO" {return new Symbol(sym.Login,yyline+1, yycolumn+1,yytext());}

//***********FORMULARIOS********//
"PARAMETROS_FORMULARIO" {return new Symbol(sym.ParametroForm,yyline+1, yycolumn+1,yytext());}
//NUEVO FORMULARIO
"NUEVO_FORMULARIO" {return new Symbol(sym.NuevoFormulario,yyline+1,yycolumn+1,yytext());}
"ID" {return new Symbol(sym.ID,yyline+1, yycolumn+1,yytext());}
"TITULO" {return new Symbol(sym.TituloForm,yyline+1, yycolumn+1,yytext());}
"NOMBRE" {return new Symbol(sym.NombreForm,yyline+1, yycolumn+1,yytext());}
"TEMA" {return new Symbol(sym.TemaForm,yyline+1, yycolumn+1,yytext());}
"USUARIO_CREACION" {return new Symbol(sym.UserCreacion,yyline+1, yycolumn+1,yytext());}
"FECHA_CREACION" {return new Symbol(sym.FechaCreacion,yyline+1, yycolumn+1,yytext());}

//**********TEMAS FORMULARIO******///
"Dark" {return new Symbol(sym.TDark,yyline+1, yycolumn+1,yytext());}
"Blue" {return new Symbol(sym.TBlue,yyline+1, yycolumn+1,yytext());}
"White" {return new Symbol(sym.TWhite,yyline+1, yycolumn+1,yytext());}

//ELIMINAR FORMULARIOS
"ELIMINAR_FORMULARIO" {return new Symbol(sym.EliminarForm,yyline+1, yycolumn+1,yytext());}
//MODIFICAR FORMULARIO
"MODIFICAR_FORMULARIO" {return new Symbol(sym.ModificarForm,yyline+1, yycolumn+1,yytext());}

//************AGREGAR COMPONENTE**********//
"PARAMETROS_COMPONENTE" {return new Symbol(sym.ParametrosComponente,yyline+1, yycolumn+1,yytext());}
"AGREGAR_COMPONENTE" {return new Symbol(sym.AgregarComponente,yyline+1, yycolumn+1,yytext());}
"ELIMINAR_COMPONENTE" {return new Symbol(sym.EliminarComponente,yyline+1, yycolumn+1,yytext() );}
"MODIFICAR_COMPONENTE" {return new Symbol(sym.ModificarComponente,yyline+1, yycolumn+1,yytext());}
"NOMBRE_CAMPO" {return new Symbol(sym.NombreCampo,yyline+1, yycolumn+1, yytext());}
"FORMULARIO" {return new Symbol(sym.Formulario,yyline+1, yycolumn+1,yytext());}
"CLASE" {return new Symbol(sym.Clase,yyline+1, yycolumn+1,yytext());}
	"CAMPO_TEXTO" {return new Symbol(sym.CampoTexto,yyline+1, yycolumn+1,yytext());}
	"AREA_TEXTO" {return new Symbol(sym.AreaTexto,yyline+1, yycolumn+1,yytext());}
	"CHECKBOX" {return new Symbol(sym.Checkbox,yyline+1, yycolumn+1,yytext());}
	"RADIO" {return new Symbol(sym.Radio,yyline+1, yycolumn+1,yytext());}
	"FICHERO" {return new Symbol(sym.Fichero,yyline+1, yycolumn+1,yytext());}
	"IMAGEN" {return new Symbol(sym.Imagen,yyline+1, yycolumn+1,yytext());}
	"COMBO" {return new Symbol(sym.Combo,yyline+1, yycolumn+1,yytext());}
	"BOTON" {return new Symbol(sym.Boton,yyline+1, yycolumn+1,yytext());}
"INDICE" {return new Symbol(sym.Indice,yyline+1, yycolumn+1,yytext() );}
"TEXTO_VISIBLE" {return new Symbol(sym.TextoVisible,yyline+1, yycolumn+1,yytext());}
"ALINEACION" {return new Symbol(sym.Alineacion,yyline+1, yycolumn+1,yytext());}
	"CENTRO" {return new Symbol(sym.Centro,yyline+1, yycolumn+1,yytext());}
	"IZQUIERDA" {return new Symbol(sym.Izquierda,yyline+1,yycolumn+1,yytext());}
	"DERECHA" {return new Symbol(sym.Derecha,yyline+1,yycolumn+1,yytext());}
	"JUSTIFICAR" {return new Symbol(sym.Justificar,yyline+1, yycolumn+1,yytext());}
"REQUERIDO" {return new Symbol(sym.Requerido,yyline+1,yycolumn+1,yytext());}
"SI" {return new Symbol(sym.Si,yyline+1, yycolumn+1,yytext());}
"NO" {return new Symbol(sym.No,yyline+1, yycolumn+1,yytext());}
"OPCIONES" {return new Symbol(sym.Opciones,yyline+1,yycolumn+1,yytext());}
"FILAS" {return new Symbol(sym.Filas,yyline+1, yycolumn+1,yytext());}
"COLUMNAS" {return new Symbol(sym.Columnas,yyline+1, yycolumn+1,yytext());}
"URL" {return new Symbol(sym.Url,yyline+1, yycolumn+1, yytext() );}
//////////////////////////////////////////SQFORM//////////////////////////////////////////
"SELECT" {return new Symbol(sym.Select,yyline+1, yycolumn+1, yytext());}
"TO" {return new Symbol(sym.To,yyline+1, yycolumn+1, yytext());}
"FORM" {return new Symbol(sym.Form,yyline+1, yycolumn+1, yytext());}
"WHERE" {return new Symbol(sym.Where,yyline+1, yycolumn+1, yytext());}
"AND" {return new Symbol(sym.And,yyline+1, yycolumn+1, yytext());}
"OR" {return new Symbol(sym.Or,yyline+1, yycolumn+1, yytext());}
"NOT" {return new Symbol(sym.Not,yyline+1, yycolumn+1, yytext());}
"CONSULTAS" {return new Symbol(sym.Consultas,yyline+1, yycolumn+1, yytext());}
"CONSULTA" {return new Symbol(sym.Consulta,yyline+1, yycolumn+1, yytext());}
"CONSULTAR_DATOS" {return new Symbol(sym.ConsultaDatos,yyline+1, yycolumn+1, yytext());}
//{numeros} {return new Symbol(sym.Numeros,yyline+1,yycolumn+1,yytext());}

("https://")?{letras}({letras})*"."{letras}({letras})*".com/"(({letras}|{numeros}|{Jsimbolos})*("/")?)* {return new Symbol(sym.DirURL,yyline+1,yycolumn+1,yytext());}
("$"|"_"|"-")("$"|"_"|"-"|{numeros}|{letras})* {return new Symbol(sym.Allids,yyline+1, yycolumn+1,yytext());}
{Fecha} {return new Symbol(sym.FechaF,yyline+1, yycolumn+1, yytext());}
{espacio} {}
({numeros}|{letras}|{Jsimbolos})+ {return new Symbol(sym.EXP_user_pass,yyline+1, yycolumn+1,yytext());}   
({esp}|{numeros}|{letras}|{Jsimbolos})+ {return new Symbol(sym.Textos,yyline+1,yycolumn+1,yytext());}  


//{letras} {return new Symbol(sym.Letras,yyline+1, yycolumn+1,yytext());}







}

/* Para cualquier otro simbolo no especificado u error lexico devuelve el error */
[^]
{	
	//ErrorLexico error = new ErrorLexico(yytext(),yyline+"",yycolumn+"");
	ErrorLexico error = new ErrorLexico();
	error.setToken(yytext());
	error.setLinea(yyline+"");
	error.setColumna(yycolumn+"");
	lexico.add(error);
	//lexico.add("Error tipo lexico "+yytext()+" linea: "+yyline);
	System.out.println("Error tipo lexico "+yytext());
}