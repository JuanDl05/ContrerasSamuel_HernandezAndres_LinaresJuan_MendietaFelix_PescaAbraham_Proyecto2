package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserAlcoholicDTO;
import co.edu.unbosque.model.UserJanitorDTO;

public class UserJanitorDAO implements UsersCRUD{
	
	private ArrayList<UserJanitorDTO> userJanitorsList;
	private DBConnection dbcon;

	public UserJanitorDAO() {
		userJanitorsList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<UserJanitorDTO> getUserJanitorsList() {
		return userJanitorsList;
	}

	public void setUserJanitorsList(ArrayList<UserJanitorDTO> userJanitorsList) {
		this.userJanitorsList = userJanitorsList;
	}

	@Override
	public void create(Object o) {
		UserJanitorDTO newJanitors = (UserJanitorDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO userJanitor VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newJanitors.getId());
			dbcon.getPreparedstatement().setString(1, newJanitors.getUserJanitor());
			dbcon.getPreparedstatement().setString(2, newJanitors.getPassJanitor());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userJanitorsList.add(newJanitors);
		
	}

	@Override
	public void create(String... args) {
		UserJanitorDTO newJanitors = new UserJanitorDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userJanitorsList.add(newJanitors);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		userJanitorsList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM userJanitor;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("nombreusuario");
				String password = dbcon.getResultset().getString("contrasena");
				userJanitorsList.add(new UserJanitorDTO(id, user, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserJanitorDTO janitors: userJanitorsList) {
			salida += janitors.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserJanitorDTO janitors: userJanitorsList) {
			if (janitors.getUserJanitor().equals(name)) {
				salida += janitors.toString();
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
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM userJanitor WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
