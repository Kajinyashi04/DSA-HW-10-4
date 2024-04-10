public class Stack1 {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Pop: " + stack.pop()); // Output: Pop: 30

        stack.push(40);
        stack.push(50);

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
        // Output:
        // Pop: 50
        // Pop: 40
        // Pop: 20
        // Pop: 10

        System.out.println("Is Empty: " + stack.isEmpty()); // Output: Is Empty: true
    }
}