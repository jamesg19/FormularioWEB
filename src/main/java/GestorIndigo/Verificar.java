/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorIndigo;

import AnalizadorUsuario.LexerU;
import AnalizadorUsuario.parserU;
import ComponentesIndigo.*;
import FormSolicitudIndigo.*;
import UsuarioIndigo.*;
import ComponentesHTML.*;
import File.ReadFormSaved;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class Verificar {

    ArrayList<Usuario> usuarios;
    ArrayList<Formulario> formularios;
    ArrayList<Componente> componentes;
    private ArrayList<String> lstErrSementico = new ArrayList<String>();
    private ArrayList<String> lstIDFORM = new ArrayList<String>();
    private ArrayList<String> INFO = new ArrayList<String>();
    //CREAR
    ArrayList<NuevoForm> Form_a_Crear = new ArrayList<NuevoForm>();
    ArrayList<AgregarComponente> Comp_Crear = new ArrayList<AgregarComponente>();
    ArrayList<CrearUsuario> user_Crear = new ArrayList<CrearUsuario>();
    ArrayList<ModificarUsuario> user_Modif = new ArrayList<ModificarUsuario>();
    ArrayList<EliminarUsuario> user_Delete = new ArrayList<EliminarUsuario>();
    ArrayList<EliminarForm> form_Delete = new ArrayList<EliminarForm>();
    ArrayList<ModificarForm> form_Modif = new ArrayList<ModificarForm>();
    
    
    
    String usuarioLogueado="JAMES";
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    public Verificar(ArrayList<Usuario> usuarios, ArrayList<Formulario> formularios, ArrayList<Componente> componentes) {
        this.usuarios = usuarios;
        this.formularios = formularios;
        this.componentes = componentes;
    }

    public void AnalisisUsuarios() {

        for (int i = 0; i < usuarios.size(); i++) {
            //CREAR USUARIO
            if (usuarios.get(i) instanceof CrearUsuario) {
                CrearUsuario crearU = (CrearUsuario) usuarios.get(i);
                if(crearU.getUsuario()!=null&& crearU.getPassword()!=null){
                    System.out.println(crearU.getUsuario());
                    System.out.println(crearU.getPassword());
                    
                        crearU.setFechaCreacion(timeStamp);
                    
                    user_Crear.add(crearU);
                }else{
                    lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS EN CREACION DE USUARIO ");
                    //NO SE AGREGARON LOS PARAMETROS OBLIGATORIOS
                }
                
            }
            //MODIFICAR USUARIO
            else if (usuarios.get(i) instanceof ModificarUsuario) {
                System.out.println("SI MODIFICA");
                ModificarUsuario modifs = (ModificarUsuario) usuarios.get(i);
                if (!modifs.getUsuarioAnt().equals(null) && !modifs.getUsuarioNue().equals(null) && !modifs.getNuevoPass().equals(null)) {
                    System.out.println(modifs.getUsuarioAnt());
                    System.out.println(modifs.getUsuarioNue());
                    System.out.println("NUEVO PASS" + modifs.getNuevoPass());

                    if (modifs.getFechaModif() == null) {
                        modifs.setFechaModif(timeStamp);
                        System.out.println("fecha1" + modifs.getFechaModif());
                    } else {
                        System.out.println("fecha2" + modifs.getFechaModif());
                    }
                    user_Modif.add(modifs);
                } else {
                    //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                    lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS EN MODIFICAR USUARIO(NUEVO USUARIO, ANTIGUO USUARIO, NUEVO PASSWORD ) ");
                    System.out.println(" NO SE ESTABLECIERON PARAMETROS OBLIGATORIOS");
                }
            }
            
            
            else if (usuarios.get(i) instanceof EliminarUsuario) {
                EliminarUsuario elimU = (EliminarUsuario) usuarios.get(i);
                System.out.println(elimU.getUsuario());
                user_Delete.add(elimU);
            }
        }
    }

    public void AnalisisFormularios() {

        for (int i = 0; i < formularios.size(); i++) {
            if (formularios.get(i) instanceof NuevoForm) {
                NuevoForm nForm = (NuevoForm) formularios.get(i);
                if (nForm.getId() != null && nForm.getTitulo() != null && nForm.getNombre() != null && nForm.getTema() != null) {
                    //NuevoForm newF = (NuevoForm) formularios.get(i);
                    System.out.println(nForm.getId());
                    System.out.println(nForm.getTitulo());
                    System.out.println(nForm.getNombre());
                    System.out.println(nForm.getTema());

                    if (nForm.getUsuarioCreacion() == null) {
                        nForm.setUsuarioCreacion(usuarioLogueado);
                    }
                    if (lstIDFORM.contains(nForm.getId())) {
                        lstErrSementico.add("EL ID DEL FORMULARIO SE REPITE: " + nForm.getId());
                    } else {
                        lstIDFORM.add(nForm.getId());
                    }
                    System.out.println(nForm.getUsuarioCreacion());

                    if (nForm.getFechaCreacion() == null) {
                        //String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                        nForm.setFechaCreacion(timeStamp);
                    } else {
                        System.out.println(nForm.getFechaCreacion());
                    }
                    //NuevoForm(String Id, String Titulo, String Nombre, String Tema, String usuarioCreacion, String fechaCreacion);
                    Form_a_Crear.add(nForm);
                } else {
                    lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS EN NUEVO FORMULARIO\n (Id, Titulo, Nombre, Tema)");
                }

            }


            else if (formularios.get(i) instanceof EliminarForm) {
                EliminarForm elimForm = (EliminarForm) formularios.get(i);
                System.out.println(elimForm.getId());
                form_Delete.add(elimForm);

            }

            
            else if (formularios.get(i) instanceof ModificarForm) {
                ModificarForm modif = (ModificarForm) formularios.get(i);
                if(modif.getId()!=null ){
                
                System.out.println(modif.getId());
                System.out.println(modif.getTitulo());
                System.out.println(modif.getNombre());
                System.out.println(modif.getTema());
                form_Modif.add(modif);
                }else{
                    lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS EN MODIFICAR FORMULARIO (Id)");
                    System.out.println("NO SE DEFINIERON PARAMETROS OBLIGATORIOS EN MODIF FORM");
                }
            }
        }
    }

    public void AnalisisComponentes() {
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i) instanceof AgregarComponente) {
                AgregarComponente AgregComp = (AgregarComponente) componentes.get(i);

                if (AgregComp.getClase()!=null) {

                    //VERIFICA LA CLASE CAMPO_TEXTO
                    if (AgregComp.getClase().equalsIgnoreCase("CAMPO_TEXTO")) {
                        //HTML crear y verificar si los componentes principales estan vacios
                        if (AgregComp.getOpciones()==null && AgregComp.getUrl()==null && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1) {

                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {
                                String req;
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
                                System.out.println(AgregComp.getRequerido());
                                if (!AgregComp.getRequerido().equals(null)) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                Comp_Crear.add(AgregComp);
                                CampoTextoH cm = new CampoTextoH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getNombreCampo(), AgregComp.getFormulario(), req, ali);
                            } else {
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR CAMPO TEXTO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }
                        } else {
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR CAMPO TEXTO\'");
                            //TRAE MAS COMPONENTES DE LOS PERMITIDOS
                        }
                    } 
                    //AREA DE TEXTO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("AREA_TEXTO")) {
                        if (AgregComp.getOpciones()==null && AgregComp.getUrl()==null) {

                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {
                                String req;
                                String ali;
                                int fila;
                                int col;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (AgregComp.getRequerido()!=null) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getRequerido());
                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                if (AgregComp.getFilas() != -1) {
                                    fila = AgregComp.getFilas();
                                } else {
                                    fila = 5;
                                }
                                if (AgregComp.getColumnas() != -1) {
                                    col = AgregComp.getColumnas();
                                } else {
                                    col = 5;
                                }
                                System.out.println(AgregComp.getFilas());
                                System.out.println(AgregComp.getColumnas());
                                Comp_Crear.add(AgregComp);
                                AreaTextoH area = new AreaTextoH(AgregComp.getTextoVisible(), AgregComp.getFormulario(), AgregComp.getId(), fila + "", col + "", req, ali, AgregComp.getNombreCampo());

                            } else {
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR AREA TEXTO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR AREA TEXTO\'");
                        }
                    } 
                    ////////CHECKBOX HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("CHECKBOX")) {
                        if (AgregComp.getUrl()==null && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()!=null) {
                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {

                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
                                System.out.println(AgregComp.getOpciones());
                                if (!AgregComp.getRequerido().equals(null)) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getRequerido());

                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                CheckBoxH ch = new CheckBoxH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);
                            } else {
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR CHECKBOX\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR CHECKBOX\'");
                        }
                    } 
                    ////////RADIO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("RADIO")) {
                        if (AgregComp.getUrl()==null && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()!=null) {
                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
                                System.out.println(AgregComp.getOpciones());
                                if (AgregComp.getRequerido()!=null) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getRequerido());

                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                RadioH rd = new RadioH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR RADIO BUTTON\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");

                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR RADIO BUTTON\'");
                        }
                    } 
                    ////////COMBO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("COMBO")) {
                        if (AgregComp.getUrl()==null && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()!=null) {
                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
                                System.out.println(AgregComp.getOpciones());
                                if (AgregComp.getRequerido()!=null) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getRequerido());

                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                ComboH cmb = new ComboH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                System.out.println("NO SE DEFINIO UN PARAMETRO OBLIGATORIO");
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR COMBOBOX\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            System.out.println("SE DEFINIO UN PARAMETRO DE MAS");
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR COMBOBOX\'");
                        }
                    } 
                    ////////FICHERO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("FICHERO")) {
                        if (AgregComp.getUrl()==null && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()==null) {
                            if (AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getNombreCampo()!=null && AgregComp.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
                                if (AgregComp.getRequerido()!=null) {
                                    req = AgregComp.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(AgregComp.getRequerido());

                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                FicheroH fich = new FicheroH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), req, ali);

                            } else {
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR FICHERO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR FICHERO\'");
                        }
                    }
                    
                    
                    
                    ////////IMAGEN HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("IMAGEN")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()==null&& AgregComp.getNombreCampo()==null&&AgregComp.getRequerido()==null) {
                            if (AgregComp.getUrl()!=null && AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getFormulario()!=null) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                ImagenH img = new ImagenH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getUrl());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR IMAGEN\'\n (TEXTOVISIBLE, ID, URL, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR IMAGEN\'");
                        }
                    }
                    ////////BOTON HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("BOTON")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones()==null&& AgregComp.getNombreCampo()==null&&AgregComp.getRequerido()==null) {
                            if (AgregComp.getUrl()==null && AgregComp.getTextoVisible()!=null && AgregComp.getId()!=null && AgregComp.getFormulario()!=null) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (AgregComp.getAlineacion()!=null) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = "Blue";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                Comp_Crear.add(AgregComp);
                                BotonH btn = new BotonH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), ali,"Blue");

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'AGREGAR BOTON\'\n (TEXTOVISIBLE, ID, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE BOTON
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'AGREGAR BOTON\'");
                        }
                    }

                } else {
                    lstErrSementico.add("NO SE DEFINIO LA CLASE DEL COMPONENTE A AGREGAR");
                    //NO SE DEFINIO LA CLASE ERRORRRR
                }

            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////MODIFICAR COMPONENTE////////////////////////////////////////////////// 
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////// && ModifCom.getIndice()!=-1
            else if (componentes.get(i) instanceof ModificarComponente) {
                ModificarComponente ModifCom = (ModificarComponente) componentes.get(i);

                if (ModifCom.getClase()!=null) {

                    //VERIFICA LA CLASE CAMPO_TEXTO
                    if (ModifCom.getClase().equalsIgnoreCase("CAMPO_TEXTO")) {
                        //HTML crear y verificar si los componentes principales estan vacios
                        if (ModifCom.getOpciones()==null && ModifCom.getUrl()==null && ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1) {

                            if (ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String req;
                                String ali;
                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());
                                System.out.println(ModifCom.getRequerido());
                                if (!ModifCom.getRequerido().equals(null)) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                if (!ModifCom.getAlineacion().equals(null)) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                CampoTextoH cm = new CampoTextoH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getNombreCampo(), ModifCom.getFormulario(), req, ali);
                            } else {
                                //
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR CAMPO TEXTO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }
                        } else {
                            //TRAE MAS COMPONENTES DE LOS PERMITIDOS
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'MODIFICAR CAMPO TEXTO\'");
                        }
                    } 
                    //AREA DE TEXTO HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("AREA_TEXTO")) {
                        if (ModifCom.getOpciones()==null && ModifCom.getUrl()==null) {

                            if ( ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String req;
                                String ali;
                                int fila;
                                int col;
                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());

                                if (ModifCom.getRequerido()!=null) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getRequerido());
                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                if (ModifCom.getFilas() != -1) {
                                    fila = ModifCom.getFilas();
                                } else {
                                    fila = 5;
                                }
                                if (ModifCom.getColumnas() != -1) {
                                    col = ModifCom.getColumnas();
                                } else {
                                    col = 5;
                                }
                                System.out.println(ModifCom.getFilas());
                                System.out.println(ModifCom.getColumnas());
                                AreaTextoH area = new AreaTextoH(ModifCom.getTextoVisible(), ModifCom.getFormulario(), ModifCom.getId(), fila + "", col + "", req, ali, ModifCom.getNombreCampo());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS PRINCIPALES
                                
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR AREA TEXTO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            //SE DEFINIO MAS COMPONENTES OPCIONES Y URL
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR AREA TEXTO\'");
                        }
                    } 
                    ////////CHECKBOX HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("CHECKBOX")) {
                        if (ModifCom.getUrl()==null && ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()!=null) {
                            if ( ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {

                                String ali;
                                String req;

                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());
                                System.out.println(ModifCom.getOpciones());
                                if (ModifCom.getRequerido()!=null) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getRequerido());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());

                                CheckBoxH ch = new CheckBoxH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ModifCom.getNombreCampo(), ModifCom.getOpciones(), req, ali);
                            } else {
                                //LOS PARAMETROS OBLIGATORIOS NO ESTAN COMPLETOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \' MODIFICAR CHECKBOX\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR CHECKBOX\'");
                        }
                    } 
                    ////////RADIO HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("RADIO")) {
                        if (ModifCom.getUrl()==null && ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()!=null) {
                            if ( ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());
                                System.out.println(ModifCom.getOpciones());
                                if (ModifCom.getRequerido()!=null) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getRequerido());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                RadioH rd = new RadioH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ModifCom.getNombreCampo(), ModifCom.getOpciones(), req, ali);

                            } else {
                                //NO SE ESTABLECIRON LOS PARAMETROS OBLIGATORIOS O PRINCIPALES
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR RADIO BUTTON\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR RADIO BUTTON\'");
                        }
                    } 
                    ////////COMBO HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("COMBO")) {
                        if (ModifCom.getUrl()==null && ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()!=null) {
                            if (ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());
                                System.out.println(ModifCom.getOpciones());
                                if (ModifCom.getRequerido()!=null) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getRequerido());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                ComboH cmb = new ComboH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ModifCom.getNombreCampo(), ModifCom.getOpciones(), req, ali);

                            } else {
                                System.out.println("NO SE DEFINIO UN PARAMETRO OBLIGATORIO");
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR COMBOBOX\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }

                        } else {
                            System.out.println("SE DEFINIO UN PARAMETRO DE MAS");
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR COMBOBOX\'");
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////FICHERO HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("FICHERO")) {
                        if (ModifCom.getUrl()==null && ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()==null) {
                            if (ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String ali;
                                String req;

                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());
                                if (ModifCom.getRequerido()!=null) {
                                    req = ModifCom.getRequerido();
                                } else {
                                    req = " ";
                                }
                                System.out.println(ModifCom.getRequerido());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());

                                FicheroH fich = new FicheroH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ModifCom.getNombreCampo(), req, ali);

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR FICHERO\'\n (TEXTOVISIBLE, ID, NOMBRECAMPO, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR FICHERO\'");
                        }
                    }
                    

                    ////////IMAGEN HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("IMAGEN")) {
                        if (ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()==null&& ModifCom.getNombreCampo()==null&&ModifCom.getRequerido()==null) {
                            if (ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String ali;
                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getNombreCampo());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                
                                ImagenH img = new ImagenH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ModifCom.getUrl());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR IMAGEN\'\n (TEXTOVISIBLE, ID, URL, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \' MODIFICAR IMAGEN\'");
                        }
                    }
                    ////////BOTON HTML
                    else if (ModifCom.getClase().trim().equalsIgnoreCase("BOTON")) {
                        if (ModifCom.getFilas() == -1 && ModifCom.getColumnas() == -1 && ModifCom.getOpciones()==null&& ModifCom.getNombreCampo()==null&&ModifCom.getRequerido()==null) {
                            if ( ModifCom.getId()!=null && ModifCom.getFormulario()!=null) {
                                String ali;
                                System.out.println(ModifCom.getId());
                                System.out.println(ModifCom.getTextoVisible());
                                System.out.println(ModifCom.getFormulario());

                                if (ModifCom.getAlineacion()!=null) {
                                    ali = ModifCom.getAlineacion();
                                } else {
                                    ali = "Blue";
                                }
                                System.out.println(ModifCom.getAlineacion());
                                
                                BotonH btn = new BotonH(ModifCom.getTextoVisible(), ModifCom.getId(), ModifCom.getFormulario(), ali,"Blue");

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                                lstErrSementico.add("NO SE AGREGARON PARAMETROS OBLIGATORIOS En \'MODIFICAR BOTON\'\n (TEXTOVISIBLE, ID, FORMULARIO)");
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                            lstErrSementico.add("SE AGREGARON PARAMETROS NO RECONOCIDOS POR \'MODIFICAR BOTON\'");
                        }
                    }

                } else {
                    //NO SE DEFINIO LA CLASE ERRORRRR
                }
            }
        }
    }
    
    public void HayErrores(){

       
        if(lstErrSementico.isEmpty()){
            GeneraArchivos();
            System.out.println("NO HAY----------------------------");
        } else{
            for(int l=0;l <lstErrSementico.size();l++ ){
                System.out.println(lstErrSementico.get(l));
                
            }
        }
    }
    
    public void GeneraArchivos() {
                                                                                                                                                                                //Comp_Crear.add(AgregComp);
        //busca los formularios a CREAR
        //con los componentes que le pertenecen
        for (int i = 0; i < Form_a_Crear.size(); i++) {
            Form_a_Crear.get(i).getId();
            String FORMATO_FINAL = FORMATO_FORM(Form_a_Crear.get(i).getId(), Form_a_Crear.get(i).getTitulo(), Form_a_Crear.get(i).getNombre(), Form_a_Crear.get(i).getTema(), "james", Form_a_Crear.get(i).getFechaCreacion());

            int cantComponentes = 0;
            int cantAgregados = 0;
            for (int j = 0; j < Comp_Crear.size(); j++) {
                if (Comp_Crear.get(j).getFormulario().trim().equals(Form_a_Crear.get(i).getId().trim())) {
                    cantComponentes++;
                }
            }
            
            for (int j = 0; j < Comp_Crear.size(); j++) {
                
                if (Comp_Crear.get(j).getFormulario().trim().equals(Form_a_Crear.get(i).getId().trim())) {
                    cantAgregados++;
                    FORMATO_FINAL += "\n{";
                    int C = CantNulos(j);
                    int cc=0;
                    //cuenta los nulos

                    if(Comp_Crear.get(j).getId()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("ID",Comp_Crear.get(j).getId());
                        INFO.add("SE HA AGREGADO EL COMPONENTE: "+Comp_Crear.get(j).getId()+" al FORMULARIO: "+Form_a_Crear.get(i).getId());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }   
                    if(Comp_Crear.get(j).getNombreCampo()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("NOMBRE_CAMPO",Comp_Crear.get(j).getNombreCampo());
                        
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }    
                    if(Comp_Crear.get(j).getClase()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("CLASE",Comp_Crear.get(j).getClase());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    cc++;
                    FORMATO_FINAL+=FORMATO_COMP_P("INDICE",cantAgregados+"");
                    if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    
                    if(Comp_Crear.get(j).getTextoVisible()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("TEXTO_VISIBLE",Comp_Crear.get(j).getTextoVisible());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getAlineacion()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("ALINEACION",Comp_Crear.get(j).getAlineacion());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getRequerido()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("REQUERIDO",Comp_Crear.get(j).getRequerido());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getOpciones()!=null){
                        cc++;
                        System.out.println("EL cc: "+cc);
                        System.out.println("EL C: "+C);
                        FORMATO_FINAL+=FORMATO_COMP_P("OPCIONES",Comp_Crear.get(j).getOpciones());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getFilas()!=-1){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("FILAS",Comp_Crear.get(j).getFilas()+"");
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getColumnas()!=-1){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("COLUMNAS",Comp_Crear.get(j).getColumnas()+"");
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }
                    if(Comp_Crear.get(j).getUrl()!=null){
                        cc++;
                        FORMATO_FINAL+=FORMATO_COMP_P("URL",Comp_Crear.get(j).getUrl());
                        if(cc==C){
                            
                        } else{
                            FORMATO_FINAL+=",\n";
                        }
                    }

                    FORMATO_FINAL += "\n}";
                    if (cantAgregados  == cantComponentes) {
                        
                    } else {
                        FORMATO_FINAL+=",";
                    }
 
                }

            }
            FORMATO_FINAL += " \n )"
                    + " \n }"
                    + "\n )";
                    System.out.println("******************************");
                    
                    
                    //GUARDA LOS DATOS OBTENIDOS DEL FORMULARIO Y COMPONENTES EN UN ARCHIVO .TXT CON EL FORMATO DATO
                    ReadFormSaved rd= new ReadFormSaved(Form_a_Crear.get(i).getId());
                    INFO.add("SE HA CREADO EL FORMULARIO: "+Form_a_Crear.get(i).getId());
                    rd.GuardarArchivo(Form_a_Crear.get(i).getId(), FORMATO_FINAL);
                    
            
            
        }
       
       //busca Agregar Componentes
       
       //CREA LOS USUARIOS
       
}
    
    public String FORMATO_FORM(String id, String titulo, String nombre, String tema, String user, String fecha){
        String formato="db.formularios(\n" +
    "  \n { \n \n" +
    "    \"ID_FORMULARIO\": \""+id+"\",  \n" +
    "    \"TITULO\": \""+titulo+"\",\n" +
    "    \"NOMBRE\": \""+nombre+"\",\n" +
    "    \"TEMA\": \""+tema+"\",\n" +
    "    \"USUARIO_CREACION\": \""+user+"\",\n" +
    "    \"FECHA_CREACION\":\""+fecha+"\"\n"+ 
    "      \"ESTRUCTURA\":\n (\n";
        return formato;
    }
    public String FORMATO_COMP_P(String N,String val){
        String form="\""+N+"\": "+"\""+val+"\"";
        return form;
    }
    
    public int CantNulos(int j){
        int c=0;
                            for (int k = 0; k <= 0; k++) {
                                c++;
                        if (Comp_Crear.get(j).getId() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getNombreCampo() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getClase() != null) {
                            c++;
                        }

                        if (Comp_Crear.get(j).getTextoVisible() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getAlineacion() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getRequerido() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getOpciones() != null) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getFilas() != -1) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getColumnas() != -1) {
                            c++;
                        }
                        if (Comp_Crear.get(j).getUrl() != null) {
                            c++;
                        }
                    }
                            return c;
    }
    
