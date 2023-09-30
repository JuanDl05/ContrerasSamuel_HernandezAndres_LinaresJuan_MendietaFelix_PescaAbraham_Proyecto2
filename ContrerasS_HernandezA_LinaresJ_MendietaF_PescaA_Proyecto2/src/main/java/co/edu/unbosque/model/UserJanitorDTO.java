package co.edu.unbosque.model;

public class UserJanitorDTO {
	
	private int id;
	private String userJanitor;
	private String passJanitor;
	
	public UserJanitorDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserJanitorDTO(int id, String userJanitor, String passJanitor) {
		super();
		this.id = id;
		this.userJanitor = userJanitor;
		this.passJanitor = passJanitor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserJanitor() {
		return userJanitor;
	}

	public void setUserJanitor(String userJanitor) {
		this.userJanitor = userJanitor;
	}

	public String getPassJanitor() {
		return passJanitor;
	}

	public void setPassJanitor(String passJanitor) {
		this.passJanitor = passJanitor;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
