package co.edu.unbosque.model;

public class UserAlcoholicDTO {
	
	private int id;
	private String userAlcoholic;
	private String passAlcoholic;
	
	public UserAlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserAlcoholicDTO(int id, String userAlcoholic, String passAlcoholic) {
		super();
		this.id = id;
		this.userAlcoholic = userAlcoholic;
		this.passAlcoholic = passAlcoholic;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserAlcoholic() {
		return userAlcoholic;
	}

	public void setUserAlcoholic(String userAlcoholic) {
		this.userAlcoholic = userAlcoholic;
	}

	public String getPassAlcoholic() {
		return passAlcoholic;
	}

	public void setPassAlcoholic(String passAlcoholic) {
		this.passAlcoholic = passAlcoholic;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
