package algorithm.dynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        // input
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";

        // function call
        int lcsLen = findLongestCommonSubsequence(str1.toCharArray(), str2.toCharArray());

        // validation
        System.out.println("longest common subsequence LCS(" + str1 + ", " + str2 + "): " + lcsLen);
    }

    private static int findLongestCommonSubsequence(char[] str1, char[] str2) {
        int[][] lcs = new int[str1.length + 1][str2.length + 1];
        char[][] solution = new char[str1.length + 1][str2.length + 1];

        for (int i = 0; i < str1.length; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j < str2.length; j++) {
            lcs[0][j] = 0;
        }
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    solution[i][j] = 'd';
                } else {
                    if (lcs[i - 1][j] > lcs[i][j - 1]) {
                        lcs[i][j] = lcs[i - 1][j];
                        solution[i][j] = 'u';
                    } else {
                        lcs[i][j] = lcs[i][j - 1];
                        solution[i][j] = 'l';
                    }
                }
            }
        }
        // print solution
        printLCS(solution, str1, str1.length, str2.length);
        System.out.println();

        return lcs[str1.length][str2.length];
    }

    private static void printLCS(char[][] solution, char[] str1, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (solution[i][j] == 'd') {
            printLCS(solution, str1, i - 1, j - 1);
            System.out.print(str1[i - 1]);
        } else if (solution[i][j] == 'u') {
            printLCS(solution, str1, i - 1, j);
        } else {
            printLCS(solution, str1, i, j - 1);
        }
    }
}