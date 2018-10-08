package fr.eni.jee.bo;

import java.sql.Timestamp;

public class Epreuve {

	/**
	 * Attributes
	 */
	public int idEpreuve;
	public Timestamp dateDebutValidite;
	public Timestamp dateFinValidite;
	public int tempsEcoule;
	public String etat;
	public float note_obtenue;
	public String niveau_obtenu;
	
	public Test test;
	public User user;
	
	/**
	 * Constructor
	 */
	public Epreuve() {
		super();
	}

	/**
	 * Constructor
	 */
	public Epreuve(int idEpreuve, Timestamp dateDebutValidite, Timestamp dateFinValidite, int tempsEcoule, String etat,
			float note_obtenue, String niveau_obtenu, Test test, User user) {
		super();
		this.idEpreuve = idEpreuve;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.note_obtenue = note_obtenue;
		this.niveau_obtenu = niveau_obtenu;
		this.test = test;
		this.user = user;
	}

	/**
	 * GETTERS AND SETTERS
	 */

	/**
	 * @return the idEpreuve
	 */
	public int getIdEpreuve() {
		return idEpreuve;
	}

	/**
	 * @param idEpreuve the idEpreuve to set
	 */
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	/**
	 * @return the dateDebutValidite
	 */
	public Timestamp getDateDebutValidite() {
		return dateDebutValidite;
	}

	/**
	 * @param dateDebutValidite the dateDebutValidite to set
	 */
	public void setDateDebutValidite(Timestamp dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}

	/**
	 * @return the dateFinValidite
	 */
	public Timestamp getDateFinValidite() {
		return dateFinValidite;
	}

	/**
	 * @param dateFinValidite the dateFinValidite to set
	 */
	public void setDateFinValidite(Timestamp dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	/**
	 * @return the tempsEcoule
	 */
	public int getTempsEcoule() {
		return tempsEcoule;
	}

	/**
	 * @param tempsEcoule the tempsEcoule to set
	 */
	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the note_obtenue
	 */
	public float getNote_obtenue() {
		return note_obtenue;
	}

	/**
	 * @param note_obtenue the note_obtenue to set
	 */
	public void setNote_obtenue(float note_obtenue) {
		this.note_obtenue = note_obtenue;
	}

	/**
	 * @return the niveau_obtenu
	 */
	public String getNiveau_obtenu() {
		return niveau_obtenu;
	}

	/**
	 * @param niveau_obtenu the niveau_obtenu to set
	 */
	public void setNiveau_obtenu(String niveau_obtenu) {
		this.niveau_obtenu = niveau_obtenu;
	}

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}	
}
