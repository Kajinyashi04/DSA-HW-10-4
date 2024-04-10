public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long value) {
        if (rear == maxSize - 1)
            rear = -1;
        queueArray[++rear] = value;
        nItems++;
    }

    public long remove() {
        long temp = queueArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void displayQueue() {
        System.out.print("Queue: ");
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < nItems; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.displayQueue(); // Output: Queue: 10 20 30

        queue.remove();
        queue.insert(40);
        queue.insert(50);
        queue.displayQueue(); // Output: Queue: 20 30 40 50

        queue.remove();
        queue.remove();
        queue.displayQueue(); // Output: Queue: 40 50

        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        queue.displayQueue(); // Output: Queue: 40 50 60 70 80
    }
}