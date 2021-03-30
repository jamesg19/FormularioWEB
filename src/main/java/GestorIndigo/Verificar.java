/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorIndigo;

import ComponentesIndigo.*;
import FormSolicitudIndigo.*;
import UsuarioIndigo.*;
import ComponentesHTML.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author James
 */
public class Verificar {

    ArrayList<Usuario> usuarios;
    ArrayList<Formulario> formularios;
    ArrayList<Componente> componentes;
    String usuarioLogueado;
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
                if(!crearU.getUsuario().equals(null)&& !crearU.getPassword().equals(null)){
                    System.out.println(crearU.getUsuario());
                    System.out.println(crearU.getPassword());
                }else{
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

                } else {
                    //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                    System.out.println(" NO SE ESTABLECIERON PARAMETROS OBLIGATORIOS");
                }
            }
            
            
            else if (usuarios.get(i) instanceof EliminarUsuario) {
                EliminarUsuario elimU = (EliminarUsuario) usuarios.get(i);
                System.out.println(elimU.getUsuario());
            }
        }
    }

    public void AnalisisFormularios() {

        for (int i = 0; i < formularios.size(); i++) {
            if (formularios.get(i) instanceof NuevoForm) {
                NuevoForm nForm = (NuevoForm) formularios.get(i);
                if(nForm.getId()!=null && nForm.getTitulo()!=null &&nForm.getNombre()!=null &&nForm.getTema()!=null){
                  //NuevoForm newF = (NuevoForm) formularios.get(i);
                System.out.println(nForm.getId());
                System.out.println(nForm.getTitulo());
                System.out.println(nForm.getNombre());
                System.out.println(nForm.getTema());

                if (nForm.getUsuarioCreacion() == null) {
                    nForm.setUsuarioCreacion(usuarioLogueado);
                }
                System.out.println(nForm.getUsuarioCreacion());

                if (nForm.getFechaCreacion() == null) {
                    //String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    nForm.setFechaCreacion("Fe P:"+timeStamp);
                }else{
                    System.out.println(nForm.getFechaCreacion());
                }
                    
                    
                }
                
                
            }


            else if (formularios.get(i) instanceof EliminarForm) {
                EliminarForm elimForm = (EliminarForm) formularios.get(i);
                System.out.println(elimForm.getId());

            }

            
            
            
            else if (formularios.get(i) instanceof ModificarForm) {
                ModificarForm modif = (ModificarForm) formularios.get(i);
                if(modif.getId()!=null && modif.getTitulo()!=null &&modif.getNombre()!=null &&modif.getTema()!=null){
                
                System.out.println(modif.getId());
                System.out.println(modif.getTitulo());
                System.out.println(modif.getNombre());
                System.out.println(modif.getTema());
                }else{
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
                                CampoTextoH cm = new CampoTextoH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getNombreCampo(), AgregComp.getFormulario(), req, ali);
                            } else {
                                //
                            }
                        } else {
                            //TRAE MAS COMPONENTES DE LOS PERMITIDOS
                        }
                    } 
                    //AREA DE TEXTO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("AREA_TEXTO")) {
                        if (AgregComp.getOpciones().equals(null) && AgregComp.getUrl().equals(null)) {

                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String req;
                                String ali;
                                int fila;
                                int col;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

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
                                AreaTextoH area = new AreaTextoH(AgregComp.getTextoVisible(), AgregComp.getFormulario(), AgregComp.getId(), fila + "", col + "", req, ali, AgregComp.getNombreCampo());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS PRINCIPALES
                            }

                        } else {
                            //SE DEFINIO MAS COMPONENTES OPCIONES Y URL
                        }
                    } 
                    ////////CHECKBOX HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("CHECKBOX")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && !AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {

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

                                CheckBoxH ch = new CheckBoxH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);
                            } else {
                                //LOS PARAMETROS OBLIGATORIOS NO ESTAN COMPLETOS
                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////RADIO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("RADIO")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && !AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
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
                                RadioH rd = new RadioH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                //NO SE ESTABLECIRON LOS PARAMETROS OBLIGATORIOS O PRINCIPALES

                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////COMBO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("COMBO")) {
                        System.out.println("S "+AgregComp.getId());
                                System.out.println("S "+AgregComp.getNombreCampo());
                                System.out.println("S "+AgregComp.getTextoVisible());
                                System.out.println("S "+AgregComp.getFormulario());
                                System.out.println("S "+AgregComp.getOpciones());
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
                                ComboH cmb = new ComboH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                System.out.println("NO SE DEFINIO UN PARAMETRO OBLIGATORIO");
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                            }

                        } else {
                            System.out.println("SE DEFINIO UN PARAMETRO DE MAS");
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////FICHERO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("FICHERO")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
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

                                FicheroH fich = new FicheroH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), req, ali);

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    }
                    
                    
                    
                    ////////IMAGEN HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("IMAGEN")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)&& AgregComp.getNombreCampo().equals(null)&&AgregComp.getRequerido().equals(null)) {
                            if (!AgregComp.getUrl().equals(null) && !AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                
                                ImagenH img = new ImagenH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getUrl());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                        }
                    }
                    ////////BOTON HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("BOTON")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)&& AgregComp.getNombreCampo().equals(null)&&AgregComp.getRequerido().equals(null)) {
                            if (AgregComp.getUrl().equals(null) && !AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = "Blue";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                
                                BotonH btn = new BotonH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), ali,"Blue");

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                        }
                    }

                } else {
                    //NO SE DEFINIO LA CLASE ERRORRRR
                }

            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////MODIFICAR COMPONENTE////////////////////////////////////////////////// 
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////// 
            else if (componentes.get(i) instanceof ModificarComponente){
                AgregarComponente AgregComp = (AgregarComponente) componentes.get(i);

                if (!AgregComp.getClase().equals(null)) {

                    //VERIFICA LA CLASE CAMPO_TEXTO
                    if (AgregComp.getClase().trim().equalsIgnoreCase("CAMPO_TEXTO")) {
                        //HTML crear y verificar si los componentes principales estan vacios
                        if (AgregComp.getOpciones().equals(null) && AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1) {

                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
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
                                CampoTextoH cm = new CampoTextoH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getNombreCampo(), AgregComp.getFormulario(), req, ali);
                            } else {
                                //
                            }
                        } else {
                            //TRAE MAS COMPONENTES DE LOS PERMITIDOS
                        }
                    } 
                    //AREA DE TEXTO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("AREA_TEXTO")) {
                        if (AgregComp.getOpciones().equals(null) && AgregComp.getUrl().equals(null)) {

                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String req;
                                String ali;
                                int fila;
                                int col;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

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
                                AreaTextoH area = new AreaTextoH(AgregComp.getTextoVisible(), AgregComp.getFormulario(), AgregComp.getId(), fila + "", col + "", req, ali, AgregComp.getNombreCampo());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS PRINCIPALES
                            }

                        } else {
                            //SE DEFINIO MAS COMPONENTES OPCIONES Y URL
                        }
                    } 
                    ////////CHECKBOX HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("CHECKBOX")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && !AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {

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

                                CheckBoxH ch = new CheckBoxH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);
                            } else {
                                //LOS PARAMETROS OBLIGATORIOS NO ESTAN COMPLETOS
                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////RADIO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("RADIO")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && !AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
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
                                RadioH rd = new RadioH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                //NO SE ESTABLECIRON LOS PARAMETROS OBLIGATORIOS O PRINCIPALES

                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////COMBO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("COMBO")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && !AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
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
                                ComboH cmb = new ComboH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), AgregComp.getOpciones(), req, ali);

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                            }

                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    } 
                    ////////FICHERO HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("FICHERO")) {
                        if (AgregComp.getUrl().equals(null) && AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)) {
                            if (!AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getNombreCampo().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                String req;

                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());
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

                                FicheroH fich = new FicheroH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getNombreCampo(), req, ali);

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO INCORRECTO
                        }
                    }
                    
                    
                    
                    ////////IMAGEN HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("IMAGEN")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)&& AgregComp.getNombreCampo().equals(null)&&AgregComp.getRequerido().equals(null)) {
                            if (!AgregComp.getUrl().equals(null) && !AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getNombreCampo());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = " ";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                
                                ImagenH img = new ImagenH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), AgregComp.getUrl());

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                        }
                    }
                    ////////BOTON HTML
                    else if (AgregComp.getClase().trim().equalsIgnoreCase("BOTON")) {
                        if (AgregComp.getFilas() == -1 && AgregComp.getColumnas() == -1 && AgregComp.getOpciones().equals(null)&& AgregComp.getNombreCampo().equals(null)&&AgregComp.getRequerido().equals(null)) {
                            if (AgregComp.getUrl().equals(null) && !AgregComp.getTextoVisible().equals(null) && !AgregComp.getId().equals(null) && !AgregComp.getFormulario().equals(null)) {
                                String ali;
                                System.out.println(AgregComp.getId());
                                System.out.println(AgregComp.getTextoVisible());
                                System.out.println(AgregComp.getFormulario());

                                if (!AgregComp.getAlineacion().equals(null)) {
                                    ali = AgregComp.getAlineacion();
                                } else {
                                    ali = "Blue";
                                }
                                System.out.println(AgregComp.getAlineacion());
                                
                                BotonH btn = new BotonH(AgregComp.getTextoVisible(), AgregComp.getId(), AgregComp.getFormulario(), ali,"Blue");

                            } else {
                                //NO SE ESTABLECIERON LOS PARAMETROS OBLIOGATORIOS
                            }
                        } else {
                            //SE DEFINIO UN PARAMETRO QUE NO PERTENECE A LA CLASE IMAGEN
                        }
                    }

                } else {
                    //NO SE DEFINIO LA CLASE ERRORRRR
                }

            }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            

        }
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

}
