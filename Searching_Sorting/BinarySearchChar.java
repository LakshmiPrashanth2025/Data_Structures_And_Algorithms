class BinarySearchChar {
    public int binarySearch(char[] arr, char target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchChar bs = new BinarySearchChar();
        char[] characters = {'a', 'c', 'e', 'g', 'i', 'k'};
        char target = 'g';
        int index = bs.binarySearch(characters, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}