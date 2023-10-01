/**
 * La clase JanitorDTO representa a un conserje y hereda los atributos básicos
 * de una persona de la clase PersonDTO. Además, contiene atributos específicos
 * para el conserje, como el salario y el número de sesiones limpiadas (cleanedSessions).
 * 
 * Esta clase proporciona constructores para crear objetos JanitorDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
 * 
*/
package co.edu.unbosque.model;

import java.util.Date;

public class JanitorDTO extends PersonDTO {

	private long salary;
	private int cleanedSessions;

	/**
	 * Constructor por defecto de la clase JanitorDTO.
	 */
	public JanitorDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos salary y cleanedSessions de
	 * un objeto JanitorDTO.
	 * 
	 * @param salary          El salario del conserje.
	 * @param cleanedSessions El número de sesiones limpiadas por el conserje.
	 */
	public JanitorDTO(long salary, int cleanedSessions) {
		super();
		this.salary = salary;
		this.cleanedSessions = cleanedSessions;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de un objeto
	 * JanitorDTO, incluyendo los heredados de la clase PersonDTO.
	 * 
	 * @param id              El identificador del conserje.
	 * @param name            El nombre del conserje.
	 * @param cc              El número de cédula del conserje.
	 * @param bornDate        La fecha de nacimiento del conserje.
	 * @param bornCity        La ciudad de nacimiento del conserje.
	 * @param salary          El salario del conserje.
	 * @param cleanedSessions El número de sesiones limpiadas por el conserje.
	 */
	public JanitorDTO(int id, String name, long cc, String bornDate, String bornCity, long salary,
			int cleanedSessions) {
		super(id, name, cc, bornDate, bornCity);
		this.salary = salary;
		this.cleanedSessions = cleanedSessions;
	}

	/**
	 * Constructor que permite inicializar los atributos heredados de la clase
	 * PersonDTO de un objeto JanitorDTO.
	 * 
	 * @param id       El identificador del conserje.
	 * @param name     El nombre del conserje.
	 * @param cc       El número de cédula del conserje.
	 * @param bornDate La fecha de nacimiento del conserje.
	 * @param bornCity La ciudad de nacimiento del conserje.
	 */
	public JanitorDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el salario del conserje.
	 * 
	 * @return El salario del conserje.
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * Establece el salario del conserje.
	 * 
	 * @param salary El salario del conserje.
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}

	/**
	 * Obtiene el número de sesiones limpiadas por el conserje.
	 * 
	 * @return El número de sesiones limpiadas.
	 */
	public int getCleanedSessions() {
		return cleanedSessions;
	}

	/**
	 * Establece el número de sesiones limpiadas por el conserje.
	 * 
	 * @param cleanedSessions El número de sesiones limpiadas.
	 */
	public void setCleanedSessions(int cleanedSessions) {
		this.cleanedSessions = cleanedSessions;
	}

	/**
	 * Devuelve una representación en cadena del objeto JanitorDTO.
	 * 
	 * @return Una cadena que representa el objeto JanitorDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
