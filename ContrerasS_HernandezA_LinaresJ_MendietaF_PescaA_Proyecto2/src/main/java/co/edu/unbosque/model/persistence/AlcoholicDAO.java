package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.PersonDTO;

public class AlcoholicDAO implements CRUDoperations{
	
	private ArrayList<AlcoholicDTO> alcoholicList;
	private DBConnection dbcon;
	
	public AlcoholicDAO() {
		alcoholicList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<AlcoholicDTO> getAlcoholicList() {
		return alcoholicList;
	}

	public void setAlcoholicList(ArrayList<AlcoholicDTO> alcoholicList) {
		this.alcoholicList = alcoholicList;
	}

	@Override
	public void create(Object o) {
		AlcoholicDTO newAlcoholic = (AlcoholicDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newAlcoholic.getId());
			dbcon.getPreparedstatement().setString(2, newAlcoholic.getName());
			dbcon.getPreparedstatement().setLong(3, newAlcoholic.getCc());
			dbcon.getPreparedstatement().setString(4, newAlcoholic.getBornDate());
			dbcon.getPreparedstatement().setString(5, newAlcoholic.getBornCity());
			dbcon.getPreparedstatement().setInt(6, newAlcoholic.getVisitedSessions());
			dbcon.getPreparedstatement().setString(7, newAlcoholic.getNickname());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alcoholicList.add(newAlcoholic);
		
	}

	@Override
	public void create(String... args) {
		AlcoholicDTO newAlcoholic = new AlcoholicDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), args[3], args[4], Integer.parseInt(args[5]), args[6]);
		dbcon.initConnection();
		alcoholicList.add(newAlcoholic);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		alcoholicList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String name = dbcon.getResultset().getString("nombre");
				long cc = dbcon.getResultset().getLong("cedula");
				String born = dbcon.getResultset().getString("fechanacimiento");
				String city = dbcon.getResultset().getString("ciudadnacimiento");
				int visited = dbcon.getResultset().getInt("sesionesvisitadas");
				String nick = dbcon.getResultset().getString("apodo");
				alcoholicList.add(new AlcoholicDTO(id, name, cc, born, city, visited, nick));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (AlcoholicDTO alcoholic : alcoholicList) {
			salida += alcoholic.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (AlcoholicDTO alcoholic: alcoholicList) {
			if (alcoholic.getName().equals(name)) {
				salida += alcoholic.toString();
			}
		}
		return salida;
	}

	@Override
	public int updateById(int id, String... args) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE usuario SET id = ?, nombre = ?, nombreusuario = ?, contrasena = ? WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().setString(2, args[0]);
			dbcon.getPreparedstatement().setLong(3, Long.parseLong(args[1]));
			dbcon.getPreparedstatement().setString(4, args[2]);
			dbcon.getPreparedstatement().setString(5, args[3]);
			dbcon.getPreparedstatement().setInt(6, Integer.parseInt(args[4]));
			dbcon.getPreparedstatement().setString(7, args[5]);
			dbcon.getPreparedstatement().setInt(8, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < alcoholicList.size(); i++) {
			if (alcoholicList.get(i).getId() == id) {
				alcoholicList.get(i).setName(args[0]);
				alcoholicList.get(i).setCc(Long.parseLong(args[1]));
				alcoholicList.get(i).setBornDate(args[2]);
				alcoholicList.get(i).setBornCity(args[3]);
				alcoholicList.get(i).setVisitedSessions(Integer.parseInt(args[4]));
				alcoholicList.get(i).setNickname(args[5]);
				return 0;
			}
		}
		return 1;
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
		for (int i = 0; i < alcoholicList.size(); i++) {
			if (alcoholicList.get(i).getId() == id) {
				alcoholicList.remove(i);
				return 0;
			}
		}
		return 1;
	}
	

}
