import java.util.*;

public class SubSequencesOfArrayWithSumEqualToK {


    // Recursive function to generate all
    // subsequences with sum of elements k
    static void findSubsequence(
        int ind, int sum, int k, ArrayList<Integer> cur,
        ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res) {
        int n = arr.size();
        
        // base case
        if(ind == n) {
            
            // check if sum of elements of current
            // subset is equal to k
            if(sum == k) {
                
                // add the subset in result
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        
        // skip the current element arr[ind]
        findSubsequence(ind + 1, sum, k, cur, arr, res);
        
        // add the current element in subset
        cur.add(arr.get(ind));
        findSubsequence(ind + 1, sum + arr.get(ind), k, cur, arr, res);
        
        // remove the added element
        cur.remove(cur.size() - 1);
    }
    
    // Function to find the subsequences
    // with sum of its elements k
    static ArrayList<ArrayList<Integer>> subsequencesSumK(
        ArrayList<Integer> arr, int k) {
        
        // to store the subsequences
        // with sum of its elements k
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        // to store the current subset
        ArrayList<Integer> cur = new ArrayList<>();
        
        findSubsequence(0, 0, k, cur, arr, res);
        
        return res;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = 
            new ArrayList<>(Arrays.asList(17, 18, 6, 11, 2, 4));

        int k = 46;
        ArrayList<ArrayList<Integer>> ans = subsequencesSumK(arr, k);
        for(ArrayList<Integer> i : ans) {
            for(Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}