public class TicketCounter {

    // Recursive method to count people
    public static int countPeople(String[] queue, int index) {
        if (index >= queue.length) {
            return 0;
        }
        return 1 + countPeople(queue, index + 1);
    }

    public static void main(String[] args) {
        String[] queue = {"Alice", "Bob", "Charlie", "Diana"};
        int count = countPeople(queue, 0);
        System.out.println("Number of people in queue: " + count);
    }
}