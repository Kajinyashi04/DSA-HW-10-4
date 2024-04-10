public class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int size) {
        maxSize = size;
        dequeArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(long value) {
        if (front == 0)
            front = maxSize;
        dequeArray[--front] = value;
        nItems++;
    }

    public void insertRight(long value) {
        if (rear == maxSize - 1)
            rear = -1;
        dequeArray[++rear] = value;
        nItems++;
    }

    public long removeLeft() {
        long temp = dequeArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public long removeRight() {
        long temp = dequeArray[rear--];
        if (rear == -1)
            rear = maxSize - 1;
        nItems--;
        return temp;
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

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertLeft(5);
        deque.insertLeft(2);

        System.out.println("Size: " + deque.size());

        while (!deque.isEmpty()) {
            System.out.println("Left: " + deque.removeLeft() + ", Right: " + deque.removeRight());
        }

        System.out.println("Size: " + deque.size());
    }
}