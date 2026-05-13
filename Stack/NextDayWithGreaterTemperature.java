import java.util.Stack;

public class NextDayWithGreaterTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = n - 1; i >= 0; i--) {
            // Pop indices with temperatures less than or equal to current
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If the stack is not empty, the next warmer day is at the top of the stack
            // Since we want to only store the number of days, we try to get the index of that next higher temperature index in stack
            // And find the difference from current day/ current index i
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            } else {
                answer[i] = 0; // No warmer day ahead
            }

            // Push current index onto the stack
            stack.push(i);
        }

        return answer;
    }

    // Example usage
    public static void main(String[] args) {
        NextDayWithGreaterTemperature solver = new NextDayWithGreaterTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solver.dailyTemperatures(temperatures);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}

