package ru.otus.java.arrays;

import java.util.Arrays;

public class Anagram {

    public boolean check(String first, String second) {
        char[] left = first.toLowerCase().toCharArray();
        char[] right = second.toLowerCase().toCharArray();

        int leftCounter = 0;
        int rightCounter = 0;

        String tempLeft = "";
        String tempRight = "";

        for (int i = 0; i < left.length; i++) {
            if (left[i] != ' ') {
                leftCounter++;
                tempLeft += left[i];
            }
        }

        for (char c : right) {
            if (c != ' ') {
                rightCounter++;
                tempRight += c;
            }
        }

        if (leftCounter != rightCounter) {
            return false;
        }


        // TODO реализуйте дальнейшую проверку
        char[] charArrayLeft = tempLeft.toCharArray();
        char[] charArrayRight = tempRight.toCharArray();
        Arrays.sort(charArrayLeft);
        Arrays.sort(charArrayRight);

        boolean flag = true;
        for (int i = 0; i < charArrayLeft.length; i++) {
            if (charArrayLeft[i] != charArrayRight[i]) {
                flag = false;
            }
        }
        return flag;
    }
}
