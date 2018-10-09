/**
 * 
 */
package fr.eni.jee.bo;

public class Test {

	/**
	 * Attributes
	 */
	private int idTest;
	private String libelle;
	private String description;
	private int duree;
	private int seuil_haut;
	private int seuil_bas;
	
	
	/**
	 * Constructor
	 */
	public Test() {
		super();
	}
	
	/**
	 * Constructor
	 * @param idTest
	 * @param libelle
	 * @param description
	 * @param duree
	 * @param seuil_haut
	 * @param seuil_bas
	 */
	public Test(int idTest, String libelle, String description, int duree, int seuil_haut, int seuil_bas) {
		super();
		this.idTest = idTest;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.seuil_haut = seuil_haut;
		this.seuil_bas = seuil_bas;
	}
	
	/**
	 * GETTERS AND SETTERS
	 */

	/**
	 * @return the idTest
	 */
	public int getIdTest() {
		return idTest;
	}

	/**
	 * @param idTest the idTest to set
	 */
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the seuil_haut
	 */
	public int getSeuil_haut() {
		return seuil_haut;
	}

	/**
	 * @param seuil_haut the seuil_haut to set
	 */
	public void setSeuil_haut(int seuil_haut) {
		this.seuil_haut = seuil_haut;
	}

	/**
	 * @return the seuil_bas
	 */
	public int getSeuil_bas() {
		return seuil_bas;
	}

	/**
	 * @param seuil_bas the seuil_bas to set
	 */
	public void setSeuil_bas(int seuil_bas) {
		this.seuil_bas = seuil_bas;
	}
	
	
	
	
	
	
	
	
}
