package documentacion;
import java.util.ArrayList;

/**
 * Este es la clase de competencia donde se van a crear y llamar las funciones necesarias para las competencias
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class Competencia {
    
    public static int cantidadAtletas;
    
    private String nombre, pais, lugar;
    private String id;
    private String fechaInicial; 
    private String fechaFinal; 
    
    private ArrayList<Prueba> listaPruebas;
    private ArrayList<Atleta> listaAtletas;
    
    /**
     * Metodo constructor de la clase competencia, tambien crea listas necesarias para las competencias como lo son:
     * la lista de pruebas, lista de atletas
     * @param pNombre nombre 
     * @param pPais pais 
     * @param pLugar lugar
     * @param pId identificacion
     * @param pFechaInicial fecha inicial 
     * @param pFechaFinal fecha final
     */
    public Competencia(String pNombre, String pPais, String pLugar, String pId, String pFechaInicial, String pFechaFinal)
    {
        listaPruebas = new ArrayList<Prueba>();
        nombre = pNombre;
        pais = pPais;
        lugar = pLugar;
        id = pId;
        fechaInicial = pFechaInicial;
        fechaFinal = pFechaFinal;
        cantidadAtletas = 0;
        listaAtletas = new ArrayList<Atleta>();
    }
    
    // SETTERS
    
    /**
     * Método para agregar una prueba a la lista de pruebas
     * @param pPrueba nombre de la prueba
     */
    public void setPrueba(Prueba pPrueba){
        
        listaPruebas.add(pPrueba);
    }
    
    //GETTERS

    /**
     * Método que agrega un atleta a una prueba de esta competencia, También agrega la prueba a la lista de pruebas que contiene el Atleta
     * @param pPrueba nombre de la prueba
     * @param pAtleta nombre del atleta
     */
    public void setAtletaPrueba(String pPrueba, Atleta pAtleta){
        
        pAtleta.setDorsal(cantidadAtletas);
        
        for(Prueba prueba: listaPruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
            
                prueba.setAtleta(pAtleta);
                pAtleta.setPrueba(prueba);
            }
        }
    }
  
    /**
     * Método para eliminar una prueba de una competencia
     * @param pPrueba nombre de la prueba
     * @return true si se elimina, false no se elimina
     */
    public boolean deletePruebaCompetencia(String pPrueba){
        
        int indice = 0;
        
        for(Prueba prueba: listaPruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
                
                listaPruebas.remove(indice);
                return true;
            }   
            indice ++;
        }
        return false;
    }
    
    /**
     * Método que recibe la identificación del atleta y lo elimina de la competencia
     * @param pAtleta nombre del atleta
     * @return true si se elmina, false no se elimina
     */
    public boolean deleteAtletaCompetencia(String pAtleta){
        
        int indice = 0;
        
        for(Atleta atleta: listaAtletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                atleta.deletePrueba(nombre);
                listaAtletas.remove(indice);
                return true;
            } 
            indice ++;
        }
        return false;
    }
    
    /**
     * Método que recorre las pruebas de esta competencia, si la encuentra la retorna
     * @param pPrueba nombre prueba
     * @return la prueba si la encuentra, si no, retorna null
     */
    public Prueba recorrerPruebas(String pPrueba){
        
        for(Prueba prueba: listaPruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
                
                return prueba;
            }
        }
        
        Prueba prueba = null;
        return prueba;
    }
    
    // SETTERS
    
    /**
     * Método para crear la identificacion de una competencia
     * @param pId identificacion de la competencia
     */
    public void setId(String pId){
        
        id = pId;
    }
     /**
      * Método para crear el nombre de una competencia
      * @param pNombre nombre de la competencia
      */
    public void setNombre(String pNombre){
        
        nombre = pNombre;
    }
    
    /**
     * Método para crear el lugar de una competencia
     * @param pLugar lugar de la competencia
     */
    public void setLugar(String pLugar){
        
        lugar = pLugar;
    }
    
    /**
     * Método para crear el pais de una competencia
     * @param pPais pais de la competencia
     */
    public void setPais(String pPais){
        
        pais = pPais;
    }
    
    /**
     * Método para crear la fecha inicial de una competencia
     * @param pFechaInicial fecha inicial de la competencia
     */
    public void setFechaInicial(String pFechaInicial){
        
        fechaInicial = pFechaInicial;
    }
    
    /**
     * Método para crear la fecha final de una competencia
     * @param pFechaFinal fecha final de la competencia
     */
    public void setFechaFinal(String pFechaFinal){
        
        fechaInicial = pFechaFinal;
    
    }
    
    // GETTERS
    /**
     * Método para obtener la lista de pruebas
     * @return lista de las pruebas
     */
    public ArrayList<Prueba> getPruebas(){
        
        return listaPruebas;
    }
    
    /**
     * Método para obtener la cantidad de atletas
     * @return cantidad de atletas
     */
    public int getCantidadAtletas(){
        
        return cantidadAtletas;
    }
    
    /**
     * Método para obtener el nombre de la competencia
     * @return nombre 
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Método para obtener el pais de la competencia
     * @return pais
     */
    public String getPais()
    {
        return pais;
    }
    
    /**
     * Método para obtener el lugar de la competencia
     * @return lugar
     */
    public String getLugar()
    {
        return lugar;
    }
    
    /**
     * Método para obtener la identificacion de la competencia
     * @return identificacion
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Método para obtener la fecha inicial de la competencia
     * @return fecha inicial
     */
    public String getFechaInicial()
    {
        return fechaInicial;
    }
    
    /**
     * Método para obtener la fecha final de la competencia
     * @return fecha final
     */
    public String getFechaFinal()
    {
        return fechaFinal;
    }
    
    /**
     * Método para imprimir los valores de competencia
     * @return nombre, pais, lugar, identificacion, fecha inicial, fecha final
     */
    @Override
    public String toString()
    {
        return nombre + pais + lugar + id + fechaInicial + fechaFinal;
    }

    
}
