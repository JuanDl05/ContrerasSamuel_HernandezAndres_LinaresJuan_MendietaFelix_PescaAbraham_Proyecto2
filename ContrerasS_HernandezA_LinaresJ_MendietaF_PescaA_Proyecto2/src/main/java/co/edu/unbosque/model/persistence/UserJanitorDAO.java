/**
 * La clase UserJanitorDAO implementa la interfaz UsersCRUD y proporciona
 * métodos para realizar operaciones CRUD en una fuente de datos que almacena información
 * sobre usuarios con roles de conserje o personal de limpieza. Estos métodos permiten
 * crear, leer y eliminar registros de usuarios con roles de conserje en la fuente de datos.
 * La clase mantiene una lista de objetos UserJanitorDTO que representa a los usuarios
 * con roles de conserje en memoria y utiliza una instancia de DBConnection para interactuar con la fuente
 * de datos.
*/
package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserJanitorDTO;

public class UserJanitorDAO implements UsersCRUD {

	private ArrayList<UserJanitorDTO> userJanitorsList;
	private DBConnection dbcon;

	/**
	 * Constructor de la clase UserJanitorDAO. Inicializa una lista de usuarios con
	 * roles de conserje y una instancia de DBConnection.
	 */
	public UserJanitorDAO() {
		userJanitorsList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * Obtiene la lista de usuarios con roles de conserje.
	 * 
	 * @return La lista de usuarios con roles de conserje almacenada en la clase.
	 */
	public ArrayList<UserJanitorDTO> getUserJanitorsList() {
		return userJanitorsList;
	}

	/**
	 * Establece la lista de usuarios con roles de conserje.
	 * 
	 * @param userJanitorsList La lista de usuarios con roles de conserje a
	 *                         establecer.
	 */
	public void setUserJanitorsList(ArrayList<UserJanitorDTO> userJanitorsList) {
		this.userJanitorsList = userJanitorsList;
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario con rol de conserje en la
	 * fuente de datos utilizando un objeto UserJanitorDTO.
	 */
	@Override
	public void create(Object o) {
		UserJanitorDTO newJanitors = (UserJanitorDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newJanitors.getId());
			dbcon.getPreparedstatement().setString(1, newJanitors.getUserJanitor());
			dbcon.getPreparedstatement().setString(2, newJanitors.getPassJanitor());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		userJanitorsList.add(newJanitors);
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario con rol de conserje en la
	 * fuente de datos utilizando argumentos individuales.
	 */
	@Override
	public void create(String... args) {
		UserJanitorDTO newJanitors = new UserJanitorDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userJanitorsList.add(newJanitors);
	}

	/**
	 * {@inheritDoc} Lee todos los registros de usuarios con roles de conserje en la
	 * fuente de datos y los devuelve en forma de cadena.
	 */
	@Override
	public String readAll() {
		String salida = "";
		userJanitorsList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userJanitorsList.add(new UserJanitorDTO(id, user, password));
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (UserJanitorDTO janitors : userJanitorsList) {
			salida += janitors.toString();
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Lee registros de usuarios con roles de conserje en la fuente de
	 * datos por nombre de usuario y los devuelve en forma de cadena.
	 */
	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserJanitorDTO janitors : userJanitorsList) {
			if (janitors.getUserJanitor().equals(name)) {
				salida += janitors.toString();
			}
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Actualiza un registro existente de usuario con rol de conserje
	 * en la fuente de datos utilizando su identificador. En esta implementación,
	 * este método no se ha implementado y devuelve siempre 0.
	 */
	@Override
	public int updateById(int id, String... args) {
		// Este método no se ha implementado en esta clase
		return 0;
	}

	/**
	 * {@inheritDoc} Elimina un registro existente de usuario con rol de conserje en
	 * la fuente de datos utilizando su identificador.
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
		for (int i = 0; i < userJanitorsList.size(); i++) {
			if (userJanitorsList.get(i).getId() == id) {
				userJanitorsList.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
