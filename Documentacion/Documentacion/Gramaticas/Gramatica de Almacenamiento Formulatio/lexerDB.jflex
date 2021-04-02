package AnalizadorDB;

import static AnalizadorDB.parserDBSym.*;
import java_cup.runtime.Symbol;

%%
%class LexerDB
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

Jsimbolos=[@_"-"%#&\|.]+
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
%}
%%

<YYINITIAL>{

"<" {return new Symbol(parserDBSym.DipleL,yyline+1, yycolumn+1, yytext());}
">" {return new Symbol(parserDBSym.DipleR,yyline+1, yycolumn+1, yytext());}
"!" {return new Symbol(parserDBSym.Exclamation,yyline+1, yycolumn+1, yytext());}
{INI_SOLICITUDESS} {return new Symbol(parserDBSym.IniSolicitudes,yyline+1, yycolumn+1, yytext());}
{FIN_SOLICITUDESS} {return new Symbol(parserDBSym.FinSolicitudes,yyline+1, yycolumn+1, yytext());}
{INI_SOLICITUDD} {return new Symbol(parserDBSym.IniSolicitud,yyline+1, yycolumn+1, yytext());}
{FIN_SOLICITUDD} {return new Symbol(parserDBSym.FinSolicitud,yyline+1, yycolumn+1, yytext());}


//Signos de Agrupacion
"(" {return new Symbol(parserDBSym.Parentesis_L,yyline+1, yycolumn+1, yytext());}
")" {return new Symbol(parserDBSym.Parentesis_R,yyline+1, yycolumn+1, yytext());}
"[" {return new Symbol(parserDBSym.Corchete_L,yyline+1, yycolumn+1, yytext());}
"]" {return new Symbol(parserDBSym.Corchete_R,yyline+1, yycolumn+1, yytext());}
"{" {return new Symbol(parserDBSym.Llave_L,yyline+1, yycolumn+1, yytext());}
"}" {return new Symbol(parserDBSym.Llave_R,yyline+1, yycolumn+1, yytext());}
"|" {return new Symbol(parserDBSym.Separador,yyline+1, yycolumn+1, yytext());}

//signos
":" {return new Symbol(parserDBSym.DosP,yyline+1, yycolumn+1, yytext());}
"," {return new Symbol(parserDBSym.Coma,yyline+1, yycolumn+1, yytext());}
"\"" {return new Symbol(parserDBSym.Comilla,yyline+1, yycolumn+1, yytext());}

//*********Aplicacion Cliente**********//
"CREDENCIALES_USUARIO" {return new Symbol(parserDBSym.CredencialUser,yyline+1, yycolumn+1, yytext());}
// CREAR USUARIOS EN SISTEMA
"CREAR_USUARIO" {return new Symbol(parserDBSym.CrearUsuario,yyline+1, yycolumn+1, yytext());}
"USUARIO" {return new Symbol(parserDBSym.Usuario,yyline+1, yycolumn+1, yytext() );}
"PASSWORD" {return new Symbol(parserDBSym.Password,yyline+1, yycolumn+1, yytext() );}
//MODIFICAR USUARIO
"MODIFICAR_USUARIO" {return new Symbol(parserDBSym.ModificarUser,yyline+1, yycolumn+1, yytext());}
"USUARIO_ANTIGUO" {return new Symbol(parserDBSym.UserAntiguo,yyline+1, yycolumn+1, yytext());}
"USUARIO_NUEVO" {return new Symbol(parserDBSym.UserNuevo,yyline+1, yycolumn+1, yytext() );}
"NUEVO_PASSWORD" {return new Symbol(parserDBSym.NuevoPassword,yyline+1, yycolumn+1, yytext() );}
"FECHA_MODIFICACION" {return new Symbol(parserDBSym.FechaModif,yyline+1, yycolumn+1, yytext());}
//ELIMINAR USUARIO
"ELIMINAR_USUARIO" {return new Symbol(parserDBSym.EliminarUsuario,yyline+1, yycolumn+1, yytext());}
//LOGIN
"LOGIN_USUARIO" {return new Symbol(parserDBSym.Login,yyline+1, yycolumn+1, yytext());}

//***********FORMULARIOS********//
"PARAMETROS_FORMULARIO" {return new Symbol(parserDBSym.ParametroForm,yyline+1, yycolumn+1, yytext() );}
//NUEVO FORMULARIO
"NUEVO_FORMULARIO" {return new Symbol(parserDBSym.NuevoFormulario,yyline+1, yycolumn+1, yytext() );}
"ID" {return new Symbol(parserDBSym.ID,yyline+1, yycolumn+1, yytext() );}
"ID_FORMULARIO" {return new Symbol(parserDBSym.IdFormulario,yyline+1, yycolumn+1, yytext() );}
"TITULO" {return new Symbol(parserDBSym.TituloForm,yyline+1, yycolumn+1, yytext() );}
"NOMBRE" {return new Symbol(parserDBSym.NombreForm,yyline+1, yycolumn+1, yytext() );}
"TEMA" {return new Symbol(parserDBSym.TemaForm,yyline+1, yycolumn+1, yytext() );}
"USUARIO_CREACION" {return new Symbol(parserDBSym.UserCreacion,yyline+1, yycolumn+1, yytext() );}
"FECHA_CREACION" {return new Symbol(parserDBSym.FechaCreacion,yyline+1, yycolumn+1, yytext() );}

//**********TEMAS FORMULARIO******///
"Dark" {return new Symbol(parserDBSym.TDark,yyline+1, yycolumn+1, yytext() );}
"Blue" {return new Symbol(parserDBSym.TBlue,yyline+1, yycolumn+1, yytext() );}
"White" {return new Symbol(parserDBSym.TWhite,yyline+1, yycolumn+1, yytext() );}

//ELIMINAR FORMULARIOS
"ELIMINAR_FORMULARIO" {return new Symbol(parserDBSym.EliminarForm,yyline+1, yycolumn+1, yytext() );}
//MODIFICAR FORMULARIO
"MODIFICAR_FORMULARIO" {return new Symbol(parserDBSym.ModificarForm,yyline+1, yycolumn+1, yytext() );}

//************AGREGAR COMPONENTE**********//
"PARAMETROS_COMPONENTE" {return new Symbol(parserDBSym.ParametrosComponente,yyline+1, yycolumn+1, yytext() );}
"AGREGAR_COMPONENTE" {return new Symbol(parserDBSym.AgregarComponente,yyline+1, yycolumn+1, yytext() );}
"ELIMINAR_COMPONENTE" {return new Symbol(parserDBSym.EliminarComponente,yyline+1, yycolumn+1, yytext() );}
"MODIFICAR_COMPONENTE" {return new Symbol(parserDBSym.ModificarComponente,yyline+1, yycolumn+1, yytext() );}
"NOMBRE_CAMPO" {return new Symbol(parserDBSym.NombreCampo,yyline+1, yycolumn+1, yytext());}
"FORMULARIO" {return new Symbol(parserDBSym.Formulario,yyline+1, yycolumn+1, yytext());}
"CLASE" {return new Symbol(parserDBSym.Clase,yyline+1, yycolumn+1, yytext());}
	"CAMPO_TEXTO" {return new Symbol(parserDBSym.CampoTexto,yyline+1, yycolumn+1, yytext());}
	"AREA_TEXTO" {return new Symbol(parserDBSym.AreaTexto,yyline+1, yycolumn+1, yytext());}
	"CHECKBOX" {return new Symbol(parserDBSym.Checkbox,yyline+1, yycolumn+1, yytext());}
	"RADIO" {return new Symbol(parserDBSym.Radio,yyline+1, yycolumn+1, yytext());}
	"FICHERO" {return new Symbol(parserDBSym.Fichero,yyline+1, yycolumn+1, yytext());}
	"IMAGEN" {return new Symbol(parserDBSym.Imagen,yyline+1, yycolumn+1, yytext());}
	"COMBO" {return new Symbol(parserDBSym.Combo,yyline+1, yycolumn+1, yytext());}
	"BOTON" {return new Symbol(parserDBSym.Boton,yyline+1, yycolumn+1, yytext());}
"INDICE" {return new Symbol(parserDBSym.Indice,yyline+1, yycolumn+1, yytext() );}
"TEXTO_VISIBLE" {return new Symbol(parserDBSym.TextoVisible,yyline+1, yycolumn+1, yytext() );}
"ALINEACION" {return new Symbol(parserDBSym.Alineacion,yyline+1, yycolumn+1, yytext() );}
	"CENTRO" {return new Symbol(parserDBSym.Centro,yyline+1, yycolumn+1, yytext() );}
	"IZQUIERDA" {return new Symbol(parserDBSym.Izquierda,yyline+1, yycolumn+1, yytext() );}
	"DERECHA" {return new Symbol(parserDBSym.Derecha,yyline+1, yycolumn+1, yytext() );}
	"JUSTIFICAR" {return new Symbol(parserDBSym.Justificar,yyline+1, yycolumn+1, yytext() );}
"REQUERIDO" {return new Symbol(parserDBSym.Requerido,yyline+1, yycolumn+1, yytext() );}
"SI" {return new Symbol(parserDBSym.Si,yyline+1, yycolumn+1, yytext());}
"NO" {return new Symbol(parserDBSym.No,yyline+1, yycolumn+1, yytext());}
"OPCIONES" {return new Symbol(parserDBSym.Opciones,yyline+1, yycolumn+1, yytext() );}
"FILAS" {return new Symbol(parserDBSym.Filas,yyline+1, yycolumn+1, yytext() );}
"COLUMNAS" {return new Symbol(parserDBSym.Columnas,yyline+1, yycolumn+1, yytext() );}
"URL" {return new Symbol(parserDBSym.Url,yyline+1, yycolumn+1, yytext() );}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//gramatica FORMULARIOS
"db.formularios" {return new Symbol(parserDBSym.InicioGuardaForm,yyline+1, yycolumn+1, yytext() );}
"ESTRUCTURA" {return new Symbol(parserDBSym.Estructura,yyline+1, yycolumn+1, yytext() );}
"DATOS_RECOPILADOS" {return new Symbol(parserDBSym.DatosRecopilados,yyline+1, yycolumn+1, yytext() );}

{numeros} {return new Symbol(parserDBSym.Numeros,yyline+1,yycolumn+1,yytext());}
("$"|"_"|"-")("$"|"_"|"-"|{numeros}|{letras})* {return new Symbol(parserDBSym.Allids,yyline+1, yycolumn+1, yytext());}
{Fecha} {return new Symbol(parserDBSym.FechaF,yyline+1, yycolumn+1, yytext() );}
{espacio} {}

({numeros}|{letras}|{Jsimbolos})+ {return new Symbol(parserDBSym.EXP_user_pass,yyline+1, yycolumn+1,yytext());}   
({esp}|{numeros}|{letras}|{Jsimbolos})+ {return new Symbol(parserDBSym.Textos,yyline+1,yycolumn+1,yytext());}  

("https://")?{letras}({letras})*"."{letras}({letras})*".com/"(({letras}|{numeros}|{Jsimbolos})*("/")?)* {return new Symbol(parserDBSym.DirURL,yyline+1,yycolumn+1,yytext());}
}

/* Para cualquier otro simbolo no especificado u error lexico devuelve el error */
[^]
{	
	System.out.println("Error tipo lexico "+yytext());
}