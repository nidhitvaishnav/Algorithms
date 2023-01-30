package algorithm.dynamicProgramming;

import java.util.Arrays;

public class MetricsChainMultiplication {
    public static String RECURSIVE_FN = "recursive";
    public static String MEMOIZED_FN = "memoized";
    public static String BOTTOM_UP_FN = "bottom up";

    public static void main(String[] args) {
        // input: Metrics Ai has dimension A[i-1, i] for i = 1 ... n
        int[] arr = new int[]{1,2,3,4,3};

        metricsChainMultiplication(arr, RECURSIVE_FN);
        metricsChainMultiplication(arr, MEMOIZED_FN);
        metricsChainMultiplication(arr, BOTTOM_UP_FN);
    }

    private static void metricsChainMultiplication(int[] input, String function) {
        // method call
        int multiplications;
        if (function == RECURSIVE_FN) {
            multiplications = metricsChainMultiplicationRecursion(input, 1, input.length - 1);
        } else if (function == MEMOIZED_FN) {
            multiplications = metricsChainMultiplicationMemoized(input);
        } else {
            multiplications = metricsChainMultiplicationBottomUp(input);
        }

        // validation
        System.out.println("To multiply metrics with order: " + Arrays.toString(input) + " using " + function
                + " approach it requires " + multiplications + " multiplications.\n");

    }

    /**
     * Given method performs metrics chain multiplication for given array metrics using recursion, where
     * Metrics Ai has dimension metrics[i-1, i] for i = 1 ... n
     * with time complexity of O(2^n) - exponential
     *
     * @param metrics
     *          Metrics Ai has dimension A[i-1, i] for i = 1 ... n
     * @param i
     *          first index
     * @param j
     *          last index
     *
     * @return
     *      cost of metrics multiplication
     */
    private static int metricsChainMultiplicationRecursion(int[] metrics, int i, int j) {
        // if it is the same metrics, no multiplication -> cost = 0
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        // we place parenthesis at different place - at k such that i <= k <= j and calculate the cost of calculation
        // cost = multiply(Ai ... Ak) + multiply (Ak+1 ... Aj) + Ai-1 * Ak * Aj
        for (int k = i; k < j; k++) {
            int cost = metricsChainMultiplicationRecursion(metrics, i, k)
                    + metricsChainMultiplicationRecursion(metrics, k + 1, j)
                    + metrics[i - 1] * metrics[k] * metrics[j];
            if (cost < min) {
                min = cost;
            }
        }
        return min;
    }

    /**
     * This function creates a 2D metrics with max value and pass it to metrics chain multiplication look up function
     * This is a recursive memoized way (dynamic programming) to calculate metrics multiplication in O(n^3) time complexity
     *
     * @param metrics
     *          Metrics Ai has dimension A[i-1, i] for i = 1 ... n
     *
     * @return
     *          cost of metrics multiplication
     */
    private static int metricsChainMultiplicationMemoized(int[] metrics) {
        int[][] dp = new int[metrics.length][metrics.length];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        return metricsChainMultiplicationLookUp(metrics, dp, 1, metrics.length - 1);
    }

    /**
     * Given method performs metrics chain multiplication for given array metrics using recursion, where
     * Metrics Ai has dimension metrics[i-1, i] for i = 1 ... n
     * with time complexity of O(2^n) - exponential
     *
     * @param metrics
     *          Metrics Ai has dimension A[i-1, i] for i = 1 ... n
     * @param dp
     *          dynamic programming 2D metrics that stores the cost of metrics multiplication;
     *          dp[i][j] = cost(metrics[i] * Metrics[j])
     * @param i
     *          first index
     * @param j
     *          last index
     *
     * @return
     *      cost of metrics multiplication
     */
    private static int metricsChainMultiplicationLookUp(int[] metrics, int[][] dp, int i, int j) {
        // if it is the same metrics, no multiplication -> cost = 0
        if (i == j) {
            return 0;
        }
        if (dp[i][j] < Integer.MAX_VALUE) {
            return dp[i][j];
        }

        for (int k = i; k < j; k++) {
            int cost = metricsChainMultiplicationLookUp(metrics, dp, i, k)
                    + metricsChainMultiplicationLookUp(metrics, dp, k + 1, j)
                    + metrics[i - 1] * metrics[k] * metrics[j];
            if (cost < dp[i][j]) {
                dp[i][j] = cost;
            }
        }
        return dp[i][j];
    }

    /**
     * This function calculates cost of metrics chain multiplication in bottom up way in O(n^3) time complexity
     * m[i][j] = 0                                                                   ; if i = j
     *         = min (dp[i][k] + dp[k+1]m[j] + metrics[i-1]*metrics[k]*metrics[j]    ; where i<=k<=j and i<j
     *
     * @param metrics
     *          Metrics Ai has dimension A[i-1, i] for i = 1 ... n
     *
     * @return
     *          cost of metrics multiplication
     */
    private static int metricsChainMultiplicationBottomUp(int[] metrics) {
        int metricsLength = metrics.length;
        // initialize dp and solution metrics
        int[][] dp = new int[metricsLength][metricsLength];
        int[][] solution = new int[metricsLength][metricsLength];

        // if it is the same metrics, no multiplication -> cost = 0
        for(int i = 0; i < metricsLength; i++) {
            dp[i][i] = 0;
        }

        // l is chain length. Starting from 2, as if chain length is at least 3 for 2 metrics to exist
        // as Metrics Ai has dimension metrics[i-1, i] for i = 1 ... n
        for (int l = 2; l < metricsLength; l++) {
            for (int i = 1; i < metricsLength - l + 1; i++) {
                int j = i + l - 1;
                if (j == metricsLength)
                    continue;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + (metrics[i-1] * metrics[k] * metrics[j]);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        solution[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Metrics multiplication Solution:");
        printOptimalParenthesis(solution, 1, metricsLength - 1);
        System.out.println();
        return dp[1][metricsLength - 1];
    }

    private static void printOptimalParenthesis(int[][] solution, int i, int j) {
        if (i == j) {
            System.out.print(" A" + i + " ");
        } else {
            System.out.print("(");
            printOptimalParenthesis(solution, i, solution[i][j]);
            printOptimalParenthesis(solution, solution[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
