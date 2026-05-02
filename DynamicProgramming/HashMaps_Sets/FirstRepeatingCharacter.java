//import java.util.Arrays;

public class FirstRepeatingCharacter {
    // Function to find the first repeated character in a  string
    public static String firstRepeatingChar(String s)
    {
        // Create an array to store the count of characters
        int[] charCount = new int[26];

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Calculate the index in the array for this
            // character
            int index = ch - 'a';

            // If the count of the character is not zero,
            // it means the character is repeated, so return it
            if (charCount[index] != 0) {
                return Character.toString(ch);
            }

            // Increment the count of the character in the
            // array
            charCount[index]++;
        }

        // If no character is repeated, return "-1"
        return "-1";
    }

    public static void main(String[] args)
    {
        // Example usage:
        String s = "geeksforgeeks";

        // Print the result of the function
        System.out.println(firstRepeatingChar(s));
    }
}

