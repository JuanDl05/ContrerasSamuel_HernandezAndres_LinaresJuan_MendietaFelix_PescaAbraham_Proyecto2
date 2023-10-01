package co.edu.unbosque.model;

import java.util.Date;

public class PsychologistDTO extends PersonDTO{
	
	private int graduationYear;
	private int daysOfService;
	private int supportedSessions;
	private long salary;
	
	public PsychologistDTO() {
	}

	public PsychologistDTO(int graduationYear, int daysOfService, int supportedSessions, long salary) {
		super();
		this.graduationYear = graduationYear;
		this.daysOfService = daysOfService;
		this.supportedSessions = supportedSessions;
		this.salary = salary;
	}
	
	public PsychologistDTO(int id, String name, long cc, String bornDate, String bornCity, int graduationYear,
			int daysOfService, int supportedSessions, long salary) {
		super(id, name, cc, bornDate, bornCity);
		this.graduationYear = graduationYear;
		this.daysOfService = daysOfService;
		this.supportedSessions = supportedSessions;
		this.salary = salary;
	}

	public PsychologistDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public int getDaysOfService() {
		return daysOfService;
	}

	public void setDaysOfService(int daysOfService) {
		this.daysOfService = daysOfService;
	}

	public int getSupportedSessions() {
		return supportedSessions;
	}

	public void setSupportedSessions(int supportedSessions) {
		this.supportedSessions = supportedSessions;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
