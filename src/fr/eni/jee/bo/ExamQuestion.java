package fr.eni.jee.bo;

public class ExamQuestion {
	
	/**
	 * Attributes
	 */
	private boolean isMarked;
	private Question question;
	private int orderNumber;
	private Exam exam;
	
	/**
	 * Constructor
	 */
	public ExamQuestion() {
		super();
	}

	public ExamQuestion(boolean isMarked, Question question, int orderNumber, Exam exam) {
		super();
		this.isMarked = isMarked;
		this.question = question;
		this.orderNumber = orderNumber;
		this.exam = exam;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
