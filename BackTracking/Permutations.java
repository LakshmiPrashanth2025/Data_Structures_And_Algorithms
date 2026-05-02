import java.util.*;

public class Permutations {

    // Recursive function to generate all permutations of a string
    static void permuteRecursively(int index, StringBuilder string, 
                                   List<String> resultPermutedStrings) {
        // Base case: if the index reaches the end, a full permutation is formed
        if (index == string.length()) {
            resultPermutedStrings.add(string.toString()); // Add to result list
            return;
        }

        // Loop to fix each character at the current index by swapping
        for (int i = index; i < string.length(); i++) {
            // Swap character at index with character at i
            swap(string, index, i);

            // Recurse for the next index
            permuteRecursively(index + 1, string, resultPermutedStrings);

            // Backtrack: undo the swap to restore original state
            swap(string, index, i);
        }
    }

    // Swap characters at positions i and j in the StringBuilder
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    // Function to find all permutations of a string
    static List<String> findPermutation(String s) {
        List<String> resultPermutations = new ArrayList<>(); // To store results
        StringBuilder str = new StringBuilder(s); // Mutable string for swapping

        // Start recursive permutation generation from index 0
        permuteRecursively(0, str, resultPermutations);

        // Sort the final results for consistent output order
        Collections.sort(resultPermutations);

        return resultPermutations;
    }

    public static void main(String[] args) {
        String string = "ABCD"; // Input string

        // Get the list of all permutations
        List<String> resultingPermutations = findPermutation(string);

        // Print results
         System.out.println("Rotal number of Unique permutations of \"" + string + "\":" + resultingPermutations.size());
        

        // Print the permutations
        System.out.println("All permutations of \"" + string + "\":");
        for (String eachStr : resultingPermutations) {
            System.out.println(eachStr);
        }
    }
}
