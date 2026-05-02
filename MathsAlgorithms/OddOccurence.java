/*
 * Given an array of positive integers. 
 * All numbers occur an even number of times except one number 
 * which occurs an odd number of times. 
 * 
 * Find the number in O(n) time & constant space.
 */

public class OddOccurence {
   
    int getOddOccurrence(int ar[], int ar_size) 
    {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++) 
        {
            res = res ^ ar[i];
        }
        return res;
    }

    //  Java 8 version of method
    public int findOddOccurrence(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) 
    {
        OddOccurence occur = new OddOccurence();
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        System.out.println(occur.getOddOccurrence(ar, n));
    }


}
