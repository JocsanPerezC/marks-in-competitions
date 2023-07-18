package Lógica;
import java.util.ArrayList;

/**
 * Este es la clase de Prueba donde se van a crear y llamar las funciones necesarias para las pruebas
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class Prueba{
    
    private boolean clasificacion; // Si está en true es de tiempo, false de distancia
    // La lista de atletas y marcasAtletas están asociadas con el indice del atleta
    // El elemento 0 de marcasAtletas corresponde a la marca del elemento 0 de la lista atletas
    private ArrayList<Atleta> atletas; 
    private ArrayList<String> marcasAtletas;
    private Competencia competencia;
    private ArrayList<String> categorias;
    private String medicion;
    String nombre;
    
    /**
     * Método constructor de la clase Prueba, tambien crea la lista de atletlas, lista de categorias y las marcas de los atletas
     * @param pNombre
     * @param pMedicion 
     */
    public Prueba(String pNombre, String pMedicion){
        
        nombre = pNombre;
        atletas = new ArrayList<Atleta>();
        categorias = new ArrayList<String>();
        marcasAtletas = new ArrayList<String>();
        medicion = pMedicion;
    }
    
    /**
     * Método para obtener el nombre de la prueba
     * @return 
     */
    public String getNombre(){
        
        return nombre;
    }
    
    /**
     * Método para crear/agregar la categoria de la prueba
     * @param pNombre nombre
     */
    public void setCategoria(String pNombre){
        
        categorias.add(pNombre);    
    }
    
    /**
     * Método para agregar el atleta a la lista y tambien agregar la marca
     * @param pAtleta nombre del atleta
     */
    public void setAtleta(Atleta pAtleta){
        
        atletas.add(pAtleta);
        marcasAtletas.add("0");
    }
    
    /**
     * Método que recibe la identificación del atleta y la marca del atleta, agrega la marca al atleta
     * @param pMarca marca del atleta
     * @param pAtleta nombre del atleta
     */
    public void setMarcaAtleta(String pMarca, String pAtleta){
        
        int indice = 0;
        
        for(Atleta atleta: atletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                marcasAtletas.set(indice, pMarca);
            }
            indice ++;
        }
    }
    
    /**
     * Método para eliminar la marca de un atleta 
     * @param pAtleta nombre del atleta
     */
    public void deleteMarcaAtleta(String pAtleta){
        
        int indice = 0;
        
        for(Atleta atleta: atletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                marcasAtletas.set(indice, "");
            }
            
            indice ++;
        }
    }
    
    /**
     * Método que agrega una competencia a la prueba para verificar que esta prueba pertenece a dicha competencia
     * @param pCompetencia nombre de la competencia
     */
    public void setCompetencia(Competencia pCompetencia){
        
        competencia = pCompetencia;       
    }
    
    /**
     * Método para crear el nombre de la prueba
     * @param pNombre nombre
     */
    public void setNombre(String pNombre){
        
        nombre = pNombre;
    }
    
    /**
     *  Método para eliminar un atleta de la lista de atletas
     * @param pAtleta nombre del atleta
     * @param pCompetencia nombre de la competencia
     */
    public void deleteAtleta(String pAtleta, String pCompetencia){
        
        int indice = 0;
        
        for(Atleta atleta: atletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                ArrayList<String> competencias = atleta.getCompetencias();
                
                for(String competencia: competencias){
                    
                    if(competencia.equals(pCompetencia)){
                        
                        atletas.remove(indice);
                        marcasAtletas.remove(indice);
                        return;
                    }
                }
                
            }
            indice ++; //para eliminar al atleta, ya que los indices coinciden
        }
    }
    
    // GETTERS

    /**
     * Método que devuelve el nombre de la competencia en la que se encuentra esta prueba
     * @return nommbre de la competencia
     */
    public String getCompetencia(){
        
        return competencia.getNombre();
    }

    /**
     * Método que retorna la lista de los atletas
     * @return lista de atletas
     */
    public ArrayList<Atleta> getListaAtletas(){
        
        return atletas;   
    }
    
    /**
     * Método que retorna la lista de las marcas de los atletas 
     * @return lista de marcas
     */
    public ArrayList<String> getMarcaAtletas(){
        
        return marcasAtletas; 
    }
    
    /**
     *  Método que retorna la medicion de la prueba
     * @return medicion
     */
    public String getMedicion(){
        
        return medicion;
    }
    
    /**
     *  Método que retorna la marca de un atleta
     * @param pAtleta
     * @return marca del atleta, null si no lo encuentra
     */
    public String getMarcaAtleta(String pAtleta){
        
        int indice = 0;
        
        for(Atleta atleta: atletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                return marcasAtletas.get(indice);
            }
            indice ++;  
        }  
        return null;
    }
}
