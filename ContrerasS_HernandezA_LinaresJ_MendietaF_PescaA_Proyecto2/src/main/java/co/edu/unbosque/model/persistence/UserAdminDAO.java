/**
 * La clase UserAdminDAO implementa la interfaz UsersCRUD y proporciona
 * métodos para realizar operaciones CRUD en una fuente de datos que almacena información
 * sobre usuarios administradores (administradores). Estos métodos permiten crear, leer
 * y eliminar registros de administradores en la fuente de datos.
 * La clase mantiene una lista de objetos UserAdminDTO que representa a los administradores
 * en memoria, y utiliza una instancia de DBConnection para interactuar con la fuente de datos.
*/
package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserAdminDTO;

public class UserAdminDAO implements UsersCRUD {

	private ArrayList<UserAdminDTO> userAdminList;
	private DBConnection dbcon;

	/**
	 * Constructor de la clase UserAdminDAO. Inicializa una lista de administradores
	 * y una instancia de DBConnection.
	 */
	public UserAdminDAO() {
		userAdminList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * Obtiene la lista de administradores.
	 * 
	 * @return La lista de administradores almacenada en la clase.
	 */
	public ArrayList<UserAdminDTO> getUserAdminList() {
		return userAdminList;
	}

	/**
	 * Establece la lista de administradores.
	 * 
	 * @param userAdminList La lista de administradores a establecer.
	 */
	public void setUserAdminList(ArrayList<UserAdminDTO> userAdminList) {
		this.userAdminList = userAdminList;
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de administrador en la fuente de datos
	 * utilizando un objeto UserAdminDTO.
	 */
	@Override
	public void create(Object o) {
		UserAdminDTO newAdmin = (UserAdminDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newAdmin.getId());
			dbcon.getPreparedstatement().setString(1, newAdmin.getUserAdmin());
			dbcon.getPreparedstatement().setString(2, newAdmin.getPassAdmin());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		userAdminList.add(newAdmin);
	}

	/**
	 * {@inheritDoc} Crea un nuevo registro de administrador en la fuente de datos
	 * utilizando argumentos individuales.
	 */
	@Override
	public void create(String... args) {
		UserAdminDTO newAdmin = new UserAdminDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userAdminList.add(newAdmin);
	}

	/**
	 * {@inheritDoc} Lee todos los registros de administradores en la fuente de
	 * datos y los devuelve en forma de cadena.
	 */
	@Override
	public String readAll() {
		String salida = "";
		userAdminList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userAdminList.add(new UserAdminDTO(id, user, password));
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
		}
		for (UserAdminDTO admins : userAdminList) {
			salida += admins.toString();
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Lee registros de administradores en la fuente de datos por
	 * nombre de usuario y los devuelve en forma de cadena.
	 */
	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserAdminDTO admins : userAdminList) {
			if (admins.getUserAdmin().equals(name)) {
				salida += admins.toString();
			}
		}
		return salida;
	}

	/**
	 * {@inheritDoc} Actualiza un registro existente de administrador en la fuente
	 * de datos utilizando su identificador. En esta implementación, este método no
	 * se ha implementado y devuelve siempre 0.
	 */
	@Override
	public int updateById(int id, String... args) {
		// Este método no se ha implementado en esta clase
		return 0;
	}

	/**
	 * {@inheritDoc} Elimina un registro existente de administrador en la fuente de
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
		for (int i = 0; i < userAdminList.size(); i++) {
			if (userAdminList.get(i).getId() == id) {
				userAdminList.remove(i);
				return 0;
			}
		}
		return 1;
	}
}
