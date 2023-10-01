/**
 * La clase UserJanitorDTO representa a un usuario con rol de conserje y contiene
 * atributos como el identificador (id), nombre de usuario de conserje (userJanitor)
 * y contraseña de conserje (passJanitor).
 * Esta clase proporciona constructores para crear objetos UserJanitorDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

public class UserJanitorDTO {

	private int id;
	private String userJanitor;
	private String passJanitor;

	/**
	 * Constructor por defecto de la clase UserJanitorDTO.
	 */
	public UserJanitorDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos id, userJanitor y
	 * passJanitor de un objeto UserJanitorDTO.
	 * 
	 * @param id          El identificador del usuario conserje.
	 * @param userJanitor El nombre de usuario del conserje.
	 * @param passJanitor La contraseña del conserje.
	 */
	public UserJanitorDTO(int id, String userJanitor, String passJanitor) {
		super();
		this.id = id;
		this.userJanitor = userJanitor;
		this.passJanitor = passJanitor;
	}

	/**
	 * Obtiene el identificador del usuario conserje.
	 * 
	 * @return El identificador del usuario conserje.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del usuario conserje.
	 * 
	 * @param id El identificador del usuario conserje.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario del conserje.
	 * 
	 * @return El nombre de usuario del conserje.
	 */
	public String getUserJanitor() {
		return userJanitor;
	}

	/**
	 * Establece el nombre de usuario del conserje.
	 * 
	 * @param userJanitor El nombre de usuario del conserje.
	 */
	public void setUserJanitor(String userJanitor) {
		this.userJanitor = userJanitor;
	}

	/**
	 * Obtiene la contraseña del conserje.
	 * 
	 * @return La contraseña del conserje.
	 */
	public String getPassJanitor() {
		return passJanitor;
	}

	/**
	 * Establece la contraseña del conserje.
	 * 
	 * @param passJanitor La contraseña del conserje.
	 */
	public void setPassJanitor(String passJanitor) {
		this.passJanitor = passJanitor;
	}

	/**
	 * Devuelve una representación en cadena del objeto UserJanitorDTO.
	 * 
	 * @return Una cadena que representa el objeto UserJanitorDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
