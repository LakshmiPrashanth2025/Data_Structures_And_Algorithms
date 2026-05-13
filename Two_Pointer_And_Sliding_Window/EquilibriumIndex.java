/*
 *  1. Calculate totalSum = sum of all elements in the array
 *  2. Initialize leftSum = 0
 *  3. Loop through the array from index 0 to n-1:
 *    a. rightSum = totalSum - leftSum - arr[i]
 *    b. If leftSum == rightSum, return i (equilibrium index)
 *    c. Update leftSum += arr[i]
 *  4. If no such index is found, return -1
 */
public class EquilibriumIndex {

    public static int findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // No equilibrium index found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        int equilibriumIndex = findEquilibriumIndex(arr);

        if (equilibriumIndex != -1) {
            System.out.println("Equilibrium Index is: " + equilibriumIndex);
        } else {
            System.out.println("No Equilibrium Index found.");
        }
    }
}