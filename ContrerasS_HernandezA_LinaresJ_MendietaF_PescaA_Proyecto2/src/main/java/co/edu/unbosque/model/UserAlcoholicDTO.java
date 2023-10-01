/**
 * La clase UserAlcoholicDTO representa a un usuario alcohólico y contiene
 * atributos como el identificador (id), nombre de usuario de alcohólico
 * (userAlcoholic) y contraseña de alcohólico (passAlcoholic).
 * Esta clase proporciona constructores para crear objetos UserAlcoholicDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

public class UserAlcoholicDTO {

	private int id;
	private String userAlcoholic;
	private String passAlcoholic;

	/**
	 * Constructor por defecto de la clase UserAlcoholicDTO.
	 */
	public UserAlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos id, userAlcoholic y
	 * passAlcoholic de un objeto UserAlcoholicDTO.
	 * 
	 * @param id            El identificador del usuario alcohólico.
	 * @param userAlcoholic El nombre de usuario de alcohólico.
	 * @param passAlcoholic La contraseña de alcohólico.
	 */
	public UserAlcoholicDTO(int id, String userAlcoholic, String passAlcoholic) {
		super();
		this.id = id;
		this.userAlcoholic = userAlcoholic;
		this.passAlcoholic = passAlcoholic;
	}

	/**
	 * Obtiene el identificador del usuario alcohólico.
	 * 
	 * @return El identificador del usuario alcohólico.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del usuario alcohólico.
	 * 
	 * @param id El identificador del usuario alcohólico.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario de alcohólico.
	 * 
	 * @return El nombre de usuario de alcohólico.
	 */
	public String getUserAlcoholic() {
		return userAlcoholic;
	}

	/**
	 * Establece el nombre de usuario de alcohólico.
	 * 
	 * @param userAlcoholic El nombre de usuario de alcohólico.
	 */
	public void setUserAlcoholic(String userAlcoholic) {
		this.userAlcoholic = userAlcoholic;
	}

	/**
	 * Obtiene la contraseña de alcohólico.
	 * 
	 * @return La contraseña de alcohólico.
	 */
	public String getPassAlcoholic() {
		return passAlcoholic;
	}

	/**
	 * Establece la contraseña de alcohólico.
	 * 
	 * @param passAlcoholic La contraseña de alcohólico.
	 */
	public void setPassAlcoholic(String passAlcoholic) {
		this.passAlcoholic = passAlcoholic;
	}

	/**
	 * Devuelve una representación en cadena del objeto UserAlcoholicDTO.
	 * 
	 * @return Una cadena que representa el objeto UserAlcoholicDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
