package fr.eni.jee.bo;

public class ExamAnswer {
	/**
	 * Attributes
	 */
	private Proposition proposition;
	private Question question;
	private Exam exam;
	
	/**
	 * Constructor
	 */
	public ExamAnswer() {
		super();
	}

	public ExamAnswer(Proposition proposition, Question question, Exam exam) {
		super();
		this.proposition = proposition;
		this.question = question;
		this.exam = exam;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
