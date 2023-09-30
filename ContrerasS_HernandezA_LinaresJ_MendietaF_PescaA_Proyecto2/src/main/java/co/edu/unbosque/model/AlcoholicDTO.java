package co.edu.unbosque.model;

import java.util.Date;

public class AlcoholicDTO extends PersonDTO{
	
	private int visitedSessions;
	private String nickname;
	
	public AlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlcoholicDTO(int visitedSessions, String nickname) {
		super();
		this.visitedSessions = visitedSessions;
		this.nickname = nickname;
	}
	
	public AlcoholicDTO(int id, String name, long cc, String bornDate, String bornCity, int visitedSessions,
			String nickname) {
		super(id, name, cc, bornDate, bornCity);
		this.visitedSessions = visitedSessions;
		this.nickname = nickname;
	}
	

	public AlcoholicDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super(id, name, cc, bornDate, bornCity);
		// TODO Auto-generated constructor stub
	}

	public int getVisitedSessions() {
		return visitedSessions;
	}

	public void setVisitedSessions(int visitedSessions) {
		this.visitedSessions = visitedSessions;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
