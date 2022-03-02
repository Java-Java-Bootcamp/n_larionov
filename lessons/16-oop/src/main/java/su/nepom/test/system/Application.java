package su.nepom.test.system;

import java.util.List;

public class Application {
	private static final List<Question> data = List.of(
			new Question("Через какое ключевое слово выражается факт реализации классом интерфейса?",
					List.of("implements", "extends", "override"), 0),
			new Question("Какой тип имеет литерал 42?",
					List.of("short", "int", "long"), 1),
			new Question("Можно ли передать массив строк в функцию, аргументы которой (String... s)?",
					List.of("нет", "да"), 1)
	);

	public static void main(String... args) {
		var ui = new ConsoleUserInterface();
		var runner = new SimpleTestRunner(ui);
		runner.runTest(data);
	}
}
