/**
 * La clase UserPsychoDTO representa a un usuario con rol de psicólogo y contiene
 * atributos como el identificador (id), nombre de usuario de psicólogo (userPsycho)
 * y contraseña de psicólogo (passPsycho).
 * Esta clase proporciona constructores para crear objetos UserPsychoDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

public class UserPsychoDTO {

	private int id;
	private String userPsycho;
	private String passPsycho;

	/**
	 * Constructor por defecto de la clase UserPsychoDTO.
	 */
	public UserPsychoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos id, userPsycho y passPsycho
	 * de un objeto UserPsychoDTO.
	 * 
	 * @param id         El identificador del usuario psicólogo.
	 * @param userPsycho El nombre de usuario del psicólogo.
	 * @param passPsycho La contraseña del psicólogo.
	 */
	public UserPsychoDTO(int id, String userPsycho, String passPsycho) {
		super();
		this.id = id;
		this.userPsycho = userPsycho;
		this.passPsycho = passPsycho;
	}

	/**
	 * Obtiene el identificador del usuario psicólogo.
	 * 
	 * @return El identificador del usuario psicólogo.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del usuario psicólogo.
	 * 
	 * @param id El identificador del usuario psicólogo.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario del psicólogo.
	 * 
	 * @return El nombre de usuario del psicólogo.
	 */
	public String getUserPsycho() {
		return userPsycho;
	}

	/**
	 * Establece el nombre de usuario del psicólogo.
	 * 
	 * @param userPsycho El nombre de usuario del psicólogo.
	 */
	public void setUserPsycho(String userPsycho) {
		this.userPsycho = userPsycho;
	}

	/**
	 * Obtiene la contraseña del psicólogo.
	 * 
	 * @return La contraseña del psicólogo.
	 */
	public String getPassPsycho() {
		return passPsycho;
	}

	/**
	 * Establece la contraseña del psicólogo.
	 * 
	 * @param passPsycho La contraseña del psicólogo.
	 */
	public void setPassPsycho(String passPsycho) {
		this.passPsycho = passPsycho;
	}

	/**
	 * Devuelve una representación en cadena del objeto UserPsychoDTO.
	 * 
	 * @return Una cadena que representa el objeto UserPsychoDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
