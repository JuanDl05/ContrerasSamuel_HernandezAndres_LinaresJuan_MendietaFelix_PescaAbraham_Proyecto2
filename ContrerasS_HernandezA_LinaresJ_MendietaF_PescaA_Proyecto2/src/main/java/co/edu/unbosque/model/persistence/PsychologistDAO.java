/**
 * La clase PsychologistDAO implementa la interfaz CRUDoperations y proporciona
 * métodos para realizar operaciones CRUD en una fuente de datos que almacena información
 * sobre psicólogos (psychologists). Estos métodos permiten crear, leer, actualizar y eliminar registros
 * de psicólogos en la fuente de datos.
 * La clase mantiene una lista de objetos PsychologistDTO que representa a los psicólogos en memoria,
 * y utiliza una instancia de DBConnection para interactuar con la fuente de datos.
*/
package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PsychologistDTO;

public class PsychologistDAO implements CRUDoperations {

	private ArrayList<PsychologistDTO> psychologistList;
	private DBConnection dbcon;

	/**
	 * Constructor de la clase PsychologistDAO. Inicializa una lista de psicólogos y
	 * una instancia de DBConnection.
	 */
	public PsychologistDAO() {
		psychologistList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * Obtiene la lista de psicólogos.
	 * 
	 * @return La lista de psicólogos almacenada en la clase.
	 */
	public ArrayList<PsychologistDTO> getPsychologistList() {
		return psychologistList;
	}

	/**
	 * Establece la lista de psicólogos.
	 * 
	 * @param psychologistList La lista de psicólogos a establecer.
	 */
	public void setPsychologistList(ArrayList<PsychologistDTO> psychologistList) {
		this.psychologistList = psychologistList;
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de psicólogo en la fuente de datos
	 * utilizando un objeto PsychologistDTO.
	 */
	@Override
	public void create(Object o) {
		PsychologistDTO newPsycho = (PsychologistDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newPsycho.getId());
			dbcon.getPreparedstatement().setString(2, newPsycho.getName());
			dbcon.getPreparedstatement().setLong(3, newPsycho.getCc());
			dbcon.getPreparedstatement().setString(4, newPsycho.getBornDate());
			dbcon.getPreparedstatement().setString(5, newPsycho.getBornCity());
			dbcon.getPreparedstatement().setInt(6, newPsycho.getGraduationYear());
			dbcon.getPreparedstatement().setInt(7, newPsycho.getDaysOfService());
			dbcon.getPreparedstatement().setInt(8, newPsycho.getSupportedSessions());
			dbcon.getPreparedstatement().setLong(9, newPsycho.getSalary());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		psychologistList.add(newPsycho);
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de psicólogo en la fuente de datos
	 * utilizando argumentos individuales.
	 */
	@Override
	public void create(String... args) {
		PsychologistDTO newPsycho = new PsychologistDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]),
				args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]),
				Integer.parseInt(args[8]));
		dbcon.initConnection();
		psychologistList.add(newPsycho);
	}

	/**
	 * {@inheritDoc} Lee todos los registros de psicólogos en la fuente de datos y
	 * los devuelve en forma de cadena.
	 */
	@Override
	public String readAll() {
		String salida = "";
		psychologistList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String name = dbcon.getResultset().getString("nombre");
				long cc = dbcon.getResultset().getLong("cedula");
				String born = dbcon.getResultset().getString("fechanacimiento");
				String city = dbcon.getResultset().getString("ciudadnacimiento");
				int gradu = dbcon.getResultset().getInt("aniograduacion");
				int daysService = dbcon.getResultset().getInt("diasdeservicio");
				int suppSess = dbcon.getResultset().getInt("sesionesapoyadas");
				long salary = dbcon.getResultset().getLong("salario");
				psychologistList
						.add(new PsychologistDTO(id, name, cc, born, city, gradu, daysService, suppSess, salary));
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (PsychologistDTO psycho : psychologistList) {
			salida += psycho.toString();
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Lee registros de psicólogos en la fuente de datos por nombre y
	 * los devuelve en forma de cadena.
	 */
	@Override
	public String readByName(String name) {
		String salida = "";
		for (PsychologistDTO psycho : psychologistList) {
			if (psycho.getName().equals(name)) {
				salida += psycho.toString();
			}
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Actualiza un registro existente de psicólogo en la fuente de
	 * datos utilizando su identificador.
	 */
	@Override
	public int updateById(int id, String... args) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"UPDATE usuario SET id = ?, nombre = ?, nombreusuario = ?, contrasena = ? WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().setString(2, args[0]);
			dbcon.getPreparedstatement().setLong(3, Long.parseLong(args[1]));
			dbcon.getPreparedstatement().setString(4, args[2]);
			dbcon.getPreparedstatement().setString(5, args[3]);
			dbcon.getPreparedstatement().setInt(6, Integer.parseInt(args[4]));
			dbcon.getPreparedstatement().setInt(7, Integer.parseInt(args[5]));
			dbcon.getPreparedstatement().setInt(8, Integer.parseInt(args[6]));
			dbcon.getPreparedstatement().setLong(9, Long.parseLong(args[7]));
			dbcon.getPreparedstatement().setInt(10, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}

		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.get(i).setName(args[0]);
				psychologistList.get(i).setCc(Long.parseLong(args[1]));
				psychologistList.get(i).setBornDate(args[2]);
				psychologistList.get(i).setBornCity(args[3]);
				psychologistList.get(i).setGraduationYear(Integer.parseInt(args[4]));
				psychologistList.get(i).setDaysOfService(Integer.parseInt(args[5]));
				psychologistList.get(i).setSupportedSessions(Integer.parseInt(args[6]));
				psychologistList.get(i).setSalary(Long.parseLong(args[7]));
				return 0;
			}
		}
		return 1;
	}

	/**
	 * {@inheritDoc} Elimina un registro existente de psicólogo en la fuente de
	 * datos utilizando su identificador.
	 */
	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM usuario WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