//    public void guardarUsuarios(){
//        ArrayList<CrearUsuario> us = new ArrayList<CrearUsuario>();
//        ArrayList<String> lstIDusuarioG = new ArrayList<String>();
//        ArrayList<CrearUsuario> listaFinal = new ArrayList<CrearUsuario>();
//        String formato="";
//        
//        ReadFormSaved lec= new ReadFormSaved("");
//        //lec.guardaUserObjt(user_Crear);
//        
//        us=lec.leerUserobj();
//        //obtengo ID de usuarios registrados
//        for(int i=0;i<us.size();i++){
//            lstIDusuarioG.add(us.get(i).getUsuario());
//        }
//        //obtengo ID de usuarios a crear
//        for(int i=0;i<user_Crear.size();i++){
//            //si los ids de los usuarios guardados coincide con los ids nuevos no se crea el usuaio
//            if(lstIDusuarioG.contains(user_Crear.get(i).getUsuario())){
//                lstErrSementico.add("Error al crear un Nuevo Usuario-- "+user_Crear.get(i).getUsuario()+" \" YA EXISTE UN USUARIO REGISTRADO CON EL MISMO ID\"");
//            }else{
//                us.add(user_Crear.get(i));
//                INFO.add("SE HA AGREGADO EL USUARIO CON ID: "+us.get(i).getUsuario());
//            }   
//        }
//        lec.guardaUserObjt(us);
//        
//        
//    }
//    public void eliminarUsuarios(){
//        
//        ArrayList<CrearUsuario> us = new ArrayList<CrearUsuario>();
//        ArrayList<String> lstIDusuarioG = new ArrayList<String>();
//        ArrayList<CrearUsuario> listaFinal = new ArrayList<CrearUsuario>();
////        String formato="";
//        //user_Delete
//        ReadFormSaved lec= new ReadFormSaved("");
//
//        
//        us=lec.leerUserobj();
//        //obtengo ID de usuarios registrados
//        for(int i=0;i<us.size();i++){
//            lstIDusuarioG.add(us.get(i).getUsuario());
//        }
//        //obtengo ID de usuarios a crear
//        for(int i=0;i<user_Delete.size();i++){
//            
//            for(int j=0;j<us.size();j++){
//                if(user_Delete.get(i).getUsuario().equals(us.get(j).getUsuario())){
//                    INFO.add("SE HA ELIMINADO EL USUARIO CON ID: "+us.get(j).getUsuario());
//                    System.out.println("SE HA ELIMINADO EL USUARIO CON ID: "+us.get(j).getUsuario());
//                } else{
//                    listaFinal.add(us.get(j));
//                }
//            }
//  
//        }
//        lec.guardaUserObjt(listaFinal);
//        
//        
//    }
    
    
//    public void modificarUsuarios(){
//        try{
//        ArrayList<CrearUsuario> us = new ArrayList<CrearUsuario>();
//        ArrayList<String> lstIDusuarioG = new ArrayList<String>();
//        ArrayList<CrearUsuario> listaFinal = new ArrayList<CrearUsuario>();
//        String formato="";
//            
//        ReadFormSaved lec= new ReadFormSaved("");
//        us=lec.leerUserobj();
//        
//        //obtengo ID de usuarios registrados
//        for(int i=0;i<us.size();i++){
//            lstIDusuarioG.add(us.get(i).getUsuario());
//        }
//        System.out.println("    PASA FOR 1");
//        //obtengo ID de usuarios a modificar
//        for (int i = 0; i < user_Modif.size(); i++) {
//            System.out.println("    ENTRA FOR 2");
//            for (int j = 0; j < us.size(); j++) {
//                System.out.println("CANTIDAD DE US.SIZE:  "+us.size());
//                System.out.println("    PASA FOR 3");
//                if (us.get(j).getUsuario().equals(user_Modif.get(i).getUsuarioAnt().trim()) && !lstIDusuarioG.contains(user_Modif.get(i).getUsuarioNue().trim())) {
//                    us.get(j).setPassword(user_Modif.get(i).getNuevoPass());
//                    us.get(j).setUsuario(user_Modif.get(i).getUsuarioNue());
//                    us.get(j).setFechaModif(timeStamp);
//                    INFO.add("SE HA MODIFICADO EL USUARIO CON ID: " + us.get(i).getUsuario());
//                } else {
//                    //us.add(user_Crear.get(i));
//                    INFO.add("NO SE MODIFICO EL USUARIO CON ID: " + us.get(i).getUsuario());
//                    INFO.add("1) EL USUARIO ACTUAL NO COINCIDE CON EL USUARIO ANTIGUO O 2) EL NUEVO USUARIO YA ESTA EN USO");
//                }
//            }
//            
//
//        }
//        System.out.println("   GUARDA");
//        lec.guardaUserObjt(us);
//        } catch(Exception e){
//            System.out.println("error en MODIFICAR USUARIOS" +e);
//        }
//    }
    public void eliminarFormularios(){
        
        for(int i=0;i<form_Delete.size();i++){
            ReadFormSaved eliminar= new ReadFormSaved("");
            INFO.add(eliminar.eliminarFicheroForm(form_Delete.get(i).getId().trim()));
                    
        }
        
    }
    
    public void GenerarDocUsuario(){
        String FormatoUsuario="";
        int CantidadUsuarios=user_Crear.size();
        int tot=0;
        ReadFormSaved rd= new ReadFormSaved("");
        FormatoUsuario+=rd.buscarUsuarios();
        
        if (user_Crear.size() > 0) {
            FormatoUsuario += ",\n";

            for (int i = 0; i < user_Crear.size(); i++) {
                
                tot++;
                if (tot != CantidadUsuarios) {
                    INFO.add("USUARIO CREADO EXITOSAMENTE: "+user_Crear.get(i).getUsuario());
                    FormatoUsuario += "{ "
                            + "\"USUARIO\": \""+user_Crear.get(i).getUsuario()+"\",\n"
                            + "\"PASSWORD\":\""+user_Crear.get(i).getPassword()+"\",\n"
                            + "\"FECHA_CREACION\":\""+user_Crear.get(i).getFechaCreacion()+"\"  \n"
                            + "} ,\n";
                } else {
                    INFO.add("USUARIO CREADO EXITOSAMENTE: "+user_Crear.get(i).getUsuario());
                    FormatoUsuario += "{ "
                            + "\"USUARIO\": \"" +user_Crear.get(i).getUsuario()+"\",\n"
                            + "\"PASSWORD\":\"" +user_Crear.get(i).getPassword()+"\",\n"
                            + "\"FECHA_CREACION\":\""+user_Crear.get(i).getFechaCreacion()+"\"\n"
                            + "} \n";
                } 
            }
        }
        rd.GuardarArchivoUsuario("USUARIO", FormatoUsuario);
    }
    
    public void EliminarUser(){
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
        recu(lst);
        
        
       

        
        GenerarDocUsuarioE(lst);
        } catch (Exception ex) {
            Logger.getLogger(Verificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public void recu(ArrayList<CrearUsuario> lst){
        ArrayList<CrearUsuario> lst2;
        for (int i = 0; i < lst.size(); i++) {
            lst.get(i).setFechaCreacion(timeStamp);
            for(int j=0;j<user_Delete.size();j++){
                String a=lst.get(i).getUsuario();
                String b=user_Delete.get(j).getUsuario();
//                System.out.println(" COMPERA CON "+lst.get(i).getUsuario());
//                System.out.print(" COMPERA CON "+user_Delete.get(j).getUsuario());
                if (a.equals(b)){
                    INFO.add("USUARIO ELIMINADO EXITOSAMENTE: "+a);
                    lst.remove(i);
                    user_Delete.remove(j);
                    lst2=lst;
                    INFO.add("SE HA ELIMINADO EL USUARIO: "+a);
                    recu(lst2);
                    
                }else{
                    
                }
            }
        }
        
    }
    public void ModifUser(){
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
        recu2(lst);
        
        
       
        GenerarDocUsuarioE(lst);
        
        
        } catch (Exception ex) {
            Logger.getLogger(Verificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void recu2(ArrayList<CrearUsuario> lst){
        ArrayList<CrearUsuario> lst2;
        for (int i = 0; i < lst.size(); i++) {
            lst.get(i).setFechaCreacion(timeStamp);
            for(int j=0;j<user_Modif.size();j++){
                String a=lst.get(i).getUsuario();
                String b=user_Modif.get(j).getUsuarioAnt();
                System.out.println("A: "+a+" B: "+b);
                if (a.equals(b)){
                    lst.get(i).setPassword(user_Modif.get(j).getNuevoPass());
                    lst.get(i).setUsuario(user_Modif.get(j).getUsuarioNue());
                    user_Modif.remove(j);
                    lst2=lst;
                    INFO.add("SE HA MODIFICADO EL USUARIO: "+a+" POR "+user_Modif.get(j).getUsuarioNue());
                    recu2(lst2);
                    
                }else{
                    
                }
            }
        } 
    }
    
    public void GenerarDocUsuarioE(ArrayList<CrearUsuario> lst){
        String FormatoUsuario1="";
        int CantidadUsuarios=lst.size();
        int tot=0;
        ReadFormSaved rd= new ReadFormSaved("");
        //FormatoUsuario1+=rd.buscarUsuarios();
        
        if (lst.size() > 0) {
            //FormatoUsuario1 += ",\n";
            FormatoUsuario1=" ";
            for (int i = 0; i < lst.size(); i++) {
                
                tot++;
                if (tot != CantidadUsuarios) {
                    FormatoUsuario1 += "{ "
                            + "\"USUARIO\": \""+lst.get(i).getUsuario()+"\",\n"
                            + "\"PASSWORD\":\""+lst.get(i).getPassword()+"\",\n"
                            + "\"FECHA_CREACION\":\""+lst.get(i).getFechaCreacion()+"\"\n"
                            + "} ,\n";
                } else {
                    FormatoUsuario1 += "{ "
                            + "\"USUARIO\": \"" +lst.get(i).getUsuario()+"\",\n"
                            + "\"PASSWORD\":\"" +lst.get(i).getPassword()+"\",\n"
                            + "\"FECHA_CREACION\":\""+lst.get(i).getFechaCreacion()+"\"\n"
                            + "} \n";
                } 
            }
        }
        rd.GuardarArchivoUsuario("USUARIO", FormatoUsuario1);
    }
    public boolean loginUsuario(){
        boolean bandera=false;
        
        
        
        
        
        return bandera;
    } 

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public ArrayList<String> getLstErrSementico() {
        return lstErrSementico;
    }

    public void setLstErrSementico(ArrayList<String> lstErrSementico) {
        this.lstErrSementico = lstErrSementico;
    }

    public ArrayList<String> getINFO() {
        return INFO;
    }

    public void setINFO(ArrayList<String> INFO) {
        this.INFO = INFO;
    }
    
    
}
