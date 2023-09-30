package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserAdminDTO;
import co.edu.unbosque.model.UserAlcoholicDTO;

public class UserAdminDAO implements UsersCRUD{
	
	private ArrayList<UserAdminDTO> userAdminList;
	private DBConnection dbcon;
	
	public UserAdminDAO() {
		userAdminList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<UserAdminDTO> getUserAdminList() {
		return userAdminList;
	}

	public void setUserAdminList(ArrayList<UserAdminDTO> userAdminList) {
		this.userAdminList = userAdminList;
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userAdminList.add(newAdmin);
		
	}

	@Override
	public void create(String... args) {
		UserAdminDTO newAdmin = new UserAdminDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userAdminList.add(newAdmin);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		userAdminList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userAdminList.add(new UserAdminDTO(id, user, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserAdminDTO admins: userAdminList) {
			salida += admins.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserAdminDTO admins: userAdminList) {
			if (admins.getUserAdmin().equals(name)) {
				salida += admins.toString();
			}
		}
		return salida;
	}

	@Override
	public int updateById(int id, String... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM usuario WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
