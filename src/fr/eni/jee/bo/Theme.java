package fr.eni.jee.bo;

public class Theme {
	
	/**
	 * Attributes
	 */
	public int id;
	public String label;
	
	
	/**
	 * Constructor
	 */
	public Theme() {
		
	}

	/**
	 * Constructor
	 * @param idTheme
	 * @param libelle
	 */
<<<<<<< HEAD
	public Theme(int id, String label) {
		super();
		this.id = id;
		this.label = label;
=======
	public Theme(int idTheme, String libelle) {		
		this.idTheme = idTheme;
		this.libelle = libelle;
>>>>>>> Referenciel-Question
	}


	/**
	 * @return the idTheme
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param idTheme the idTheme to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the libelle
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param libelle the libelle to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
