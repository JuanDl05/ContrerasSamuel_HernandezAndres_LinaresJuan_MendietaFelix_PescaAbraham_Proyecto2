/*
 * La clase AlcoholicDTO representa a un individuo que es un alcohólico y hereda
 * los atributos básicos de una persona de la clase PersonDTO. Además, contiene
 * atributos específicos para el alcohólico, como el número de sesiones visitadas
 * y un apodo (nickname).
 * Esta clase proporciona constructores para crear objetos AlcoholicDTO con diferentes
 * conjuntos de atributos, así como getters y setters para acceder a estos atributos.
*/
package co.edu.unbosque.model;

import java.util.Date;

public class AlcoholicDTO extends PersonDTO {

	private int visitedSessions;
	private String nickname;

	/*
	 * Constructor por defecto de la clase AlcoholicDTO.
	 */
	public AlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que permite inicializar los atributos visitedSessions y nickname
	 * de un objeto AlcoholicDTO.
	 * 
	 * @param visitedSessions El número de sesiones visitadas por el alcohólico.
	 * @param nickname        El apodo del alcohólico.
	 */
	public AlcoholicDTO(int visitedSessions, String nickname) {
		super();
		this.visitedSessions = visitedSessions;
		this.nickname = nickname;
	}

	/**
	 * Constructor que permite inicializar todos los atributos de un objeto
	 * AlcoholicDTO, incluyendo los heredados de la clase PersonDTO.
	 * 
	 * @param id              El identificador del alcohólico.
	 * @param name            El nombre del alcohólico.
	 * @param cc              El número de cédula del alcohólico.
	 * @param bornDate        La fecha de nacimiento del alcohólico.
	 * @param bornCity        La ciudad de nacimiento del alcohólico.
	 * @param visitedSessions El número de sesiones visitadas por el alcohólico.
	 * @param nickname        El apodo del alcohólico.
	 */
	public AlcoholicDTO(int id, String name, long cc, String bornDate, String bornCity, int visitedSessions,
			String nickname) {
		super(id, name, cc, bornDate, bornCity);
		this.visitedSessions = visitedSessions;
		this.nickname = nickname;
	}

	/**
	 * Constructor que permite inicializar los atributos heredados de la clase
	 * PersonDTO de un objeto AlcoholicDTO.
	 * 
	 * @param id       El identificador del alcohólico.
	 * @param name     El nombre del alcohólico.
	 * @param cc       El número de cédula del alcohólico.
	 * @param bornDate La fecha de nacimiento del alcohólico.
	 * @param bornCity La ciudad de nacimiento del alcohólico.
	 */
	public AlcoholicDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el número de sesiones visitadas por el alcohólico.
	 * 
	 * @return El número de sesiones visitadas.
	 */
	public int getVisitedSessions() {
		return visitedSessions;
	}

	/**
	 * Establece el número de sesiones visitadas por el alcohólico.
	 * 
	 * @param visitedSessions El número de sesiones visitadas.
	 */
	public void setVisitedSessions(int visitedSessions) {
		this.visitedSessions = visitedSessions;
	}

	/**
	 * Obtiene el apodo del alcohólico.
	 * 
	 * @return El apodo del alcohólico.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Establece el apodo del alcohólico.
	 * 
	 * @param nickname El apodo del alcohólico.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Devuelve una representación en cadena del objeto AlcoholicDTO.
	 * 
	 * @return Una cadena que representa el objeto AlcoholicDTO.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
