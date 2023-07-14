package documentacion;
import java.util.ArrayList;

/**
 * Este es la clase de VisorAtleta donde se van a crear y llamar las funciones necesarias para los visores de atletas
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public class VisorAtleta extends Persona{
    
    ArrayList<Prueba> listaPruebas;
    ArrayList<Atleta> listaAtletas;
    
    /**
     * Método constructor para la clase VisorAtleta, se extiende de la clase de persona, tambien crea las listas de pruebas y listas de atletas
     * @param pNombre nombre
     * @param pApellido1 primer apellido
     * @param pApellido2 segundo apellido
     * @param pId identificacion
     * @param pPais pais
     * @param pTelefono telefon
     * @param pEmail email
     * @param pFecha fecha de nacimiento
     */
    public VisorAtleta(String pNombre, String pApellido1, String pApellido2, String pId, String pPais, 
            String pTelefono, String pEmail, String pFecha){
        
        super(pNombre, pApellido1, pApellido2, pId, pPais, pTelefono, pEmail, pFecha);
        
        listaPruebas = new ArrayList<Prueba>();
        listaAtletas = new ArrayList<Atleta>();
    }
    
    /**
     * Método para agregar el atleta a la lista de atletas
     * @param atleta atleta (con toda la informacion de el)
     */
    public void setAtleta(Atleta atleta){
        
        listaAtletas.add(atleta);
    }
    
    /**
     * Método para agregar la prueba a la lista de pruebas
     * @param prueba prueba (con toda la informacion de la prueba)
     */
    public void setPrueba(Prueba prueba){
        
        listaPruebas.add(prueba);
    }
    
    // SETTERS
    
    /**
     * Método para crear el nombre del visor
     * @param pNombre nombre
     */
    public void setNombre(String pNombre){
        
        super.setNombre(pNombre);
    }
    
    /**
     * Método para crear el primer apellido del visor 
     * @param pApellido primer apellido
     */
    public void setApellido1(String pApellido){
        
        super.setApellido1(pApellido);
    }
    
    /**
     * Método para crear el segundo apellido del visor 
     * @param pApellido segundo apellido
     */
    public void setApellido2(String pApellido){
        
        super.setApellido2(pApellido);
    }
    
    /**
     * Método para crear el pais del visor 
     * @param pPais pais
     */
    public void setPais(String pPais){
        
        super.setPais(pPais);
    }
    
    /**
     * Método para crear el telefono del visor 
     * @param pTelefono telefono
     */
    public void setTelefono(String pTelefono){
        
        super.setTelefono(pTelefono);
    }
    
    /**
     * Método para crear el email del visor 
     * @param pEmail email
     */
    public void setEmail(String pEmail){
        
        super.setEmail(pEmail);
    }
    
    /**
     * Método para crear la fecha de nacimiento del visor 
     * @param pFecha fecha de nacimiento
     */
    public void setFecha(String pFecha){
        
        super.setFecha(pFecha);
    }
    
    // GETTERS
    /**
     * Método para obtener la lista de pruebas
     * @return lista de pruebas
     */
    public ArrayList<Prueba> getPruebas(){
        
        return listaPruebas;
    }
    
    /**
     * Método para obtener la lista de atletas 
     * @return lista de atletas
     */
    public ArrayList<Atleta> getAtletas(){
        
        return listaAtletas;
    }
    
    /**
     * Método que elimina un atleta de la lista de atletas
     * @param pAtleta nombre del atleta
     * @return true si fue eliminado, false si no fue eliminado
     */
    public boolean deleteAtleta(String pAtleta){
        
        int indice = 0;
        
        for(Atleta atleta: listaAtletas){
            
            if(atleta.getId().equals(pAtleta)){
                
                listaAtletas.remove(indice);
                return true;
            }      
            indice ++;
        }
        return false;
    }
    
    /**
     * Método que elimina una prueba de la lista de pruebas
     * @param pPrueba nombre de la prueba
     * @return true si fue eliminado, false si no fue eliminado
     */
    public boolean deletePrueba(String pPrueba){
        
        int indice = 0;
        
        for(Prueba prueba: listaPruebas){
            
            if(prueba.getNombre().equals(pPrueba)){
                
                listaPruebas.remove(indice);
                prueba = null;
                return true;
            }
            indice ++;
        }
        return false;
    }
}
