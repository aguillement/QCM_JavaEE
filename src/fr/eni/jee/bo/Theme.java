package fr.eni.jee.bo;

public class Theme {
	
	/**
	 * Attributes
	 */
	public int idTheme;
	public String libelle;
	
	
	/**
	 * Constructor
	 */
	public Theme() {
		super();
	}


	/**
	 * Constructor
	 * @param idTheme
	 * @param libelle
	 */
	public Theme(int idTheme, String libelle) {
		super();
		this.idTheme = idTheme;
		this.libelle = libelle;
	}


	/**
	 * @return the idTheme
	 */
	public int getIdTheme() {
		return idTheme;
	}


	/**
	 * @param idTheme the idTheme to set
	 */
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
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
}
