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
                System.out.println(crearU.getUsuario());
                System.out.println(crearU.getPassword());
            }
            //MODIFICAR USUARIO
            if (usuarios.get(i) instanceof ModificarUsuario) {
                ModificarUsuario modif = (ModificarUsuario) usuarios.get(i);
                System.out.println(modif.getUsuarioAnt());
                System.out.println(modif.getUsuarioNue());
                System.out.println("NUEVO PASS"+modif.getNuevoPass());
                if (modif.getFechaModif().isEmpty() | modif.getFechaModif() == null) {
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    modif.setFechaModif(timeStamp);
                    System.out.println("fecha"+modif.getFechaModif());
                }
                System.out.println("New Pass"+modif.getNuevoPass());
            }
            if (usuarios.get(i) instanceof EliminarUsuario) {
                EliminarUsuario elimU = (EliminarUsuario) usuarios.get(i);
                System.out.println(elimU.getUsuario());
            }
        }
    }

    public void AnalisisFormularios() {

        for (int i = 0; i < formularios.size(); i++) {
            if (formularios.get(i) instanceof NuevoForm) {
                NuevoForm newF = (NuevoForm) formularios.get(i);
                System.out.println(newF.getId());
                System.out.println(newF.getTitulo());
                System.out.println(newF.getNombre());
                System.out.println(newF.getTema());

                if (newF.getUsuarioCreacion().isEmpty() | newF.getUsuarioCreacion() == null) {
                    newF.setUsuarioCreacion(usuarioLogueado);
                }
                System.out.println(newF.getUsuarioCreacion());

                if (newF.getFechaCreacion().isEmpty() | newF.getFechaCreacion() == null) {
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    newF.setFechaCreacion(timeStamp);
                }
                System.out.println(newF.getFechaCreacion());
            }

            if (formularios.get(i) instanceof EliminarForm) {
                EliminarForm elimForm = (EliminarForm) formularios.get(i);
                System.out.println(elimForm.getId());

            }

            if (formularios.get(i) instanceof ModificarForm) {
                ModificarForm modif = (ModificarForm) formularios.get(i);
                System.out.println(modif.getId());
                System.out.println(modif.getTitulo());
                System.out.println(modif.getNombre());
                System.out.println(modif.getTema());
            }
        }
    }

    public void AnalisisComponentes() {
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i) instanceof AgregarComponente) {
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
