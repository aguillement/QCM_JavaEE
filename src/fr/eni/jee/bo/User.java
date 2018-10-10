package fr.eni.jee.bo;

public class User {

	private int id;
	private String lastname;
	private String firstname;
	private String mail;
	private String password;
	private int idProfile;
	private int idPromotion;
	
	public User(){
		
	}
	
	public User(String nom, String prenom, String mail, String password, int idProfile){
		this.lastname = nom;
		this.firstname = prenom;
		this.mail = mail;
		this.password = password;
		this.idProfile = idProfile;
	}
	
	public User(int id, String lastname, String firstname, String mail, String password, int idProfile,int idPromotion){
		
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.idProfile = idProfile;
		this.idPromotion = idPromotion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	
			
	
	
}
