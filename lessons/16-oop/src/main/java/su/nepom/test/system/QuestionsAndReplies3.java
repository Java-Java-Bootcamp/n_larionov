package su.nepom.test.system;

import java.util.Scanner;

public class QuestionsAndReplies3 {
    public static void main(String[] args) {
        int count = 0;
        String[] questions = {"Сколько человек за столом: 1 два 2 четыри 3 десять ?",
                "что больше: Земля, Венера, Марс?"};
        int[] answers = {1, 1};
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            if (sc.nextInt() == answers[i]) {
                count++;
            }
        }
        System.out.println("Кол-во правильных ответов: " + count);
    }
}
