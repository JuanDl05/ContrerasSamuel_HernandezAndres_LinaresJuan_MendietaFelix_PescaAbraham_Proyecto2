/**
 * La clase PsychologistDTO representa a un psicólogo y hereda los atributos básicos
 * de una persona de la clase PersonDTO. Además, contiene atributos específicos
 * para el psicólogo, como el año de graduación (graduationYear), días de servicio
 * (daysOfService), sesiones apoyadas (supportedSessions) y salario (salary).
 * Esta clase proporciona constructores para crear objetos PsychologistDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

import java.util.Date;

public class PsychologistDTO extends PersonDTO {

	private int graduationYear;
	private int daysOfService;
	private int supportedSessions;
	private long salary;

	/**
	 * Constructor por defecto de la clase PsychologistDTO.
	 */
	public PsychologistDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos graduationYear,
	 * daysOfService, supportedSessions y salary de un objeto PsychologistDTO.
	 * 
	 * @param graduationYear    El año de graduación del psicólogo.
	 * @param daysOfService     El número de días de servicio del psicólogo.
	 * @param supportedSessions El número de sesiones apoyadas por el psicólogo.
	 * @param salary            El salario del psicólogo.
	 */
	public PsychologistDTO(int graduationYear, int daysOfService, int supportedSessions, long salary) {
		super();
		this.graduationYear = graduationYear;
		this.daysOfService = daysOfService;
		this.supportedSessions = supportedSessions;
		this.salary = salary;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de un objeto
	 * PsychologistDTO, incluyendo los heredados de la clase PersonDTO.
	 * 
	 * @param id                El identificador del psicólogo.
	 * @param name              El nombre del psicólogo.
	 * @param cc                El número de cédula del psicólogo.
	 * @param bornDate          La fecha de nacimiento del psicólogo.
	 * @param bornCity          La ciudad de nacimiento del psicólogo.
	 * @param graduationYear    El año de graduación del psicólogo.
	 * @param daysOfService     El número de días de servicio del psicólogo.
	 * @param supportedSessions El número de sesiones apoyadas por el psicólogo.
	 * @param salary            El salario del psicólogo.
	 */
	public PsychologistDTO(int id, String name, long cc, String bornDate, String bornCity, int graduationYear,
			int daysOfService, int supportedSessions, long salary) {
		super(id, name, cc, bornDate, bornCity);
		this.graduationYear = graduationYear;
		this.daysOfService = daysOfService;
		this.supportedSessions = supportedSessions;
		this.salary = salary;
	}

	/**
	 * Constructor que permite inicializar los atributos heredados de la clase
	 * PersonDTO de un objeto PsychologistDTO.
	 * 
	 * @param id       El identificador del psicólogo.
	 * @param name     El nombre del psicólogo.
	 * @param cc       El número de cédula del psicólogo.
	 * @param bornDate La fecha de nacimiento del psicólogo.
	 * @param bornCity La ciudad de nacimiento del psicólogo.
	 */
	public PsychologistDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el año de graduación del psicólogo.
	 * 
	 * @return El año de graduación del psicólogo.
	 */
	public int getGraduationYear() {
		return graduationYear;
	}

	/**
	 * Establece el año de graduación del psicólogo.
	 * 
	 * @param graduationYear El año de graduación del psicólogo.
	 */
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	/**
	 * Obtiene el número de días de servicio del psicólogo.
	 * 
	 * @return El número de días de servicio del psicólogo.
	 */
	public int getDaysOfService() {
		return daysOfService;
	}

	/**
	 * Establece el número de días de servicio del psicólogo.
	 * 
	 * @param daysOfService El número de días de servicio del psicólogo.
	 */
	public void setDaysOfService(int daysOfService) {
		this.daysOfService = daysOfService;
	}

	/**
	 * Obtiene el número de sesiones apoyadas por el psicólogo.
	 * 
	 * @return El número de sesiones apoyadas por el psicólogo.
	 */
	public int getSupportedSessions() {
		return supportedSessions;
	}

	/**
	 * Establece el número de sesiones apoyadas por el psicólogo.
	 * 
	 * @param supportedSessions El número de sesiones apoyadas por el psicólogo.
	 */
	public void setSupportedSessions(int supportedSessions) {
		this.supportedSessions = supportedSessions;
	}

	/**
	 * Obtiene el salario del psicólogo.
	 * 
	 * @return El salario del psicólogo.
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * Establece el salario del psicólogo.
	 * 
	 * @param salary El salario del psicólogo.
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}

	/**
	 * Devuelve una representación en cadena del objeto PsychologistDTO.
	 * 
	 * @return Una cadena que representa el objeto PsychologistDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
