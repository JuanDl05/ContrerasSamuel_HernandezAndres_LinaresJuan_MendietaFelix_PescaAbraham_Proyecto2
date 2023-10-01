/**
 * La clase UserAdminDTO representa a un usuario administrador y contiene
 * atributos como el identificador (id), nombre de usuario de administrador
 * (userAdmin) y contraseña de administrador (passAdmin).
 * Esta clase proporciona constructores para crear objetos UserAdminDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

public class UserAdminDTO {

	private int id;
	private String userAdmin;
	private String passAdmin;

	/**
	 * Constructor por defecto de la clase UserAdminDTO.
	 */
	public UserAdminDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos id, userAdmin y passAdmin
	 * de un objeto UserAdminDTO.
	 * 
	 * @param id        El identificador del usuario administrador.
	 * @param userAdmin El nombre de usuario de administrador.
	 * @param passAdmin La contraseña de administrador.
	 */
	public UserAdminDTO(int id, String userAdmin, String passAdmin) {
		super();
		this.id = id;
		this.userAdmin = userAdmin;
		this.passAdmin = passAdmin;
	}

	/**
	 * Obtiene el identificador del usuario administrador.
	 * 
	 * @return El identificador del usuario administrador.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del usuario administrador.
	 * 
	 * @param id El identificador del usuario administrador.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario de administrador.
	 * 
	 * @return El nombre de usuario de administrador.
	 */
	public String getUserAdmin() {
		return userAdmin;
	}

	/**
	 * Establece el nombre de usuario de administrador.
	 * 
	 * @param userAdmin El nombre de usuario de administrador.
	 */
	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	/**
	 * Obtiene la contraseña de administrador.
	 * 
	 * @return La contraseña de administrador.
	 */
	public String getPassAdmin() {
		return passAdmin;
	}

	/**
	 * Establece la contraseña de administrador.
	 * 
	 * @param passAdmin La contraseña de administrador.
	 */
	public void setPassAdmin(String passAdmin) {
		this.passAdmin = passAdmin;
	}

	/**
	 * Devuelve una representación en cadena del objeto UserAdminDTO.
	 * 
	 * @return Una cadena que representa el objeto UserAdminDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
