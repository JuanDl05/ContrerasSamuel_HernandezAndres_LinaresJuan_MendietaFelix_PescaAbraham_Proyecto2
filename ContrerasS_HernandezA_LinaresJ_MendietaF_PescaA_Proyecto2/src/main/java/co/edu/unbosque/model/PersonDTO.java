/**
 * La clase PersonDTO representa a una persona y contiene atributos básicos
 * como el identificador (id), nombre (name), número de cédula (cc), fecha de nacimiento
 * (bornDate) y ciudad de nacimiento (bornCity).
 * Esta clase proporciona constructores para crear objetos PersonDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
 * 
*/
package co.edu.unbosque.model;

import java.util.Date;

public class PersonDTO {

	private int id;
	private String name;
	private long cc;
	private String bornDate;
	private String bornCity;

	/**
	 * Constructor por defecto de la clase PersonDTO.
	 */
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar todos los atributos de un objeto
	 * PersonDTO.
	 * 
	 * @param id       El identificador de la persona.
	 * @param name     El nombre de la persona.
	 * @param cc       El número de cédula de la persona.
	 * @param bornDate La fecha de nacimiento de la persona.
	 * @param bornCity La ciudad de nacimiento de la persona.
	 */
	public PersonDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super();
		this.id = id;
		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
		this.bornCity = bornCity;
	}

	/**
	 * Obtiene el identificador de la persona.
	 * 
	 * @return El identificador de la persona.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador de la persona.
	 * 
	 * @param id El identificador de la persona.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * 
	 * @return El nombre de la persona.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre de la persona.
	 * 
	 * @param name El nombre de la persona.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el número de cédula de la persona.
	 * 
	 * @return El número de cédula de la persona.
	 */
	public long getCc() {
		return cc;
	}

	/**
	 * Establece el número de cédula de la persona.
	 * 
	 * @param cc El número de cédula de la persona.
	 */
	public void setCc(long cc) {
		this.cc = cc;
	}

	/**
	 * Obtiene la fecha de nacimiento de la persona.
	 * 
	 * @return La fecha de nacimiento de la persona.
	 */
	public String getBornDate() {
		return bornDate;
	}

	/**
	 * Establece la fecha de nacimiento de la persona.
	 * 
	 * @param bornDate La fecha de nacimiento de la persona.
	 */
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * Obtiene la ciudad de nacimiento de la persona.
	 * 
	 * @return La ciudad de nacimiento de la persona.
	 */
	public String getBornCity() {
		return bornCity;
	}

	/**
	 * Establece la ciudad de nacimiento de la persona.
	 * 
	 * @param bornCity La ciudad de nacimiento de la persona.
	 */
	public void setBornCity(String bornCity) {
		this.bornCity = bornCity;
	}

	/**
	 * Devuelve una representación en cadena del objeto PersonDTO.
	 * 
	 * @return Una cadena que representa el objeto PersonDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
