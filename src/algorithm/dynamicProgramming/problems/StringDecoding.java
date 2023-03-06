package algorithm.dynamicProgramming.problems;

//If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings.
//
//        For example:
//        Input: "1123". You need to general all valid alphabet codes from this string.
//
//        Output List
//        aabc //a = 1, a = 1, b = 2, c = 3
//        kbc // since k is 11, b = 2, c= 3
//        alc // a = 1, l = 12, c = 3
//        aaw // a= 1, a =1, w= 23
//        kw // k = 11, w = 23

public class StringDecoding {
    public static void main(String[] args) {
        // input
//        String input = "";
//        String input = "0";
//        String input = "1";
//        String input = "12";
        String input = "100";
//        String input = "1123";

        // function call
        int decodePossibilities = decodeString(input);

        // output
        System.out.println("To decode string \"" + input + "\" there are " + decodePossibilities + " possibilities");
    }

    public static int decodeString(String input) {
        if (input.length() == 0 || input == null) {
            return 0;
        }
        int[] dp = new int[input.length() + 1];
        // base case
        dp[0] = 1;
        dp[1] = input.charAt(0) == '0'? 0: 1;

        for (int i = 2; i <= input.length(); i++) {
            int currentVal = input.charAt(i - 1) - '0';
            int mergedVal = getMergedVal(input.charAt(i - 2), input.charAt(i - 1));
            if (currentVal >=1 && currentVal <=9) {
                dp[i] += dp[i-1];;
            }
            if (mergedVal >= 10 && mergedVal <= 26) {
                dp[i] += dp[i-2];;
            }
        }
        return dp[input.length()];
    }

    private static int getMergedVal(char a, char b) {
        int aVal = a - '0';
        int bVal = b - '0';
        return aVal*10 + bVal;
    }
}
