package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserAlcoholicDTO;
import co.edu.unbosque.model.UserPsychoDTO;

public class UserPsychoDAO implements UsersCRUD{

	private ArrayList<UserPsychoDTO> userPsychosList;
	private DBConnection dbcon;
	
	public UserPsychoDAO() {
		userPsychosList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<UserPsychoDTO> getUserPsychosList() {
		return userPsychosList;
	}

	public void setUserPsychosList(ArrayList<UserPsychoDTO> userPsychosList) {
		this.userPsychosList = userPsychosList;
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userPsychosList.add(newPsychos);
		
	}

	@Override
	public void create(String... args) {
		UserPsychoDTO newPsychos = new UserPsychoDTO(Integer.parseInt(args[0]), args[1], args[2]);
		dbcon.initConnection();
		userPsychosList.add(newPsychos);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		userPsychosList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String user = dbcon.getResultset().getString("usuario");
				String password = dbcon.getResultset().getString("contrasena");
				userPsychosList.add(new UserPsychoDTO(id, user, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (UserPsychoDTO psychos: userPsychosList) {
			salida += psychos.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (UserPsychoDTO psychos: userPsychosList) {
			if (psychos.getUserPsycho().equals(name)) {
				salida += psychos.toString();
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
		for (int i = 0; i < userPsychosList.size(); i++) {
			if (userPsychosList.get(i).getId() == id) {
				userPsychosList.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
}
