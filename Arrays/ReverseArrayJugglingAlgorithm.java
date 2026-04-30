// Java Program to left rotate the array by d positions
// using Juggling Algorithm

// O(n)  Time complexity and O(1) Space complexity

import java.util.Arrays;

public class ReverseArrayJugglingAlgorithm {

    
    // Function to rotate array
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Handle the case where d > size of array
        d %= n;

        // Calculate the number of cycles in the rotation
        int cycles = gcd(n, d);

        // Process each cycle
        for (int i = 0; i < cycles; i++) {
            
            // Start element of current cycle
            int startEle = arr[i];
            
            // Start index of current cycle
            int currIdx = i, nextIdx;
            
            // Rotate elements till we reach the start of cycle
            while (true) {
                nextIdx = (currIdx + d) % n;
                
                if (nextIdx == i)
                    break;
                
                // Update the next index with the current element
                arr[currIdx] = arr[nextIdx];
                currIdx = nextIdx;
            }
          
            // Copy the start element of current cycle at the last
            // index of the cycle
            arr[currIdx] = startEle;
        }
    }

    // function to compute GCD
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        rotateArr(arr, d);

        // Print the rotated array
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}


