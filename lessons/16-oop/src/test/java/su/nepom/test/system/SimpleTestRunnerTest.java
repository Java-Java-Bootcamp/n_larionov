package su.nepom.test.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleTestRunnerTest {
	@Mock
	private UserInterface ui;

	@InjectMocks
	private SimpleTestRunner runner;

	private final Question
			question1 = new Question("question1", List.of("a", "b"), 0),
			question2 = new Question("question2", List.of("a", "b"), 1);

	@Test
	void normalInteraction() {
		when(ui.queryAnswer()).thenReturn(1, 1);

		runner.runTest(List.of(question1, question2));

		var inOrder = Mockito.inOrder(ui);
		inOrder.verify(ui).print(eq(question1));
		inOrder.verify(ui).queryAnswer();
		inOrder.verify(ui).print(eq(question2));
		inOrder.verify(ui).queryAnswer();
		inOrder.verify(ui).showMessage(eq(new ResultsMessage(2, 1)));
		verifyNoMoreInteractions(ui);
	}

	@Test
	void illegalAnswer() {
		when(ui.queryAnswer()).thenReturn(0, 1);

		runner.runTest(List.of(question1));

		var inOrder = Mockito.inOrder(ui);
		inOrder.verify(ui).print(eq(question1));
		inOrder.verify(ui).queryAnswer();
		inOrder.verify(ui).showMessage(eq(new SimpleMessage(SimpleMessage.Type.ANSWER_OUT_OF_RANGE)));
		inOrder.verify(ui).queryAnswer();
		inOrder.verify(ui).showMessage(eq(new ResultsMessage(1, 1)));
		verifyNoMoreInteractions(ui);
	}
}