package algorithm.stringAlgo;

public class findFirstNonRepeating {
    public static void main(String[] args) {
        //String str = "moonmen";
        String str = "geeksforgeeks";
        String ans = firstNonRepeatingLetter(str);

        System.out.println(ans);
    }

    public static String firstNonRepeatingLetter( String str ) {
        // converting str to a string array
        char[] strArr = str.toLowerCase().toCharArray();
        // for entire string perform following task
        for (int i = 0; i < strArr.length; i++) {
            int j = 0;
            for (; j < strArr.length; j++) {
                // if we find match, break and move on as this character does not satisfy the requirement,
                // else check increase j
                if (i != j && strArr[i] == strArr[j]) {
                   break;
                }
            }
            if (i != j && (j == strArr.length)) {
                return String.valueOf(str.charAt(i));
            }
        }
        // return empty string as no non-repeatative character is found
        return "";
    }

    public static String firstNonRepeatingLetter_stringLogic( String str ) {
        // converting str to a string array
        char[] strArr = str.toLowerCase().toCharArray();
        // for entire string perform following task
        for (char ch : strArr) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                break;
            }
        }
        // return empty string as no non-repeatative character is found
        return "";
    }
}
