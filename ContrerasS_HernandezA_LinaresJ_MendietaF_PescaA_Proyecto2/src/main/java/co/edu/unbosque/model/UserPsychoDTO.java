package co.edu.unbosque.model;

public class UserPsychoDTO {
	
	private int id;
	private String userPsycho;
	private String passPsycho;

	public UserPsychoDTO() {
	}

	public UserPsychoDTO(int id, String userPsycho, String passPsycho) {
		super();
		this.id = id;
		this.userPsycho = userPsycho;
		this.passPsycho = passPsycho;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserPsycho() {
		return userPsycho;
	}

	public void setUserPsycho(String userPsycho) {
		this.userPsycho = userPsycho;
	}

	public String getPassPsycho() {
		return passPsycho;
	}

	public void setPassPsycho(String passPsycho) {
		this.passPsycho = passPsycho;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
