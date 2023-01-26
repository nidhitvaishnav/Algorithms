package utils;

public class CommonUtils {
    public void swap(int[] arr, int i, int j) {
        // swap values of arr[i] and arr[minIndex]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
