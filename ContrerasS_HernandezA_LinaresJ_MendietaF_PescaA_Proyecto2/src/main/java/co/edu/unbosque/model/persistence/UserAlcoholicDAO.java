/**
 * La clase UserAlcoholicDAO implementa la interfaz UsersCRUD y proporciona
 * métodos para realizar operaciones CRUD en una fuente de datos que almacena información
 * sobre usuarios alcohólicos. Estos métodos permiten crear, leer y eliminar registros
 * de usuarios alcohólicos en la fuente de datos.
 * La clase mantiene una lista de objetos UserAlcoholicDTO que representa a los usuarios
 * alcohólicos en memoria, y utiliza una instancia de DBConnection para interactuar con la fuente
 * de datos.
*/
package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserAlcoholicDTO;

public class UserAlcoholicDAO implements UsersCRUD {

	private ArrayList<UserAlcoholicDTO> userAlcoholicsList;
	private DBConnection dbcon;

	/**
	 * Constructor de la clase UserAlcoholicDAO. Inicializa una lista de usuarios
	 * alcohólicos y una instancia de DBConnection.
	 */
	public UserAlcoholicDAO() {
		userAlcoholicsList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * Obtiene la lista de usuarios alcohólicos.
	 * 
	 * @return La lista de usuarios alcohólicos almacenada en la clase.
	 */
	public ArrayList<UserAlcoholicDTO> getUserAlcoholicsList() {
		return userAlcoholicsList;
	}

	/**
	 * Establece la lista de usuarios alcohólicos.
	 * 
	 * @param userAlcoholicsList La lista de usuarios alcohólicos a establecer.
	 */
	public void setUserAlcoholicsList(ArrayList<UserAlcoholicDTO> userAlcoholicsList) {
		this.userAlcoholicsList = userAlcoholicsList;
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario alcohólico en la fuente de
	 * datos utilizando un objeto UserAlcoholicDTO.
	 */
	@Override
	public void create(Object o) {
		UserAlcoholicDTO newAlcoholics = (UserAlcoholicDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newAlcoholics.getId());
			dbcon.getPreparedstatement().setString(1, newAlcoholics.getUserAlcoholic());
			dbcon.getPreparedstatement().setString(2, newAlcoholics.getPassAlcoholic());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		userAlcoholicsList.add(newAlcoholics);
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario alcohólico en la fuente de
	 * datos utilizando argumentos individuales.
	 */
	@Override
	public void create(String... args) {
		UserAlcoholicDTO newAlcoholics = new UserAlcoholicDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userAlcoholicsList.add(newAlcoholics);
	}

	/**
	 * {@inheritDoc} Lee todos los registros de usuarios alcohólicos en la fuente de
	 * datos y los devuelve en forma de cadena.
	 */
	@Override
	public String readAll() {
		String salida = "";
		userAlcoholicsList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userAlcoholicsList.add(new UserAlcoholicDTO(id, user, password));
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (UserAlcoholicDTO alcoholics : userAlcoholicsList) {
			salida += alcoholics.toString();
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Lee registros de usuarios alcohólicos en la fuente de datos por
	 * nombre de usuario y los devuelve en forma de cadena.
	 */
	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserAlcoholicDTO alcoholics : userAlcoholicsList) {
			if (alcoholics.getUserAlcoholic().equals(name)) {
				salida += alcoholics.toString();
			}
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Actualiza un registro existente de usuario alcohólico en la
	 * fuente de datos utilizando su identificador. En esta implementación, este
	 * método no se ha implementado y devuelve siempre 0.
	 */
	@Override
	public int updateById(int id, String... args) {
		// Este método no se ha implementado en esta clase
		return 0;
	}

	/**
	 * {@inheritDoc} Elimina un registro existente de usuario alcohólico en la
	 * fuente de datos utilizando su identificador.
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
		for (int i = 0; i < userAlcoholicsList.size(); i++) {
			if (userAlcoholicsList.get(i).getId() == id) {
				userAlcoholicsList.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
