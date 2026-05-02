public class LongestPalindromicSubsequencePrint {

    /* Returns the Longest Common Subsequence (LCS) between s1 and s2 */
    static String findLCS(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[][] lcsTable = new int[len1 + 1][len2 + 1];

        // Build the lcsTable in bottom-up fashion
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                } else if (chars1[i - 1] == chars2[j - 1]) {
                    lcsTable[i][j] = lcsTable[i - 1][j - 1] + 1;
                } else {
                    lcsTable[i][j] = Math.max(lcsTable[i - 1][j], lcsTable[i][j - 1]);
                }
            }
        }

        // Reconstruct and return the LCS string
        return reconstructLCS(chars1, chars2, lcsTable);
    }

    /* Reconstructs the LCS from the lcsTable */
    static String reconstructLCS(char[] chars1, char[] chars2, int[][] lcsTable) {
        int i = chars1.length;
        int j = chars2.length;
        int index = lcsTable[i][j];
        char[] lcsChars = new char[index];

        // Start from the bottom-right corner of the table and move upwards
        while (i > 0 && j > 0) {
            if (chars1[i - 1] == chars2[j - 1]) {
                lcsChars[index - 1] = chars1[i - 1];
                i--;
                j--;
                index--;
            } else if (lcsTable[i - 1][j] > lcsTable[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcsChars);
    }

    // Returns the longest palindromic subsequence of the input string
    static String longestPalindromicSubsequence(String input) {
        String reversed = reverseString(input);
        return findLCS(input, reversed);
    }

    // Reverses a given string
    static String reverseString(String input) {
        StringBuilder reversedBuilder = new StringBuilder(input);
        return reversedBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String testString = "GEEKSFORGEEKS";
        System.out.println(longestPalindromicSubsequence(testString));
    }
}
