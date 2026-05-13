import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    // Main method
    public static void main(String[] args) {
        RabbitsInForest rif = new RabbitsInForest();
        int[] answers = {1, 1, 1, 1, 2, 1}; // Expected output: 9
        System.out.println("Minimum number of rabbits: " + rif.numRabbits(answers));
    }

    // Entry method that computes the total number of rabbits
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> frequencyMap = buildFrequencyMap(answers);
        return calculateTotalRabbits(frequencyMap);
    }

    // 1. Build a frequency map of answers 
    private Map<Integer, Integer> buildFrequencyMap(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        return map;
    }

    // 2. Calculate the total number of rabbits using the frequency map
    private int calculateTotalRabbits(Map<Integer, Integer> map) {
        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();
            totalRabbits += rabbitsForAnswer(answer, count);
        }
        return totalRabbits;
    }

    // 2a. Calculate number of rabbits for a given answer and count - using the Ceiling division formula
    private int rabbitsForAnswer(int answer, int count) {
        int groupSize = answer + 1;
        int numberOfGroups = (count + groupSize - 1) / groupSize; // Ceiling division
        return numberOfGroups * groupSize;
    }
}
