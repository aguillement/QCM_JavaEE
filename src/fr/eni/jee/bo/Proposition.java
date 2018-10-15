package fr.eni.jee.bo;

public class Proposition {
	
	/**
	 * Attributes
	 */
	private int id;
	private String statement;
	private boolean isTrue;
	private Question question;
	
	/**
	 * Constructor
	 */
	public Proposition() {
		super();
	}
	public Proposition(String statement, boolean isTrue, Question question) {
		super();
		this.statement = statement;
		this.isTrue = isTrue;
		this.question = question;
	}
	public Proposition(int id, String statement, boolean isTrue, Question question) {
		super();
		this.id = id;
		this.statement = statement;
		this.isTrue = isTrue;
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
