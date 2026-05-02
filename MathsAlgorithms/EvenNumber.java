public class EvenNumber {

   
        public static boolean isEven(int n) {
            return (n & 1) == 0;
        }
    
        public static void main(String[] args) {
            int num1 = 10;
            int num2 = 15;
    
            System.out.println(num1 + " is even: " + isEven(num1));
            System.out.println(num2 + " is even: " + isEven(num2));
        }
    

}
