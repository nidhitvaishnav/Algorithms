package algorithm.search;

import java.util.Arrays;

public class Search {

    public static void main(String args[]) {
        int arr[] = {5, 2, 4, 6, 1, 3};
        Search search = new Search();
        int val1 = 4;
        System.out.println("Found value  " + val1 + " in arr " + Arrays.toString(arr) + ":  " + search.searchVal(arr, val1));

        int val2 = 10;
        System.out.println("Found value  " + val2 + " in arr " + Arrays.toString(arr) + ":  " + search.searchVal(arr, val2));

    }

    private boolean searchVal(int[] arr, int val) {
        for (int element : arr) {
            if (element == val) {
                return true;
            }
        }
        return false;
    }
}
