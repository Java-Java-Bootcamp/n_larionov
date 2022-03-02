package su.nepom.test.system;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
	@Override
	public void print(Question question) {
		System.out.println("---------");
		System.out.println("Вопрос:");
		System.out.println(question.getQuestion());
		System.out.println("---------");
		System.out.println("Выберите один из вариантов:");
		for (int i = 0; i < question.getAnswers().size(); ++i) {
			System.out.println((i + 1) + ". " + question.getAnswers().get(i));
		}
		System.out.println();
	}

	@Override
	public int queryAnswer() {
		System.out.println("Выберите ответ");
		return new Scanner(System.in).nextInt();
	}

	@Override
	public void showMessage(Message message) {
		if (message instanceof SimpleMessage m) {
			showSimpleMessage(m);
		}
		else if (message instanceof ResultsMessage m) {
			showResults(m);
		}
		else {
			throw new UnsupportedOperationException("Unknown message type " + message.getClass());
		}

	}

	private void showSimpleMessage(SimpleMessage message) {
		switch (message.getType()) {
			case ANSWER_OUT_OF_RANGE -> System.out.println("Введенный вами ответ за пределами диапазона");
		}
	}

	private void showResults(ResultsMessage message) {
		System.out.println("Тест завершен");
		if (message.getIncorrectAnswers() == 0) {
			System.out.println("Все ответы верны");
		}
		else {
			System.out.println("Ваш результат: верны " + message.getCorrectAnswers() + " ответов из " + message.getTotalAnswers());
		}
	}
}
