public class ReverseString {

    // Recursive method to reverse a string
    public static String reverse(String str) {
        // Base case: if the string is empty or has one character
        if (str == null || str.length() <= 1) {
            return str;
        }
        // Recursive case: reverse the substring and append the first character at the end
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String input = "Lakshmi";
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
