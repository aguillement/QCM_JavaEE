package fr.eni.jee.bo;

import java.sql.Timestamp;

public class Exam {

	/**
	 * Attributes
	 */
	private int id;
	private Timestamp startDate;
	private Timestamp endDate;
	private int timeSpent;
	private String state;
	private float score;
	private String level;
	private Test test;
	private User user;
	
	/**
	 * Constructor
	 */
	public Exam() {
		super();
	}

	public Exam(int id, Timestamp startDate, Timestamp endDate, int timeSpent, String state, float score, String level,
			Test test, User user) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.timeSpent = timeSpent;
		this.state = state;
		this.score = score;
		this.level = level;
		this.test = test;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
