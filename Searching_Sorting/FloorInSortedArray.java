
public class FloorInSortedArray {

        static int findFloor(int arr[], int x)
    {

        int n = arr.length;

        int lowIndex = 0;
        int highIndex = n - 1;

        int result = -1;

        while (lowIndex <= highIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (arr[midIndex] <= x) {
                result = midIndex; 
                lowIndex = midIndex + 1; 
            }
            else {
                highIndex = midIndex - 1; // Move left
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int x = 7;

        // Function call
        int index = findFloor(arr, x);
        System.out.println("Floor Index: " + index);
        System.out.println("Floor Value: " + arr[index]);
        System.out.println("___________________________________ \n" );


        int arr2[] = { 1, 2, 4, 6, 10, 12, 14, 16, 25, 33, 40, 42 };
        int targetValue = 15;

        // Function call
        int index2 = findFloor(arr2, targetValue);
        System.out.println("Floor Index: " + index2);
        System.out.println("Floor Value: " + arr2[index2]);
    }

}