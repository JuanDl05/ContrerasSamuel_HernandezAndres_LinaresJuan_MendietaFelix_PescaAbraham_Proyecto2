/**
 * La interfaz CRUDoperations define las operaciones básicas que se pueden realizar
 * en una fuente de datos, como una base de datos, siguiendo el patrón CRUD (Crear, Leer, 
 * Actualizar, Eliminar). Esta interfaz proporciona métodos que permiten realizar estas 
 * operaciones en una fuente de datos.
 * Cada método de esta interfaz representa una operación CRUD específica:
 * El método `create(Object o)` se utiliza para crear un nuevo registro en la fuente de datos
 * utilizando un objeto.
 * El método `create(String... args)` se utiliza para crear un nuevo registro en la fuente de datos
 * utilizando argumentos individuales.
 * El método `readAll()` se utiliza para leer todos los registros de la fuente de datos y devolverlos
 * en forma de cadena.
 * El método `readByName(String name)` se utiliza para buscar registros por nombre en la fuente de datos
 * y devolverlos en forma de cadena.
 * El método `updateById(int id, String... args)` se utiliza para actualizar un registro existente en la 
 * fuente de datos utilizando su identificador y argumentos para la actualización.
 * El método `deleteById(int id)` se utiliza para eliminar un registro existente en la fuente de datos
 * utilizando su identificador.
 * Esta interfaz se utiliza como un contrato para definir las operaciones básicas que deben ser implementadas
 * por las clases que interactúan con fuentes de datos y desean seguir el patrón CRUD.
*/
package co.edu.unbosque.model.persistence;

public interface CRUDoperations {

	/**
	 * Crea un nuevo registro en la fuente de datos utilizando un objeto.
	 * 
	 * @param o El objeto que representa el registro a crear.
	 */
	public void create(Object o);

	/**
	 * Crea un nuevo registro en la fuente de datos utilizando argumentos
	 * individuales.
	 * 
	 * @param args Los argumentos que representan el registro a crear.
	 */
	public void create(String... args);

	/**
	 * Lee todos los registros de la fuente de datos y los devuelve en forma de
	 * cadena.
	 * 
	 * @return Una cadena que contiene todos los registros de la fuente de datos.
	 */
	public String readAll();

	/**
	 * Busca registros por nombre en la fuente de datos y los devuelve en forma de
	 * cadena.
	 * 
	 * @param name El nombre utilizado para buscar registros.
	 * @return Una cadena que contiene los registros encontrados por nombre.
	 */
	public String readByName(String name);

	/**
	 * Actualiza un registro existente en la fuente de datos utilizando su
	 * identificador y argumentos para la actualización.
	 * 
	 * @param id   El identificador del registro a actualizar.
	 * @param args Los argumentos que representan los cambios a aplicar en el
	 *             registro.
	 * @return 0 si la actualización se realiza con éxito, 1 si no se encuentra el
	 *         registro.
	 */
	public int updateById(int id, String... args);

	/**
	 * Elimina un registro existente en la fuente de datos utilizando su
	 * identificador.
	 * 
	 * @param id El identificador del registro a eliminar.
	 * @return 0 si la eliminación se realiza con éxito, 1 si no se encuentra el
	 *         registro.
	 */
	public int deleteById(int id);

}
