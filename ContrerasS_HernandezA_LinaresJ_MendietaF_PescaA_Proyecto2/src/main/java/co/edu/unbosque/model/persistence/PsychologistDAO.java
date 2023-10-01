package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.PsychologistDTO;

public class PsychologistDAO implements CRUDoperations{
	
	private ArrayList<PsychologistDTO> psychologistList;
	private DBConnection dbcon;
	
	public PsychologistDAO() {
		psychologistList = new ArrayList<>();
		dbcon = new DBConnection();
	}

	public ArrayList<PsychologistDTO> getPsychologistList() {
		return psychologistList;
	}

	public void setPsychologistList(ArrayList<PsychologistDTO> psychologistList) {
		this.psychologistList = psychologistList;
	}

	@Override
	public void create(Object o) {
		PsychologistDTO newPsycho = (PsychologistDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO psychologist VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);"));
			dbcon.getPreparedstatement().setInt(1, newPsycho.getId());
			dbcon.getPreparedstatement().setString(2, newPsycho.getName());
			dbcon.getPreparedstatement().setLong(3, newPsycho.getCc());
			dbcon.getPreparedstatement().setString(4, newPsycho.getBornDate());
			dbcon.getPreparedstatement().setString(5, newPsycho.getBornCity());
			dbcon.getPreparedstatement().setInt(6, newPsycho.getGraduationYear());
			dbcon.getPreparedstatement().setInt(7, newPsycho.getDaysOfService());
			dbcon.getPreparedstatement().setInt(8, newPsycho.getSupportedSessions());
			dbcon.getPreparedstatement().setLong(9, newPsycho.getSalary());
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		psychologistList.add(newPsycho);
		
	}

	@Override
	public void create(String... args) {
		PsychologistDTO newPsycho = new PsychologistDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]));
		dbcon.initConnection();
		psychologistList.add(newPsycho);
		
	}

	@Override
	public String readAll() {
		String salida = "";
		psychologistList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM psychologist;"));
			while(dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id");
				String name = dbcon.getResultset().getString("nombre");
				long cc = dbcon.getResultset().getLong("cedula");
				String born = dbcon.getResultset().getString("fechanacimiento");
				String city = dbcon.getResultset().getString("ciudadnacimiento");
				int gradu = dbcon.getResultset().getInt("aniograduacion");
				int daysService = dbcon.getResultset().getInt("diasdeservicio");
				int suppSess = dbcon.getResultset().getInt("sesionesapoyadas");
				long salary = dbcon.getResultset().getLong("salario");
				psychologistList.add(new PsychologistDTO(id, name, cc, born, city, gradu, daysService, suppSess, salary));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PsychologistDTO psycho : psychologistList) {
			salida += psycho.toString();
		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (PsychologistDTO psycho : psychologistList) {
			if (psycho.getName().equals(name)) {
				salida += psycho.toString();
			}
		}
		return salida;
	}

	@Override
	public int updateById(int id, String... args) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE janitor SET id = ?, nombre = ?, cedula = ?, contrasena = , ciudadnacimiento = ?, aniograduacion = ?, diasdeservicio = ?, sesionesapoyadas = ?, salario = ? WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().setString(2, args[0]);
			dbcon.getPreparedstatement().setLong(3, Long.parseLong(args[1]));
			dbcon.getPreparedstatement().setString(4, args[2]);
			dbcon.getPreparedstatement().setString(5, args[3]);
			dbcon.getPreparedstatement().setInt(6, Integer.parseInt(args[4]));
			dbcon.getPreparedstatement().setInt(7, Integer.parseInt(args[5]));
			dbcon.getPreparedstatement().setInt(8, Integer.parseInt(args[6]));
			dbcon.getPreparedstatement().setLong(9, Long.parseLong(args[7]));
			dbcon.getPreparedstatement().setInt(10, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.get(i).setName(args[0]);
				psychologistList.get(i).setCc(Long.parseLong(args[1]));
				psychologistList.get(i).setBornDate(args[2]);
				psychologistList.get(i).setBornCity(args[3]);
				psychologistList.get(i).setGraduationYear(Integer.parseInt(args[4]));
				psychologistList.get(i).setDaysOfService(Integer.parseInt(args[5]));
				psychologistList.get(i).setSupportedSessions(Integer.parseInt(args[6]));
				psychologistList.get(i).setSalary(Long.parseLong(args[7]));
				return 0;
			}
		}
		return 1;
	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM psychologist WHERE id = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.remove(i);
				return 0;
			}
		}
		return 1;
	}
	

}
