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

    private static int[] getInput() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        return arr;
    }
    public static void sort(int [] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    public void sort_nonDecreasing(int [] arr) {
        for (int j = arr.length - 2; j >= 0; j--) {
            int key = arr[j];
            int i = j + 1;
            while (i <arr.length && arr[i] < key) {
                arr[i-1] = arr[i];
                i++;
            }
            arr[i-1] = key;
        }
    }
}
