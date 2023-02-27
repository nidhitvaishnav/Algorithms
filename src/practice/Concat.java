package practice;

/**
 *
 (1, 3). Their concatenation equals 13, which is less than 31, so the pair is tiny;
 (2, 2). Their concatenation equals 22, which is less than 31, so the pair is tiny;
 (3, 1). Their concatenation equals 31, which is not less than 31, so the pair is not tiny.
 As you can see, there are 2 tiny pairs during the iteration, so the answer is 2.

 For a = [16, 1, 4, 2, 14], b = [7, 11, 2, 0, 15], and k = 743, the output should be
 solution(a, b, k) = 4.

 We're considering the following pairs during iteration:

 (16, 15). Their concatenation equals 1615, which is greater than 743, so the pair is not tiny;
 (1, 0). Their concatenation equals 10, which is less than 743, so the pair is tiny;
 (4, 2). Their concatenation equals 42, which is less than 743, so the pair is tiny.
 (2, 11). Their concatenation equals 211, which is less than 743, so the pair is tiny;
 (14, 7). Their concatenation equals 147, which is less than 743, so the pair is tiny.
 There are 4 tiny pairs during the iteration, so the answer is 4.

 Input/Output

 [execution time limit] 3 seconds (java)

 [input] array.integer a

 An array of non-negative integers.

 Guaranteed constraints:
 0 ≤ a.length ≤ 105,
 0 ≤ a[i] ≤ 104.

 [input] array.integer b

 An array of non-negative integers.

 Guaranteed constraints:
 b.length = a.length,
 0 ≤ b[i] ≤ 104.

 [input] integer k

 An integer to compare concatenated pairs with.

 Guaranteed constraints:
 0 ≤ k ≤ 109.

 [output] integer

 The number of tiny pairs during the iteration.

 */
public class Concat {

    /**
     * a and b are arrays of same length
     **/
    int solution(int[] a, int[] b, int k) {
        int bIndex = b.length - 1;
        int tinyCount = 0;
        for (int i = 0; i < a.length; i++) {
            String aNum = Integer.toString(a[i]);
            String bNum = Integer.toString(b[bIndex]);
            String concatStr = aNum + bNum;
            int concatVal = Integer.parseInt(concatStr);
            if (concatVal < k) {
                tinyCount++;
            }
            bIndex--;
        }
        return tinyCount;
    }
}
