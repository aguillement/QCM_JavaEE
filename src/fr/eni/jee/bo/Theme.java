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
		super();
	}


	/**
	 * Constructor
	 * @param idTheme
	 * @param libelle
	 */
	public Theme(int id, String label) {
		super();
		this.id = id;
		this.label = label;
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
