package fr.eni.jee.bo;

public class ResultExamDTO {

	private int nbRightAnswer;
	private int nbQuestionToDraw;
	private String result;
	private String label;
	
	public ResultExamDTO(){	}

	public int getNbRightAnswer() {
		return nbRightAnswer;
	}

	public void setNbRightAnswer(int nbRightAnswer) {
		this.nbRightAnswer = nbRightAnswer;
	}

	public int getNbQuestionToDraw() {
		return nbQuestionToDraw;
	}

	public void setNbQuestionToDraw(int nbQuestionToDraw) {
		this.nbQuestionToDraw = nbQuestionToDraw;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}	
}
