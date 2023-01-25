package algorithm.divideAndConquer;

public class power {
    public static void main(String args[]) {
        // input
        long x = 5;
        long power = 3;

        // method call
        long answer = findPower(x, power);

        // output
        System.out.println(x + "^" + power + " = " + answer);
    }

    /**
     * Find power of a number recursively with time complexity of O(lg n)
     * @param x
     *      long base value
     * @param n
     *      power long value
     * @return
     *      long answer
     */
    private static long findPower(long x, long n) {
        // for x^0 = 1
        if (n == 0) {
            return 1;
        }
        // for even n: (x*x)^n/2 = (x^2)^(n/2) = x^n
        long ans = findPower(x * x, n / 2);
        // if n is odd, (n-1)/2 is even.
        // (x^2)^((n-1)/2) * x = (x)^(n-1) * x = x^n
        return isOdd(n) ? ans * x : ans;
    }

    private static boolean isOdd(long n) {
        if ((n % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
