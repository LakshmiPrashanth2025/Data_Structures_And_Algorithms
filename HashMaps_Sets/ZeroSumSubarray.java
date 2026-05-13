import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    // Returns true if arr[] has a subarray with zero sum
    static Boolean subArrayExists(int arr[]) {
        // Create an empty HashSet to store prefix sums
        Set<Integer> hs = new HashSet<>();

        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check for any of the 3 conditions
            // if array element is 0
            // Or if sum of the subarray is zero upto now
            // If the prefix sum stored for this index  is already there in the Hash set with prefix sum
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return true;

            hs.add(sum);
        }

        // No subarray with zero sum found
        return false;
    }

    // Driver code
    public static void main(String arg[]) {
        int arr[] = { -3, 2, 3, 1, 6 };
        if (subArrayExists(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }
}
