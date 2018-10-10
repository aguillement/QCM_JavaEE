/**
 * 
 */
package fr.eni.jee.bo;

public class Test {

	/**
	 * Attributes
	 */
	private int id;
	private String label;
	private String statement;
	private int duration;
	private int high_level;
	private int low_level;
	
	
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
	public Test(int id, String label, String statement, int duration, int high_level, int low_level) {
		super();
		this.id = id;
		this.label = label;
		this.statement = statement;
		this.duration = duration;
		this.high_level = high_level;
		this.low_level = low_level;
	}
	
	/**
	 * GETTERS AND SETTERS
	 */

	/**
	 * @return the idTest
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idTest the idTest to set
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

	/**
	 * @return the description
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * @param description the description to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**
	 * @return the duree
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the seuil_haut
	 */
	public int getHigh_level() {
		return high_level;
	}

	/**
	 * @param seuil_haut the seuil_haut to set
	 */
	public void setHigh_level(int high_level) {
		this.high_level = high_level;
	}

	/**
	 * @return the seuil_bas
	 */
	public int getLow_level() {
		return low_level;
	}

	/**
	 * @param seuil_bas the seuil_bas to set
	 */
	public void setLow_level(int low_level) {
		this.low_level = low_level;
	}
	
	
	
	
	
	
	
	
}
