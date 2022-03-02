package su.nepom.test.system;

import java.util.List;

public class SimpleTestRunner implements TestRunner {
	private final UserInterface userInterface;

	public SimpleTestRunner(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	@Override
	public void runTest(List<Question> questions) {
		int correctAnswers = 0;
		for (var q : questions) {
			userInterface.print(q);

			while (true) {
				var answer = userInterface.queryAnswer();
				if (answer >= 1 && answer <= q.getAnswers().size()) {
					if (answer - 1 == q.getValidAnswerNo())
						correctAnswers += 1;
					break;
				}
				else {
					userInterface.showMessage(new SimpleMessage(SimpleMessage.Type.ANSWER_OUT_OF_RANGE));
				}
			}
		}

		userInterface.showMessage(new ResultsMessage(questions.size(), correctAnswers));
	}
}
