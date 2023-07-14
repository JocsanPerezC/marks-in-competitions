package documentacion;

/**
 * Este es la clase de competencia donde se van a crear y llamar las funciones necesarias para la configuracion
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class Configuracion {
    
    private int cantidadAtletasListado;
    private int cantidadCompetencias;
    
    /**
     * Método constructor de configuracion
     */
    public Configuracion(){
        
        cantidadAtletasListado = 0;
        cantidadCompetencias = 0;
    }
    
    /**
     * Método para crear/agregar la cantidad de atletas
     * @param cantidad cantidad de atletltas
     * @return true si se crea correctamente, false si se indica un numero incorrecto
     */
    public boolean setCantidadAtletas(int cantidad){
        
        if(cantidad >= 0 && cantidad <= 50){
            
            cantidadAtletasListado = cantidad;
            return true;
        }
        return false;               
    }
    
    /**
     * Método para actualizar la cantidad de competencias
     */
    public void actualizarCompetencia(){
        
        cantidadCompetencias ++;
    }
    
    /**
     * Método para obtener la cantidad de competencias
     * @return la cantidad de competencias
     */
    public int getCompetencias(){
        
        return cantidadCompetencias;
    }
    
    /**
     * Método para obtener la cantidad de atletas listados
     * @return la cantidad de atletas listados
     */
    public int getListado(){
        
        return cantidadAtletasListado;
    }
    
}
