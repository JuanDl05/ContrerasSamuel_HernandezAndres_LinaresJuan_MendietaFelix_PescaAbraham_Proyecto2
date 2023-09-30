package co.edu.unbosque.model;

import java.util.Date;

public class PersonDTO {
	
	private int id;
	private String name;
	private long cc;
//	private Date bornDate;
	private String bornDate;
	private String bornCity;
	
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonDTO(int id, String name, long cc, String bornDate, String bornCity) {
		super();
		this.id = id;
		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
		this.bornCity = bornCity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCc() {
		return cc;
	}

	public void setCc(long cc) {
		this.cc = cc;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getBornCity() {
		return bornCity;
	}

	public void setBornCity(String bornCity) {
		this.bornCity = bornCity;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
