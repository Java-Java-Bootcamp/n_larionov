package su.nepom.test.system;

public class ResultsMessage implements Message {
	private final int totalAnswers, correctAnswers;

	public ResultsMessage(int totalAnswers, int correctAnswers) {
		this.totalAnswers = totalAnswers;
		this.correctAnswers = correctAnswers;
	}

	public int getTotalAnswers() {
		return totalAnswers;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public int getIncorrectAnswers() {
		return totalAnswers - correctAnswers;
	}

	@Override
	public String toString() {
		return "ResultsMessage{" +
				"totalAnswers=" + totalAnswers +
				", correctAnswers=" + correctAnswers +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ResultsMessage that = (ResultsMessage) o;

		if (totalAnswers != that.totalAnswers) return false;
		return correctAnswers == that.correctAnswers;
	}

	@Override
	public int hashCode() {
		int result = totalAnswers;
		result = 31 * result + correctAnswers;
		return result;
	}
}
