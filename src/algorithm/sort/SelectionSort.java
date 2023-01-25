package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String args[]) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        System.out.println("Arr before calling selection sort: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("Arr after calling selection sort: " + Arrays.toString(arr));
    }

    /**
     * This method performs selection sort operation using Selection sort with O(n^2) time complexity
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    private static void sort(int[] arr) {
        // scan entire array with i as pivot
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // find min index from i to len such that value at minIndex is minimum.
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap values of arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
