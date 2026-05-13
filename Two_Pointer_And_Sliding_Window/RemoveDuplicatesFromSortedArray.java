public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

         // Pointer for next unique element
         int j = 1;

        for (int i = 1; i < nums.length; i++) {

            // if ith element is not the same as previous element
            // Swap i & j index values
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];

                // After swapping, increment jth index
                j++;
            }
        }

        return j; // Number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        int newLength = removeDuplicates(nums);
        System.out.println("Length after removing duplicates: " + newLength);

        // Optional: print the updated array
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}