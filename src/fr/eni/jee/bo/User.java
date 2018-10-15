package fr.eni.jee.bo;

public class User {

	private int id;
	private String lastname;
	private String firstname;
	private String mail;
	private String password;
	private Profile profile;
	private Promotion promotion;
	
	public User(){
		
	}
	
	public User(String nom, String prenom, String mail, String password,Profile profile){
		this.lastname = nom;
		this.firstname = prenom;
		this.mail = mail;
		this.password = password;
		this.profile = profile;
	}
	
	public User(int id, String lastname, String firstname, String mail, String password, Profile profile,Promotion promotion){
		
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.profile = profile;
		this.promotion = promotion;
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
			
	
	
}
