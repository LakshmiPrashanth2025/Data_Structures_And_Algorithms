import java.util.Arrays;

class PrrintAllPrimeNumbers {
    /* 
    *   Sieve OF Eratosthenes
    *   Function to find prime numbers up to 'n' using 
    *   the normal Sieve of Eratosthenes algorithm
    */ 
    public static void normalSieve(int n) {
       /*
        *    Create a boolean array to mark non-prime numbers, 
        *    starting from 3 up to n
        *    Since we only need to consider odd numbers 
        *    (except for 2), we use n/2 elements in the array.
        */
        boolean[] prime = new boolean[n / 2];

        /* Initialize all elements as false 
        *  (considering all numbers as potential primes initially)
        */ 
        Arrays.fill(prime, false);

       /*
        *  Iterate over odd numbers starting from 3         
        *  up to the square root of n
        *   Since any composite number has a prime factor 
        *  less than or equal to its square root,
        *  we only need to check up to the square root to 
        *  find all primes.
        */
        for (int i = 3; i * i < n; i += 2) {
            /* 
            *   If 'i' is marked as non-prime (prime[i/2] is true), 
            *   skip to the next iteration
            */ 
            if (!prime[i / 2]) {
                /*
                 *  Mark all multiples of 'i' as non-prime by 
                 *  setting their corresponding positions in the array to true
                 *  We start marking from i*i since all smaller multiples of 'i' 
                 *  would have been marked by previous primes.
                 */
                for (int j = i * i; j < n; j += i * 2) {
                    prime[j / 2] = true;
                }
            }
        }

        // Print the prime numbers

        // 2 is the only even prime number
        System.out.print("2 "); 

        for (int i = 3; i < n; i += 2) {
            if (!prime[i / 2]) {

                // If prime[i/2] is false, 'i' is a prime number, so print it.
                System.out.print(i + " "); 
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        normalSieve(n); // Find and print prime numbers up to 'n'
    }
}
