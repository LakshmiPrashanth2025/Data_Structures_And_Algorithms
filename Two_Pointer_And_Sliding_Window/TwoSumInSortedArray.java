import java.util.*;

public class TwoSumInSortedArray {

    /*
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
     *  find two numbers such that they add up to a specific target number
     */

    public static List<Integer> twoSum(List<Integer> numbers, int target) {
        int left = 0, right = numbers.size() - 1;

        while (left < right) {
            int current_sum = numbers.get(left) + numbers.get(right);
            // If current sum = target, return left and right
            if (current_sum == target) {
                return Arrays.asList(left + 1, right + 1);
            }
            // If current sum < target, then increase the
            // current sum by moving the left pointer by 1
            else if (current_sum < target) {
                left++;
            } else {
                // If current sum > target, then decrease the
                // current sum by moving the right pointer by 1
                right--;
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 7, 11, 15);
        int target = 9;
        List<Integer> result = twoSum(numbers, target);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}