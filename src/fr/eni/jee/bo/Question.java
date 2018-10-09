package fr.eni.jee.bo;

public class Question {
	
	/**
	 * Attributes
	 */
	public int idQuestion;
	public String enonce;
	public String media;
	public int points;
	public Theme theme = new Theme();
	
	/**
	 * Constructeur
	 */
	public Question() {
		super();
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
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.media = media;
		this.points = points;
		this.theme = theme;
	}
	
	
	/**
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	/**
	 * @return the enonce
	 */
	public String getEnonce() {
		return enonce;
	}
	/**
	 * @param enonce the enonce to set
	 */
	public void setEnonce(String enonce) {
		this.enonce = enonce;
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
