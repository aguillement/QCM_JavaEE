package fr.eni.jee.bo;

public class Question {
	
	/**
	 * Attributes
	 */
	public int id;
	public String statement;
	public String media;
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
	 * @param enonce
	 * @param media
	 * @param points
	 * @param theme
	 */
	public Question(int idQuestion, String enonce, String media, int points, Theme theme) {
		
		this.idQuestion = idQuestion;
		this.enonce = enonce;
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
	 * @return the enonce
	 */
	public String getStatement() {
		return statement;
	}
	/**
	 * @param enonce the enonce to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}
	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
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
