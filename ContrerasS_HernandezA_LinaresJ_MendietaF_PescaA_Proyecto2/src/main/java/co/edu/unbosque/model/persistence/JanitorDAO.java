package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.JanitorDTO;
import co.edu.unbosque.model.PersonDTO;

public class JanitorDAO implements CRUDoperations{
	
	private ArrayList<JanitorDTO> janitorList;
	private DBConnection dbcon;
	
	public JanitorDAO() {
		janitorList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<JanitorDTO> getJanitorList() {
		return janitorList;
	}

	public void setJanitorList(ArrayList<JanitorDTO> janitorList) {
		this.janitorList = janitorList;
	}

	@Override
	public void create(Object o) {
		JanitorDTO newPerson = (JanitorDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?, ?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newPerson.getId());
			dbcon.getPreparedstatement().setString(2, newPerson.getName());
			dbcon.getPreparedstatement().setLong(3, newPerson.getCc());
			dbcon.getPreparedstatement().setString(4, newPerson.getBornDate());
			dbcon.getPreparedstatement().setString(5, newPerson.getBornCity());
			dbcon.getPreparedstatement().setLong(5, newPerson.getSalary());
			dbcon.getPreparedstatement().setInt(5, newPerson.getCleanedSessions());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		janitorList.add(newPerson);
		
	}

	@Override
	public void create(String... args) {
		JanitorDTO newCleaner = new JanitorDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), args[3], args[4], Long.parseLong(args[5]), Integer.parseInt(args[6]));
		dbcon.initConnection();
		janitorList.add(newCleaner);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		janitorList.clear();
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
				long salary = dbcon.getResultset().getLong("salario");
				int cleaned = dbcon.getResultset().getInt("sesioneslimpiadas");
				janitorList.add(new JanitorDTO(id, name, cc, born, city, salary, cleaned));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JanitorDTO cleaner : janitorList) {
			salida += cleaner.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (JanitorDTO cleaner: janitorList) {
			if (cleaner.getName().equals(name)) {
				salida += cleaner.toString();
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
			dbcon.getPreparedstatement().setLong(6, Long.parseLong(args[4]));
			dbcon.getPreparedstatement().setInt(7, Integer.parseInt(args[5]));
			dbcon.getPreparedstatement().setInt(8, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < janitorList.size(); i++) {
			if (janitorList.get(i).getId() == id) {
				janitorList.get(i).setName(args[0]);
				janitorList.get(i).setCc(Long.parseLong(args[1]));
				janitorList.get(i).setBornDate(args[2]);
				janitorList.get(i).setBornCity(args[3]);
				janitorList.get(i).setSalary(Long.parseLong(args[4]));
				janitorList.get(i).setCleanedSessions(Integer.parseInt(args[5]));
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
		for (int i = 0; i < janitorList.size(); i++) {
			if (janitorList.get(i).getId() == id) {
				janitorList.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
	

}
