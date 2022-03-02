package su.nepom.test.system;

import java.util.List;

public class Question {
	private final String question;
	private final List<String> answers;
	private final int validAnswerNo;

	public Question(String question, List<String> answers, int validAnswerNo) {
		this.question = question;
		this.answers = answers;
		this.validAnswerNo = validAnswerNo;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public int getValidAnswerNo() {
		return validAnswerNo;
	}

	@Override
	public String toString() {
		return "Question{" +
				"question='" + question + '\'' +
				", answers=" + answers +
				", validAnswer=" + validAnswerNo +
				'}';
	}
}
