package algorithm.dynamicProgramming;

public class Fibonacci {
    public static String RECURSIVE_FN = "findFibonacciRecursive";
    public static String TOP_DOWN_FN = "findFibonacciWithTopDownApproach";
    public static String MEMOIZED_FN = "findFibonacciWithMemoizedApproach";

    public static void main(String args[]) {
        // input
        int n = 7;

        // function call
        callFindFibonacci(n, RECURSIVE_FN);
        callFindFibonacci(n, TOP_DOWN_FN);
        callFindFibonacci(n, MEMOIZED_FN);
    }

    public static void callFindFibonacci(int input, String function) {
        int fibonacci;
        if (function == RECURSIVE_FN) {
            fibonacci = findFibonacciRecursive(input);
        } else if (function == TOP_DOWN_FN){
            fibonacci = findFibonacciTopDown(input);
        } else {
            fibonacci = findFibonacciMemoized(input);
        }

        // validation
        System.out.println("fibonacci(" + input + ") = " + fibonacci);
    }

    private static int findFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return findFibonacciRecursive(n - 1) + findFibonacciRecursive(n - 2);
    }

    private static int findFibonacciTopDown(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n - 1];
    }

    private static int findFibonacciMemoized(int n) {
        int[] fibonacci = new int[n  + 1];
        for (int i = 0; i < n + 1; i++) {
            fibonacci[i] = Integer.MIN_VALUE;
        }
        return findFibonacciMemoizedAux(fibonacci, n);
    }

    private static int findFibonacciMemoizedAux(int[] fibonacci, int n) {
        if(n <= 1){
            return n;
        }
        if (fibonacci[n] != Integer.MIN_VALUE) {
            return fibonacci[n];
        }
        return findFibonacciMemoizedAux(fibonacci, n - 1) + findFibonacciMemoizedAux(fibonacci, n - 2);
    }
}
