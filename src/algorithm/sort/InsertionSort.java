package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        callInsertionSort();
        callInsertionSortInReverse();
    }

    private static void callInsertionSort() {
        // input
        int[] arr = getInput();
        System.out.println("Arr before calling insertion sort: " + Arrays.toString(arr));

        // method call
        sort(arr);

        // output
        System.out.println("Arr before calling insertion sort: " + Arrays.toString(arr));
    }

    private static void callInsertionSortInReverse() {
        InsertionSort insertionSort = new InsertionSort();

        // input
        int[] arr = getInput();
        System.out.println("Arr before calling insertion sort in reverse: " + Arrays.toString(arr));

        // method call
        insertionSort.sort_nonDecreasing(arr);

        // output
        System.out.println("Arr before calling insertion sort in reverse: " + Arrays.toString(arr));
    }

    /**
     * Perform selection sort with O(n^2) time complexity
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    public static void sort(int [] arr) {
        // select item from left as key (and perform this for all keys except left most)
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            // if any items on left of the key is larger than key, move them to the right
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i--;
            }
            // put key at its minimum place
            arr[i+1] = key;
        }
    }

    /**
     * Perform selection sort in non-decreasing order with O(n^2) time complexity
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    public void sort_nonDecreasing(int [] arr) {
        // select item from right as key (and perform this for all numbers except leftmost)
        for (int j = arr.length - 2; j >= 0; j--) {
            int key = arr[j];
            int i = j + 1;
            // if any items on left of the key is smaller than key, move them to the left
            while (i <arr.length && arr[i] < key) {
                arr[i-1] = arr[i];
                i++;
            }
            // put key at its maximum place
            arr[i-1] = key;
        }
    }

    private static int[] getInput() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        return arr;
    }
}
