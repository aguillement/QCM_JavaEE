package fr.eni.jee.bo;

public class ResultExamDTO {

	private String result;
	private int nbQuestion;
	private int IdExam;
	private String label;
	private int nbRightQuestion;
	private int nbAnsweredQuestion;
	
	public ResultExamDTO(){	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getNbQuestion() {
		return nbQuestion;
	}

	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}

	public int getIdExam() {
		return IdExam;
	}

	public void setIdExam(int idExam) {
		IdExam = idExam;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getNbRightQuestion() {
		return nbRightQuestion;
	}

	public void setNbRightQuestion(int nbRightQuestion) {
		this.nbRightQuestion = nbRightQuestion;
	}

	public int getNbAnsweredQuestion() {
		return nbAnsweredQuestion;
	}

	public void setNbAnsweredQuestion(int nbAnsweredQuestion) {
		this.nbAnsweredQuestion = nbAnsweredQuestion;
	}	
}
