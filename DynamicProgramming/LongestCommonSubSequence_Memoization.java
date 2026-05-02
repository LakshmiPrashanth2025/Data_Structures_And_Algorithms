// Java implementation of Top-Down DP of LCS problem
import java.util.Arrays;

public class LongestCommonSubSequence_Memoization {

    // Returns length of LCS for string1[0..str1Length-1], string2[0..str2Length-1]
    // Start from matching last characters of the 2 strings to find out the Longest common subsequence
    static int calculateLCS(String string1, String string2, int str1Length, int str2Length, int[][] memo) {
       
        // Base Case: If either string length is zero
        if (str1Length == 0 || str2Length == 0)
            return 0;

        // Return cached value if already computed
        if (memo[str1Length][str2Length] != -1)
            return memo[str1Length][str2Length];

        // Case: Last characters are the same -> Include this character in LCS
        if (string1.charAt(str1Length - 1) == string2.charAt(str2Length - 1)) 
        {
            memo[str1Length][str2Length] = 1 + calculateLCS(string1, string2, str1Length - 1, str2Length - 1, memo);
        } 
        else {
            // Case: Last characters are different -> Exclude one character either from string1 or string2 and find max LCS
            int excludeLastCharFromString1 = calculateLCS(string1, string2, str1Length - 1, str2Length, memo);
            int excludeLastCharFromString2 = calculateLCS(string1, string2, str1Length, str2Length - 1, memo);

            memo[str1Length][str2Length] = Math.max(excludeLastCharFromString1, excludeLastCharFromString2);
        }

        return memo[str1Length][str2Length];
    }

    static int findLongestCommonSubsequence(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        int[][] memo = new int[length1 + 1][length2 + 1];

        // Initialize memoization table with -1 to indicate uncalculated states
        for (int i = 0; i <= length1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return calculateLCS(string1, string2, length1, length2, memo);
    }

    public static void main(String[] args) {
        String string1 = "AGGTAB";
        String string2 = "GXTXAYB";

        System.out.println("Length of Longest Common Subsequence is: " + findLongestCommonSubsequence(string1, string2));
    }
}
