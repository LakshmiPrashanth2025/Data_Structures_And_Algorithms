import java.util.ArrayDeque;
import java.util.Deque;

public class StackByDequeue {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Pop element
        System.out.println("Popped: " + stack.pop());

        // Peek top element
        System.out.println("Top: " + stack.peek());

        // Check if empty
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
