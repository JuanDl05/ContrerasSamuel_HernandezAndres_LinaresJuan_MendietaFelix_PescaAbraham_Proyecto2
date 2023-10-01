package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.UserAlcoholicDTO;

public class UserAlcoholicDAO implements UsersCRUD{
	
	private ArrayList<UserAlcoholicDTO> userAlcoholicsList;
	private DBConnection dbcon;
	
	public UserAlcoholicDAO() {
		userAlcoholicsList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<UserAlcoholicDTO> getUserAlcoholicsList() {
		return userAlcoholicsList;
	}

	public void setUserAlcoholicsList(ArrayList<UserAlcoholicDTO> userAlcoholicsList) {
		this.userAlcoholicsList = userAlcoholicsList;
	}

	@Override
	public void create(Object o) {
		UserAlcoholicDTO newAlcoholics = (UserAlcoholicDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO userAlcoholic VALUES(?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newAlcoholics.getId());
			dbcon.getPreparedstatement().setString(1, newAlcoholics.getUserAlcoholic());
			dbcon.getPreparedstatement().setString(2, newAlcoholics.getPassAlcoholic());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userAlcoholicsList.add(newAlcoholics);
		
	}

	@Override
	public void create(String... args) {
		UserAlcoholicDTO newAlcoholics = new UserAlcoholicDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userAlcoholicsList.add(newAlcoholics);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		userAlcoholicsList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM userAlcoholic;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("nombreusuario");
				String password = dbcon.getResultset().getString("contrasena");
				userAlcoholicsList.add(new UserAlcoholicDTO(id, user, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserAlcoholicDTO alcoholics: userAlcoholicsList) {
			salida += alcoholics.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserAlcoholicDTO alcoholics: userAlcoholicsList) {
			if (alcoholics.getUserAlcoholic().equals(name)) {
				salida += alcoholics.toString();
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
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM userAlcoholic WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
