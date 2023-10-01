/**
 * La clase UserPsychoDAO implementa la interfaz UsersCRUD y proporciona
 * métodos para realizar operaciones CRUD en una fuente de datos que almacena información
 * sobre usuarios con roles de psicólogo. Estos métodos permiten
 * crear, leer y eliminar registros de usuarios con roles de psicólogo en la fuente de datos.
 * La clase mantiene una lista de objetos UserPsychoDTO que representa a los usuarios
 * con roles de psicólogo en memoria y utiliza una instancia de DBConnection para interactuar con la fuente
 * de datos.
*/
package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserPsychoDTO;

public class UserPsychoDAO implements UsersCRUD {

	private ArrayList<UserPsychoDTO> userPsychosList;
	private DBConnection dbcon;

	/**
	 * Constructor de la clase UserPsychoDAO. Inicializa una lista de usuarios con
	 * roles de psicólogo y una instancia de DBConnection.
	 */
	public UserPsychoDAO() {
		userPsychosList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * Obtiene la lista de usuarios con roles de psicólogo.
	 * 
	 * @return La lista de usuarios con roles de psicólogo almacenada en la clase.
	 */
	public ArrayList<UserPsychoDTO> getUserPsychosList() {
		return userPsychosList;
	}

	/**
	 * Establece la lista de usuarios con roles de psicólogo.
	 * 
	 * @param userPsychosList La lista de usuarios con roles de psicólogo a
	 * establecer.
	 */
	public void setUserPsychosList(ArrayList<UserPsychoDTO> userPsychosList) {
		this.userPsychosList = userPsychosList;
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario con rol de psicólogo en la
	 * fuente de datos utilizando un objeto UserPsychoDTO.
	 */
	@Override
	public void create(Object o) {
		UserPsychoDTO newPsychos = (UserPsychoDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newPsychos.getId());
			dbcon.getPreparedstatement().setString(1, newPsychos.getUserPsycho());
			dbcon.getPreparedstatement().setString(2, newPsychos.getPassPsycho());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		userPsychosList.add(newPsychos);
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de usuario con rol de psicólogo en la
	 * fuente de datos utilizando argumentos individuales.
	 */
	@Override
	public void create(String... args) {
		UserPsychoDTO newPsychos = new UserPsychoDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userPsychosList.add(newPsychos);
	}

	/**
	 * {@inheritDoc} Lee todos los registros de usuarios con roles de psicólogo en
	 * la fuente de datos y los devuelve en forma de cadena.
	 */
	@Override
	public String readAll() {
		String salida = "";
		userPsychosList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userPsychosList.add(new UserPsychoDTO(id, user, password));
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (UserPsychoDTO psychos : userPsychosList) {
			salida += psychos.toString();
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Lee registros de usuarios con roles de psicólogo en la fuente
	 * de datos por nombre de usuario y los devuelve en forma de cadena.
	 */
	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserPsychoDTO psychos : userPsychosList) {
			if (psychos.getUserPsycho().equals(name)) {
				salida += psychos.toString();
			}
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Actualiza un registro existente de usuario con rol de psicólogo
	 * en la fuente de datos utilizando su identificador. En esta implementación,
	 * este método no se ha implementado y devuelve siempre 0.
	 */
	@Override
	public int updateById(int id, String... args) {
		// Este método no se ha implementado en esta clase
		return 0;
	}

	/**
	 * {@inheritDoc} Elimina un registro existente de usuario con rol de psicólogo
	 * en la fuente de datos utilizando su identificador.
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
		for (int i = 0; i < userPsychosList.size(); i++) {
			if (userPsychosList.get(i).getId() == id) {
				userPsychosList.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
