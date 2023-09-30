package co.edu.unbosque.model;

public class UserAdminDTO {
	
	private int id;
	private String userAdmin;
	private String passAdmin;
	
	public UserAdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserAdminDTO(int id, String userAdmin, String passAdmin) {
		super();
		this.id = id;
		this.userAdmin = userAdmin;
		this.passAdmin = passAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getPassAdmin() {
		return passAdmin;
	}

	public void setPassAdmin(String passAdmin) {
		this.passAdmin = passAdmin;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
