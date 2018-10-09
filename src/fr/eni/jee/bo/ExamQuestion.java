package fr.eni.jee.bo;

public class ExamQuestion {
	
	/**
	 * Attributes
	 */
	private boolean isMarked;
	private int idQuestion;
	private int orderNumber;
	private int idExam;
	
	/**
	 * Constructor
	 */
	public ExamQuestion() {
		super();
	}

	public ExamQuestion(boolean isMarked, int idQuestion, int orderNumber, int idExam) {
		super();
		this.isMarked = isMarked;
		this.idQuestion = idQuestion;
		this.orderNumber = orderNumber;
		this.idExam = idExam;
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */

	public boolean getIsMarked() {
		return isMarked;
	}

	public void setIsMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getIdExam() {
		return idExam;
	}

	public void setIdExam(int idExam) {
		this.idExam = idExam;
	}
}
