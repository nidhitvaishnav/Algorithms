package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String args[]) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        System.out.println("Arr before calling selection sort: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("Arr after calling selection sort: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap values
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
