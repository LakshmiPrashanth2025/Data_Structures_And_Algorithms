import java.util.*;

public class LongestConsecutiveSequence {

    // Method to remove duplicates and return a sorted unique list
    private static List<Integer> getSortedUniqueList(int[] arr) {
        Arrays.sort(arr);  // Step 1: Sort the array
        List<Integer> uniqueList = new ArrayList<>();

        // Step 2: Add first element and skip duplicates
        uniqueList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueList.add(arr[i]);
            }
        }

        return uniqueList;
    }

    // Method to find the longest consecutive subsequence
    public static int findLongestConsecutiveSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        List<Integer> uniqueList = getSortedUniqueList(arr);

        int maxLength = 1;
        int currentLength = 1;

        // Loop through the list and go through the subsequences in the sorted list
        // Store the maxlength of the subsequences in a variable
        // Compare the  length of the current subsequences with maxlength
        // Determine the max length
        for (int i = 1; i < uniqueList.size(); i++) {
            if (uniqueList.get(i) == uniqueList.get(i - 1) + 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    // Main method - driver code
    public static void main(String[] args) {
        int[] arr = { 1, 9, 3, 10, 4, 20, 2 };

        int result = findLongestConsecutiveSubsequence(arr);
        System.out.println("Length of the Longest Contiguous Subsequence is " + result);
    }
}
