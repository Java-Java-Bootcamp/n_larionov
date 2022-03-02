package ru.otus.java.arrays;

public class Anagram {

    public boolean check(String first, String second) {
        char[] left = first.toLowerCase().toCharArray();
        char[] right = second.toLowerCase().toCharArray();

        int leftCounter = 0;
        int rightCounter = 0;

        for (int i = 0; i < left.length; i++) {
            if (left[i] != ' ') {
                leftCounter++;

            }
        }

        for (char c : right) {
            if (c != ' ') {
                rightCounter++;
            }
        }

        if (leftCounter != rightCounter) {
            return false;
        }


        // TODO реализуйте дальнейшую проверку

        return true;
    }
}
