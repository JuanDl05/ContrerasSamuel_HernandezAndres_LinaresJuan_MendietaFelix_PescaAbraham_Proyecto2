package co.edu.unbosque.model;

import java.util.Date;

public class JanitorDTO extends PersonDTO{
	
	private long salary;
	private int cleanedSessions;
	
	public JanitorDTO() {
		// TODO Auto-generated constructor stub
	}

	public JanitorDTO(long salary, int cleanedSessions) {
		super();
		this.salary = salary;
		this.cleanedSessions = cleanedSessions;
	}

	public JanitorDTO(int id, String name, long cc, String bornDate, String bornCity, long salary,
			int cleanedSessions) {
		super(id, name, cc, bornDate, bornCity);
		this.salary = salary;
		this.cleanedSessions = cleanedSessions;
	}
	
	public JanitorDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getCleanedSessions() {
		return cleanedSessions;
	}

	public void setCleanedSessions(int cleanedSessions) {
		this.cleanedSessions = cleanedSessions;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
