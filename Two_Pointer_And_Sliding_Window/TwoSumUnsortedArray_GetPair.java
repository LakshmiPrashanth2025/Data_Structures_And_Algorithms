import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsortedArray_GetPair {

    public static int[] getPair(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;

            if (seen.containsKey(complement)) {
                return new int[] {complement, num}; // found the pair
            }

            seen.put(num, 1); // store current number
        }

        return new int[] {}; // no pair found
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 9, 2,-1,11};
        int target = 10;

        int[] result = getPair(nums, target);
        if (result.length == 2) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}