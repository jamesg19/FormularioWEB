package AnalizadorDB;

import static AnalizadorDB.parserUSym.*;
import java_cup.runtime.Symbol;

%%
%class LexerU

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

Jsimbolos=[@_"-"%#&\|]+
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

"<" {return new Symbol(parserUSym.DipleL,yyline+1, yycolumn+1, yytext());}
">" {return new Symbol(parserUSym.DipleR,yyline+1, yycolumn+1, yytext());}
"!" {return new Symbol(parserUSym.Exclamation,yyline+1, yycolumn+1, yytext());}
{INI_SOLICITUDESS} {return new Symbol(parserUSym.IniSolicitudes,yyline+1, yycolumn+1, yytext());}
{FIN_SOLICITUDESS} {return new Symbol(parserUSym.FinSolicitudes,yyline+1, yycolumn+1, yytext());}
{INI_SOLICITUDD} {return new Symbol(parserUSym.IniSolicitud,yyline+1, yycolumn+1, yytext());}
{FIN_SOLICITUDD} {return new Symbol(parserUSym.FinSolicitud,yyline+1, yycolumn+1, yytext());}


//Signos de Agrupacion
"(" {return new Symbol(parserUSym.Parentesis_L,yyline+1, yycolumn+1, yytext());}
")" {return new Symbol(parserUSym.Parentesis_R,yyline+1, yycolumn+1, yytext());}
"[" {return new Symbol(parserUSym.Corchete_L,yyline+1, yycolumn+1, yytext());}
"]" {return new Symbol(parserUSym.Corchete_R,yyline+1, yycolumn+1, yytext());}
"{" {return new Symbol(parserUSym.Llave_L,yyline+1, yycolumn+1, yytext());}
"}" {return new Symbol(parserUSym.Llave_R,yyline+1, yycolumn+1, yytext());}
"|" {return new Symbol(parserUSym.Separador,yyline+1, yycolumn+1, yytext());}

//signos
":" {return new Symbol(parserUSym.DosP,yyline+1, yycolumn+1, yytext());}
"," {return new Symbol(parserUSym.Coma,yyline+1, yycolumn+1, yytext());}
"\"" {return new Symbol(parserUSym.Comilla,yyline+1, yycolumn+1, yytext());}

//*********Aplicacion Cliente**********//
"CREDENCIALES_USUARIO" {return new Symbol(parserUSym.CredencialUser,yyline+1, yycolumn+1, yytext());}
// CREAR USUARIOS EN SISTEMA
"CREAR_USUARIO" {return new Symbol(parserUSym.CrearUsuario,yyline+1, yycolumn+1, yytext());}
"USUARIO" {return new Symbol(parserUSym.Usuario,yyline+1, yycolumn+1, yytext() );}
"PASSWORD" {return new Symbol(parserUSym.Password,yyline+1, yycolumn+1, yytext() );}
//MODIFICAR USUARIO
"MODIFICAR_USUARIO" {return new Symbol(parserUSym.ModificarUser,yyline+1, yycolumn+1, yytext());}
"USUARIO_ANTIGUO" {return new Symbol(parserUSym.UserAntiguo,yyline+1, yycolumn+1, yytext());}
"USUARIO_NUEVO" {return new Symbol(parserUSym.UserNuevo,yyline+1, yycolumn+1, yytext() );}
"NUEVO_PASSWORD" {return new Symbol(parserUSym.NuevoPassword,yyline+1, yycolumn+1, yytext() );}
"FECHA_MODIFICACION" {return new Symbol(parserUSym.FechaModif,yyline+1, yycolumn+1, yytext());}
//ELIMINAR USUARIO
"ELIMINAR_USUARIO" {return new Symbol(parserUSym.EliminarUsuario,yyline+1, yycolumn+1, yytext());}
//LOGIN
"LOGIN_USUARIO" {return new Symbol(parserUSym.Login,yyline+1, yycolumn+1, yytext());}

//***********FORMULARIOS********//
"PARAMETROS_FORMULARIO" {return new Symbol(parserUSym.ParametroForm,yyline+1, yycolumn+1, yytext() );}
//NUEVO FORMULARIO
"NUEVO_FORMULARIO" {return new Symbol(parserUSym.NuevoFormulario,yyline+1, yycolumn+1, yytext() );}
"ID" {return new Symbol(parserUSym.ID,yyline+1, yycolumn+1, yytext() );}
"ID_FORMULARIO" {return new Symbol(parserUSym.IdFormulario,yyline+1, yycolumn+1, yytext() );}
"TITULO" {return new Symbol(parserUSym.TituloForm,yyline+1, yycolumn+1, yytext() );}
"NOMBRE" {return new Symbol(parserUSym.NombreForm,yyline+1, yycolumn+1, yytext() );}
"TEMA" {return new Symbol(parserUSym.TemaForm,yyline+1, yycolumn+1, yytext() );}
"USUARIO_CREACION" {return new Symbol(parserUSym.UserCreacion,yyline+1, yycolumn+1, yytext() );}
"FECHA_CREACION" {return new Symbol(parserUSym.FechaCreacion,yyline+1, yycolumn+1, yytext() );}

//**********TEMAS FORMULARIO******///
"Dark" {return new Symbol(parserUSym.TDark,yyline+1, yycolumn+1, yytext() );}
"Blue" {return new Symbol(parserUSym.TBlue,yyline+1, yycolumn+1, yytext() );}
"White" {return new Symbol(parserUSym.TWhite,yyline+1, yycolumn+1, yytext() );}

//ELIMINAR FORMULARIOS
"ELIMINAR_FORMULARIO" {return new Symbol(parserUSym.EliminarForm,yyline+1, yycolumn+1, yytext() );}
//MODIFICAR FORMULARIO
"MODIFICAR_FORMULARIO" {return new Symbol(parserUSym.ModificarForm,yyline+1, yycolumn+1, yytext() );}

//************AGREGAR COMPONENTE**********//
"PARAMETROS_COMPONENTE" {return new Symbol(parserUSym.ParametrosComponente,yyline+1, yycolumn+1, yytext() );}
"AGREGAR_COMPONENTE" {return new Symbol(parserUSym.AgregarComponente,yyline+1, yycolumn+1, yytext() );}
"ELIMINAR_COMPONENTE" {return new Symbol(parserUSym.EliminarComponente,yyline+1, yycolumn+1, yytext() );}
"MODIFICAR_COMPONENTE" {return new Symbol(parserUSym.ModificarComponente,yyline+1, yycolumn+1, yytext() );}
"NOMBRE_CAMPO" {return new Symbol(parserUSym.NombreCampo,yyline+1, yycolumn+1, yytext());}
"FORMULARIO" {return new Symbol(parserUSym.Formulario,yyline+1, yycolumn+1, yytext());}
"CLASE" {return new Symbol(parserUSym.Clase,yyline+1, yycolumn+1, yytext());}
	"CAMPO_TEXTO" {return new Symbol(parserUSym.CampoTexto,yyline+1, yycolumn+1, yytext());}
	"AREA_TEXTO" {return new Symbol(parserUSym.AreaTexto,yyline+1, yycolumn+1, yytext());}
	"CHECKBOX" {return new Symbol(parserUSym.Checkbox,yyline+1, yycolumn+1, yytext());}
	"RADIO" {return new Symbol(parserUSym.Radio,yyline+1, yycolumn+1, yytext());}
	"FICHERO" {return new Symbol(parserUSym.Fichero,yyline+1, yycolumn+1, yytext());}
	"IMAGEN" {return new Symbol(parserUSym.Imagen,yyline+1, yycolumn+1, yytext());}
	"COMBO" {return new Symbol(parserUSym.Combo,yyline+1, yycolumn+1, yytext());}
	"BOTON" {return new Symbol(parserUSym.Boton,yyline+1, yycolumn+1, yytext());}
"INDICE" {return new Symbol(parserUSym.Indice,yyline+1, yycolumn+1, yytext() );}
"TEXTO_VISIBLE" {return new Symbol(parserUSym.TextoVisible,yyline+1, yycolumn+1, yytext() );}
"ALINEACION" {return new Symbol(parserUSym.Alineacion,yyline+1, yycolumn+1, yytext() );}
	"CENTRO" {return new Symbol(parserUSym.Centro,yyline+1, yycolumn+1, yytext() );}
	"IZQUIERDA" {return new Symbol(parserUSym.Izquierda,yyline+1, yycolumn+1, yytext() );}
	"DERECHA" {return new Symbol(parserUSym.Derecha,yyline+1, yycolumn+1, yytext() );}
	"JUSTIFICAR" {return new Symbol(parserUSym.Justificar,yyline+1, yycolumn+1, yytext() );}
"REQUERIDO" {return new Symbol(parserUSym.Requerido,yyline+1, yycolumn+1, yytext() );}
"SI" {return new Symbol(parserUSym.Si,yyline+1, yycolumn+1, yytext());}
"NO" {return new Symbol(parserUSym.No,yyline+1, yycolumn+1, yytext());}
"OPCIONES" {return new Symbol(parserUSym.Opciones,yyline+1, yycolumn+1, yytext() );}
"FILAS" {return new Symbol(parserUSym.Filas,yyline+1, yycolumn+1, yytext() );}
"COLUMNAS" {return new Symbol(parserUSym.Columnas,yyline+1, yycolumn+1, yytext() );}
"URL" {return new Symbol(parserUSym.Url,yyline+1, yycolumn+1, yytext() );}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//gramatica FORMULARIOS
"db.formularios" {return new Symbol(parserUSym.InicioGuardaForm,yyline+1, yycolumn+1, yytext() );}
"ESTRUCTURA" {return new Symbol(parserUSym.Estructura,yyline+1, yycolumn+1, yytext() );}
"DATOS_RECOPILADOS" {return new Symbol(parserUSym.DatosRecopilados,yyline+1, yycolumn+1, yytext() );}

{numeros} {return new Symbol(parserUSym.Numeros,yyline+1,yycolumn+1,yytext());}
("$"|"_"|"-")("$"|"_"|"-"|{numeros}|{letras})* {return new Symbol(parserUSym.Allids,yyline+1, yycolumn+1, yytext());}
{Fecha} {return new Symbol(parserUSym.FechaF,yyline+1, yycolumn+1, yytext() );}
{espacio} {}

({numeros}|{letras}|{Jsimbolos})+ {return new Symbol(parserUSym.EXP_user_pass,yyline+1, yycolumn+1,yytext());}   
({esp}|{numeros}|{letras}|{Jsimbolos})+ {return new Symbol(parserUSym.Textos,yyline+1,yycolumn+1,yytext());}  

("https://")?{letras}({letras})*"."{letras}({letras})*".com/"(({letras}|{numeros}|{Jsimbolos})*("/")?)* {return new Symbol(parserUSym.DirURL,yyline+1,yycolumn+1,yytext());}
}

/* Para cualquier otro simbolo no especificado u error lexico devuelve el error */
[^]
{	
	System.out.println("Error tipo lexico "+yytext());
}