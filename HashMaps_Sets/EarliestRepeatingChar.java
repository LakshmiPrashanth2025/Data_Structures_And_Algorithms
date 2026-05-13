import java.util.HashMap;

public class EarliestRepeatingChar {
    public static Character findEarliestRepeatingChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int earliestIndex = Integer.MAX_VALUE;
        Character earliestChar = null;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // Already seen, check if this is the earliest repetition
                int firstIndex = map.get(ch);
                if (firstIndex < earliestIndex) {
                    earliestIndex = firstIndex;
                    earliestChar = ch;
                }
            } else {
                map.put(ch, i);
            }
        }

        return earliestChar;
    }

    public static void main(String[] args) {
        String input = "abcaadb";
        Character result = findEarliestRepeatingChar(input);
        if (result != null) {
            System.out.println("Earliest repeating character: " + result);
        } else {
            System.out.println("No repeating characters found.");
        }
    }
}
