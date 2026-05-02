public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for general checks
        str = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: pointers have met or crossed
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false; // Characters don't match
        }

        return isPalindromeRecursive(str, left + 1, right - 1); // Recurse inward
    }

    public static void main(String[] args) {
        String test1 = "madam";
        String test2 = "racecar";
        String test3 = "hello";

        System.out.println(test1 + " is palindrome? " + isPalindrome(test1));
        System.out.println(test2 + " is palindrome? " + isPalindrome(test2));
        System.out.println(test3 + " is palindrome? " + isPalindrome(test3));
    }
}
