import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Returns indices of the two numbers such that they add up to target
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            numToIndex.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        
        if (result.length == 2) {
            System.out.println("Indices found: " + result[0] + " and " + result[1]);
            System.out.println("Numbers are: " + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
        } else {
            System.out.println("No two sum solution found");
        }
    }
}
