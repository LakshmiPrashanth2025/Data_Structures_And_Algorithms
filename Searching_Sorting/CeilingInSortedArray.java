/*
* Given a sorted array and a value x, find index of the ceiling of x. 
* The ceiling of x is the smallest element in an array greater than or equal to x.
*/
public class CeilingInSortedArray {

      
        /* Function to find the ceiling of x using
           binary search */
        static int ceilSearch(int[] arr, int x) {
            int lowIndex = 0;
            int highIndex = arr.length - 1;
            int resultIndex = -1;
            
            while (lowIndex <= highIndex) {
              
                int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
    
                if (arr[middleIndex] < x)
                lowIndex = middleIndex + 1;      
                
                else { // Potential ceiling found
                    resultIndex = middleIndex;   
                    highIndex = middleIndex - 1;
                }
            }
            return resultIndex;  
        }
    
        public static void main(String[] args) {
            int[] arr = {1, 2, 8, 10, 10, 12, 19};
            int x = 3;
            int index = ceilSearch(arr, x);
            
            if (index == -1) 
                System.out.println("Ceiling of " + x + " doesn't exist in array");
            else
                System.out.println("Ceiling of " + x + " is " + arr[index]);
        }
    }