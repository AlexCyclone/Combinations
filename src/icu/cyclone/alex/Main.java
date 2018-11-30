package icu.cyclone.alex;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input array:");
        int[] arr = readArray();
        printCombination(arr);
    }

    private static int[] readArray() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] stringArray = line.split("[ .,]");

        int[] array = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i += 1) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }

    private static void printCombination(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int moveIndex = moveIndex(array);
        while (moveIndex >= 0) {
            System.out.println(Arrays.toString(nextCombination(moveIndex, array)));
            moveIndex = moveIndex(array);
        }
    }

    private static int moveIndex(int[] array) {
        int moveIndex = array.length - 1;
        while (moveIndex > 0) {
            if (array[moveIndex] <= array[moveIndex - 1]) {
                moveIndex--;
            } else {
                return moveIndex - 1;
            }
        }
        return moveIndex - 1;
    }

    private static int[] nextCombination(int moveIndex, int[] array) {
        if (moveIndex == array.length - 2) {
            changePosition(array, moveIndex, array.length - 1);
            return array;
        }

        for (int i = array.length - 1; ; i--) {
            if (array[i] > array[moveIndex]) {
                changePosition(array, moveIndex, i);
                Arrays.sort(array, moveIndex + 1, array.length);
                return array;
            }
        }
    }

    private static void changePosition(int[] array, int n, int k) {
        int tempValue = array[n];
        array[n] = array[k];
        array[k] = tempValue;
    }
}
