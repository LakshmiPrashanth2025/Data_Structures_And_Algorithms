public class EuclideanGCD {

    /*
     *   Java program to demonstrate working of 
     *   extended Euclidean Algorithm
     */

    // Function to return gcd of a and b
    static int findGCD(int a, int b) {

        // b is GCD, if remainder of previous round of division/ modulo is 0
        if (a == 0)
            return b;

        return findGCD(b % a, a);
    }

    public static void main(String[] args) { 
        int a = 35, b = 15;
        int g = findGCD(a, b); 
        System.out.println(g);
    }



}
