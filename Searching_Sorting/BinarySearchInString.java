import java.util.Arrays;

public class BinarySearchInString {
    
        public static int binarySearch(String str, char target) {
            if (str == null || str.isEmpty()) {
                return -1;
            }
    
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
    
            int low = 0;
            int high = charArray.length - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
    
                if (charArray[mid] == target) {
                    return mid;
                } else if (charArray[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    
        public static void main(String[] args) {
            String text = "javaprogramming";
            char charToFind = 'r';
    
            int index = binarySearch(text, charToFind);
    
            if (index != -1) {
                System.out.println("Character '" + charToFind + "' found at index: " + index);
            } else {
                System.out.println("Character '" + charToFind + "' not found in the string.");
            }
        }
    }