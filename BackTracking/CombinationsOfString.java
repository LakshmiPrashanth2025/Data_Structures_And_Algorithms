import java.util.*;

public class CombinationsOfString {
 public static void main(String[] args) {
        String input = "abc";

        List<String> resultCombinationStrs = new ArrayList<>();
        backtrack(input, 0, "", resultCombinationStrs);

        System.out.println("All combinations of \"" + input + "\":");
        for (String eachCombination : resultCombinationStrs) {
            System.out.println(eachCombination);
        }
    }

    private static void backtrack(String input, int index, String current, List<String> result) {
        if (!current.isEmpty()) {
            result.add(current);
        }

        for (int i = index; i < input.length(); i++) {
            backtrack(input, i + 1, current + input.charAt(i), result);
        }
    }
}
