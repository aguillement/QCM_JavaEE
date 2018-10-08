package fr.eni.jee.bo;

public class Promotion {

	private int idPromotion;
	private String libelle;
	
	public Promotion(){
		
	}
	
	public Promotion(int idPromotion, String libelle){
		this.idPromotion = idPromotion;
		this.libelle = libelle;
	}
	
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
