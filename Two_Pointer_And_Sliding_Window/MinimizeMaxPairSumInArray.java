import java.util.Arrays;

/*
 * Given an array of size 2 * N integers. Divide the array into N pairs,
 *  such that the maximum pair sum is minimized. In other words, 
 * the optimal division of array into N pairs should result into a maximum pair sum 
 * which is minimum of other maximum pair sum of all possibilities.
 */

public class MinimizeMaxPairSumInArray {

    static void findOptimalPairs(int arr[], int N)
    {
        Arrays.sort(arr);
     
        // After Sorting Maintain two variables i and j 
        // pointing to start and end of array Such that 
        // smallest element of array pairs with largest
        // element
        for (int i = 0, j = N - 1; i <= j; i++, j--)
        {
            System.out.print( "(" + arr[i] + ", " + arr[j] + ")" + " ");
        }
    }
     
       
        public static void main (String[] args)
        {
            int arr[] = {9, 6, 5, 1};
            int N = arr.length;
     
            findOptimalPairs(arr, N);
        }
    }
     
