import java.util.*;

public class PalindromePartitioning {

    // Function to fill isPalin array such that isPalin[i][j] 
    // stores whether substring s[i, j] is a palindrome or not
    static void generatePalindrome(String s, boolean[][] isPalindrome) {
        int n = s.length();

        // Substring s[i .. i] of len 1 is always palindromic
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // Iterate over different lengths of substrings
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                if (s.charAt(i) == s.charAt(j) && 
                    (len == 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
    }

    // Function to calculate the minimum number of cuts
    static int palindromePartition(String s, boolean[][] isPalindrome) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = i; j >= 1; j--) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    // Function to recursively generate all palindromic partitions
    static void printAllPalindromicPartitions(String s, boolean[][] isPalindrome) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, isPalindrome);

        System.out.println("All Palindromic Partitions:");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }

    static void backtrack(String s, int start, List<String> current,
                          List<List<String>> result, boolean[][] isPalindrome) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result, isPalindrome);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        String string1 = "geek";
        solvePalindromePartition(string1);
        System.out.println("*****************************");

         String string2 = "rotator";
        solvePalindromePartition(string2);
        System.out.println("*****************************");

         String string3 = "Nenonen";
        solvePalindromePartition(string3);
        System.out.println("*****************************");

       
    }

    static void solvePalindromePartition(String str){
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];

        generatePalindrome(str, isPalindrome);

        int minCuts = palindromePartition(str, isPalindrome);
        System.out.println("Minimum Cuts: " + minCuts);

        printAllPalindromicPartitions(str, isPalindrome);
    }
}
