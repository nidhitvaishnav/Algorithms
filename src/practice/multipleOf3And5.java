package practice;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Complete the function multiples_of_3_and_5 so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 */
public class multipleOf3And5 {

    public static int multiplesOf3And5(int number) {
        int sum = 0;
        // iterate from 1 -> n  Time complexity: O(n)
        for (int i = 1; i < number; i++) {
            // if i is multiple of 3 or 5, add the number into sum
            if ((i % 3 ==0) || (i % 5 == 0)) {
                sum += i;
            }
        }
        // return sum
        return sum;
    }
}
