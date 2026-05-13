public class MergeTwoArraysShellSort {

    // Function to calculate next gap
    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        
        return (gap + 1) / 2;
    }

    // Function to merge two sorted arrays in-place using Shell Sort technique
    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;

            // Compare elements in the first array
            while (i + gap < n) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
                i++;
            }

            // Compare elements between arrays
            int j = gap > n ? gap - n : 0;
            while (i < n && j < m) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
                j++;
            }

            // Compare elements in the second array
            if (j < m) {
                j = 0;
                while (j + gap < m) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                    j++;
                }
            }

            gap = nextGap(gap);
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        merge(arr1, arr2);

        System.out.print("Merged arr1: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }

        System.out.print("\nMerged arr2: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}
