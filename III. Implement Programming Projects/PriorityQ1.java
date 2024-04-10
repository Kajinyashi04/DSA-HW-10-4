public class PriorityQ1 {
    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(5);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(20);

        priorityQ.display(); // Output: Priority Queue (from highest to lowest priority): 10 20 30 50

        while (!priorityQ.isEmpty()) {
            System.out.println("Removed: " + priorityQ.remove());
        }
        // Output:
        // Removed: 10
        // Removed: 20
        // Removed: 30
        // Removed: 50
    }
}