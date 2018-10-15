package fr.eni.jee.bo;

public class Profile {
	
	private int id;
	private String label;
	
	public Profile(){
		
	}
	
	public Profile(int id, String libelle){
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
