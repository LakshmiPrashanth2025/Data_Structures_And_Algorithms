 // Simple Java program to count distinct elements in every
// window of size k

import java.util.Arrays;

public class CountDistintElementsInWindow {



    // Counts distinct elements in window of size k
    static int countWindowDistinct(int win[], int k)
    {
        int dist_count = 0;

        // Traverse the window
        for (int i = 0; i < k; i++) {
            // Check if element arr[i] exists in arr[0..i-1]
            int j;
            for (j = 0; j < i; j++)
                if (win[i] == win[j])
                    break;
            if (j == i)
                dist_count++;
        }
        return dist_count;
    }

    // Counts distinct elements in all windows of size k
    static void countDistinct(int arr[], int n, int k)
    {
        // Traverse through every window
        for (int i = 0; i <= n - k; i++)
            System.out.println(countWindowDistinct(Arrays.copyOfRange(arr, i, arr.length), k));
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;

        countDistinct(arr, arr.length, k);
    }
}


