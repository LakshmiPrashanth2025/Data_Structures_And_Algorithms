import java.util.Arrays;

public class MinimizeMaxPairSum {

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPairSum = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]);
            left++;
            right--;
        }
        return maxPairSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 2, 3};
        System.out.println("Minimum maximum pair sum: " + minPairSum(nums1)); // Output: 7

        int[] nums2 = {3, 5, 4, 2, 4, 6};
        System.out.println("Minimum maximum pair sum: " + minPairSum(nums2)); // Output: 8
    }
}