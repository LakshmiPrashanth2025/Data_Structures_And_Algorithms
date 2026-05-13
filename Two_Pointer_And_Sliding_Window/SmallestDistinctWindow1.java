import java.util.*;

/*
*   Count total number of distinct characters in the string.
*   Use a sliding window (two pointers) to maintain a window containing all distinct characters.
*   Use a HashMap or int array to count characters in the current window.
*   Try to minimize the window while it still contains all distinct characters.
*/
public class SmallestDistinctWindow1 {
    public static String findSmallestDistinctWindow(String str) {
        int n = str.length();
        if (n == 0)
            return "";

        // Step 1: Count total number of distinct characters in the string
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int required = uniqueChars.size();

        // Step 2: Sliding window variables
        Map<Character, Integer> windowCount = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0;

        int start = 0;
        for (int end = 0; end < n; end++) {
            char endChar = str.charAt(end);
            windowCount.put(endChar, windowCount.getOrDefault(endChar, 0) + 1);

            if (windowCount.get(endChar) == 1) {
                count++;
            }

            // Step 3: Try to shrink the window
            while (count == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = str.charAt(start);
                windowCount.put(startChar, windowCount.get(startChar) - 1);
                if (windowCount.get(startChar) == 0) {
                    count--;
                }
                start++;
            }
        }

        return str.substring(minStart, minStart + minLen);
    }

    // Test
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        String result = findSmallestDistinctWindow(str);
        System.out.println("Smallest distinct window: " + result); // Output: dbca
    }
}