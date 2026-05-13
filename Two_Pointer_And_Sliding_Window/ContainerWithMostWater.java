public class ContainerWithMostWater {

    // Use 2 pointer technique    
    static int maxWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int maxAreaOfWater = 0;

        while (left < right) {
            
            // Find the water stored in the container between 
            // arr[left] and arr[right]
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;

            int areaOfWater =  height * width;
            maxAreaOfWater = Math.max(maxAreaOfWater, areaOfWater);
            
            if (arr[left] < arr[right])
                left += 1;
            else
                right -= 1;
        }
        
        return maxAreaOfWater;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));

        int[] arr2 = {3, 1, 2, 4, 5 };
        System.out.println(maxWater(arr2));
    }
}