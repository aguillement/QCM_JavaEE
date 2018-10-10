package fr.eni.jee.bo;

public class Question {
	
	/**
	 * Attributes
	 */
	public int id;
	public String statement;
	public int media;
	public int points;
	public Theme theme = new Theme();
	
	/**
	 * Constructeur
	 */
	public Question() {

	}
	
	/**
	 * Constructeur
	 * @param idQuestion
	 * @param statement
	 * @param media
	 * @param points
	 * @param theme
	 */
	public Question(int id, String statement, String media, int points, Theme theme) {
		super();
		this.id = id;
		this.statement = statement;
		this.media = media;
		this.points = points;
		this.theme = theme;
	}	
	
	/**
	 * @return the idQuestion
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}
	/**
	 * @param statement the statement to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}
	/**
	 * @return the media
	 */
	public int getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(int media) {
		this.media = media;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @return the theme
	 */
	public Theme getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
}
