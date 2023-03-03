package algorithm.dynamicProgramming.problems;

import java.util.Arrays;

/**
 * Given two sequences K and N of numbers, find the Longest Common Subsequence of two sequences.
 *
 * Challenge 1: If we are allowed to change at most X elements in the first sequence to any value. *
 * Examples:
 *
 * Input : K = { 8, 3, 4, 6, 2 } N = { 7, 3, 4, 7, 2 }t
 * X = 1
 *
 * K = 8,1,2,3,4 N 3,4,7,2
 */
public class LCSGoogleMock {
    public static void main(String[] args) {
        // input
        int[] K = {8,3,4,6,2};
        int[] N = {7,3,4,7,2};

        // call
         int max = lcs(K, N);
        // output
        System.out.println("LCS of : {" + Arrays.toString(K) + "} and N: {" + Arrays.toString(N) + "} is " + max);
    }

    public static int lcs(int[] K, int[] N) {
        // initialization
        int max = -1;
        int[][] lcsAns = new int[K.length + 1][N.length + 1];
        // making first row and column 0
        for (int i = 0; i < K.length; i++) {
            lcsAns[0][i] = 0;
        }
        for (int j = 0; j < N.length; j++) {
            lcsAns[j][0] = 0;
        }

        // loop invariant
        for (int i = 0; i < K.length; i++) {
            for (int j = 0; j < N.length; j++) {
                if (K[i] == N[j]) {
                    lcsAns[i+1][j+1] = lcsAns[i][j] + 1;
                    if (max < lcsAns[i+1][j+1]) {
                        max = lcsAns[i+1][j+1];
                    }
                }  else {
                    lcsAns[i+1][j+1] = 0;
                }
            }
        }


        return max;
    }
}
