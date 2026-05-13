public class ReverseVowels {
    
    // Function to check if a character is a vowel
    static boolean isVowel(char c) {
        
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' 
               || c == 'o' || c == 'u';
    }

    static String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        
        // Two-pointer approach to swap vowels
        while (left < right) {
            
            // Move left pointer until a vowel is found
            while (left < right && !isVowel(str[left])) {
                left++;
            }

            // Move right pointer until a vowel is found
            while (left < right && !isVowel(str[right])) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(str);
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(reverseVowels(s));

        String s1 = "icecream";
        System.out.println(reverseVowels(s1));

        String s2 = "IceCream";
        System.out.println(reverseVowels(s2));
    }

    
}
