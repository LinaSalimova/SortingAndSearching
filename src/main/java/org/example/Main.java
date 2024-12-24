package org.example;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int key = 5;
        int result = Arrays.binarySearch(arr, key);
        System.out.println("Результат поиска: " + result);

        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        result = Collections.binarySearch(list, key);
        System.out.println("Результат поиска в списке: " + result);
    }
}
