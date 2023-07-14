package documentacion;

/**
 * Este es la clase abstracta de persona donde se van a crear y llamar las funciones necesarias para las personas
 * @author Kendall Rodríguez Camacho 2022049438 y Jocsan Adriel Perez Coto 2022437948 
 */

public abstract class Persona {
    
    private String nombre, apellido1, apellido2, id, pais, telefono, email;
    private String fecha;//cambiar con el paquete java.time
    
    /**
     * Método constructor de una persona
     * @param pNombre nombre
     * @param pApellido1 primer apellido
     * @param pApellido2 segundo apellido
     * @param pId identificacion
     * @param pPais pais
     * @param pTelefono telefono
     * @param pEmail email
     * @param pFecha fecha de nacimiento
     */
    public Persona(String pNombre, String pApellido1, String pApellido2, String pId, String pPais, 
            String pTelefono, String pEmail, String pFecha){
        
        nombre = pNombre;
        apellido1 = pApellido1;
        apellido2 = pApellido2;
        id = pId;
        pais = pPais;
        telefono = pTelefono;
        email = pEmail;
        fecha = pFecha;
    
    }
    
    // SETTERS
    
    /**
     * Método para crear el nombre de una persona
     * @param pNombre nombre
     */
    public void setNombre(String pNombre){
        
        nombre = pNombre;
    }
    
    /**
     * Método para crear el primer apellido de una persona
     * @param pApellido primer apellido
     */
    public void setApellido1(String pApellido){
        
        apellido1 = pApellido;
    }
    
    /**
     * Método para crear el segundo apellido de una persona
     * @param pApellido segundo apellido
     */
    public void setApellido2(String pApellido){
        
        apellido2 = pApellido;
    }
    
    /**
     * Método para crear el pais de una persona
     * @param pPais pais
     */
    public void setPais(String pPais){
        
        pais = pPais;
    }
    
    /**
     * Método para crear el telefono de una persona
     * @param pTelefono telefono
     */
    public void setTelefono(String pTelefono){
        
        telefono = pTelefono;
    }
    
    /**
     * Método para crear el email de una persona
     * @param pEmail email
     */
    public void setEmail(String pEmail){
        
        email = pEmail;
    }
    
    /**
     * Método para crear la fecha de nacimiento de una persona
     * @param pFecha fecha de nacimiento
     */
    public void setFecha(String pFecha){
        
        fecha = pFecha;
    }
    
    // GETTERS
    
    /**
     * Método para obtener el nombre de una persona
     * @return nombre
     */
     public String getNombre()
    {
        return nombre;
    }
     
    /**
     * Método para obtener el primer apellido de una persona
     * @return primer apellido
     */ 
    public String getApellido1()
    {
        return apellido1;
    } 
    
    /**
     * Método para obtener el segundo apellido de una persona
     * @return segundo apellido
     */
    public String getApellido2()
    {
        return apellido2;
    } 
    
    /**
     * Método para obtener la identificacion de una persona
     * @return identificacion
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Método para obtener el pais de una persona
     * @return pais
     */
    public String getPais()
    {
        return pais;
    }
    
    /**
     * Método para obtener telefono de una persona
     * @return telefono
     */
    public String getTelefono()
    {
        return telefono;
    }
    
    /**
     * Método para obtener el email de una persona
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Método para obtener la fecha de nacimiento de una persona
     * @return fecha de nacimiento
     */
    public String getFecha()
    {
        return fecha;
    }

    /**
     * Método para imiprimir los valores de una persona
     * @return nombre, primer apellido, segundo apellido, identificacion, pais, telefono, email, fecha de nacimiento
     */
    public String toString()
    {
        return nombre + apellido1 + apellido2 + id + pais + telefono + email + fecha;
    }
    
}
