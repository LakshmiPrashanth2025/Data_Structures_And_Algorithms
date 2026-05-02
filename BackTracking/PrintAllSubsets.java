import java.util.*;

public class PrintAllSubsets {
    static void subsetRecur(int i, int[] arr,
                            ArrayList<ArrayList<Integer>> res,
                            ArrayList<Integer> subset) {
        if (i == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Include the current element
        subset.add(arr[i]);
        subsetRecur(i + 1, arr, res, subset);

        // Exclude the current element
        subset.remove(subset.size() - 1);
        subsetRecur(i + 1, arr, res, subset);
    }

    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        Arrays.sort(arr); // Sort array once

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subsetRecur(0, arr, res, subset);

        // Lexicographically sort all subsets
        res.sort((a, b) -> {
            int minLength = Math.min(a.size(), b.size());
            for (int i = 0; i < minLength; i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0)
                    return cmp;
            }
            return Integer.compare(a.size(), b.size());
        });

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = subsets(arr);

        for (ArrayList<Integer> subset : res) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}