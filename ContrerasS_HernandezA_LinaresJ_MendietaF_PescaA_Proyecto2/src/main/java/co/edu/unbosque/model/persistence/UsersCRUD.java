/**
 * La interfaz UsersCRUD define métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar y Eliminar) en una fuente de datos que almacena información sobre usuarios.
 * Las clases que implementen esta interfaz deben proporcionar implementaciones concretas de estos métodos
 * para interactuar con la fuente de datos y realizar las operaciones CRUD en los registros de usuario.
*/
package co.edu.unbosque.model.persistence;


public interface UsersCRUD {

    /**
     * Crea un nuevo registro de usuario en la fuente de datos utilizando un objeto.
     * 
     * @param o El objeto que representa el nuevo registro de usuario.
     */
    public void create(Object o);

    /**
     * Crea un nuevo registro de usuario en la fuente de datos utilizando argumentos individuales.
     * 
     * @param args Argumentos individuales que representan los atributos del nuevo registro de usuario.
     */
    public void create(String... args);

    /**
     * Lee todos los registros de usuario en la fuente de datos y los devuelve en forma de cadena.
     * 
     * @return Una cadena que contiene todos los registros de usuario en la fuente de datos.
     */
    public String readAll();

    /**
     * Lee registros de usuario en la fuente de datos por nombre y los devuelve en forma de cadena.
     * 
     * @param name El nombre del usuario que se busca en la fuente de datos.
     * @return Una cadena que contiene los registros de usuario con el nombre especificado.
     */
    public String readByName(String name);

    /**
     * Actualiza un registro existente de usuario en la fuente de datos utilizando su identificador y argumentos individuales.
     * 
     * @param id El identificador único del usuario que se desea actualizar.
     * @param args Argumentos individuales que representan los atributos actualizados del usuario.
     * @return 0 si la actualización fue exitosa, 1 si no se encontró el usuario con el identificador especificado.
     */
    public int updateById(int id, String... args);

    /**
     * Elimina un registro existente de usuario en la fuente de datos utilizando su identificador.
     * 
     * @param id El identificador único del usuario que se desea eliminar.
     * @return 0 si la eliminación fue exitosa, 1 si no se encontró el usuario con el identificador especificado.
     */
    public int deleteById(int id);

}
