public class FirstOccurrenceOfChar {
    int binarySearchFirstOccurrence(char[] arr, char target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Continue searching on the left for the first occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FirstOccurrenceOfChar searcher = new FirstOccurrenceOfChar();
        char[] arr = {'a', 'b', 'b', 'c', 'c', 'c', 'd'};
        char target = 'c';
        int index = searcher.binarySearchFirstOccurrence(arr, target);

        if (index != -1) {
            System.out.println("First occurrence of '" + target + "' is at index: " + index);
        } else {
            System.out.println("'" + target + "' not found in the array");
        }

        char target2 = 'z';
         index = searcher.binarySearchFirstOccurrence(arr, target2);

        if (index != -1) {
            System.out.println("First occurrence of '" + target2 + "' is at index: " + index);
        } else {
            System.out.println("'" + target2 + "' not found in the array");
        }
    }
}