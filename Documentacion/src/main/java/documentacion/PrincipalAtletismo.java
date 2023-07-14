package documentacion;
import java.util.ArrayList;
//import Interfaces.MenuPrincipalPantalla.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Este es la clase main donde se van a crear y llamar las funciones necesarias para el proyecto de atletismo
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class PrincipalAtletismo {
    
    public final static PrincipalAtletismo claseMain = new PrincipalAtletismo();
    
    private Configuracion configuracion;
    
    private static ArrayList<Atleta> listaAtletas;
    private static ArrayList<Competencia> listaCompetencias;
    private static ArrayList<Disciplina> listaDisciplinas;
    private static ArrayList<VisorAtleta> listaVisorAtletas;
    
    public static int cantidadCompetencias;    
    
    /**
     * Metodo constructor de la clase principal, va a almacenar o crear varias listas necesarias
     */
    public PrincipalAtletismo(){
        
        configuracion = new Configuracion();
        listaAtletas = new ArrayList();
        listaCompetencias = new ArrayList();
        listaDisciplinas = new ArrayList();
        listaVisorAtletas = new ArrayList();
    }
    /**
     * Metodo Principal donde se crea la pantalla/interfaz del programa
     * @param args 
     */
    public static void main(String args[]){
        
        //MenuPrincipal pantalla = new MenuPrincipal();
        //pantalla.setVisible(true);
        
    } 
    // -----------------------------------------------------------------------------------------------------------------
    
    // ------------------------------------ MÉTODOS PARA COMPETENCIAS --------------------------------------------------
    
    /**
     * Método para agregar/crear una competencia a la lista de competencia
     * @param pNombre nombre de la competencia
     * @param pPais pais de la competencia
     * @param pLugar lugar de la competencia
     * @param pFechaInicial fecha inicial de la competencia
     * @param pFechaFinal fecha final de la competencia
     * @return null en caso de no recibir bien los valores
     */
    public String setCompetencia(String pNombre, String pPais, String pLugar,String pFechaInicial, String pFechaFinal)
    {
        
        if(pNombre.length() < 5 || pNombre.length() > 60){
            
            return "El nombre debe tener entre 5 y 50 caracteres";
        }
    
        if(pLugar.length() < 5 || pLugar.length() > 60){
            
            return "El lugar debe tener entre 5 y 50 caracteres";
        }
        
        switch(pNombre){
            
            case "Costa Rica": 
                
                pNombre = "CRI " + pNombre;
                break;
            
            case "Mexico": 
                
                pNombre = "MEX " + pNombre;
                break;
               
            case "España": 
                
                pNombre = "ESP" + pNombre;
                break;
               
            case "Nicaragua": 
                
                pNombre = "NIC " + pNombre; 
                
        }
        
        String id = "" + (configuracion.getCompetencias() + 1);
        configuracion.actualizarCompetencia();
        Competencia competencia = new Competencia(pNombre, pPais, pLugar, id, pFechaInicial, pFechaFinal);    
        cantidadCompetencias ++;
        listaCompetencias.add(competencia);
        
        return null;
        
    }
    
    /**
     * Método para agregar/crear una prueba a una Competencia
     * @param pNombrePrueba nombre de la prueba
     * @param pMedicion tipo de medicion de la prueba
     * @param pCategoria tipo de categoria de la prueba
     * @param pGenero genero/sexo de la prueba
     * @param pCompetencia la competencia donde se va a guardar/ en que tipo de compentencia se almacena
     */
    public void setPruebaCompetencia(String pNombrePrueba, String pMedicion, String pCategoria, 
            String pGenero, String pCompetencia){
        
          for(Competencia competencia: listaCompetencias){
                    
            if(competencia.getNombre().equals(pCompetencia)){
                        
                Prueba prueba = new Prueba(pNombrePrueba, pMedicion);
                competencia.setPrueba(prueba);
                prueba.setCompetencia(competencia);
              
            }
        }
    }
    
    /**
     * Metodo para agregar un atleta a una competencia
     * @param pIdAtleta identificacion del atleta
     * @param pPrueba nombre de la prueba
     * @param pCompetencia nombre de la prueba
     */
    public void setAtletaCompetenciaPrueba(String pIdAtleta, String pPrueba, String pCompetencia){
        
        for(Atleta atleta: listaAtletas){
           
            if(atleta.getId().equals(pIdAtleta)){
                
                for(Competencia competencia: listaCompetencias){
                    
                    if(competencia.getNombre().equals(pCompetencia)){
                        
                        int dorsal = competencia.getCantidadAtletas();
                        dorsal ++;
                        atleta.setCompetencia(pCompetencia, dorsal);
                        competencia.setAtletaPrueba(pPrueba, atleta);
                        
                    }
                }
            }
        }
    }
  
    /**
     * Metodo que elimina una prueba de una competencia 
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @return retorna null en caso de no recibir bien los valores o que no se encuentra la competencia
     */
    public String deletePruebaCompetencia(String pCompetencia, String pPrueba){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                if(competencia.deletePruebaCompetencia(pPrueba) == false){
                    
                    return "Esta prueba no se encuentra en la competencia";
                }
            }
        }
        return null;
    }
    
    /**
     * Método que elimina un atleta de una competencia
     * @param pAtleta nombre del atleta
     * @param pCompetencia nombre de la competencia 
     * @return retorna null en caso de no recibir bien los valores o que no se encuentra el atleta
     */
    public String deleteAtletaCompetencia(String pAtleta, String pCompetencia){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                if(competencia.deleteAtletaCompetencia(pAtleta) == false){
                    
                    return "Este atleta no se encuentra en esta competencia";
                }
 
            }
        }
           
        return null;
    }
    
    /**
     * Método que elimina una competencia de la lista de competencias
     * @param pCompetencia nombre de la competencia
     * @return retorna null en caso de no recibir bien los valores o que si fue eliminado
     */
    public String deleteCompetencia(String pCompetencia){
        
        int indice = 0;
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                competencia = null;
                listaCompetencias.remove(indice);
                return "si";
                
            }
            
            indice ++;
        }
        
        return null;
    }

    /**
     *  Método para modificar los datos de una competencia, modifica los datos en los cuales los parametros son diferente de null
     * @param pNombre nombre de la competencia
     * @param pLugar lugar nuevo de la competencia
     * @param pPais pais nuevo de la competencia
     * @param pFechaI fecha inicial de la competencia
     * @param pFechaF fecha final de la competencia
     * @return null en caso de no recibir bien el valor del nombre
     */
    public String modificarCompetencia(String pNombre, String pLugar,String pPais,
            String pFechaI, String pFechaF){
        
        String mensaje = null;
        
        for(Competencia competencia: listaCompetencias){
            
                if(pNombre != null){
                    
                    if(pNombre.length() <= 60 && pNombre.length()>= 5){
                    
                        competencia.setNombre(pNombre);
                    }
                    else{
                        
                        mensaje += "- El nombre de la competencia debe estar entre 5 y 60 caracteres";
                    }
                }
                                
                if(pLugar != null){
                    
                    if(pLugar.length() <= 60 && pLugar.length() >= 5){
                    
                        competencia.setLugar(pLugar);
                        
                    }
                    else{
                        
                        mensaje += "- El nombre del lugar debe estar entre 5 y 60 caracteres";
                    
                    }
                      
                }
                
                if(pPais != null){
                    
                    competencia.setPais(pPais);
                }
            }
                       
        return null;
    }
    
    /**
     * Método para modificar una prueba de una competencia
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @param pNuevoNombre nuevo nombre de la prueba
     * @return null en caso de no recibir bien el valor del nombre
     */
    public String modificarPruebaCompetencia(String pCompetencia, String pPrueba, String pNuevoNombre){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getId().equals(pCompetencia)){
                
                ArrayList<Prueba> listaPruebas = competencia.getPruebas();
                
                for(Prueba prueba: listaPruebas){
                    
                    if(prueba.getNombre().equals(pNuevoNombre)){
                        
                        return "Ya existe una prueba con este nombre en esta competencia";
                    }
                }
                
                for(Prueba prueba: listaPruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        prueba.setNombre(pNuevoNombre);
                    }
                }
            }
        }
        
        return null;
    }
    
    /**
     * Métododo que valida si existe una competencia, recibe el nombre de la competencia
     * @param pNombre nombre de la competencia
     * @return null en caso de no encontrar, o retorna el nombre en caso de si encontrarlo
     */
    public String getCompetencia(String pNombre){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pNombre)){
                
                return competencia.getNombre();
            }
        }
        
        return null;
    }
    
    /**
     * Método que retorna la lista de competencias
     * @return la lista de competencias
     */
    public ArrayList<Competencia> getCompetencias(){

        return listaCompetencias;
    }
    
    /**
     * Método para validar si una prueba está en una competencia
     * @param pCompetencia nombre de la prueba  
     * @param pPrueba nombre de la prueba
     * @return null en caso de no estar, si en caso de si estar
     */
    public String validarCompetenciasPruebas(String pCompetencia, String pPrueba){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                ArrayList<Prueba> listaPruebas = competencia.getPruebas();
                
                for(Prueba prueba: listaPruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        return "si";
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Método para validar si un atleta está en una prueba en una competencia
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @param pAtleta nombre del atleta
     * @return null en caso no estar, si en caso de si estar
     */
    public String validarCompetenciaPruebaAtleta(String pCompetencia, String pPrueba, String pAtleta){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                ArrayList<Prueba> listaPruebas = competencia.getPruebas();
                
                for(Prueba prueba: listaPruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        ArrayList<Atleta> atletas = prueba.getListaAtletas();
                        
                        for(Atleta atleta: atletas){
                            
                            if(atleta.getId().equals(pAtleta)){
                                
                                return "si";
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
        
    // ------------------------------------ MÉTODOS PARA ATLETAS ----------------------------------------------------
    
    /**
     * Método para agregar un atleta a la lista de atletas
     * @param pNombre nombre del atleta
     * @param pApellido1 primer apellido del atleta
     * @param pApellido2 segundo apellido del atleta
     * @param pId identificacion del atleta
     * @param pPais pais del atleta
     * @param pTelefono telefono del atleta
     * @param pEmail email del atleta
     * @param pFecha fecha de nacimiento del atleta
     * @return null en caso de recibir mal los valores
     */
    public String setAtleta(String pNombre, String pApellido1, String pApellido2, String pId, String pPais, 
            String pTelefono, String pEmail, String pFecha){
        
        if(pNombre.length() < 2 || pNombre.length() > 20){
            
            return "El nombre debe contener entre 2 y 20 caracteres ";
        }
        
        if(pApellido1.length() < 2 || pApellido1.length() > 20){
            
            return "El primer apellido debe contener entre 2 y 20 caracteres";
        }
        
        if(pApellido2.length() < 2 || pApellido2.length() > 20){
            
            return "El segundo apellido debe contener entre 2 y 20 caracteres";
        }
        
        if(pId.length() < 9 || pId.length() > 20){
            
            return "La identificación debe contener entre 9 y 20 caracteres";
        }
        
        else{
            
            int indicador = 0;
            
            for(Atleta atleta: listaAtletas){
                
                if(atleta.getId().equals(pId)){
                    
                    indicador ++;
                    break;
                }
            }
            
            if(indicador > 0){
                
                return "La identificación ya existe, no se puede asignar a este atleta";
            }
        }
        
        if(pTelefono.length() != 8){
            
            return "El telefono debe ser de 8 caracteres";
        }
        
        Atleta atleta = new Atleta(pNombre, pApellido1, pApellido2, pId, pPais, pTelefono, pEmail, pFecha);
        listaAtletas.add(atleta);
        
        return null;
        
    }
    
    /**
     * Método para obtener el nombre del atleta de la lista de atletas
     * @param id identificacion del atleta
     * @return null en caso de no encontrarlo, si en caso de encontrarlo
     */
    public String getAtleta(String id){
        
        System.out.println("ENTRA 1");
        for(Atleta atleta: listaAtletas){
            
            if(atleta.getId().equals(id)){
                System.out.println("ESTE ES EL ID " + id + " y " + atleta.getId());
                return "si";
            }
        }
        return null;
    }
    
    /**
     * Método para eliminar un atleta de la lista de atletas
     * @param pId identificacion del atleta
     * @return null en caso de no encontrarlo, si en caso de haberlo eliminado
     */
        public String deleteAtleta(String pId){
        
        int indice = 0;
        
        for(Atleta atleta: listaAtletas){
            
            if(atleta.getId().equals(pId)){
                
                listaAtletas.remove(indice);
                return "si";
            }
            indice ++;
        }
        return null;
    }
    
    /**
     * Método para modificar los datos del atleta, solo modifica los que vengan diferente de null en los parametros
     * @param pId identificacion para encontrar al atleta
     * @param pNombre nuevo nombre
     * @param pPapellido nuevo primer apellido
     * @param pSapellido nuevo segundo apellido
     * @param pPais nuevo pais
     * @param telefono nuevo telefono
     * @param email nuevo email
     * @param fecha nueva fecha de nacimiento
     * @return null en caso de no encontrar al atleta o los valores diferentes de null
     */
    public String modificarAtleta(String pId, String pNombre, String pPapellido, String pSapellido, String pPais,
            String telefono, String email, String fecha){
        
        String mensaje = null;
        
        for(Atleta atleta: listaAtletas){
            
            if(atleta.getId().equals(pId)){
                
                if(pNombre != null){
                    
                    if(pNombre.length() >= 2 && pNombre.length() <= 20){
                        
                        atleta.setNombre(pNombre);
                    }
                    else{
                        
                        mensaje += "-El nombre debe contener entre 2 y 20 caracteres";
                    }
                }
                if(pPapellido != null){
                    
                    if(pPapellido.length() >= 2 && pPapellido.length() <= 20){
                        
                        atleta.setApellido1(pPapellido);
                    }
                    else{
                        
                        mensaje += "-El primer apellido debe contener entre 2 y 20 caracteres";
                    }
                }
                
                if(pSapellido != null){
                    
                    if(pSapellido.length() >= 2 && pSapellido.length() <= 20){
                        
                        atleta.setApellido2(pSapellido);
                    }
                    else{
                        
                        mensaje += "-El segundo apellido debe contener entre 2 y 20 caracteres";
                    }
                }
                
                if(pPais != null){
                    
                    if(pPais.length() == 3){
                        
                        atleta.setPais(pPais);
                    }
                    else{
                        
                        mensaje += "-El pais debe ser de 3 caracteres";
                    }
                }
                
                if(telefono != null){
                    
                    if(telefono.length() != 20){
                        
                        atleta.setTelefono(telefono);
                    }
                    else{
                        
                        mensaje += "-El telefono debe ser de 20 caracteres";
                    }
                }
            }
        }
        
        return null;
    }
    
    /**
     * Método que retorna la lista de atletas
     * @return lista de atletas
     */
    public ArrayList<Atleta> getListaAtletas(){
        
        return listaAtletas;
    }
    
    // ------------------------------------ MÉTODOS PARA DISCIPLINAS ----------------------------------------------------   

    /**
     * Método para agregar una disciplina a la lista de disciplinas 
     * @param pNombre nombre de la disciplina
     * @param pMedicion manera en la que la disciplina va a ser medida (por ejemplo: metros o tiempo)
     * @return null si se realiza bien, en caso de existir ya la disciplina se indica que ya existe
     */
    public String setDisciplina(String pNombre, String pMedicion){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pNombre)){
                
                return "La disciplina ya existe";
            }
        } 
        Disciplina disciplina = new Disciplina(pNombre, pMedicion);
        listaDisciplinas.add(disciplina);
        
        return null;    
    }

    /**
     * Método para agregar una prueba a una disciplina
     * @param pDisciplina nombre de la disciplina
     * @param pPrueba nombre de la prueba
     * @param pMedicion manera en la que la disciplina va a ser medida (por ejemplo: metros o tiempo)
     * @return null en caso de no encontrar los nombres recibidos o ya fue registrada
     */
    public String setPruebaDisciplina(String pDisciplina, String pPrueba, String pMedicion){
        
        for(Disciplina disciplina: listaDisciplinas){
         
            if(disciplina.getNombre().equals(pDisciplina)){
                 
                ArrayList<Prueba> pruebas = disciplina.getPruebas();
                
                for(Prueba prueba: pruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        return "Esta prueba ya está registrada en esta disciplina";
                    }
                }   
                Prueba prueba = new Prueba(pPrueba, pMedicion);
                disciplina.setPrueba(prueba);       
            } 
        }   
        return null;
    }

    /**
     * Método para obtener la lista de las pruebas en una disciplina, 
     * @param pNombre nombre de la disciplina
     * @return null en caso de no encontrar el nombre de la disciplina o retorna el array de las pruebas
     */
    public ArrayList<Prueba> getPruebasDisciplina(String pNombre){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pNombre)){
                
                return disciplina.getPruebas();
            }
        } 
        return null;
    }

    /**
     * Método para eliminar una prueba en una Disciplina
     * @param pPrueba nombre de la prueba
     * @param pDisciplina nombre de la disciplina
     * @return null  aso de no encontrar el nombre de la disciplina o se indica que no existe la prueba
     */
    public String deletePruebaDisciplina(String pPrueba, String pDisciplina){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pDisciplina)){
                
                if(disciplina.recorrerPruebas(pPrueba) == false){
                    
                    return "La prueba no existe en esta disciplina";
                }
            }
        }
        
        return null;
    }
    
    /**
     * Método que elimina una disciplina de la lista de disciplinas
     * @param pDisciplina nombre de la disciplina
     * @return null si fue eliminada, en caso de no estar registrada se indica
     */
    public String deleteDisciplina(String pDisciplina){
        
        int indice = 0;
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pDisciplina)){
                
                listaDisciplinas.remove(indice);
                return null;
            }
        }
        
        return "Esta disciplina no ha sido registrada";
    }
    
    /**
     * Método para modificar el nombre de una disciplina
     * @param pDisciplina nombre de la disciplina
     * @param pNuevoNombre nuevo nombre de la disciplina
     * @return null si fue modificada, en caso de no estar registrada se indica
     */
    public String modificarDisciplina(String pDisciplina, String pNuevoNombre){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pNuevoNombre)){
                
                return "Ya existe una disciplina con este nombre";
                
            }
        }
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pDisciplina)){
                
                disciplina.setNombre(pNuevoNombre);
                                
            }
        }
        
        return null;
    }

    /**
     * Método para modificar el nombre de una prueba dentro de una disciplina
     * @param pDisciplina nombre de la disciplina
     * @param pPrueba nombre de la prueba
     * @param pNuevoNombre nuevo nombre de la prueba
     * @return null si fue modificada, tambien se indica si ya existe una prueba con el nombre nuevo
     */
    public String modificarPruebaDisciplina(String pDisciplina, String pPrueba, String pNuevoNombre){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pDisciplina)){
                
                ArrayList<Prueba> pruebas = disciplina.getPruebas();
                
                for(Prueba prueba: pruebas){
                    
                    if(prueba.getNombre().equals(pNuevoNombre)){
                        
                        return "Ya existe una prueba con este nombre en esta disciplina";
                    }
                }
                
                for(Prueba prueba: pruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        prueba.setNombre(pNuevoNombre);
                    }
                }
            }
        }  
        return null;
    }

    /**
     * Método que valida si una disciplina ya existe 
     * @param pNombre nombre de la disciplina
     * @return null en caso no estar, si no se indica que esta registrada
     */
    public String getDisciplina(String pNombre){
        
        for(Disciplina disciplina: listaDisciplinas){
            
            if(disciplina.getNombre().equals(pNombre)){
                
                return "Esta disciplina ya esta registrada";
            }
        }
        return null;
    }
    
    /**
     * Método que retorna la lista de disciplinas
     * @return lista de disciplinas
     */
    public ArrayList<Disciplina> getDisciplinas(){
        
        return listaDisciplinas;
    }
    
    // --------------------------------- MÉTODOS PARA VISOR DE ATLETAS --------------------------------------------------
    
    /**
     * Método que agrega/crea un visor de atletas
     * @param pId identificaciom del visor de atletas
     * @param pNombre nombre del visor de atletas
     * @param pPapellido primer apellido del visor de atletas
     * @param pSapellido segundo apellido del visor de atletas
     * @param pPais pais del visor de atletas
     * @param pTelefono telefono del visor de atletas
     * @param email email del visor de atletas
     * @param fecha fecha de nacimiento del visor de atletas
     * @return null en caso de haberlo creado, si no se indica cual valor esta incorrecto
     */
    public String setVisorAtleta(String pId, String pNombre, String pPapellido, String pSapellido, String pPais,
            String pTelefono, String email, String fecha){
        
        if(pNombre.length() < 2 || pNombre.length() > 20){
            
            return "El nombre debe contener entre 2 y 20 caracteres ";
        }
        
        if(pPapellido.length() < 2 || pPapellido.length() > 20){
            
            return "El primer apellido debe contener entre 2 y 20 caracteres";
        }
        
        if(pPapellido.length() < 2 || pPapellido.length() > 20){
            
            return "El segundo apellido debe contener entre 2 y 20 caracteres";
        }
        
        if(pId.length() < 9 || pId.length() > 20){
            
            return "La identificación debe contener entre 9 y 20 caracteres";
        }
        
        else{
            
            int indicador = 0;
            
            for(VisorAtleta visor: listaVisorAtletas){
                
                if(visor.getId().equals(pId)){
                    
                    indicador ++;
                    break;
                }
            }
            
            if(indicador > 0){
                
                return "La identificación ya existe, no se puede asignar a este atleta";
            }
        }
        
        if(pTelefono.length() != 8){
            
            return "El telefono debe ser de 8 caracteres";
        }
        
        VisorAtleta visor = new VisorAtleta(pNombre, pPapellido, pSapellido, pId, pPais, 
                pTelefono, email, fecha);        
        listaVisorAtletas.add(visor);
        return null;
    }
    
    /**
     * Este método agrega un atleta al visor de atleta
     * @param pIdVisor identificacion del visor
     * @param pIdAtleta identificaion del atleta
     * @return null en caso de agregarlo correctamente, en caso de que no, se indica cual fue el error
     */
    public String setAtletaVisorAtleta(String pIdVisor, String pIdAtleta){
        
        for(VisorAtleta visor: listaVisorAtletas){
            
         
            if(visor.getId().equals(pIdVisor)){
                
                ArrayList<Atleta> listaDeAtletas = visor.getAtletas();
                for(Atleta atletas: listaDeAtletas){
                    
                    if(atletas.getId().equals(pIdAtleta)){
                        
                        return "Este visor ya sigue a este atleta";
                    }
                }
                
                
                for(Atleta atletaActual: listaAtletas){
                    
                
                    if(atletaActual.getId().equals(pIdAtleta)){
                        
                        visor.setAtleta(atletaActual);
                        return null;
                    }
                }
                
            }
        }
        
        return "Este atleta no esta registrado";
    }
    
    /**
     * Método que agrega una prueba a un visor de atleta
     * @param pIdVisor identificacion del visor
     * @param pPrueba nombre de la prueba
     * @param pMedicion manera en la que la prueba va a ser medida (por ejemplo: metros o tiempo)
     * @return null en caso de agregarlo correctamente, en caso de que no, el visor ya seguia a la prueba
     */
    public String setPruebaVisor(String pIdVisor, String pPrueba, String pMedicion){
        
        for(VisorAtleta visor: listaVisorAtletas){
            
            if(visor.getId().equals(pIdVisor)){
                
                ArrayList<Prueba> pruebas = visor.getPruebas();
                
                for(Prueba prueba: pruebas){
                    
                    if(prueba.getNombre().equals(pPrueba)){
                        
                        return "Este visor ya sigue a esta prueba";
                    }
                }
                
                Prueba prueba = new Prueba(pPrueba, pMedicion);
                visor.setPrueba(prueba);
            }
        }
        return null;
    }
    
    /**
     * Método que elimina un atleta de un visor de atleta
     * @param pAtleta nombre del atleta
     * @param pVisor nombre del visor
     * @return null en caso de elmmininarlo correctamente, en caso de que no, se indica que el visor no sigue al atleta
     */
    public String deleteAtletaVisorAtleta(String pAtleta, String pVisor){
        
        for(VisorAtleta visor: listaVisorAtletas){
            
            if(visor.getNombre().equals(pVisor)){
                
                if(visor.deleteAtleta(pAtleta) == false){
                    
                    return "Este visor no sigue a este atleta";
                }
            }
        }
        return null;
    }

    /**
     * Método que elimina un visor de atleta de la lista de visor de atletas
     * @param pVisor identificacion el visor
     * @return null en caso de eliminarlo correctamente, en caso de que no, se indica que no ha sido registrado
     */
    public String deleteVisorAtleta(String pVisor){
        
        int indice = 0;
        
        for(VisorAtleta visor: listaVisorAtletas){
            
            if(visor.getId().equals(pVisor)){
                
                listaVisorAtletas.remove(indice);
                return null;
            }
            
            indice ++;
        }
        
        return "Este visor no ha sido registrado";
    }
    
    /**
     * Método para verificar si un visor está registrado
     * @param pVisor nombre del visor
     * @return indica si en caso de estar registrado, null en caso de no estar registrado
     */
    public String getVisor(String pVisor){
        
        for(VisorAtleta visor: listaVisorAtletas){
            
            if(visor.getId().equals(pVisor)){
                
                return "si";
            }
        }
        
        return null;
    }

    /**
     * Método para modificar los valores un visor de atleta
     * @param pId identificacion del visor
     * @param pNombre nuevo nombre
     * @param pPapellido nuevo primer apellido
     * @param pSapellido nuevo segundo apellido
     * @param pPais nuevo pais
     * @param telefono nuevo telefono
     * @param email nuevo email
     * @param fecha nueva fecha de nacimiento
     * @return null en caso de modificarse correctamente, en caso de no, se indica cual fue el error
     */
    public String modificarVisorAtleta(String pId, String pNombre, String pPapellido, String pSapellido, String pPais,
            String telefono, String email, String fecha){
        
        String mensaje = null;
        
        for(VisorAtleta visor: listaVisorAtletas){
            
            if(visor.getId().equals(pId)){
                
                if(pNombre != null){
                    
                    if(pNombre.length() >= 2 && pNombre.length() <= 20){
                        
                        visor.setNombre(pNombre);
                    }
                    else{
                        
                        mensaje += "-El nombre debe contener entre 2 y 20 caracteres";
                    }
                }
                if(pPapellido != null){
                    
                    if(pPapellido.length() >= 2 && pPapellido.length() <= 20){
                        
                        visor.setApellido1(pPapellido);
                    }
                    else{
                        
                        mensaje += "-El primer apellido debe contener entre 2 y 20 caracteres";
                    }
                }
                
                if(pSapellido != null){
                    
                    if(pSapellido.length() >= 2 && pSapellido.length() <= 20){
                        
                        visor.setApellido2(pSapellido);
                    }
                    else{
                        
                        mensaje += "-El segundo apellido debe contener entre 2 y 20 caracteres";
                    }
                }
                
                if(pPais != null){
                    
                    if(pPais.length() == 3){
                        
                        visor.setPais(pPais);
                    }
                    else{
                        
                        mensaje += "-El pais debe ser de 3 caracteres";
                    }
                }
                
                if(telefono != null){
                    
                    if(telefono.length() != 8){
                        
                        visor.setTelefono(telefono);
                    }
                    else{
                        
                        mensaje += "-El telefono debe ser de 8 caracteres";
                    }
                }
            }
        }
        
        return null;
        
    }
    
    /**
     * Método para retornar la lista de visores atletas
     * @return lista de los visores de atletas
     */
    public ArrayList<VisorAtleta> getListaVisores(){
        
        return listaVisorAtletas;
    }
    
    // ---------------------------------- MÉTODOS PARA CONFIGURACIÓN ----------------------------------------------------

    /**
     * Método para agregar la cantidad de atletas a desplegar en pantalla en la configuración
     * @param cantidad tipo de configuracion para el listado
     * @return la configuracin que fue recibida
     */
    public boolean setConfiguracion(int cantidad){
        
        return configuracion.setCantidadAtletas(cantidad);
    }
    
    /**
     * Método para obtener la configuracion que fue registrada
     * @return la configuracion que se registro
     */
    public int getConfiguracion(){
        
        return configuracion.getListado();
    }
    
    // ------------------------------------ MÉTODOS PARA LISTADO ----------------------------------------------------
    
    /**
     * Método que retorna la lista de atletas que contiene la competencia x en la prueba y
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @return lista de los atletas en la competencia "x" y en la prueba "y", null en caso de no encontrar la competencia
     */
    public ArrayList<Atleta> listadoCompetenciaPruebaAtleta(String pCompetencia, String pPrueba){
        
        System.out.println(pCompetencia);//nombre de la competencia
        
        for(Competencia competencia: listaCompetencias){
         
            if(competencia.getNombre().equals(pCompetencia)){
                 
                Prueba prueba = competencia.recorrerPruebas(pPrueba);        
                
                return prueba.getListaAtletas() ;
            }
        }
        return null;
    }
    
    /**
     * Método que retorna la lista de las marcas de los atletas que contiene la competencia x en la prueba y
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @param pAtleta nombre del atleta
     * @param pObjetivo 
     * @return lista de las marcas de los atletas, null en caso de no encontrar la competencia
     */
    public ArrayList<String> marcasCompetenciaPruebaAtleta(String pCompetencia, String pPrueba, String pAtleta, int pObjetivo){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
                Prueba prueba = competencia.recorrerPruebas(pPrueba);
                   
                return prueba.getMarcaAtletas();
            }
        }
        return null;
    }
      
    // ------------------------------ MÉTODOS PARA REGISTRO DE MARCAS ----------------------------------------------------
    
    /**
     * Método que asigna la marca de un atleta dentro de una prueba en una competencia
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @param pAtleta nombre del atleta
     * @param pMarca depende del tipo de prueba, ya sea en metros o tiempo (por ejemplo: "9.989" o "9:28")
     */
    public void setRegistroMarcas(String pCompetencia, String pPrueba, String pAtleta, String pMarca){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
               Prueba prueba = competencia.recorrerPruebas(pPrueba);
               if(prueba != null){
                   
                   prueba.setMarcaAtleta(pMarca, pAtleta);
               }
               
            }
        }
    }
    
    /**
     * Método que borra la marca de un atleta dentro de una prueba en una competencia
     * @param pCompetencia nombre de la competencia
     * @param pPrueba nombre de la prueba
     * @param pAtleta nombre del atleta
     */
    public void deleteRegistroMarcas(String pCompetencia, String pPrueba, String pAtleta){
        
        for(Competencia competencia: listaCompetencias){
            
            if(competencia.getNombre().equals(pCompetencia)){
                
               Prueba prueba = competencia.recorrerPruebas(pPrueba);
               
               if(prueba != null){
                   
                   prueba.deleteMarcaAtleta(pAtleta);
               }           
            }
        }
    }
}

