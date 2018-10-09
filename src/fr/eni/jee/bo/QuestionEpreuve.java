package fr.eni.jee.bo;

public class QuestionEpreuve {
	
	/**
	 * Attributes
	 */
	private String estMarquee;
	private int idQuestion;
	private int numOrdre;
	private int idEpreuve;
	
	/**
	 * Constructor
	 */
	public QuestionEpreuve() {
		super();
	}

	public QuestionEpreuve(String estMarquee, int idQuestion, int numOrdre, int idEpreuve) {
		super();
		this.estMarquee = estMarquee;
		this.idQuestion = idQuestion;
		this.numOrdre = numOrdre;
		this.idEpreuve = idEpreuve;
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */

	public String getEstMarquee() {
		return estMarquee;
	}

	public void setEstMarquee(String estMarquee) {
		this.estMarquee = estMarquee;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public int getNumOrdre() {
		return numOrdre;
	}

	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}
}
