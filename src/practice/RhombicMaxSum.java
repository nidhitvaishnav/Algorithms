package practice;

import java.util.ArrayList;

public class RhombicMaxSum {
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{1,3,5,7,9},{2,4,6,8,10}, {1,1,2,3,5}};
        // int[][] matrix = {{100}};
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,1,2,3}, {4,5,6,7}};
        int[][] matrix = {{1,1,0,2,3,4}, {5,6,2,1,0,3}, {1,0,1,2,3,0},{0,1,2,1,1,0}, {1,0,1,2,3,4}};

        int radius = 1;

        // rhombic max sum
        int maxRhombic = rhombicMaxSum(matrix, radius);

        System.out.println("max of rhombic array : " + maxRhombic);
    }

    private static int rhombicMaxSum(int[][] matrix, int radius) {
        ArrayList<Integer> rhombicSum = new ArrayList<>();

        for (int x = radius; x < matrix.length - radius; x++) {
            for (int y = radius; y < matrix[0].length - radius; y++) {
                int sum = 0;
                for (int i = x - radius; i <= x + radius; i++) {
                    for (int j = y - radius; j <= y + radius; j++) {

                        if (Math.abs(x - i) + Math.abs(y - j) == radius) {
                            sum += matrix[i][j];
                        }
                    }
                }
                rhombicSum.add(sum);
                System.out.println("rhombic sum at [" + x + "][" + y + "] is: " + sum);
            }
        }

        return maxArray(rhombicSum);
    }

    private static int maxArray(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }
}
