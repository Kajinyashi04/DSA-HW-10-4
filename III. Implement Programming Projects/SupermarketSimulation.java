import java.util.Scanner;

public class SupermarketSimulation {
    public static void main(String[] args) {
        int numCheckoutLines = 3; // Number of checkout lines
        int checkoutTimeRange = 5; // Maximum processing time range for each customer

        Queue[] checkoutLines = new Queue[numCheckoutLines];
        for (int i = 0; i < numCheckoutLines; i++) {
            checkoutLines[i] = new Queue(100); // Set the maximum size for each line (e.g., 100)
        }

        Scanner scanner = new Scanner(System.in);
        char key;
        int minute = 1;

        while (true) {
            System.out.print("Press any key to add a customer (Q to quit): ");
            key = scanner.nextLine().toUpperCase().charAt(0);

            if (key == 'Q') {
                break;
            }

            int shortestLineIndex = findShortestLine(checkoutLines);
            int processingTime = 1 + (int) (Math.random() * checkoutTimeRange);

            checkoutLines[shortestLineIndex].insert(minute + processingTime);

            System.out.println("Added customer to line " + (shortestLineIndex + 1) +
                    " (Processing time: " + processingTime + " minutes)");
            minute++;
        }

        System.out.println("\nSimulation Report:");
        for (int i = 0; i < numCheckoutLines; i++) {
            System.out.print("Line " + (i + 1) + ": ");
            checkoutLines[i].displayQueue();
        }
    }

    private static int findShortestLine(Queue[] checkoutLines) {
        int shortestLineIndex = 0;
        int shortestLineSize = checkoutLines[0].size();

        for (int i = 1; i < checkoutLines.length; i++) {
            int lineSize = checkoutLines[i].size();
            if (lineSize < shortestLineSize) {
                shortestLineIndex = i;
                shortestLineSize = lineSize;
            }
        }

        return shortestLineIndex;
    }
}