package ru.otus.java.arrays.util;

import java.util.Random;

public class ArrayUtil {
    private static final Random random = new Random();

    public static void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            String format = i < array.length - 1 ? "%s, " : "%s";
            System.out.printf(format, array[i]);
        }
        System.out.println();
    }

    public static void swap(int[] array, int left, int right) {
        array[left] = array[left] ^ array[right] ^ (array[right] = array[left]);
    }

    public static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
        return array;
    }
}
