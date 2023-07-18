package Lógica;
//import java.time.*;
import java.util.ArrayList;

/**
 * Este es la clase Atleta donde se van a crear y llamar las funciones necesarias para los atletas
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class Atleta extends Persona{
    
    private int dorsal = 0;
    
    private ArrayList<Prueba> pruebas;
    private ArrayList<String> competencias;
    private Competencia competencia;
    private ArrayList<String> marcasPruebasCompetencia;
    
    /**
     * Metodo constructor de la clase atleta, se extiende de la clase persona, tambien crea listas necesarias para los atletas, como lo son:
     * la lista de competencias y lista de pruebas
     * @param pNombre nombre del atleta
     * @param pApellido1 primer apellido
     * @param pApellido2 segundo apellido
     * @param pId identificacion
     * @param pPais pais
     * @param pTelefono telefono
     * @param pEmail email
     * @param pFecha fecha de nacimiento
     */
    public Atleta(String pNombre, String pApellido1, String pApellido2, String pId, String pPais, String pTelefono, String pEmail, String pFecha)
    {   
        super(pNombre, pApellido1, pApellido2, pId, pPais, pTelefono, pEmail, pFecha);
        pruebas = new ArrayList<Prueba>();
        competencias = new ArrayList<String>();
        
    }
    
    /**
     * Metodo para crear la marca de un atleta
     * @param pMarca depende del tipo de prueba, ya sea en metros o tiempo (por ejemplo: "9.989" o "9:28")
     * @param pPrueba nombre de la prueba
     */
    public void setMarcaPruebaCompetencia(String pMarca, String pPrueba){
        
        for(Prueba prueba: pruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
                
                prueba.getCompetencia();
            }
        }  
    }
    
    /**
     * Metodo para agregar una competencia a una lista y tambien agregarle el dorsal
     * @param competencia nombre de la competencia
     * @param pDorsal numero del dorsal
     */
    public void setCompetencia(String competencia, int pDorsal){
        
        competencias.add(competencia);
        dorsal = pDorsal;
    }
    
    /**
     * Método que elimina a este atleta de la prueba en la competencia en la que está 
     * @param pCompetencia nombre de la competencia
     */
    public void deletePrueba(String pCompetencia){
        
        int indice = 0;
        for(Prueba prueba: pruebas){
            
            if(prueba.getCompetencia().equals(pCompetencia)){
                prueba.deleteAtleta(super.getId(), pCompetencia);
                pruebas.remove(indice);
            }
            indice ++;
        }
        
        indice = 0;
        for(String competencia: competencias){
            
            if(competencia.equals(pCompetencia)){
                
                competencias.remove(indice);
            }
            
            indice ++;
        }
    }
    
    /**
     * Método para agregar una prueba a una lista
     * @param pPrueba nombre de la prueba
     */
    public void setPrueba(Prueba pPrueba){
        
        pruebas.add(pPrueba);

    }
    
    /**
     * Método para obtener la lista de pruebas
     * @return lista de pruebas
     */
    public ArrayList<Prueba> getPruebas(){
        
        return pruebas;
    }
    
    /**
     * Método para obtener la lista de competencias
     * @return lista de competencias
     */
    public ArrayList<String> getCompetencias(){
        
        return competencias;
    }
   
    /**
     * Método para obtener el id del atleta
     * @return identificaion del atleta
     */
    public String getId(){
        
        return super.getId();
    }
    
    /**
     * Método para agregar el dorsal al atleta
     * @param pDorsal numero del dorsal
     */
    public void setDorsal(int pDorsal){
        
        dorsal = pDorsal;
    }
    
    /**
     * Método para obtener el dorsal del atleta
     * @return dorsal del atleta
     */
    public int getDorsal(){
        
        return dorsal;
    }
    
    // SETTERS
    
    /**
     * Método para crear el nombre del atleta
     * @param pNombre nombre del atleta
     */
    public void setNombre(String pNombre){
        
        super.setNombre(pNombre);
    }
    
    /**
     * Método para crear el primer apellido del atleta
     * @param pApellido primer apellido
     */
    public void setApellido1(String pApellido){
        
        super.setApellido1(pApellido);
    }
    
    /**
     * Método para crear el segundo apellido del atleta
     * @param pApellido segundo apellido
     */
    public void setApellido2(String pApellido){
        
        super.setApellido2(pApellido);
    }
    
    /**
     * Método para crear el pais  del atleta
     * @param pPais pais del atleta
     */
    public void setPais(String pPais){
        
        super.setPais(pPais);
    }
    
    /**
     * Método para crear el telefono del atleta
     * @param pTelefono numero de telefono del atleta
     */
    public void setTelefono(String pTelefono){
        
        super.setTelefono(pTelefono);
    }
    
    /**
     * Método para crear el email del atleta
     * @param pEmail email del atleta
     */
    public void setEmail(String pEmail){
        
        super.setEmail(pEmail);
    }
    
    /**
     * Método para crear la fecha de nacimiento del atleta
     * @param pFecha fecha de nacimiento
     */
    public void setFecha(String pFecha){
        
        super.setFecha(pFecha);
    }
    
}

