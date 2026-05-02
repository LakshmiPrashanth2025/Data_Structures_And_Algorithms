import java.util.*;

public class PrintLongestConsequtiveSequence {

    // Method to remove duplicates and return a sorted unique list
    private static List<Integer> getSortedUniqueList(int[] arr) {
        Arrays.sort(arr);
        List<Integer> uniqueList = new ArrayList<>();
        uniqueList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueList.add(arr[i]);
            }
        }
        return uniqueList;
    }

    // Method to find and print the longest consecutive subsequence
    public static List<Integer> findLongestConsecutiveSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<Integer> uniqueList = getSortedUniqueList(arr);

        int maxLength = 1;
        int currentLength = 1;
        int startIndex = 0;
        int maxStartIndex = 0;

        for (int i = 1; i < uniqueList.size(); i++) {
            if (uniqueList.get(i) == uniqueList.get(i - 1) + 1) {
                currentLength++;
            } else {
                currentLength = 1;
                startIndex = i;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStartIndex = startIndex;
            }
        }

        return uniqueList.subList(maxStartIndex, maxStartIndex + maxLength);
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};

        List<Integer> longestSubsequence = findLongestConsecutiveSubsequence(arr);
        System.out.println("Longest Consecutive Subsequence: " + longestSubsequence);
        System.out.println("Length: " + longestSubsequence.size());
    }
}
