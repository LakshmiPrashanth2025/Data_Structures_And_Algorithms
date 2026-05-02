import java.util.*;

public class UniquePermutations {

    // Recursive function to generate all unique permutations of a string
    static void permuteRecursively(int index, StringBuilder string, 
                                   List<String> resultPermutedStrings) {

        // Base case: if we've reached the end, add the permutation
        if (index == string.length()) {
            resultPermutedStrings.add(string.toString());
            return;
        }

        // Set to track characters we've already used at this position
        Set<Character> used = new HashSet<>();

        // Try placing each character at the current index
        for (int i = index; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            // Skip if this character has already been used at this level
            if (used.contains(currentChar)) continue;

            used.add(currentChar); // Mark as used

            // Swap and recurse
            swap(string, index, i);
            permuteRecursively(index + 1, string, resultPermutedStrings);
            swap(string, index, i); // Backtrack
        }
    }

    // Utility method to swap characters in StringBuilder
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    // Main function to find all unique permutations of a string
    static List<String> findUniquePermutations(String s) {
        List<String> resultPermutations = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);

        // Sort the string to ensure duplicates are adjacent
        // (optional here, but useful for consistent order)
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        str = new StringBuilder(new String(chars));

        permuteRecursively(0, str, resultPermutations);
        return resultPermutations;
    }

    public static void main(String[] args) {
        String string = "aabd";

        List<String> uniquePermutations = findUniquePermutations(string);

        // Print results
         System.out.println("Rotal number of Unique permutations of \"" + string + "\":" + uniquePermutations.size());
         
        System.out.println("Unique permutations of \"" + string + "\":");
        for (String perm : uniquePermutations) {
            System.out.println(perm);
        }
    }
}
