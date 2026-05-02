import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingAndRepeatingNumbersInArray  {
    /**
     * Finds the repeating and missing numbers in an unsorted array.
     *
     * @param arr The unsorted array.
     * @return An array containing the repeating and missing numbers.
     */
    public static void findRepeatingAndMissing(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int n = arr.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> repeating = new ArrayList<>();
        List<Integer> missing = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (counts.containsKey(i)) {
                if (counts.get(i) > 1) {
                    for(int j=1; j < counts.get(i); ++j)
                        repeating.add(i);
                }
            } else {
                missing.add(i);
            }
        }

        System.out.println("Repeating numbers: " + repeating);
        System.out.println("Missing numbers: " + missing);
    }

    public static void main(String[] args) {
        MissingAndRepeatingNumbersInArray solution = new MissingAndRepeatingNumbersInArray();

        int[] arr1 = {3, 1, 3};
        solution.findRepeatingAndMissing(arr1);

        int[] arr2 = {4, 3, 6, 2, 1, 1};
        solution.findRepeatingAndMissing(arr2);

       
        int[] arr3 = {4, 3, 6, 2, 1, 1, 4};
        solution.findRepeatingAndMissing(arr3);
    }
}


