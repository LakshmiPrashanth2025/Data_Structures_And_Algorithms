/*
 * Divide And Conquer Method
 * Base Case:
 * If the exponent is 0, return 1. (As any number raised to the power of 0 is 1)
 * Handling Negative Exponent:
 * If the exponent is negative: calculate the power using the absolute value of the exponent and take the reciprocal of the result.
 *
 * Exponentiation by Squaring:
 * If the exponent is even:
 *      Calculate the power for half of the exponent, then square the result.
 * If the exponent is odd:
 *      Multiply the base by the result of calculating the power for exponent - 1.
 */
public class PowerFunctionByCurveOfLog {

        // Recursive method to calculate power (base^exponent)
        public static double power(double base, int exponent) {
            
            // Base case: when exponent is 0, return 1 (as any number to the power of 0 is 1)
            if (exponent == 0) {
                return 1;
            }
    
            // If exponent is negative, compute the positive power and take reciprocal
            if (exponent < 0) {
                return 1 / power(base, -exponent);
            }
    
            // If exponent is even, use exponentiation by squaring
            if (exponent % 2 == 0) 
            {
                double halfPower = power(base, exponent / 2);
                return halfPower * halfPower;
            } 
            else 
            {
                // If exponent is odd, recursively calculate base * base^(exponent-1)
                return base * power(base, exponent - 1);
            }
        }
        
        public static void main(String[] args) {
            double base = 2;
            int exponent = 10;
            System.out.println(base + " raised to the power of " + exponent + " is: " + power(base, exponent));
        }
    }
    
