public class CountNumberOfSetBits {

    
        public static int countSetBits(int n) {
            int count = 0;
            
            while (n > 0) {

                // Check the last bit and add to count if set  as  (1&1 =1 if last bit is 1)
                count += (n & 1); 

                // Right shift to check the next bit
                n >>= 1; 
            }
            return count;
        }
    
        public static void main(String[] args) {
            int num = 9;
            System.out.println("Number of set bits in " + num + " is: " + countSetBits(num)); // Output: 2
        }
    

}
