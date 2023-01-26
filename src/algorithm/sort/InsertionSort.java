package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    private static String INSERTION_SORT = "insertionSort";
    private static String INSERTION_SORT_REVERSE = "insertionSortReverse";

    public static void main(String[] args) {
        int[] arr = getInput();
        sort(INSERTION_SORT, Arrays.copyOf(arr, arr.length));
        sort(INSERTION_SORT_REVERSE, Arrays.copyOf(arr, arr.length));
    }

    private static void sort(String sortType, int[] arr) {
        // input
        System.out.println("Arr before calling " + sortType + " sort: " + Arrays.toString(arr));

        // method call
        if (sortType == INSERTION_SORT) {
            insertionSort(arr);
        } else {
            sort_nonDecreasing(arr);
        }

        // output
        System.out.println("Arr before calling " + sortType + " sort: " + Arrays.toString(arr) + "\n");
    }

    /**
     * Perform selection sort with O(n^2) time complexity
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    public static void insertionSort(int [] arr) {
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
    public static void sort_nonDecreasing(int [] arr) {
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
