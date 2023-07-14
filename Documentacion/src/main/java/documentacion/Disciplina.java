package documentacion;
import java.util.ArrayList;

/**
 * Este es la clase de disciplina donde se van a crear y llamar las funciones necesarias para las disciplinas
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class Disciplina {
    
    private String nombre, medicion;
    private ArrayList<Prueba> pruebas;
    
    /**
     * Método costructor de la clase disciplina, tambien se crea una lista de las pruebas
     * @param pNombre nombre de la disciplina
     * @param pMedicion tipo de medicion
     */
    public Disciplina(String pNombre, String pMedicion)
    {
        nombre = pNombre;
        medicion = pMedicion;
        pruebas = new ArrayList<Prueba>();
    }
    
    // SETTERS
    
    /**
     * Método para agregar una prueba a la lista de pruebas
     * @param pPrueba nombre de la prueba
     */
    public void setPrueba(Prueba pPrueba){
        
        pruebas.add(pPrueba);             
    }
    
    /**
     * Método para crear el nombre de la disciplina
     * @param pNombre nombre
     */
    public void setNombre(String pNombre){
        
        nombre = pNombre;
    }
    /**
     * Método para obtener la lista de pruebas
     * @return lista de pruebas
     */
    public ArrayList<Prueba> getPruebas(){
        
        return pruebas;
    }

    /**
     * Método que recorre las pruebas y la elimina en caso de que la encuentre
     * @param pPrueba nombre de la prueba
     * @return true fue eliminada, false no se eliminó
     */
    public boolean recorrerPruebas(String pPrueba){        
        
  
        for(Prueba prueba: pruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
                
                prueba = null;
                return true;
            }
        }
        return false;
    }
    
    //GETTERS
    
    /**
     * Método para obtener el nombre de la disciplina
     * @return nombre
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Método para obtener la medicion de la disciplina
     * @return 
     */
    public String getMedicion()
    {
        return medicion;
    }
    
    /**
     * Método para imprimir los valores de disciplina
     * @return nombre, medicion
     */
    public String toString()
    {
        return nombre + medicion;
    }
    
    
    
}

